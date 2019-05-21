package data.ClientData;

import java.rmi.RemoteException;

import dataservice.ClientDataService.ClientDataService;
import po.posale_purchase_client.ClientPO;

public class ClientDataServiceImpl implements ClientDataService{
	//文本操作辅助方法
	filetest f =new filetest();
	
	@Override
	public boolean Find(String input) throws RemoteException {
		
		System.out.println("连接到server了");
		
		return f.FindExist(input);
	}

	@Override
	public ClientPO ClientInfo(String input) throws RemoteException {
		//获取文本化的对象信息
		String str = f.Info(input);
		//转化为对象;
		ClientPO po = this.stringToPO(str);
		return  po;
	}

	@Override
	public void ClientChange(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String name = po.get_name();
		String numbering = po.get_numbering();
		f.deleteFile(name, numbering);
		f.changeFile(poToString(po),name,numbering);
		
	}

	@Override
	public void ClientDelete(String id) throws RemoteException {
		ClientPO po =ClientInfo(id);
		String name = po.get_name();
		String numbering = po.get_numbering();
		f.deleteFile(name, numbering);
		
	}

	@Override
	public void ClientAdd(ClientPO po) throws RemoteException {
		System.out.println("add impl");
		String name = po.get_name();
		String numbering = po.get_numbering();
		f.writeFile(poToString(po), name, numbering);
	}

	@Override
	public ClientPO[] GetAll() throws RemoteException {
		String AllInString[] =f.getAll();
		ClientPO po[] =new ClientPO[AllInString.length];
		
		for(int i=0;i< po.length;i++){
			po[i]  = stringToPO(AllInString[i]);
		}	
		return po;
	}
	
	
		public String poToString(ClientPO po) {
			  String result ="";
			  String a0  = po.get_numbering();
			  String a1 = po.get_classification();
			  String a2 = po.get_level();
			  String a3 = po.get_name();
			  String a4 = po.get_phone_number();
			  String a5 = po.get_address();
			  String a6 =po.get_postcode();
			  String a7 =po.get_email();
			 double b0 = po.get_receivalbe_amount();
			  double b1 = po.get_receivables();
			  double b2 = po.get_should_pay();
			  String a8 = po.get_acquiescence_merchandiser();
			  
			  
			  result = a0+";;;"+a1+";;;"+a2+";;;"+a3+";;;"+a4+";;;"
			  +a5+";;;"+a6+";;;"+a7+";;;"+b0+";;;"+b1+";;;"+b2+";;;"+a8;
			  
			  return result;
		  }
		
		public ClientPO stringToPO(String str){
			ClientPO po;
			
			String member[] =str.split(";;;");
			  String a0  = member[0];
			  String a1 =  member[1];
			  String a2 = member[2];
			  String a3 =member[3];
			  String a4 =member[4];
			  String a5 = member[5];
			  String a6 =member[6];
			  String a7 =member[7];
			  
			  double b0 = Double.parseDouble(member[8]);
			  double b1 = Double.parseDouble(member[9]);
			  double b2 = Double.parseDouble(member[10]);
			  String a8 = member[11];
			  
			 po =new ClientPO(a0,a1,a2,a3,a4,a5,a6,a7,b0,b1,b2,a8);
			
			return po;
		}
		
}
