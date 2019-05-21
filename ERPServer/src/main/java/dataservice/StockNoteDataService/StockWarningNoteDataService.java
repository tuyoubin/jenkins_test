package dataservice.StockNoteDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.postock.StockWarningNotePO;


public interface StockWarningNoteDataService extends Remote{
	
	//获取所有的库存报警单
	public List<StockWarningNotePO> getAllStockWarningNote() throws RemoteException;
		
	//保存库存报警单
	public boolean saveStockWarningNote(StockWarningNotePO warningNote) throws RemoteException;	
	
}
