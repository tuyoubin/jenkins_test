package dataservice.DocumentDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.popublic.NotePO;


public interface DocumentDataService extends Remote{

	//单据名称，提交人ID，单据类型
	public ArrayList<NotePO> getAll()throws RemoteException;
	public boolean ApprovalDoc(NotePO Note)throws RemoteException;
	public boolean NoPassDoc(NotePO Note)throws RemoteException;
	public boolean submitDoc(NotePO Note)throws RemoteException;
}
