package model;

public class Bclass {	     
	private int ClassId;
	private String ClassName;
	private String ClassMsg;
	private String ClassPicture;
	private String UserName;
	public Bclass(String className, String classMsg, String classPicture,
			String userName) {
		ClassName = className;
		ClassMsg = classMsg;
		ClassPicture = classPicture;
		UserName = userName;
	}
	public int getClassId() {
		return ClassId;
	}
	public void setClassId(int classId) {
		ClassId = classId;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getClassMsg() {
		return ClassMsg;
	}
	public void setClassMsg(String classMsg) {
		ClassMsg = classMsg;
	}
	public String getClassPicture() {
		return ClassPicture;
	}
	public void setClassPicture(String classPicture) {
		ClassPicture = classPicture;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public Bclass(int classId, String className, String classMsg,
			String classPicture, String userName) {
		
		ClassId = classId;
		ClassName = className;
		ClassMsg = classMsg;
		ClassPicture = classPicture;
		UserName = userName;
	}
	
	public Bclass() {
		
	}
	
	
}
