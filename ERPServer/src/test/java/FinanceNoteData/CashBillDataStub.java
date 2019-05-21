package FinanceNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.FinanceNoteDataService.CashBillDataService;
import po.potreasurer.CashBillPO;
import queryItem.CashBillQueryItem;

public class CashBillDataStub implements CashBillDataService {


	@Override
	public boolean saveCashBill(CashBillPO cashbill) throws RemoteException {
		System.out.println("data commitCashBill");
		System.out.println(cashbill.getNoteNumber());
		System.out.println(cashbill.getUserID());
		System.out.println(cashbill.getCompanyAccountName());		
		
		int expenseAccountItemNum = cashbill.getExpenseAccountItemNum();//列表项数
		String[] itemNameList = cashbill.getItemNameList();//条目名
		double[] amountList = cashbill.getAmountList();//金额
		String[] remarkList = cashbill.getRemarkList();//备注
		for(int i = 0; i < expenseAccountItemNum; i++) {
			System.out.println(itemNameList[i] + " " + amountList[i] + " " + remarkList[i]);
		}
		
		System.out.println(cashbill.getTotalAmount());
		System.out.println(cashbill.isPassed());
		System.out.println(cashbill.isInformed());
		return true;
	}

	@Override
	public List<CashBillPO> inquiryCashBill(CashBillQueryItem cashBillQueryItem) throws RemoteException {
		System.out.println("bl inquiryCashBill");
		System.out.println("startDate:" + cashBillQueryItem.startDate);
		System.out.println("endDate:" + cashBillQueryItem.endDate);
		System.out.println("userID:" + cashBillQueryItem.userID);
		System.out.println("companyAccountName:" + cashBillQueryItem.companyAccountName);
		
		List<CashBillPO> listvo = new ArrayList<CashBillPO>();
		
		String[] a = {"条目1", "条目2"};
		double[] b = {100, 200};
		String[] c = {"备注1", "备注2"};
		listvo.add(new CashBillPO("XJFYD-20000101", "财务人员1", "账户1", 2, a, b, c, 300, false, false));
		
		String[] d = {"条目3", "条目4"};
		double[] e = {500, 1000};
		String[] f = {"备注3", "备注4"};
		listvo.add(new CashBillPO("XJFYD-20000202", "财务人员2", "账户2", 2, d, e, f, 1500, false, false));
		
		return listvo;
	}

	@Override
	public List<CashBillPO> getAllPassedButNotInformedCashBill() throws RemoteException {
		System.out.println("data getAllPassedButNotInformedCashBill");
		List<CashBillPO> listvo = new ArrayList<CashBillPO>();
		
		String[] a = {"条目1", "条目2"};
		double[] b = {100, 200};
		String[] c = {"备注1", "备注2"};
		listvo.add(new CashBillPO("XJFYD-20000101-12151", "财务人员1", "账户1", 2, a, b, c, 300, true, false));
		
		String[] d = {"条目3", "条目4"};
		double[] e = {500, 1000};
		String[] f = {"备注3", "备注4"};
		listvo.add(new CashBillPO("XJFYD-20000202-15245", "财务人员2", "账户2", 2, d, e, f, 1500, true, false));
		
		return listvo;
	}

	@Override
	public boolean setCashBillInformed(CashBillPO cashBill) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
