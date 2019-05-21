package data.FinanceNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.noteSQLModule.noteSQLGetter.CashBillSQLGetter;
import data.noteSQLModule.noteSQLModifier.CashBillSQLModifier;
import data.noteSQLModule.noteSQLWriter.CashBillSQLWriter;
import data.utility.DataStringHelper;
import dataservice.FinanceNoteDataService.CashBillDataService;
import po.popublic.NotePO;
import po.potreasurer.CashBillPO;
import queryItem.CashBillQueryItem;

/**
 * 制定现金费用单DATA
 * @author CharlieLei
 *
 */
public class CashBillDataImpl implements CashBillDataService {

	//数据库名称
	private static final String treasurerDataBaseName = "treasurer";
	
	private CashBillSQLGetter SQLGetter;
	private CashBillSQLWriter SQLWriter;
	private CashBillSQLModifier SQLModifier;
	
	public CashBillDataImpl() {
		SQLGetter = new CashBillSQLGetter(treasurerDataBaseName);
		SQLWriter = new CashBillSQLWriter(treasurerDataBaseName);
		SQLModifier = new CashBillSQLModifier(treasurerDataBaseName);
	}

	
	@Override
	public boolean saveCashBill(CashBillPO cashbill) throws RemoteException {
		return SQLWriter.saveNote(cashbill);
	}

	@Override
	public List<CashBillPO> inquiryCashBill(CashBillQueryItem cashBillQueryItem) throws RemoteException {
		List<NotePO> noteList = SQLGetter.getNoteList();
		List<CashBillPO> cashBillPOList = null;
		
		if(noteList == null) return null;
		
		cashBillPOList = new ArrayList<CashBillPO>();
		
		CashBillPO tempCashBill = null;
		for(int i = 0; i < noteList.size(); i++) {
			tempCashBill = (CashBillPO)noteList.get(i);
			if(this.isEligible(tempCashBill, cashBillQueryItem))
				cashBillPOList.add(tempCashBill);
		}
		
		return cashBillPOList;
	}
	private boolean isEligible(CashBillPO cashBill, CashBillQueryItem cashBillQueryItem) {
		if(cashBill == null && cashBillQueryItem == null) return false;
		
		//从单据编号获得时间
		String noteDate = DataStringHelper.getTimeFromNoteNumber(cashBill.getNoteNumber());
		
		String startdate = cashBillQueryItem.startDate;
		String enddate = cashBillQueryItem.endDate;
		String queryUserID = cashBillQueryItem.userID;
		String queryAccountName = cashBillQueryItem.companyAccountName;

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
			if(!cashBill.getUserID().equals(queryUserID)) return false;
		//要查询账户名
		if(!queryAccountName.equals(""))
			if(!cashBill.getCompanyAccountName().equals(queryAccountName)) return false;
		
		return true;
	}
	
	@Override
	public List<CashBillPO> getAllPassedButNotInformedCashBill() throws RemoteException {
		List<NotePO> noteList = SQLGetter.getNoteList();
		List<CashBillPO> cashBillPOList = null;
		
		if(noteList == null) return null;
		
		cashBillPOList = new ArrayList<CashBillPO>();
		
		CashBillPO tempCashBill = null;
		for(int i = 0; i < noteList.size(); i++) {
			tempCashBill = (CashBillPO)noteList.get(i);
			if(!tempCashBill.isInformed())
				cashBillPOList.add(tempCashBill);
		}
		
		return cashBillPOList;
	}


	@Override
	public boolean setCashBillInformed(CashBillPO cashBill) throws RemoteException {
		// TODO Auto-generated method stub
		cashBill.hasInformedTheNote();
		return SQLModifier.modifyNote(cashBill);
	}

}
