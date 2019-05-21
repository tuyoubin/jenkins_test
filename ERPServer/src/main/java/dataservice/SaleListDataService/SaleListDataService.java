package dataservice.SaleListDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;


import po.posale_purchase_client.SaleListPO;
import queryItem.SaleListQueryItem;
import queryItem.SaleReturnListQueryItem;


public interface SaleListDataService extends Remote {
	//已审批
	public void insert(SaleListPO po) throws RemoteException;
	//提交审批
	public void commit(SaleListPO po) throws RemoteException;
	//所有已审批过的单据
	public SaleListPO[] GetAllSaleList()throws RemoteException;
	public SaleListPO[] GetAllSaleReturnList()throws RemoteException;
	//查询特定时间单据
	public SaleListPO[] CheckSaleList(String start,String end)throws RemoteException;
	public SaleListPO[] CheckSaleReturnList(String start,String end)throws RemoteException;
	
	public SaleListPO[] CheckSaleList(SaleListQueryItem  item) throws RemoteException;
	public SaleListPO[] CheckSaleReturnList(SaleReturnListQueryItem item) throws RemoteException;
	
			//获取所有待审批销售单、销售退货单
			public SaleListPO[] GetAllPendingSaleList() throws RemoteException;
			//删除这一个销售待审批单据
			public void deletePendingSaleList(SaleListPO po) throws RemoteException;
}
