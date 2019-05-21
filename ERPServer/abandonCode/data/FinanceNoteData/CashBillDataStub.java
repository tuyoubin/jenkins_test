package data.FinanceNoteData;

import java.util.List;

import dataservice.CashBillDataService.CashBillDataService;
import po.potreasurer.CashBillPO;

public class CashBillDataStub implements CashBillDataService {

//	public static void main(String[] args) {
//		CashBillDataStub stub = new CashBillDataStub();
//		CashBillPO so = new CashBillPO("type", "num", "id","account", null, 25.0, false);
//		CashBillVO po = so.toVO();
//		System.out.println(po.getNoteType());
//		System.out.println(po.getCompanyAccountName());
//		System.out.println(po.getUserID());
//		System.out.println(po.getNoteNumber());
//		System.out.println(po.getTotalAmount());
//		System.out.println(po.getExpenseAccount());
//		System.out.println(po.isPassed());
//		po.passTheApproval();
//		System.out.println(po.isPassed());
//	}

	public boolean saveCashBill(CashBillPO cashbill) {
		System.out.println("data saveCashBill");
		return false;
	}

	public List<CashBillPO> getAllCashBill() {
		System.out.println("data getAllCashBill");
		return null;
	}
	
	public List<CashBillPO> getAllPassedButNotInformedCashBill() {
		System.out.println("data getAllPassedButNotInformedCashBill");
		return null;
	}

}
