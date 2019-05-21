package data.StockNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.noteSQLModule.noteSQLGetter.StockWarningNoteSQLGetter;
import data.noteSQLModule.noteSQLWriter.StockWarningNoteSQLWriter;
import dataservice.StockNoteDataService.StockWarningNoteDataService;
import po.popublic.NotePO;
import po.postock.StockWarningNotePO;

public class StockWarningNoteDataImpl implements StockWarningNoteDataService{

	//数据库名称
	private static final String stockDataBaseName = "stock";
		
	private StockWarningNoteSQLGetter SQLGetter;
	private StockWarningNoteSQLWriter SQLWriter;
		
	public StockWarningNoteDataImpl() {
		SQLGetter = new StockWarningNoteSQLGetter(stockDataBaseName);
		SQLWriter = new StockWarningNoteSQLWriter(stockDataBaseName);
	}
	
	@Override
	public List<StockWarningNotePO> getAllStockWarningNote() throws RemoteException {
		List<NotePO> list = SQLGetter.getNoteList();
		List<StockWarningNotePO> stockWarningNotePOList = new ArrayList<StockWarningNotePO>();
		if(list == null)
			return null;
		for(int i = 0; i < list.size(); i++){
			stockWarningNotePOList.add((StockWarningNotePO)list.get(i));			
		}
		return stockWarningNotePOList;
	}

	@Override
	public boolean saveStockWarningNote(StockWarningNotePO warningNote) throws RemoteException {		
		return SQLWriter.saveNote(warningNote);
	}

	
}
