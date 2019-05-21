package ViewSaleDetailData;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.ViewReportDataService.ViewSaleDetailDataService;
import po.potreasurer.SaleDetailItemPO;

public class ViewSaleDetailDataStub implements ViewSaleDetailDataService {

	@Override
	public boolean exportSaleDetail(List<SaleDetailItemPO> saleDetailItemPOList) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
