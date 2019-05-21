package vo.voUser;

import po.poUser.UserPO;

public class UserVO {
	private String ID;
	private String PassWord;
	private String position;//职位
	private String potence;//权限
	
	public UserVO(String id, String password, String pos,String Potence) {
		ID =id;
		PassWord = password;
		position = pos;
		potence = Potence;
	}
	
	public UserVO(UserPO User){
		this.ID = User.getID();
		this.PassWord = User.getPassWord();
		this.position = User.getposition();
		this.potence = User.getPotence();
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getposition() {
		return position;
	}
	public void setposition(String position) {
		this.position = position;
	}

	public String getPotence() {
		return potence;
	}

	public void setPotence(String potence) {
		this.potence = potence;
	}
}
