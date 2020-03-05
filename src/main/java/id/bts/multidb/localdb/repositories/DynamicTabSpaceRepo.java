package id.bts.multidb.localdb.repositories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import id.bts.multidb.configs.DataSOurceEntity;
import id.bts.multidb.localdb.domains.DbaDataFilesDTO;
import id.bts.multidb.localdb.domains.DbaSegmentsDTO;
import id.bts.multidb.localdb.domains.TableSpaceDTO;
import id.bts.multidb.localdb.mappers.DbaDataFilesMapper;

@Repository(value = "tableSpace_jdbcTemplate")
public class DynamicTabSpaceRepo {
	
	
	private static final Logger log = LoggerFactory.getLogger(DynamicTabSpaceRepo.class);

	@Autowired
	@Qualifier("ocdb12cDataSources")
	List<DataSOurceEntity> dataSources;
	
	public List<TableSpaceDTO> getAllTableSpace() {
		
		List<DbaSegmentsDTO> usedSpaces = this.getUsedSpace();
		List<DbaDataFilesDTO> dataFiles = this.getTotalSpace();
		
		List<TableSpaceDTO> results = new ArrayList<>();

		
		for (Iterator<DbaSegmentsDTO> iterator = usedSpaces.iterator(); iterator.hasNext();) {
			DbaSegmentsDTO used = (DbaSegmentsDTO) iterator.next();
			
			for (Iterator<DbaDataFilesDTO> iterator2 = dataFiles.iterator(); iterator2.hasNext();) {
				DbaDataFilesDTO total = (DbaDataFilesDTO) iterator2.next();
				
				if (used.getTableSpaceName().equals(total.getTablespace_name())) {
					TableSpaceDTO tableSpace = new TableSpaceDTO();
					tableSpace.setTableSpace(used.getTableSpaceName());
					tableSpace.setTotalMB(total.getTotalSpace());
					tableSpace.setUsedMB(used.getTotalUsedSpace());
					tableSpace.setFreeMB(total.getTotalSpace() - used.getTotalUsedSpace());
					tableSpace.setPercentFree(tableSpace.getFreeMB()/total.getTotalSpace());
					
					results.add(tableSpace);
					
					iterator2.remove();
				}
			}
		}
		
		return results;
	}

	public List<DbaDataFilesDTO> getTotalSpace() {
		String query = "SELECT tablespace_name,\n" + 
				"    ROUND(SUM(bytes) / 1048576) TotalSpace\n" + 
				"  FROM dba_data_files\n" + 
				"  GROUP BY tablespace_name";
		
		log.warn(query);
		log.warn(dataSources.toString());
		List<DbaDataFilesDTO> results = new ArrayList<>();
		
		for (Iterator<DataSOurceEntity> iterator = dataSources.iterator(); iterator.hasNext();) {
			DataSOurceEntity dataSOurceEntity = (DataSOurceEntity) iterator.next();
			
			log.warn(dataSOurceEntity.toString());
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSOurceEntity.getDataSource());
			
			List<DbaDataFilesDTO> result = jdbcTemplate.query(query, new DbaDataFilesMapper());
			
			for (Iterator<DbaDataFilesDTO> iterator2 = result.iterator(); iterator2.hasNext();) {
				DbaDataFilesDTO dbaDataFilesDTO = (DbaDataFilesDTO) iterator2.next();
				
				dbaDataFilesDTO.setDbName(dataSOurceEntity.getId());
				
				results.add(dbaDataFilesDTO);
			}
		}
		
		return results;
	}
	
	public List<DbaSegmentsDTO> getUsedSpace() {
		String query = "SELECT ROUND(SUM(bytes)/(1024*1024)) totalusedspace,\n" + 
				"    tablespace_name\n" + 
				"  FROM dba_segments\n" + 
				"  GROUP BY tablespace_name";
		
		List<DbaSegmentsDTO> results = null; //jdbcTemplate.query(query, new DbaSegmentsMapper());
		
		return results;
	}
}
