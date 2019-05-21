package UserData;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.UserData.UserImpl;
import po.poUser.UserPO;

public class UserTestImpl {

	UserImpl user = new UserImpl();
	
	@Before
	
	
	@Test
	
	public void testNewUser(){
		UserPO a = new UserPO("库存管理人员", "123456", "Stock", "1");
		try {
			assertEquals(true,user.newUser(a));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelteteUser() {
		UserPO a = new UserPO("库存管理人员", "123456", "Stock", "1");
		try {
			assertEquals(true,user.deleteUser(a.getID()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
