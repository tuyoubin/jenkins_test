package dataservice.StockNoteDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.postock.StockGiftNotePO;
import queryItem.StockGiftNoteQueryItem;

public interface StockGiftNoteDataService extends Remote{
	
	//获取所有的库存赠送单
	public List<StockGiftNotePO> getAllStockGiftNote() throws RemoteException;
		
	//获取符合条件的库存赠送单
	public List<StockGiftNotePO> inquiryStockGiftNote(StockGiftNoteQueryItem stockGiftNoteQueryItem) throws RemoteException;
	
	//保存库存赠送单 
	public boolean saveStockGiftNote(StockGiftNotePO giftNote)throws RemoteException;
	
}
