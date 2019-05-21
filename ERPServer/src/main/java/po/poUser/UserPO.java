package po.poUser;

import java.io.Serializable;

import vo.voUser.UserVO;

public class UserPO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String ID;
	private String PassWord;
	private String position;
	private String potence;
	
	public UserPO(String Id,String Password,String Position,String Potence){
		ID = Id;
		PassWord = Password;
		position = Position;
		potence = Potence;
		
	}
	
	public UserPO(UserVO User){
		this.setID(User.getID());
		this.setPassWord(User.getPassWord());
		this.setposition(User.getposition());
		this.setPotence(User.getPotence());
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
