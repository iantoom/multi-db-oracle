package id.bts.multidb.localdb.domains;
import javax.persistence.Entity;


public class DbaSegmentsDTO {

	int totalUsedSpace;
	
	String tableSpaceName;

	public int getTotalUsedSpace() {
		return totalUsedSpace;
	}

	public void setTotalUsedSpace(int totalUsedSpace) {
		this.totalUsedSpace = totalUsedSpace;
	}

	public String getTableSpaceName() {
		return tableSpaceName;
	}

	public void setTableSpaceName(String tableSpaceName) {
		this.tableSpaceName = tableSpaceName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tableSpaceName == null) ? 0 : tableSpaceName.hashCode());
		result = prime * result + totalUsedSpace;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DbaSegmentsDTO other = (DbaSegmentsDTO) obj;
		if (tableSpaceName == null) {
			if (other.tableSpaceName != null)
				return false;
		} else if (!tableSpaceName.equals(other.tableSpaceName))
			return false;
		if (totalUsedSpace != other.totalUsedSpace)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DbaSegmentsDTO [totalUsedSpace=" + totalUsedSpace + ", tableSpaceName=" + tableSpaceName + "]";
	}
}
