package FinanceNoteData;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data.FinanceNoteData.CashBillDataImpl;
import data.utility.DataBaseHelper;
import initialization.CashBillInitializer;
import po.potreasurer.CashBillPO;
import queryItem.CashBillQueryItem;

public class CashBillDataImplTest {

	private static final String treasurerDataBaseName = "treasurer";
	private Connection connection = DataBaseHelper.getDataBaseConnection(treasurerDataBaseName);
	CashBillDataImpl impl = new CashBillDataImpl();
	
	@Before
	public void setUp() throws Exception {	
		String sql = "delete from cash_bill";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt = connection.prepareStatement(sql);
		stmt.executeUpdate();
		stmt.close();
	}

	@Test
	public void testSaveCashBill1() {
		boolean result = true;
		String[] a = {"条目1", "条目2"};
		double[] b = {100, 200};
		String[] c = {"备注1", "备注2"};
		
		try {
			result = impl.saveCashBill(new CashBillPO("XJFYD-20170101-12536", "财务人员1", "账户1", 2, a, b, c, 300, true, false));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	@Test
	public void testSaveCashBill2() {
		boolean result = true;
		String[] x = {"条目1", "条目2"};
		double[] y = {1000, 2000};
		String[] z = {"备注1", "备注2"};
		
		try {
			result = impl.saveCashBill(new CashBillPO("XJFYD-20170202-12036", "财务人员1", "账户1", 2, x, y, z, 3000, true, false));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	@Test
	public void testSaveCashBill3() {
		boolean result = true;
		String[] d = {"条目3", "条目4"};
		double[] e = {500, 1000};
		String[] f = {"备注3", "备注4"};
		
		try {
			result = impl.saveCashBill(new CashBillPO("XJFYD-20180101-52630", "财务人员2", "账户2", 2, d, e, f, 1500, true, false));
		} catch (RemoteException ed) {
			ed.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	

	@Test
	public void testInquiryCashBill() {
		CashBillInitializer.initCashBill();
		List<CashBillPO> list = null;
		try {
			list = impl.inquiryCashBill(new CashBillQueryItem("20170201", "20180101", "", ""));
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		assertEquals(list.size(), 2);
		assertEquals(list.get(0).getNoteNumber(), "XJFYD-20170202-12036");
		assertEquals(list.get(1).getNoteNumber(), "XJFYD-20180101-52630");
	}

	@Test
	public void testGetAllPassedButNotInformedCashBill() {
		CashBillInitializer.initCashBill();
		List<CashBillPO> list = null;
		try {
			list = impl.inquiryCashBill(new CashBillQueryItem());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		assertEquals(list.size(), 3);
		assertEquals(list.get(0).getNoteNumber(), "XJFYD-20170101-12536");
		assertEquals(list.get(1).getNoteNumber(), "XJFYD-20170202-12036");
		assertEquals(list.get(2).getNoteNumber(), "XJFYD-20180101-52630");
	}

	@Test
	public void testSetCashBillInformed() {
		boolean result = true;
		try {
			result = impl.setCashBillInformed(new CashBillPO("XJFYD-20170101-12536", "", "", 0, null, null, null, 0, true, false));
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		assertEquals(result, true);
	}
}
