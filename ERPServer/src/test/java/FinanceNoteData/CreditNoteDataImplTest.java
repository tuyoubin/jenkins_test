package FinanceNoteData;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data.FinanceNoteData.CreditNoteDataImpl;
import data.utility.DataBaseHelper;
import initialization.CreditNoteInitializer;
import po.potreasurer.CreditNotePO;
import queryItem.CreditNoteQueryItem;

public class CreditNoteDataImplTest {

	private static final String treasurerDataBaseName = "treasurer";
	private Connection connection = DataBaseHelper.getDataBaseConnection(treasurerDataBaseName);
	CreditNoteDataImpl impl = new CreditNoteDataImpl();
	
	@Before
	public void setUp() throws Exception {
		String sql = "delete from credit_note";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt = connection.prepareStatement(sql);
		stmt.executeUpdate();
		stmt.close();
	}

	@Test
	public void testSaveCreditNote1() {
		boolean result = true;
		String[] a= {"账户1", "账户2"};
		double[] b = {100, 200};
		String[] c = {"备注1", "备注2"};
		
		try {
			result = impl.saveCreditNote(new CreditNotePO("FKD##-20170101-54321", "客户1", "财务人员1", 2, a, b, c, 300, true, false));

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(result, true);
	}
	@Test
	public void testSaveCreditNote2() {
		boolean result = true;
		String[] x= {"账户1", "账户2"};
		double[] y = {100, 200};
		String[] z = {"备注1", "备注2"};
		
		try {
			result = impl.saveCreditNote(new CreditNotePO("FKD##-20170202-12121", "客户1", "财务人员1", 2, x, y, z, 300, true, false));

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(result, true);
	}
	@Test
	public void testSaveCreditNote3() {
		boolean result = true;
		String[] d = {"账户1", "账户2"};
		double[] e = {500, 600};
		String[] f = {"备注3", "备注4"};
		
		try {
			result = impl.saveCreditNote(new CreditNotePO("FKD##-20180101-15234", "客户2", "财务人员2", 2, d, e, f, 1100, true, false));

		} catch (RemoteException ed) {
			ed.printStackTrace();
		}
		assertEquals(result, true);
	}

	@Test
	public void testInquiryCreditNote() {
		CreditNoteInitializer.initCreditNote();
		List<CreditNotePO> list = null;
		try {
			list = impl.inquiryCreditNote(new CreditNoteQueryItem("20170201", "20180101", "", ""));
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		assertEquals(list.size(), 2);
		assertEquals(list.get(0).getNoteNumber(), "FKD##-20170202-12121");
		assertEquals(list.get(1).getNoteNumber(), "FKD##-20180101-15234");
	}

	@Test
	public void testGetAllPassedButNotInformedCreditNote() {
		CreditNoteInitializer.initCreditNote();
		List<CreditNotePO> list = null;
		try {
			list = impl.inquiryCreditNote(new CreditNoteQueryItem());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		assertEquals(list.size(), 3);
		assertEquals(list.get(0).getNoteNumber(), "FKD##-20170101-54321");
		assertEquals(list.get(1).getNoteNumber(), "FKD##-20170202-12121");
		assertEquals(list.get(2).getNoteNumber(), "FKD##-20180101-15234");
	}

	@Test
	public void testSetCreditNoteInformed() {
		boolean result = true;
		try {
			result = impl.setCreditNoteInformed(new CreditNotePO("FKD##-20170101-54321", "", "", 0, null, null, null, 0, true, false));
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		assertEquals(result, true);
	}

}
