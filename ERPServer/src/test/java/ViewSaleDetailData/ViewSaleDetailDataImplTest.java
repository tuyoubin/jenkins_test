package ViewSaleDetailData;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data.ViewReportData.ViewSaleDetailData.ViewSaleDetailDataImpl;
import po.potreasurer.SaleDetailItemPO;

public class ViewSaleDetailDataImplTest {

	ViewSaleDetailDataImpl impl = new ViewSaleDetailDataImpl();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExportSaleDetail() {
		List<SaleDetailItemPO> saleDetailItemPOList = new ArrayList<SaleDetailItemPO>();
		saleDetailItemPOList.add(new SaleDetailItemPO("20180101", "0001", "goods1", "type1", 10, 1.5, 15));
		saleDetailItemPOList.add(new SaleDetailItemPO("20180101", "0002", "goods1", "type2", 20, 1.5, 30));
		saleDetailItemPOList.add(new SaleDetailItemPO("20180202", "0003", "goods1", "type3", 10, 3, 30));
		saleDetailItemPOList.add(new SaleDetailItemPO("20180303", "0004", "goods1", "type4", 10, 1, 10));
		
		boolean result = false;
		try {
			result = impl.exportSaleDetail(saleDetailItemPOList);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(result, true);
	}

}
