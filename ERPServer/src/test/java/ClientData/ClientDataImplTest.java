package ClientData;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.ClientData.ClientDataServiceImpl;
import dataservice.ClientDataService.ClientDataService;
import po.posale_purchase_client.ClientPO;

public class ClientDataImplTest {
	ClientDataService data =new  ClientDataServiceImpl();	
	ClientPO po = new ClientPO("编号", "分类","等级", "新月", "123456789", "中国", "223800", "1151128974@", 0, 0, 0, "ha");
	
	@Before
	public void setUp() throws Exception {
		data.ClientAdd(po);
	}

	@Test
	public void testFind()  {
		int flag = 0;
		
		try {
			if(data.Find("客户1"))
				flag =1;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(flag,1);
		
		
	}

	@Test
	public void testClientInfo() {
		
		try {
			ClientPO p =data.ClientInfo("客户1");
			
			assertEquals(p.get_name(),"客户1");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	@Test
//	public void testClientChange() {
//		po = new ClientPO("编号", "分类","等级", "客户1", "123456789", "中国", "223800", "1151128974@", 0, 0, 0, "hhh");
//		try {
//			data.ClientChange(po);
//			assertEquals(po.get_acquiescence_merchandiser(),"hhh");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testClientDelete(){
//		try {
//			data.ClientDelete("新月");
//			boolean exsit = data.Find("新月");
//			assertEquals(exsit,false);
//			
//		} catch (RemoteException e) {
//			
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testClientAdd() {
//		try {
//			data.ClientAdd(po);
//			boolean exsit = data.Find("新月");
//			assertEquals(exsit,true);
//			
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

	@Test
	public void testGetAll() {
		try {
			int all = data.GetAll().length;
			int flag = 0;
			if(all>0)
				flag =1;
			assertEquals(flag,1);
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
