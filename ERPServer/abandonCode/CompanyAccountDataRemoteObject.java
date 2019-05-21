package rmi;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.CompanyAccountDataService.CompanyAccountDataService;
import po.potreasurer.CompanyAccountPO;

public class CompanyAccountDataRemoteObject extends DataRemoteObject implements CompanyAccountDataService {

	private static final long serialVersionUID = 1L;
	
	private CompanyAccountDataService companyAccountData;

	public CompanyAccountDataRemoteObject() throws RemoteException {
//		companyAccountData = new CompanyAccountDataStub();
	}

}
