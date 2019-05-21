package StockNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.StockNoteDataService.StockWarningNoteDataService;
import po.postock.StockWarningNotePO;

public class StockWarningNoteDataStub implements StockWarningNoteDataService{

	@Override
	public List<StockWarningNotePO> getAllStockWarningNote() throws RemoteException {
		List<StockWarningNotePO> list = new ArrayList<StockWarningNotePO>();
		StockWarningNotePO note1 = new StockWarningNotePO("KCBJD-20180101-1334", "0001", "A", 10);
		StockWarningNotePO note2 = new StockWarningNotePO("KCBJD-20180101-1812", "0002", "B", 10);
		list.add(note1);
		list.add(note2);
		return list;
	}

	@Override
	public boolean saveStockWarningNote(StockWarningNotePO warningNote) throws RemoteException {
		System.out.println("保存单据到数据库");
		return false;
	}

}
