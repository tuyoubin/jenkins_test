package dataservice.ClientDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.posale_purchase_client.ClientPO;


public interface ClientDataService extends Remote{
	public boolean Find(String input) throws RemoteException;
	
	public ClientPO ClientInfo(String input)throws RemoteException;

	public void ClientChange(ClientPO po) throws RemoteException;
	public void ClientDelete(String id) throws RemoteException;
	public void ClientAdd(ClientPO po) throws RemoteException;
	
	public ClientPO[] GetAll() throws RemoteException;
}
