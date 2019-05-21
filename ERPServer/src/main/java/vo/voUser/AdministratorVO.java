package vo.voUser;

import po.poUser.AdministratorPO;

public class AdministratorVO {
	private String ID;
	
	private String PassWord;

	public AdministratorVO(AdministratorPO Ad){
		ID = Ad.getID();
		PassWord  = Ad.getPassWord();
	}
	
	public AdministratorVO(String iD,String passWord){
		ID = iD;
		PassWord = passWord;
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
