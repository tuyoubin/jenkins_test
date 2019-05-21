package data.SaleListData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.SaleListDataService.SaleListDataService;
import po.posale_purchase_client.ListOfGoodsPO;
import po.posale_purchase_client.SaleListPO;
import queryItem.SaleListQueryItem;
import queryItem.SaleReturnListQueryItem;

public class SaleListDataServiceImpl implements SaleListDataService{
	FileHelper  fh= new FileHelper();
	@Override
	public void insert(SaleListPO po) throws RemoteException {
		String state = po.get_state();
		String info  = fh.SaleList_poToString(po);
		String numbering = po.get_ListNumbering();
		fh.writeFile(info, numbering, state);
		
	}

	@Override
	public void commit(SaleListPO po) throws RemoteException {
		String info  = fh.SaleList_poToString(po);
		String numbering = po.get_ListNumbering();
		fh.write(info, numbering);
	}

	@Override
	public SaleListPO[] GetAllSaleList() throws RemoteException {
		String state = "";
		String salelist[] =fh.readFileList("销售单");
		String numberingList[] = new String[ salelist.length];
		for(int i=0;i<salelist.length;i++){
			numberingList[i] = salelist[i].split("_")[0];
		}		
		String info[] =new String [salelist.length];
		SaleListPO po[] =new SaleListPO[salelist.length];
		
		for(int i=0;i<salelist.length;i++){
			info[i] = fh.readFile(state, numberingList[i]);
			po[i] = fh.SaleList_stringToPO(info[i]);
		}
		return po;
	}

	@Override
	public SaleListPO[] GetAllSaleReturnList() throws RemoteException {
		String state = "Return";
		String salelist[] =fh.readFileList("销售退货单");
		String numberingList[] = new String[ salelist.length];
		for(int i=0;i<salelist.length;i++){
			numberingList[i] = salelist[i].split("_")[0];
		}		
		String info[] =new String [salelist.length];
		SaleListPO po[] =new SaleListPO[salelist.length];
		
		for(int i=0;i<salelist.length;i++){
			info[i] = fh.readFile(state, numberingList[i]);
			po[i] = fh.SaleList_stringToPO(info[i]);
		}
		return po;
	}

	@Override
	public SaleListPO[] CheckSaleList(String start, String end) throws RemoteException {
		SaleListPO[] po =GetAllSaleList();
		
		ArrayList<SaleListPO>  list = new ArrayList<SaleListPO>();
		
		if(start.equals(""))
			start = "0";
		
		if(end.equals(""))
			end ="99999999";
		
		
		for(int i=0;i<po.length;i++){
			int time = Integer.parseInt(po[i].get_ListNumbering().split("-")[1]);
			if(time<=Integer.parseInt(end)&&time>=Integer.parseInt(start))
				list.add(po[i]);	
		}
		
		SaleListPO[] result =new SaleListPO[list.size()];
		for(int i =0;i<list.size();i++){
			result[i] = list.get(i);	
		}
		return result;
		
	}

	@Override
	public SaleListPO[] CheckSaleReturnList(String start, String end) throws RemoteException {
		SaleListPO[] po =GetAllSaleReturnList();
		
		ArrayList<SaleListPO>  list = new ArrayList<SaleListPO>();
		
		if(start.equals(""))
			start = "0";
		
		if(end.equals(""))
			end ="99999999";
		
		for(int i=0;i<po.length;i++){
			int time = Integer.parseInt(po[i].get_ListNumbering().split("-")[1]);
			if(time<=Integer.parseInt(end)&&time>=Integer.parseInt(start))
				list.add(po[i]);	
		}
		
		SaleListPO[] result =new SaleListPO[list.size()];
		for(int i =0;i<list.size();i++){
			result[i] = list.get(i);	
		}
		return result;
	}

	@Override
	public SaleListPO[] CheckSaleList(SaleListQueryItem item) throws RemoteException {
		String start = item.startDate;
		String end  = item.endDate;
		String   merchandiser = item.merchandiser;
		String   goodsName =  item.goodsName;
		String  operator_id =item.operator_id;
		String  client= item.client;
		String  storehouse     = item.storehouse;
		
		//时间过滤一层
		SaleListPO po_selectedbyTime[] = CheckSaleList(start,end);
	
		// merchandiser过滤一层
		SaleListPO po1[] =selectedbymerchandiser(po_selectedbyTime,merchandiser);
//System.out.println(po1.length);		
		// operator_id过滤
		SaleListPO po2[] =selectedbyoperator_id(po1,operator_id);
//System.out.println(po2.length);
		//client
		SaleListPO po3[] =selectedbyclient(po2,client);
//System.out.println(po3.length);
		//storehouse
		SaleListPO po4[] =selectedbystorehouse(po3,storehouse);

		//names
		SaleListPO po5[] =selectedbyGoodsName(po4,goodsName);


		return po5;
}
	public SaleListPO[] selectedbymerchandiser(SaleListPO   po[],String merchandiser){
		ArrayList<SaleListPO>  po_merchandiser =new ArrayList<SaleListPO>();
		
		if(!merchandiser.equals(""))
		{
			for(int i=0;i<po.length;i++)
			{
				if(po[i].get_merchandiser().equals(merchandiser))
				po_merchandiser.add(po[i]);
			}		
		}
		
		else
		{
			return po;
		}
		
			
		SaleListPO po_selectedbyMerchandiser[] =new SaleListPO[po_merchandiser.size()];
		for(int i=0;i<po_merchandiser.size();i++)
			{
			po_selectedbyMerchandiser[i] = po_merchandiser.get(i);
			}
		
		return po_selectedbyMerchandiser;
		
	}
	
