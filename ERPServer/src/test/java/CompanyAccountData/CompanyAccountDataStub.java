package CompanyAccountData;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.CompanyAccountDataService.CompanyAccountDataService;
import po.potreasurer.CompanyAccountPO;

public class CompanyAccountDataStub implements CompanyAccountDataService {

	@Override
	public boolean isExist(CompanyAccountPO account) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addCompanyAccount(CompanyAccountPO account) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteCompanyAccount(CompanyAccountPO account) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean modifyCompanyAccount(CompanyAccountPO oldAccountState, CompanyAccountPO newAccountState)
			throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<CompanyAccountPO> inquiryCompanyAccount(String inquiryInput) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyAccountPO getOneCompanyAccount(String accountName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
