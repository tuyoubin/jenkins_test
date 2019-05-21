package data.StockNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.noteSQLModule.noteSQLGetter.StockGiftNoteSQLGetter;
import data.noteSQLModule.noteSQLWriter.StockGiftNoteSQLWriter;
import data.utility.DataStringHelper;
import dataservice.StockNoteDataService.StockGiftNoteDataService;
import queryItem.StockGiftNoteQueryItem;
import po.popublic.NotePO;
import po.postock.StockGiftNotePO;

public class StockGiftNoteDataImpl implements StockGiftNoteDataService{

	//数据库名称
	private static final String stockDataBaseName = "stock";
		
	private StockGiftNoteSQLGetter SQLGetter;
	private StockGiftNoteSQLWriter SQLWriter;
		
	public StockGiftNoteDataImpl() {
		SQLGetter = new StockGiftNoteSQLGetter(stockDataBaseName);
		SQLWriter = new StockGiftNoteSQLWriter(stockDataBaseName);
	}
	
	
	@Override
	public List<StockGiftNotePO> getAllStockGiftNote() throws RemoteException {
		List<NotePO> list = SQLGetter.getNoteList();
		List<StockGiftNotePO> stockGiftNotePOList = new ArrayList<StockGiftNotePO>();
		if(list == null)
			return null;
		for(int i = 0; i < list.size(); i++){
			stockGiftNotePOList.add((StockGiftNotePO)list.get(i));			
		}
		return stockGiftNotePOList;
	}

	@Override
	public boolean saveStockGiftNote(StockGiftNotePO giftNote) throws RemoteException {		
		return SQLWriter.saveNote(giftNote);
	}


	@Override
	public List<StockGiftNotePO> inquiryStockGiftNote(StockGiftNoteQueryItem stockGiftNoteQueryItem) throws RemoteException {
		List<StockGiftNotePO> list = this.getAllStockGiftNote();
		List<StockGiftNotePO> stockGiftNotePOList = new ArrayList<StockGiftNotePO>();
		
		if(list == null)
			return null;
		
		StockGiftNotePO po = null;
		for(int i = 0; i < list.size(); i++){
			po = list.get(i);
			if(this.isEligible(po, stockGiftNoteQueryItem))
				stockGiftNotePOList.add(po);			
		}
		
		return stockGiftNotePOList;		
	}

	private boolean isEligible(StockGiftNotePO giftNote, StockGiftNoteQueryItem stockGiftNoteQueryItem) throws RemoteException {
		if(giftNote == null && stockGiftNoteQueryItem == null) return false;
		
		//从单据编号获得时间
		String noteDate = DataStringHelper.getTimeFromNoteNumber(giftNote.getNoteNumber());
		
		//获取查询条件
		String startdate = stockGiftNoteQueryItem.startDate;
		String enddate = stockGiftNoteQueryItem.endDate;
		String queryUserID = stockGiftNoteQueryItem.userID;
		
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
			if(!giftNote.getUserID().equals(queryUserID)) return false;
		
		return true;		
	}


}
