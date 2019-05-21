package PurchaseNoteData;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.PurchaseNoteData.PurchaseNoteDataServiceImpl;
import dataservice.PurchaseNoteDataService.PurchaseNoteDataService;
import po.posale_purchase_client.ListOfGoodsPO;
import po.posale_purchase_client.PurchaseNotePO;
import queryItem.PurchaseNoteQueryItem;
import queryItem.PurchaseReturnNoteQueryItem;

public class PurchaseNoteDataServiceImplTestTest {
	PurchaseNoteDataService data = new  PurchaseNoteDataServiceImpl();
	@Before
	public void setUp() throws Exception {
		
	}



	@Test
	public void testGetAllPurchaseNote() {
		
	
		PurchaseNotePO po[];
		try {
			po = data.GetAllPurchaseNote();
			
//要自己数啊		
			assertEquals(po.length,4);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Test
	public void testGetAllPurchaseReturnNote() {

		PurchaseNotePO po[];
		try {
			po = data.GetAllPurchaseReturnNote();
			assertEquals(po.length,1);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testCheckPurchaseNoteStringString() {
	   String start = "";
	   String end = "";
	   PurchaseNotePO po[];
	   try {
		po = data.CheckPurchaseNote(start, end);
//要自己数啊		
		assertEquals(po.length , 4);
		
	} catch (RemoteException e) {
	
		e.printStackTrace();
	}
	   
	}

	@Test
	public void testCheckPurchaseReturnNoteStringString() {
		 String start = "";
		   String end = "";
		   
		   PurchaseNotePO po[];
		   try {
			po = data.CheckPurchaseReturnNote(start, end);
			
//要自己数啊			
			assertEquals(po.length,1);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   
	}

	@Test
	public void testCheckPurchaseNotePurchaseNoteQueryItem() {
		PurchaseNoteQueryItem item  =new  PurchaseNoteQueryItem();
		 PurchaseNotePO po[];
		   try {
			po=data.CheckPurchaseNote(item);
			
//要自己数啊			
			assertEquals(po.length, 4 );
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		
	}

	@Test
	public void testCheckPurchaseReturnNotePurchaseReturnNoteQueryItem() {
		PurchaseReturnNoteQueryItem item  =new  PurchaseReturnNoteQueryItem();
		 PurchaseNotePO po[];
		   try {
			   
			po = data.CheckPurchaseReturnNote(item);
		
	
System.out.println("退货单"+po.length);	

			
//要自己数啊			
			assertEquals(po.length,1);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	}

	@Test
	public void testGetAllPendingPurchaseNote() {
		PurchaseNotePO po[];
		try {
			po = data.GetAllPendingPurchaseNote();
//要自己数啊			
			assertEquals(po.length,2);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
