package UserData;

import java.rmi.RemoteException;

import dataservice.UserDataService.AdminisDataService;
import po.poUser.AdministratorPO;

public class AdminDataStub implements AdminisDataService{

	@Override
	public AdministratorPO getADPO() throws RemoteException {
		// TODO Auto-generated method stub
		AdministratorPO a = new AdministratorPO("Admin","123456");
		return a;
	}

	@Override
	public boolean reviseAD(AdministratorPO ADPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean AdminLogin(String ID, String PassWord) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
