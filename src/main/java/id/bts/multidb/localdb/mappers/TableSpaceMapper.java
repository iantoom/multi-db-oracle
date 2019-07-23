package id.bts.multidb.localdb.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import id.bts.multidb.localdb.domains.TableSpaceDTO;

public class TableSpaceMapper implements RowMapper<TableSpaceDTO>{

	@Override
	public TableSpaceDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TableSpaceDTO tableSpaceDTO = new TableSpaceDTO();
		
		tableSpaceDTO.setTableSpace(rs.getString("TABLE_SPACE"));
		tableSpaceDTO.setUsedMB(rs.getInt("USED_MB"));
		tableSpaceDTO.setFreeMB(rs.getInt("FREE_MB"));
		tableSpaceDTO.setTotalMB(rs.getInt("TOTAL_MB"));
		tableSpaceDTO.setPercentFree(rs.getInt("PERCENT_FREE"));
		
		return tableSpaceDTO;
	}

}
