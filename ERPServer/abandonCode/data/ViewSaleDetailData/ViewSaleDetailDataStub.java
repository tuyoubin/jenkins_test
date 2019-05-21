package data.ViewSaleDetailData;

import dataservice.ViewReportDataService.ViewSaleDetailDataService;

public class ViewSaleDetailDataStub implements ViewSaleDetailDataService {

	@Override
	public boolean exportSaleDetail() {
		System.out.println("data exportSaleDetail");
		return true;
	}
	
}
