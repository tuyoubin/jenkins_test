package dataservice.StockNoteDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.postock.StockOverflowNotePO;
import queryItem.StockOverflowNoteQueryItem;

public interface StockOverflowNoteDataService extends Remote{

	//获取所有的库存报溢单
	public List <StockOverflowNotePO>  getAllStockOverflowNote() throws RemoteException;
	
	//获得符合条件的库存报溢单
	public List<StockOverflowNotePO> inquiryStockOverflowNote(StockOverflowNoteQueryItem stockOverflowNoteQueryItem) throws RemoteException;
		
	//保存通过审批的库存报溢单
	public boolean saveStockOverflowNote(StockOverflowNotePO overflowNote) throws RemoteException;
		
}
