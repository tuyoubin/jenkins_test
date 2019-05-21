package data.FinanceNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.noteSQLModule.noteSQLGetter.DebitNoteSQLGetter;
import data.noteSQLModule.noteSQLModifier.DebitNoteSQLModifier;
import data.noteSQLModule.noteSQLWriter.DebitNoteSQLWriter;
import data.utility.DataStringHelper;
import dataservice.FinanceNoteDataService.DebitNoteDataService;
import po.popublic.NotePO;
import po.potreasurer.DebitNotePO;
import queryItem.DebitNoteQueryItem;

/**
 * 制定收款单DATA
 * @author CharlieLei
 *
 */
public class DebitNoteDataImpl implements DebitNoteDataService {

	//数据库名称
	private static final String treasurerDataBaseName = "treasurer";

	private DebitNoteSQLGetter SQLGetter;
	private DebitNoteSQLWriter SQLWriter;
	private DebitNoteSQLModifier SQLModifier;
	
	
	public DebitNoteDataImpl() {
		SQLGetter = new DebitNoteSQLGetter(treasurerDataBaseName);
		SQLWriter = new DebitNoteSQLWriter(treasurerDataBaseName);
		SQLModifier = new DebitNoteSQLModifier(treasurerDataBaseName);
	}
	
	
	@Override
	public boolean saveDebitNote(DebitNotePO debitnote) throws RemoteException {
		return SQLWriter.saveNote(debitnote);
	}

	@Override
	public List<DebitNotePO> inquiryDebitNote(DebitNoteQueryItem debitNoteQueryItem) throws RemoteException {
		List<DebitNotePO> debitNotePOList = null;
		List<NotePO> noteList = SQLGetter.getNoteList();
		
		if(noteList == null) return null;
		
		debitNotePOList = new ArrayList<DebitNotePO>();
		
		DebitNotePO tempDebitNote = null;
		for(int i = 0; i < noteList.size(); i++) {
			tempDebitNote = (DebitNotePO) noteList.get(i);
			if(this.isEligible(tempDebitNote, debitNoteQueryItem))
				debitNotePOList.add(tempDebitNote);
		}
		
		return debitNotePOList;
	}

	@Override
	public List<DebitNotePO> getAllPassedButNotInformedDebitNote() throws RemoteException {
		List<DebitNotePO> debitNotePOList = null;
		List<NotePO> noteList = SQLGetter.getNoteList();
		
		if(noteList == null) return null;
		
		debitNotePOList = new ArrayList<DebitNotePO>();
		
		DebitNotePO tempDebitNote = null;
		for(int i = 0; i < noteList.size(); i++) {
			tempDebitNote = (DebitNotePO) noteList.get(i);
			if(!tempDebitNote.isInformed())
				debitNotePOList.add(tempDebitNote);
		}
		
		return debitNotePOList;
	}
	
	private boolean isEligible(DebitNotePO debitNote, DebitNoteQueryItem debitNoteQueryItem) {
		if(debitNote == null || debitNoteQueryItem == null) return false;
		
		String noteDate = DataStringHelper.getTimeFromNoteNumber(debitNote.getNoteNumber());
		
		String startdate = debitNoteQueryItem.startDate;
		String enddate = debitNoteQueryItem.endDate;
		String querySellerName = debitNoteQueryItem.sellerName;
		String queryUserID = debitNoteQueryItem.userID;
		
		//只有结束时间
		if(startdate.equals("") && !enddate.equals(""))
			if((noteDate.compareTo(enddate) > 0)) return false;
		//只有开始时间
		if(!startdate.equals("") && enddate.equals(""))
			if((noteDate.compareTo(startdate) < 0)) return false;
		//开始时间和结束时间都有
		if(!startdate.equals("") && !enddate.equals(""))
			if((noteDate.compareTo(enddate) > 0) || (noteDate.compareTo(startdate) < 0)) return false;
		//要查询操作员ID
		if(!queryUserID.equals(""))
			if(!debitNote.getUserID().equals(queryUserID)) return false;
		//要查询销售商
		if(!querySellerName.equals(""))
			if(!debitNote.getSellerName().equals(querySellerName)) return false;
		
		return true;
	}


	@Override
	public boolean setDebitNoteInformed(DebitNotePO debitNote) throws RemoteException {
		// TODO Auto-generated method stub
		debitNote.hasInformedTheNote();
		return SQLModifier.modifyNote(debitNote);
	}
}
