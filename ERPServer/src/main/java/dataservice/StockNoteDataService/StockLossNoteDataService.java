package dataservice.StockNoteDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.postock.StockLossNotePO;
import queryItem.StockLossNoteQueryItem;

public interface StockLossNoteDataService extends Remote{

	//获取所有的库存报损单
	public List <StockLossNotePO> getAllStockLossNote() throws RemoteException;
	
	//获取符合条件的库存报损单
	public List<StockLossNotePO> inquiryStockLossNote(StockLossNoteQueryItem stockLossNoteQueryItem) throws RemoteException;
		
	//保存通过审批的库存报损单
	public boolean saveStockLossNote(StockLossNotePO lossNote) throws RemoteException;
		
}