	public SaleListPO[] selectedbyclient(SaleListPO   po[],String client){
		ArrayList<SaleListPO>  po_client =new ArrayList<SaleListPO>();
		if(!client.equals(""))
		{
			for(int i=0;i<po.length;i++)
			{
				if(po[i].get_client().equals(client))
				po_client.add(po[i]);
			}		
		}
		else{
			return po;
			}
		
		SaleListPO po_selectedbyclient[] =new SaleListPO[po_client.size()];
		for(int i=0;i<po_client.size();i++)
			{
			po_selectedbyclient[i] = po_client.get(i);
			}
		
		
		return po_selectedbyclient;
		
	}
	
	public SaleListPO[] selectedbyoperator_id(SaleListPO   po[],String operator_id){
		ArrayList<SaleListPO>  po_operator_id =new ArrayList<SaleListPO>();
		if(!operator_id.equals(""))
		{
			for(int i=0;i<po.length;i++)
			{
				if(po[i].get_operator_id().equals(operator_id))
				po_operator_id.add(po[i]);
			}		
		}
		else{
			return po;
			}
		
		SaleListPO po_select[] =new SaleListPO[po_operator_id.size()];
		for(int i=0;i<po_operator_id.size();i++)
			{
			po_select[i] = po_operator_id.get(i);
			}
		
		
		return po_select;
		
	}
	
	
	public SaleListPO[] selectedbystorehouse(SaleListPO   po[],String storehouse){
		ArrayList<SaleListPO>  po_storehouse =new ArrayList<SaleListPO>();
		if(!storehouse.equals(""))
		{
			for(int i=0;i<po.length;i++)
			{
				if(po[i].storehouse().equals(storehouse))
				po_storehouse.add(po[i]);
			}		
		}
		else{	
			return po;
			}
		
		SaleListPO po_select[] =new SaleListPO[po_storehouse.size()];
		for(int i=0;i<po_storehouse.size();i++)
			{
			po_select[i] = po_storehouse.get(i);
			}
		
		return po_select;
		
	}
	
	
	public SaleListPO[] selectedbyGoodsName(SaleListPO[] po,String GoodsNames){
		if(GoodsNames.equals(""))
			return po;
		
		
		SaleListPO[] pobyName;
		ArrayList<SaleListPO> po_name =new ArrayList<SaleListPO>();
		
		ListOfGoodsPO goods[] =new ListOfGoodsPO[po.length];
			
		String goodsName[][] =new String[po.length][];
		
		for(int i=0;i<po.length;i++)
		{			
			goods[i] =po[i].get_ListOfGoodsPO();
			goodsName[i] = goods[i].get_NameOfGoods();	
		}
		
		for(int i=0;i<po.length;i++){
			for(int j=0;j<goodsName[i].length;j++){
				if(goodsName[i][j].equals(GoodsNames)){
					po_name.add(po[i]);
				}		
			}	
		}
		
		pobyName =new SaleListPO[po_name.size()];
		for(int i=0;i<pobyName.length;i++){
			pobyName[i] = po_name.get(i);
		}
		
		
		return pobyName;
	}
	
	

	@Override
	public SaleListPO[] CheckSaleReturnList(SaleReturnListQueryItem item) throws RemoteException {
		String start = item.startDate;
		String end  = item.endDate;
		String   merchandiser = item.merchandiser;
		
		String  operator_id =item.operator_id;
		String  client= item.client;
		String  storehouse     = item.storehouse;
		
		//时间过滤一层
		SaleListPO po_selectedbyTime[] = CheckSaleReturnList(start,end);
		
		// merchandiser过滤一层
		SaleListPO po1[] =selectedbymerchandiser(po_selectedbyTime,merchandiser);
		
		// operator_id过滤
		SaleListPO po2[] =selectedbyoperator_id(po1,operator_id);
		//client
		SaleListPO po3[] =selectedbyclient(po2,client);
		//storehouse
		SaleListPO po4[] =selectedbystorehouse(po3,storehouse);
		
		return po4;
		
	}

	@Override
	public SaleListPO[] GetAllPendingSaleList() throws RemoteException {
		SaleListPO po[];
		String SaleListList[] =fh.readPendingList();
		String eachNote[][] = new String[SaleListList.length][5];
		


		for(int i=0;i<SaleListList.length;i++){
			eachNote[i] =  SaleListList[i].split("_"); 		
		}
		
		String info[] =new String[SaleListList.length];
		po=new SaleListPO[SaleListList.length];
		
		for(int i=0;i<SaleListList.length;i++){
			info[i] = fh.read(eachNote[i][0]);
			po[i] = fh.SaleList_stringToPO(info[i]);
		}
		
		return po;
	}

	@Override
	public void deletePendingSaleList(SaleListPO po) throws RemoteException {
		
			fh.deleteNote(po);		
		
	}

}
