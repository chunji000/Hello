package model;

public class authMsg {
	int authId;
	String authMsg;
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public String getAuthMsg() {
		return authMsg;
	}
	public void setAuthMsg(String authMsg) {
		this.authMsg = authMsg;
	}
	public authMsg(int authId, String authMsg) {
		this.authId = authId;
		this.authMsg = authMsg;
	}
	public authMsg() {
	}
	
}
