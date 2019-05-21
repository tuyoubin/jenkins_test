package SaleListData;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.SaleListData.SaleListDataServiceImpl;
import po.posale_purchase_client.ListOfGoodsPO;
import po.posale_purchase_client.SaleListPO;
import queryItem.SaleListQueryItem;
import queryItem.SaleReturnListQueryItem;

public class SaleListDataServiceImplTest {
	SaleListDataServiceImpl data = new SaleListDataServiceImpl();
	
	 SaleListQueryItem saleItem ;
	 SaleReturnListQueryItem saleReturnItem;
	 
	@Before
	//@00060001@goods4@type4@1@100.0@100.0@无^@00050001@goods5@type5@2@100.0@200.0@无^@00020001@goods1@type1@1@100.0@100.0@无
	public void setUp() throws Exception {
		saleItem  = new SaleListQueryItem("","","","","","","");
		
		SaleListPO po[] =data.CheckSaleList(saleItem);
		
		System.out.println(po.length);
		
	}

	
	
	@Test
	public void testGetAllSaleList() {
		try {
			assertEquals(4,data.GetAllSaleList().length);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllSaleReturnList() {
		try {
			assertEquals(2,data.GetAllSaleReturnList().length);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testCheckSaleListStringString() {
		try {
			int n = data.CheckSaleList("", "").length;
			assertEquals(n,4);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testCheckSaleReturnListStringString() {
		try {
			int n = data.CheckSaleReturnList("", "").length;
			assertEquals(n,2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testCheckSaleListSaleListQueryItem() {
		saleItem  = new SaleListQueryItem();
		
		try {
			int n = data.CheckSaleList(saleItem).length;	
			assertEquals(n,4);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCheckSaleListSaleListQueryItem1() {
		saleItem  = new SaleListQueryItem("","","123","","","","");
		
		try {
			int n = data.CheckSaleList(saleItem).length;	
			assertEquals(n,3);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testCheckSaleListSaleListQueryItem2() {
		saleItem  = new SaleListQueryItem("","","","","","","goods1");
		
		try {
			int n = data.CheckSaleList(saleItem).length;	
			assertEquals(n,3);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testCheckSaleListSaleListQueryItem3() {
		saleItem  = new SaleListQueryItem("","","","","","1","");
		
		try {
			int n = data.CheckSaleList(saleItem).length;	
			assertEquals(n,4);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCheckSaleListSaleListQueryItem4() {
		saleItem  = new SaleListQueryItem("","","","1","","","");
		
		try {
			int n = data.CheckSaleList(saleItem).length;	
			assertEquals(n,4);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCheckSaleListSaleListQueryItem5() {
		saleItem  = new SaleListQueryItem("","","","","销售管理人员","","");
		
		try {
			int n = data.CheckSaleList(saleItem).length;	
			assertEquals(n,4);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void testCheckSaleReturnListSaleReturnListQueryItem() {
		saleReturnItem  = new SaleReturnListQueryItem();
		try {
			int n = data.CheckSaleReturnList(saleReturnItem).length;
			assertEquals(n,2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllPendingSaleList() {
		try {
			assertEquals(1,data.GetAllPendingSaleList().clone().length);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}