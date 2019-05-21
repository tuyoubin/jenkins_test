package data.PurchaseNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.PurchaseNoteDataService.PurchaseNoteDataService;
import po.posale_purchase_client.PurchaseNotePO;
import queryItem.PurchaseNoteQueryItem;
import queryItem.PurchaseReturnNoteQueryItem;

public class PurchaseNoteDataServiceImpl  implements PurchaseNoteDataService{
	filehelper help =new filehelper();


	
	
//保存在进货单或者是进货退货单里
	public void insert(PurchaseNotePO po) throws RemoteException {
		
		String info = help.PurchaseNote_poToString(po);
		String numbering = po.get_ListNumbering();
		String state = po.get_state();
		String provider = po.get_provider();
		String operator_id =po.operator_id();
		String storehouse = po.get_storehouse();
		
		System.out.println(help.writeFile(info, numbering, state, provider, operator_id, storehouse));
	}

	@Override
//保存在待审批文件夹里	
	public void commit(PurchaseNotePO po) {
		// TODO Auto-generated method stub
		String info = help.PurchaseNote_poToString(po);
		String numbering = po.get_ListNumbering();
		String state = po.get_state();
		String provider = po.get_provider();
		String operator_id =po.operator_id();
		String storehouse = po.get_storehouse();
		help.write(info, numbering, state, provider, operator_id, storehouse);
		
	}

	@Override
	public PurchaseNotePO[] GetAllPurchaseNote() throws RemoteException {
	
		PurchaseNotePO po[];
		String PurchaseNoteList[] =help.readFileList("进货单");
		String state ="";
		
		String eachName[][] = new String[PurchaseNoteList.length][5];
		for(int i=0;i<PurchaseNoteList.length;i++){
			eachName[i] =  PurchaseNoteList[i].split("_"); 	
		}
		
		String info[] =new String[PurchaseNoteList.length];
		po=new PurchaseNotePO[PurchaseNoteList.length];
		for(int i=0;i<PurchaseNoteList.length;i++){
			info[i] = help.readFile(state, eachName[i][0],eachName[i][1],eachName[i][2],eachName[i][3]);
			po[i] = help.PurchaseNote_stringToPO(info[i]);
		}
		return po;
	}

	@Override
	public PurchaseNotePO[] GetAllPurchaseReturnNote() throws RemoteException {
		PurchaseNotePO po[];
		String PurchaseNoteList[] =help.readFileList("进货退货单");
		String state ="Return";
		
		String eachNote[][] = new String[PurchaseNoteList.length][5];
		for(int i=0;i<PurchaseNoteList.length;i++){
			eachNote[i] =  PurchaseNoteList[i].split("_"); 	
		}
		
		String info[] =new String[PurchaseNoteList.length];
		po=new PurchaseNotePO[PurchaseNoteList.length];
		
		for(int i=0;i<PurchaseNoteList.length;i++){
			info[i] = help.readFile(state, eachNote[i][0],eachNote[i][1],eachNote[i][2],eachNote[i][3]);
			po[i] = help.PurchaseNote_stringToPO(info[i]);
		}
		return po;
	}

	@Override
	public PurchaseNotePO[] CheckPurchaseNote(String start, String end) throws RemoteException {
		PurchaseNotePO[] allPurchaseNote= GetAllPurchaseNote();
		
		ArrayList<PurchaseNotePO>  list = new ArrayList<PurchaseNotePO>();
		
		if(start.equals(""))
			start = "0";
		
		if(end.equals(""))
			end ="99999999";
		
		
		
		for(int i=0;i<allPurchaseNote.length;i++){
			int time = Integer.parseInt(allPurchaseNote[i].get_ListNumbering().split("-")[1]);
			if(time<=Integer.parseInt(end)&&time>=Integer.parseInt(start))
				list.add(allPurchaseNote[i]);	
		}
		
		PurchaseNotePO[] result =new PurchaseNotePO[list.size()];
		for(int i =0;i<list.size();i++){
			result[i] = list.get(i);	
		}
		return result;
	}

