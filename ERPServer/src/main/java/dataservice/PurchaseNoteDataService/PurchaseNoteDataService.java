package dataservice.PurchaseNoteDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;


import po.posale_purchase_client.PurchaseNotePO;
import queryItem.PurchaseNoteQueryItem;
import queryItem.PurchaseReturnNoteQueryItem;


public interface PurchaseNoteDataService extends Remote {
	public void insert(PurchaseNotePO po) throws RemoteException;	
	
	public void commit(PurchaseNotePO po) throws RemoteException;
	public PurchaseNotePO[] GetAllPurchaseNote()throws RemoteException;
	public PurchaseNotePO[] GetAllPurchaseReturnNote()throws RemoteException;
	public PurchaseNotePO[] CheckPurchaseNote(String start,String end)throws RemoteException;
	public PurchaseNotePO[] CheckPurchaseReturnNote(String start,String end)throws RemoteException;
	
	public PurchaseNotePO[] CheckPurchaseNote(PurchaseNoteQueryItem item)throws RemoteException;
	public PurchaseNotePO[] CheckPurchaseReturnNote(PurchaseReturnNoteQueryItem item)throws RemoteException;
	
	public  PurchaseNotePO[] GetAllPendingPurchaseNote() throws RemoteException;
	public void deletePendingPurchaseNote(PurchaseNotePO po) throws RemoteException;
	
	
	
}
