package ViewBusinessSituation;

import java.rmi.RemoteException;

import dataservice.ViewReportDataService.ViewBusinessSituationDataService;
import po.poMangaer.BusinessSituationPO;

public class ViewBusinessSituationDataStub implements ViewBusinessSituationDataService {

	public ViewBusinessSituationDataStub() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean exportBS(BusinessSituationPO BSPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
