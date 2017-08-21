package model;

public class moderator {
	int MdId; 
	int UserId;
	int ClassId;
	public int getMdId() {
		return MdId;
	}
	public void setMdId(int mdId) {
		MdId = mdId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getClassId() {
		return ClassId;
	}
	public void setClassId(int classId) {
		ClassId = classId;
	}
	public moderator(int userId, int classId) {
		
		UserId = userId;
		ClassId = classId;
	}
	
}
