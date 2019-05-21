package StockNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.StockNoteDataService.StockGiftNoteDataService;
import po.postock.StockGiftNotePO;
import queryItem.StockGiftNoteQueryItem;

public class StockGiftNoteDataStub implements StockGiftNoteDataService{

	@Override
	public List<StockGiftNotePO> getAllStockGiftNote() throws RemoteException {
		List<StockGiftNotePO> list = new ArrayList<StockGiftNotePO>();
		
		String[] id = {"0001","0002"};
		String[] name = {"A","B"};
		String[] type = {"type1", "type2"};
		int[] amounts = {5, 10};
		StockGiftNotePO note1 = new StockGiftNotePO("KCZSD-20171201-1148", null, 2, id, name, type, amounts, "");
		StockGiftNotePO note2 = new StockGiftNotePO("KCZSD-20180101-0916", null, 2, id, name, type, amounts, "");
		list.add(note1);
		list.add(note2);
		
		return list;
	}

	@Override
	public List<StockGiftNotePO> inquiryStockGiftNote(StockGiftNoteQueryItem stockGiftNoteQueryItem)
			throws RemoteException {
		return getAllStockGiftNote();
	}

	@Override
	public boolean saveStockGiftNote(StockGiftNotePO giftNote) throws RemoteException {
		System.out.println("保存单据到数据库");
		return false;
	}

}
