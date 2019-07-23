package id.bts.multidb.localdb.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import id.bts.multidb.localdb.domains.DbaSegmentsDTO;

public class DbaSegmentsMapper implements RowMapper<DbaSegmentsDTO> {

	@Override
	public DbaSegmentsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		DbaSegmentsDTO result = new DbaSegmentsDTO();
		result.setTableSpaceName(rs.getString("TABLESPACE_NAME"));
		result.setTotalUsedSpace(rs.getInt("TOTALUSEDSPACE"));
		return result;
	}

}
