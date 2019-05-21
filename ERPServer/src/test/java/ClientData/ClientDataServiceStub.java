package ClientData;

import java.rmi.RemoteException;

import dataservice.ClientDataService.ClientDataService;
import po.posale_purchase_client.ClientPO;

public class ClientDataServiceStub implements ClientDataService{
	ClientPO po= new ClientPO("编号", "分类","等级", "客户1", "123456789", "中国", "223800", "1151128974@", 0, 0, 0, "ha");
	
	@Override
	public boolean Find(String input) throws RemoteException {
		if(input.equals("客户1"))
		return true;
		return false;
	}

	@Override
	public ClientPO ClientInfo(String input) throws RemoteException {
		return po;
	}

	@Override
	public void ClientChange(ClientPO po) throws RemoteException {
		return;
		
	}

	@Override
	public void ClientDelete(String id) throws RemoteException {
		return;
		
	}

	@Override
	public void ClientAdd(ClientPO po) throws RemoteException {
		return;
		
	}

	@Override
	public ClientPO[] GetAll() throws RemoteException {
		ClientPO[] p =new ClientPO[1];
		p[0] =po;
		return p;
	}

}
