package id.bts.multidb.localdb.domains;

import javax.persistence.Entity;


public class TableSpaceDTO {

	String tableSpace;
	
	int usedMB;
	
	int freeMB;
	
	int totalMB;
	
	int percentFree;

	public String getTableSpace() {
		return tableSpace;
	}

	public void setTableSpace(String tableSpace) {
		this.tableSpace = tableSpace;
	}

	public int getUsedMB() {
		return usedMB;
	}

	public void setUsedMB(int usedMB) {
		this.usedMB = usedMB;
	}

	public int getFreeMB() {
		return freeMB;
	}

	public void setFreeMB(int freeMB) {
		this.freeMB = freeMB;
	}

	public int getTotalMB() {
		return totalMB;
	}

	public void setTotalMB(int totalMB) {
		this.totalMB = totalMB;
	}

	public int getPercentFree() {
		return percentFree;
	}

	public void setPercentFree(int percentFree) {
		this.percentFree = percentFree;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + freeMB;
		result = prime * result + percentFree;
		result = prime * result + ((tableSpace == null) ? 0 : tableSpace.hashCode());
		result = prime * result + totalMB;
		result = prime * result + usedMB;
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
		TableSpaceDTO other = (TableSpaceDTO) obj;
		if (freeMB != other.freeMB)
			return false;
		if (percentFree != other.percentFree)
			return false;
		if (tableSpace == null) {
			if (other.tableSpace != null)
				return false;
		} else if (!tableSpace.equals(other.tableSpace))
			return false;
		if (totalMB != other.totalMB)
			return false;
		if (usedMB != other.usedMB)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TableSpaceDTO [tableSpace=" + tableSpace + ", usedMB=" + usedMB + ", freeMB=" + freeMB + ", totalMB="
				+ totalMB + ", percentFree=" + percentFree + "]";
	}
	
}
