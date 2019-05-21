package StockNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.StockNoteDataService.StockOverflowNoteDataService;
import po.postock.StockOverflowNotePO;
import queryItem.StockOverflowNoteQueryItem;

public class StockOverflowNoteDataStub implements StockOverflowNoteDataService{

	@Override
	public List<StockOverflowNotePO> getAllStockOverflowNote() throws RemoteException {
		List<StockOverflowNotePO> list = new ArrayList<StockOverflowNotePO>();

 		String[]id = {"0001","0002"};

 		String[]name = {"A","B"};

 		int[] stockNum = {50,20};

 		int[] realNum = {80,100};

 		list.add(new StockOverflowNotePO("KCBYD-20171224-123111", null, 2, id, name, stockNum, realNum, false));

 		list.add(new StockOverflowNotePO("KCBYD-20171223-165101", null, 0, null, null, null, null, false));

 		return list;
	}

	@Override
	public List<StockOverflowNotePO> inquiryStockOverflowNote(StockOverflowNoteQueryItem stockOverflowNoteQueryItem)
			throws RemoteException {
		return getAllStockOverflowNote();
	}

	@Override
	public boolean saveStockOverflowNote(StockOverflowNotePO lossNote) throws RemoteException {
		System.out.println("保存单据到数据库");
		return false;
	}

}
