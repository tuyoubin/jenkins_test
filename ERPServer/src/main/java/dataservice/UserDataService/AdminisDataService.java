package dataservice.UserDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.poUser.AdministratorPO;

public interface AdminisDataService extends Remote{
	public AdministratorPO getADPO() throws  RemoteException;
	public boolean reviseAD(AdministratorPO ADPO)throws RemoteException;
	public boolean AdminLogin(String ID,String PassWord)throws RemoteException;
	
}
