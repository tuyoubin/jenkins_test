package dataservice.UserDataService;

import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;
import po.poUser.UserPO;

public interface UserService extends Remote{
	public boolean newUser(UserPO User)throws RemoteException;
	public boolean deleteUser(String ID)throws RemoteException;
	public ArrayList<UserPO> getAllUser()throws RemoteException;
	public UserPO Login(String ID,String PassWord)throws RemoteException;
}
