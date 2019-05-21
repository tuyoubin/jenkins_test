package StockNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.StockNoteDataService.StockLossNoteDataService;
import po.postock.StockLossNotePO;
import queryItem.StockLossNoteQueryItem;

public class StockLossNoteDataStub implements StockLossNoteDataService{

	@Override
	public List<StockLossNotePO> getAllStockLossNote() throws RemoteException {
		List<StockLossNotePO> list = new ArrayList<StockLossNotePO>();

 		String[]id = {"0001","0002"};

 		String[]name = {"A","B"};

 		int[] stockNum = {50,20};

 		int[] realNum = {80,100};

 		list.add(new StockLossNotePO("KCBSD-20171224-123111", null, 2, id, name, stockNum, realNum, false));

 		list.add(new StockLossNotePO("KCBSD-20171223-165101", null, 0, null, null, null, null, false));

 		return list;
	}

	@Override
	public List<StockLossNotePO> inquiryStockLossNote(StockLossNoteQueryItem stockLossNoteQueryItem)
			throws RemoteException {
		return getAllStockLossNote();
	}

	@Override
	public boolean saveStockLossNote(StockLossNotePO lossNote) throws RemoteException {
		System.out.println("保存单据到数据库");
		return false;
	}

}
