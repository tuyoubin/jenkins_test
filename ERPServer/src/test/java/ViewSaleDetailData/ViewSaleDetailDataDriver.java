package ViewSaleDetailData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.ViewReportData.ViewSaleDetailData.ViewSaleDetailDataImpl;
import po.potreasurer.SaleDetailItemPO;

public class ViewSaleDetailDataDriver {

	public ViewSaleDetailDataDriver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ViewSaleDetailDataDriver d = new ViewSaleDetailDataDriver();
		d.test();
	}
	
	public void test() {
		List<SaleDetailItemPO> saleDetailItemPOList = new ArrayList<SaleDetailItemPO>();
		
		SaleDetailItemPO a = new SaleDetailItemPO("Time1", "Number1", "Goods1", "Type1", 2.5);
		a.setAmount(5);a.setTotalPrice(5*2.5);
		
		saleDetailItemPOList.add(a);
		
		a = new SaleDetailItemPO("Time2", "Number2", "Goods2", "Type2", 3.5);
		a.setAmount(10); a.setTotalPrice(3.5*10);
		saleDetailItemPOList.add(a);
		
		ViewSaleDetailDataImpl im = new ViewSaleDetailDataImpl();
		
		try {
			im.exportSaleDetail(saleDetailItemPOList);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
