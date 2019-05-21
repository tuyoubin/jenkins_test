package FinanceNoteData;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data.FinanceNoteData.DebitNoteDataImpl;
import data.utility.DataBaseHelper;
import initialization.DebitNoteInitializer;
import po.potreasurer.DebitNotePO;
import queryItem.DebitNoteQueryItem;

public class DebitNoteDataImplTest {

	private static final String treasurerDataBaseName = "treasurer";
	private Connection connection = DataBaseHelper.getDataBaseConnection(treasurerDataBaseName);
	DebitNoteDataImpl impl = new DebitNoteDataImpl();
	
	@Before
	public void setUp() throws Exception {
		String sql = "delete from debit_note";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt = connection.prepareStatement(sql);
		stmt.executeUpdate();
		stmt.close();
	}

	@Test
	public void testSaveDebitNote1() {
		boolean result = false;
		String[] a= {"账户1", "账户2"};
		double[] b = {100, 200};
		String[] c = {"备注1", "备注2"};
		
		try {
			result = impl.saveDebitNote(
							new DebitNotePO("SKD##-20170101-54321", "客户1", "财务人员1", 2, a, b, c, 300, true, false));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(result, true);
	}
	@Test
	public void testSaveDebitNote2() {
		boolean result = false;
		try {
			String[] x= {"账户1", "账户2"};
			double[] y = {100, 200};
			String[] z = {"备注1", "备注2"};
			result = impl.saveDebitNote(
							new DebitNotePO("SKD##-20170202-12121", "客户1", "财务人员1", 2, x, y, z, 300, true, false));
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(result, true);
	}
	@Test
	public void testSaveDebitNote3() {
		boolean result = false;
		try {
			String[] d = {"账户1", "账户2"};
			double[] e = {500, 600};
			String[] f = {"备注3", "备注4"};
			result = impl.saveDebitNote(
							new DebitNotePO("SKD##-20180101-15234", "客户2", "财务人员2", 2, d, e, f, 1100, true, false));
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(result, true);
	}

	@Test
	public void testInquiryDebitNote() {
		DebitNoteInitializer.initDebitNote();
		List<DebitNotePO> list = null;
		try {
			list = impl.inquiryDebitNote(new DebitNoteQueryItem("20170201", "20180101", "", ""));
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		assertEquals(list.size(), 2);
		assertEquals(list.get(0).getNoteNumber(), "SKD##-20170202-12121");
		assertEquals(list.get(1).getNoteNumber(), "SKD##-20180101-15234");
	}

	@Test
	public void testGetAllPassedButNotInformedDebitNote() {
		DebitNoteInitializer.initDebitNote();
		List<DebitNotePO> list = null;
		try {
			list = impl.inquiryDebitNote(new DebitNoteQueryItem());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		assertEquals(list.size(), 3);
		assertEquals(list.get(0).getNoteNumber(), "SKD##-20170101-54321");
		assertEquals(list.get(1).getNoteNumber(), "SKD##-20170202-12121");
		assertEquals(list.get(2).getNoteNumber(), "SKD##-20180101-15234");
	}

	@Test
	public void testSetDebitNoteInformed() {
		DebitNoteInitializer.initDebitNote();
		try {
			assertEquals(impl.setDebitNoteInformed(new DebitNotePO("SKD##-20170101-54321", "", "", 0, null, null, null, 0, true, false)), true);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

}
