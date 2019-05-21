package data.StockNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.noteSQLModule.noteSQLGetter.StockLossNoteSQLGetter;
import data.noteSQLModule.noteSQLWriter.StockLossNoteSQLWriter;
import data.utility.DataStringHelper;
import dataservice.StockNoteDataService.StockLossNoteDataService;
import queryItem.StockLossNoteQueryItem;
import po.popublic.NotePO;
import po.postock.StockLossNotePO;

public class StockLossNoteDataImpl implements StockLossNoteDataService{

	//数据库名称
	private static final String stockDataBaseName = "stock";
		
	private StockLossNoteSQLGetter SQLGetter;
	private StockLossNoteSQLWriter SQLWriter;
		
	public StockLossNoteDataImpl() {
		SQLGetter = new StockLossNoteSQLGetter(stockDataBaseName);
		SQLWriter = new StockLossNoteSQLWriter(stockDataBaseName);
	}
	
	
	@Override
	public List<StockLossNotePO> getAllStockLossNote() throws RemoteException {
		List<NotePO> list = SQLGetter.getNoteList();
		List<StockLossNotePO> stockLossNotePOList = new ArrayList<StockLossNotePO>();
		if(list == null)
			return null;
		for(int i = 0; i < list.size(); i++){
			stockLossNotePOList.add((StockLossNotePO)list.get(i));			
		}
		return stockLossNotePOList;
	}

	@Override
	public boolean saveStockLossNote(StockLossNotePO lossNote) throws RemoteException {		
		return SQLWriter.saveNote(lossNote);
	}


	@Override
	public List<StockLossNotePO> inquiryStockLossNote(StockLossNoteQueryItem stockLossNoteQueryItem) throws RemoteException {
		List<StockLossNotePO> list = this.getAllStockLossNote();
		List<StockLossNotePO> stockLossNotePOList = new ArrayList<StockLossNotePO>();
		
		if(list == null)
			return null;
		
		StockLossNotePO po = null;
		for(int i = 0; i < list.size(); i++){
			po = list.get(i);
			if(this.isEligible(po, stockLossNoteQueryItem))
				stockLossNotePOList.add(po);			
		}
		
		return stockLossNotePOList;		
	}

	private boolean isEligible(StockLossNotePO lossNote, StockLossNoteQueryItem stockLossNoteQueryItem) throws RemoteException {
		if(lossNote == null && stockLossNoteQueryItem == null) return false;
		
		//从单据编号获得时间
		String noteDate = DataStringHelper.getTimeFromNoteNumber(lossNote.getNoteNumber());
		
		//获取查询条件
		String startdate = stockLossNoteQueryItem.startDate;
		String enddate = stockLossNoteQueryItem.endDate;
		String queryUserID = stockLossNoteQueryItem.userID;
		
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
			if(!lossNote.getUserID().equals(queryUserID)) return false;
		
		return true;		
	}


}
