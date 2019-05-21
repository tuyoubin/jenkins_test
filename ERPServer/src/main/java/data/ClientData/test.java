package data.ClientData;

import java.rmi.RemoteException;

import po.posale_purchase_client.ClientPO;

public class test {

	
	
	public test() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		ClientDataServiceImpl s = new ClientDataServiceImpl();
		ClientPO po = new ClientPO("22","22", "22", "22", "22", "22", "22", "22", 23.2, 25.2 , 22, "22");
		try {
			s.ClientAdd(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