	@Override
	public PurchaseNotePO[] CheckPurchaseReturnNote(String start, String end) throws RemoteException {
		PurchaseNotePO[] allPurchaseNote= GetAllPurchaseReturnNote();
		
		ArrayList<PurchaseNotePO>  list = new ArrayList<PurchaseNotePO>();
		
		if(start.equals(""))
			start = "0";
		
		if(end.equals(""))
			end ="99999999";
		
			
		for(int i=0;i<allPurchaseNote.length;i++){
			int time = Integer.parseInt(allPurchaseNote[i].get_ListNumbering().split("-")[1]);
			if(time<=Integer.parseInt(end)&&time>=Integer.parseInt(start))
				list.add(allPurchaseNote[i]);	
		}
		
		PurchaseNotePO[] result =new PurchaseNotePO[list.size()];
		for(int i =0;i<list.size();i++){
			result[i] = list.get(i);	
		}
		return result;
		
	}
//排列组合出所有的情况筛选，很傻
	@Override
	public PurchaseNotePO[] CheckPurchaseNote(PurchaseNoteQueryItem item) throws RemoteException {
		String provider = item.provider;
		//操作员
		String operator_id  = item.operator_id;
		//仓库
		String storehouse  =item.storehouse;
		
		PurchaseNotePO[] po = CheckPurchaseNote(item.startDate,item.endDate);
		
		ArrayList<PurchaseNotePO> list =new ArrayList<PurchaseNotePO>();
		
		
		
		 if(operator_id.equals("") && storehouse.equals("" ) && provider.equals("")){
			return po;
		}
		 
		 else if(operator_id.equals("")&&storehouse.equals("")&&!provider.equals("")){
			 for(int i=0;i<po.length;i++){
					if(po[i].get_provider().equals(provider))
						list.add(po[i]);
			 }
		 }
		
		else if(operator_id.equals("")&&!storehouse.equals("")&&provider.equals("")){
			for(int i=0;i<po.length;i++){
				if(po[i].get_storehouse().equals(storehouse))
					list.add(po[i]);
			}
		}
		
			else if(!operator_id.equals("")&&storehouse.equals("")&&provider.equals("")){
				for(int i=0;i<po.length;i++){
					if(po[i].operator_id().equals(operator_id))
						list.add(po[i]);
				}	
		}
		
			else if(!operator_id.equals("")&&!storehouse.equals("")&&provider.equals("")){
				for(int i=0;i<po.length;i++){
					if(po[i].operator_id().equals(operator_id)&&po[i].get_storehouse().equals(storehouse))
						list.add(po[i]);
				}	
		}
		
			else if(!operator_id.equals("")&&storehouse.equals("")&&!provider.equals("")){
				for(int i=0;i<po.length;i++){
					if(po[i].operator_id().equals(operator_id)&&po[i].get_provider().equals(provider))
						list.add(po[i]);
				}	
		}
		
			else if(operator_id.equals("")&&!storehouse.equals("")&&!provider.equals("")){
				for(int i=0;i<po.length;i++){
					if(po[i].get_storehouse().equals(storehouse)&&po[i].get_provider().equals(provider))
						list.add(po[i]);
				}	
		}
		
			else if(!operator_id.equals("")&&!storehouse.equals("")&&!provider.equals("")){
				for(int i=0;i<po.length;i++){
					if(po[i].get_storehouse().equals(storehouse)&&po[i].get_provider().equals(provider)&&po[i].operator_id().equals(operator_id))
						list.add(po[i]);
				}	
		}
		
		int size = list.size();
		PurchaseNotePO filter[] =  new PurchaseNotePO[size];
		for(int i=0;i<size;i++){
			filter[i] =list.get(i);
		}
		
		return filter;
	}

