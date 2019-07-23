package id.bts.multidb.localdb.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import id.bts.multidb.localdb.domains.DbaDataFilesDTO;

public class DbaDataFilesMapper implements RowMapper<DbaDataFilesDTO> {

	@Override
	public DbaDataFilesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DbaDataFilesDTO dataFiles = new DbaDataFilesDTO();
		
		dataFiles.setTablespace_name(rs.getString("TABLESPACE_NAME"));
		dataFiles.setTotalSpace(rs.getInt("TOTALSPACE"));
		return dataFiles;
	}

}
