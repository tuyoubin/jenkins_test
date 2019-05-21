package PurchaseNoteData;

import java.rmi.RemoteException;

import dataservice.PurchaseNoteDataService.PurchaseNoteDataService;
import po.posale_purchase_client.ListOfGoodsPO;
import po.posale_purchase_client.PurchaseNotePO;
import queryItem.PurchaseNoteQueryItem;
import queryItem.PurchaseReturnNoteQueryItem;

public class PurchaseNoteDataServiceStub implements PurchaseNoteDataService{
	String[] state ={""};
	 String[] numbering ={"0001"};
	 String[] NameOfGoods = {"崩坏三台灯"};
	 String[] type = {"small"};
	  int[] num = {2};  
	  double[] unit_price={33.8};
	  double[] total = {0};
	 String[] remark ={"hehe"};
	 double all_total = 67.6;
	 
	
	ListOfGoodsPO goods =new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
	
	
	 String stateofNote ="";
	 String ListNumbering = "JHD##-20171221-102536";
	 String provider ="李四";
	 String storehouse = "1";
	 String operator_id ="12138" ;
	//list of adding store
	//private List ListOfStorehouseChange;
	 String remarkofNote = "meiyou";
	 double totalofNote = all_total;
	 
	 
	PurchaseNotePO purchase =new PurchaseNotePO(ListNumbering,provider, storehouse, operator_id, remarkofNote, totalofNote, stateofNote, goods);


	@Override
	public void insert(PurchaseNotePO po) throws RemoteException {
		return;
		
	}


	@Override
	public void commit(PurchaseNotePO po) throws RemoteException {
		return;
		
	}


	@Override
	public PurchaseNotePO[] GetAllPurchaseNote() throws RemoteException {
		PurchaseNotePO p[] =new PurchaseNotePO[1];
		p[0] =purchase;
		return p;
	}


	@Override
	public PurchaseNotePO[] GetAllPurchaseReturnNote() throws RemoteException {
		PurchaseNotePO p[] =new PurchaseNotePO[1];
		p[0] =purchase;
		return p;
	}


	@Override
	public PurchaseNotePO[] CheckPurchaseNote(String start, String end) throws RemoteException {
		PurchaseNotePO p[] =new PurchaseNotePO[1];
		p[0] =purchase;
		return p;
	}


	@Override
	public PurchaseNotePO[] CheckPurchaseReturnNote(String start, String end) throws RemoteException {
		PurchaseNotePO p[] =new PurchaseNotePO[1];
		p[0] =purchase;
		return p;
	}


	@Override
	public PurchaseNotePO[] CheckPurchaseNote(PurchaseNoteQueryItem item) throws RemoteException {
		PurchaseNotePO p[] =new PurchaseNotePO[1];
		p[0] =purchase;
		return p;
	}


	@Override
	public PurchaseNotePO[] CheckPurchaseReturnNote(PurchaseReturnNoteQueryItem item) throws RemoteException {
		PurchaseNotePO p[] =new PurchaseNotePO[1];
		p[0] =purchase;
		return p;
	}


	@Override
	public PurchaseNotePO[] GetAllPendingPurchaseNote() throws RemoteException {
		PurchaseNotePO p[] =new PurchaseNotePO[1];
		p[0] =purchase;
		return p;
	}


	@Override
	public void deletePendingPurchaseNote(PurchaseNotePO po) throws RemoteException {
		return;	
	}
	 
	
	
	
}