	@Override
	public PurchaseNotePO[] CheckPurchaseReturnNote(PurchaseReturnNoteQueryItem item) throws RemoteException {
		String provider = item.provider;
		//操作员
		String operator_id  = item.operator_id;
		//仓库
		String storehouse  =item.storehouse;
		
		PurchaseNotePO[] po = CheckPurchaseReturnNote(item.startDate,item.endDate);
		
System.out.println(po.length);	

		ArrayList<PurchaseNotePO> list =new ArrayList<PurchaseNotePO>();
		
		if(operator_id.equals("")&&storehouse.equals("")&&provider.equals("")){
			return po;
		}
		
		else if(operator_id.equals("")&&!storehouse.equals("")&&!provider.equals("")){
			for(int i=0;i<po.length;i++){
				if(po[i].get_provider().equals(provider))
					list.add(po[i]);
			}
		}
		
		
		else if(operator_id.equals("")&&!storehouse.equals("")&&provider.equals("")){
			for(int i=0;i<po.length;i++){
				if(po[i].get_storehouse().equals(storehouse))
					list.add(po[i]);
			}
		}
		
		
			else if(!operator_id.equals("")&&storehouse.equals("")&&provider.equals("")){
				for(int i=0;i<po.length;i++){
					if(po[i].operator_id().equals(operator_id))
						list.add(po[i]);
				}	
		}
		
			else if(!operator_id.equals("")&&!storehouse.equals("")&&provider.equals("")){
				for(int i=0;i<po.length;i++){
					if(po[i].operator_id().equals(operator_id)&&po[i].get_storehouse().equals(storehouse))
						list.add(po[i]);
				}	
		}
		
			else if(!operator_id.equals("")&&storehouse.equals("")&&!provider.equals("")){
				for(int i=0;i<po.length;i++){
					if(po[i].operator_id().equals(operator_id)&&po[i].get_provider().equals(provider))
						list.add(po[i]);
				}	
		}
		
			else if(operator_id.equals("")&&!storehouse.equals("")&&!provider.equals("")){
				for(int i=0;i<po.length;i++){
					if(po[i].get_storehouse().equals(storehouse)&&po[i].get_provider().equals(provider))
						list.add(po[i]);
				}	
		}
		
			else if(!operator_id.equals("")&&!storehouse.equals("")&&!provider.equals("")){
				for(int i=0;i<po.length;i++){
			System.out.println(po[i].get_storehouse()+":"+storehouse);
			System.out.println(po[i].get_provider()+":"+provider);
			System.out.println(po[i].operator_id()+":"+operator_id);
			
					if(po[i].get_storehouse().equals(storehouse)&&po[i].get_provider().equals(provider)&&po[i].operator_id().equals(operator_id))
						list.add(po[i]);
				}	
		}
		
		int size = list.size();
		PurchaseNotePO filter[] =  new PurchaseNotePO[size];
		for(int i=0;i<size;i++){
			filter[i] =list.get(i);
		}
		
		return filter;
	}

	@Override
	public PurchaseNotePO[] GetAllPendingPurchaseNote() throws RemoteException {
		PurchaseNotePO po[];
		String PurchaseNoteList[] =help.readPendingList();
		String eachNote[][] = new String[PurchaseNoteList.length][5];
		
		for(int i=0;i<PurchaseNoteList.length;i++){
			eachNote[i] =  PurchaseNoteList[i].split("_"); 		
		}
		
		String info[] =new String[PurchaseNoteList.length];
		po=new PurchaseNotePO[PurchaseNoteList.length];
		for(int i=0;i<PurchaseNoteList.length;i++){
			
			info[i] = help.read(eachNote[i][0],eachNote[i][1],eachNote[i][2],eachNote[i][3]);
			po[i] = help.PurchaseNote_stringToPO(info[i]);
		}
		
		return po;
		
	}

	@Override
	public void deletePendingPurchaseNote(PurchaseNotePO po) throws RemoteException {
			help.deleteNote(po);		
	}	
	
	
}
