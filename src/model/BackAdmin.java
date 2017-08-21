package model;

public class BackAdmin {
	@Override
	public String toString() {
		return "BackAdmin [authMsg=" + authMsg + ", birth=" + birth + ", exp="
				+ exp + ", lastTime=" + lastTime + ", money=" + money
				+ ", picture=" + picture + ", regTime=" + regTime + ", sex="
				+ sex + ", spe=" + spe + ", uid=" + uid + ", uname=" + uname
				+ ", upwd=" + upwd + "]";
	}
	private int uid;
	private String uname;
	private String upwd;	
	private String birth;
	private String sex;
	private String picture;
	private int exp;
	private int money;
	private String spe;
	private String authMsg;	
	private String regTime;
	private String lastTime;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getSpe() {
		return spe;
	}
	public void setSpe(String spe) {
		this.spe = spe;
	}
	public String getAuthMsg() {
		return authMsg;
	}
	public void setAuthMsg(String authMsg) {
		this.authMsg = authMsg;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public BackAdmin(int uid, String uname, String upwd, String birth,
			String sex, String picture, int exp, int money, String spe,
			String authMsg, String regTime, String lastTime) {
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.birth = birth;
		this.sex = sex;
		this.picture = picture;
		this.exp = exp;
		this.money = money;
		this.spe = spe;
		this.authMsg = authMsg;
		this.regTime = regTime;
		this.lastTime = lastTime;
	}
	public BackAdmin(String uname, String upwd, String birth, String sex,
			String picture, int exp, int money, String spe, String authMsg,
			String regTime, String lastTime) {
		this.uname = uname;
		this.upwd = upwd;
		this.birth = birth;
		this.sex = sex;
		this.picture = picture;
		this.exp = exp;
		this.money = money;
		this.spe = spe;
		this.authMsg = authMsg;
		this.regTime = regTime;
		this.lastTime = lastTime;
	}
	
	
	public BackAdmin(int uid, String uname) {
		
		this.uid = uid;
		this.uname = uname;
	}
	public BackAdmin(int uid,String uname, String upwd, String birth, String sex,
			String picture, int exp, int money, String spe, String authMsg) {
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.birth = birth;
		this.sex = sex;
		this.picture = picture;
		this.exp = exp;
		this.money = money;
		this.spe = spe;
		this.authMsg = authMsg;
	}
	public BackAdmin() {
	}
	
}
