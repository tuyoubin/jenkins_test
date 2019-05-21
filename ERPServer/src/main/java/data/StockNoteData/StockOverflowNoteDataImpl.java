package data.StockNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.noteSQLModule.noteSQLGetter.StockOverflowNoteSQLGetter;
import data.noteSQLModule.noteSQLWriter.StockOverflowNoteSQLWriter;
import data.utility.DataStringHelper;
import dataservice.StockNoteDataService.StockOverflowNoteDataService;
import queryItem.StockOverflowNoteQueryItem;
import po.popublic.NotePO;
import po.postock.StockOverflowNotePO;

public class StockOverflowNoteDataImpl implements StockOverflowNoteDataService{

	//数据库名称
	private static final String stockDataBaseName = "stock";
		
	private StockOverflowNoteSQLGetter SQLGetter;
	private StockOverflowNoteSQLWriter SQLWriter;
		
	public StockOverflowNoteDataImpl() {
		SQLGetter = new StockOverflowNoteSQLGetter(stockDataBaseName);
		SQLWriter = new StockOverflowNoteSQLWriter(stockDataBaseName);
	}
	
	
	@Override
	public List<StockOverflowNotePO> getAllStockOverflowNote() throws RemoteException {
		List<NotePO> list = SQLGetter.getNoteList();
		List<StockOverflowNotePO> stockOverflowNotePOList = new ArrayList<StockOverflowNotePO>();
		if(list == null)
			return null;
		for(int i = 0; i < list.size(); i++){
			stockOverflowNotePOList.add((StockOverflowNotePO)list.get(i));			
		}
		return stockOverflowNotePOList;
	}

	@Override
	public boolean saveStockOverflowNote(StockOverflowNotePO overflowNote) throws RemoteException {		
		return SQLWriter.saveNote(overflowNote);
	}


	@Override
	public List<StockOverflowNotePO> inquiryStockOverflowNote(StockOverflowNoteQueryItem stockOverflowNoteQueryItem) throws RemoteException {
		List<StockOverflowNotePO> list = this.getAllStockOverflowNote();
		List<StockOverflowNotePO> stockOverflowNotePOList = new ArrayList<StockOverflowNotePO>();
		
		if(list == null)
			return null;
		
		StockOverflowNotePO po = null;
		for(int i = 0; i < list.size(); i++){
			po = list.get(i);
			if(this.isEligible(po, stockOverflowNoteQueryItem))
				stockOverflowNotePOList.add(po);			
		}
		
		return stockOverflowNotePOList;		
	}

	private boolean isEligible(StockOverflowNotePO overflowNote, StockOverflowNoteQueryItem stockOverflowNoteQueryItem) throws RemoteException {
		if(overflowNote == null && stockOverflowNoteQueryItem == null) return false;
		
		//从单据编号获得时间
		String noteDate = DataStringHelper.getTimeFromNoteNumber(overflowNote.getNoteNumber());
		
		//获取查询条件
		String startdate = stockOverflowNoteQueryItem.startDate;
		String enddate = stockOverflowNoteQueryItem.endDate;
		String queryUserID = stockOverflowNoteQueryItem.userID;
		
		//只有结束时间	
		if(startdate.equals("") && !enddate.equals(""))
			if((noteDate.compareTo(enddate) >= 0)) return false;
		//只有开始时间
		if(!startdate.equals("") && enddate.equals(""))
			if((noteDate.compareTo(startdate) <= 0)) return false;
		//开始时间和结束时间都有
		if(!startdate.equals("") && !enddate.equals(""))
			if((noteDate.compareTo(enddate) >= 0) || (noteDate.compareTo(startdate) <= 0)) return false;
		//要查询操作员ID
		if(!queryUserID.equals(""))
			if(!overflowNote.getUserID().equals(queryUserID)) return false;
		
		return true;		
	}


}
