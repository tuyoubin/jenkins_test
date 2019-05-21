package po.poUser;

import java.io.Serializable;

import vo.voUser.AdministratorVO;

public class AdministratorPO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ID;

	private String PassWord;
	
	public AdministratorPO(String iD,String passWord){
		ID = iD;
		PassWord = passWord;
	}
	
	public AdministratorPO(AdministratorVO Ad){
		ID = Ad.getID();
		PassWord = Ad.getPassWord();
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
	
}
