package DocumentData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.DocumentDataService.DocumentDataService;
import po.popublic.NotePO;
import po.potreasurer.CashBillPO;

public class DocumentDataStub implements DocumentDataService {

	public DocumentDataStub() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<NotePO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<NotePO> listvo = new ArrayList<NotePO>();
		String[] a = {"条目1", "条目2"};
		double[] b = {100, 200};
		String[] c = {"备注1", "备注2"};
		listvo.add(new CashBillPO("XJFYD-20000101", "财务人员1", "账户1", 2, a, b, c, 300, false, false));
		return listvo;
	}

	@Override
	public boolean ApprovalDoc(NotePO Note) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean submitDoc(NotePO Note) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean NoPassDoc(NotePO Note) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
