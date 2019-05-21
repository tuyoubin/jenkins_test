package data.FinanceNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.noteSQLModule.noteSQLGetter.CreditNoteSQLGetter;
import data.noteSQLModule.noteSQLModifier.CreditNoteSQLModifier;
import data.noteSQLModule.noteSQLWriter.CreditNoteSQLWriter;
import data.utility.DataStringHelper;
import dataservice.FinanceNoteDataService.CreditNoteDataService;
import po.popublic.NotePO;
import po.potreasurer.CreditNotePO;
import queryItem.CreditNoteQueryItem;

/**
 * 制定付款单DATA
 * @author CharlieLei
 *
 */
public class CreditNoteDataImpl implements CreditNoteDataService {

	//数据库名称
	private static final String treasurerDataBaseName = "treasurer";
	
	private CreditNoteSQLGetter SQLGetter;
	private CreditNoteSQLWriter SQLWriter;
	private CreditNoteSQLModifier SQLModifier;
	
	
	public CreditNoteDataImpl() {
		SQLGetter = new CreditNoteSQLGetter(treasurerDataBaseName);
		SQLWriter = new CreditNoteSQLWriter(treasurerDataBaseName);
		SQLModifier = new CreditNoteSQLModifier(treasurerDataBaseName);
	}

	
	@Override
	public boolean saveCreditNote(CreditNotePO creditnote) throws RemoteException {
		return SQLWriter.saveNote(creditnote);
	}

	@Override
	public List<CreditNotePO> inquiryCreditNote(CreditNoteQueryItem creditNoteQueryitem) throws RemoteException {
		List<CreditNotePO> creditNotePOList = new ArrayList<CreditNotePO>();
		List<NotePO> noteList = SQLGetter.getNoteList();
		
		if(noteList == null) return null;
		
		CreditNotePO tempCreditNote = null;
		for(int i = 0; i < noteList.size(); i++) {
			tempCreditNote = (CreditNotePO) noteList.get(i);
			if(this.isEligible(tempCreditNote, creditNoteQueryitem))
				creditNotePOList.add(tempCreditNote);
		}
		
		return creditNotePOList;
	}

	@Override
	public List<CreditNotePO> getAllPassedButNotInformedCreditNote() throws RemoteException {
		List<CreditNotePO> creditNotePOList = new ArrayList<CreditNotePO>();
		List<NotePO> noteList = SQLGetter.getNoteList();
		
		if(noteList == null) return null;
		
		CreditNotePO tempCreditNote = null;
		for(int i = 0; i < noteList.size(); i++) {
			tempCreditNote = (CreditNotePO) noteList.get(i);
			if(!tempCreditNote.isInformed())
				creditNotePOList.add(tempCreditNote);
		}
		
		return creditNotePOList;
	}
	
	private boolean isEligible(CreditNotePO creditNote, CreditNoteQueryItem creditNoteQueryItem) {
		if(creditNote == null || creditNoteQueryItem == null) return false;
		
		String noteDate = DataStringHelper.getTimeFromNoteNumber(creditNote.getNoteNumber());
		
		String startdate = creditNoteQueryItem.startDate;
		String enddate = creditNoteQueryItem.endDate;
		String querySupplierName = creditNoteQueryItem.supplierName;
		String queryUserID = creditNoteQueryItem.userID;
		
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
			if(!creditNote.getUserID().equals(queryUserID)) return false;
		//要查询销售商
		if(!querySupplierName.equals(""))
			if(!creditNote.getSupplierName().equals(querySupplierName)) return false;
		
		return true;
	}


	@Override
	public boolean setCreditNoteInformed(CreditNotePO creditNote) throws RemoteException {
		// TODO Auto-generated method stub
		creditNote.hasInformedTheNote();
		return SQLModifier.modifyNote(creditNote);
	}

}
