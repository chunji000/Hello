package model;

public class admin {

	int infoId;
	String uname;
	String birth;
	String sex;
	String picture;
	int exp;
	int money;
	String spe;
	String authMsg;
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
	public admin(int infoId, String uname, String birth, String sex,
			String picture, int exp, int money, String spe, String authMsg) {
		this.infoId = infoId;
		this.uname = uname;
		this.birth = birth;
		this.sex = sex;
		this.picture = picture;
		this.exp = exp;
		this.money = money;
		this.spe = spe;
		this.authMsg = authMsg;
	}
	public admin() {
	}
	
}
