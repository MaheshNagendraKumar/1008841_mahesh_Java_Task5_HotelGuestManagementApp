package in.kmnk.hotelms.domain;

public class Guest {

	private long gid;
	private String gfirstName;
	private String glastName;
	private String gemailId;
	
	public long getGid() {
		return gid;
	}
	public void setGid(long gid) {
		this.gid = gid;
	}
	public String getGfirstName() {
		return gfirstName;
	}
	public void setGfirstName(String gfirstName) {
		this.gfirstName = gfirstName;
	}
	public String getGlastName() {
		return glastName;
	}
	public void setGlastName(String glastName) {
		this.glastName = glastName;
	}
	public String getGemailId() {
		return gemailId;
	}
	public void setGemailId(String gemailId) {
		this.gemailId = gemailId;
	}
	
	@Override
	public String toString() {
		return "Guest [gid=" + gid + ", gfirstName=" + gfirstName + ", glastName=" + glastName + ", gemailId="
				+ gemailId + "]";
	}
}
