package ViewBusinessTrackData;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data.ViewReportData.ViewBusinessTrackData.ViewBusinessTrackDataImpl;
import po.popublic.NotePO;
import po.potreasurer.CashBillPO;
import po.potreasurer.CreditNotePO;
import po.potreasurer.DebitNotePO;

public class ViewBusinessTrackDataImplTest {

	ViewBusinessTrackDataImpl impl = new ViewBusinessTrackDataImpl();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExportBusinessTrack1() {
		List<List<NotePO>> alllist = new ArrayList<List<NotePO>>();
		
		List<NotePO> list = new ArrayList<NotePO>();
		String[] a= {"账户1", "账户2"};
		double[] b = {100, 200};
		String[] c = {"备注1", "备注2"};
		list.add(new DebitNotePO("SKD##-20170101-54321", "客户1", "财务人员1", 2, a, b, c, 300, true, false));
		
		alllist.add(list);
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		
		boolean result = false;
		try {
			result = impl.exportBusinessTrack(alllist);
		} catch (RemoteException es) {
			// TODO Auto-generated catch block
			es.printStackTrace();
		}
		assertEquals(result, true);
	}
	@Test
	public void testExportBusinessTrack2() {
		List<List<NotePO>> alllist = new ArrayList<List<NotePO>>();
		
		List<NotePO> list = new ArrayList<NotePO>();
		String[] x= {"账户1", "账户2"};
		double[] y = {100, 200};
		String[] z = {"备注1", "备注2"};
		list.add(new CreditNotePO("FKD##-20170202-12121", "客户1", "财务人员1", 2, x, y, z, 300, true, false));
		
		alllist.add(list);
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		
		boolean result = false;
		try {
			result = impl.exportBusinessTrack(alllist);
		} catch (RemoteException es) {
			// TODO Auto-generated catch block
			es.printStackTrace();
		}
		assertEquals(result, true);
	}
	@Test
	public void testExportBusinessTrack3() {
		List<List<NotePO>> alllist = new ArrayList<List<NotePO>>();
		
		List<NotePO> list = new ArrayList<NotePO>();
		String[] d = {"条目3", "条目4"};
		double[] e = {500, 1000};
		String[] f = {"备注3", "备注4"};
		list.add(new CashBillPO("XJFYD-20180101-52630", "财务人员2", "账户2", 2, d, e, f, 1500, true, false));
		
		alllist.add(list);
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		alllist.add(new ArrayList<NotePO>());
		
		boolean result = false;
		try {
			result = impl.exportBusinessTrack(alllist);
		} catch (RemoteException es) {
			// TODO Auto-generated catch block
			es.printStackTrace();
		}
		assertEquals(result, true);
	}

}
