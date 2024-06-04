package jp.co.aforce.bean;

public class MemberShip implements java.io.Serializable{
	private int MEMBER_ID;
	private String PASSWORD;
	
	public int getMEMBER_ID() {
		return MEMBER_ID;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	
	public void setMEMBER_ID(int MEMBER_ID) {
		this.MEMBER_ID = MEMBER_ID;
	}
	public void setPASSWORD(String PASSWORD) {
		this.PASSWORD = PASSWORD;
	}
	
    public MemberShip(int MEMBER_ID, String PASSWORD) {
        this.MEMBER_ID = MEMBER_ID;
        this.PASSWORD = PASSWORD;
    }
}
