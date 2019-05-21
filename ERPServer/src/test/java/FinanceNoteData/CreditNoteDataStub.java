package FinanceNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.FinanceNoteDataService.CreditNoteDataService;
import po.potreasurer.CreditNotePO;
import queryItem.CreditNoteQueryItem;

public class CreditNoteDataStub implements CreditNoteDataService {

	@Override
	public boolean saveCreditNote(CreditNotePO creditnote) throws RemoteException {
		System.out.println("noteNumber:" + creditnote.getNoteNumber());
		System.out.println("supplierName:" + creditnote.getSupplierName());
		System.out.println("userID:" + creditnote.getUserID());
		System.out.println("transferListItemNum:" + creditnote.getTransferListItemNum());
		for(int i = 0; i < creditnote.getTransferListItemNum(); i++) {
			System.out.println(creditnote.getAccountNameList()[i] + 
					" " + creditnote.getTransferAmountList()[i] + 
					" " + creditnote.getRemarkList()[i]);
		}
		System.out.println("totalAmount:" + creditnote.getTotalAmount());
		System.out.println("isPassed:" + creditnote.isPassed());
		System.out.println("isInformed:" + creditnote.isInformed());
		return true;
	}

	@Override
	public List<CreditNotePO> inquiryCreditNote(CreditNoteQueryItem creditNoteQueryitem) throws RemoteException {
		System.out.println("startDate:" + creditNoteQueryitem.startDate);
		System.out.println("endDate:" + creditNoteQueryitem.endDate);
		System.out.println("supplierName:" + creditNoteQueryitem.supplierName);
		System.out.println("userID:" + creditNoteQueryitem.userID);
		
		List<CreditNotePO> notelist = new ArrayList<CreditNotePO>();
		
		String[] a= {"账户1", "账户2"};
		double[] b = {100, 200};
		String[] c = {"备注1", "备注2"};
		notelist.add(new CreditNotePO("FKD##-21110101-12121", "客户1", "财务人员1", 2, a, b, c, 300, false, false));
		
		String[] d = {"账户1", "账户2"};
		double[] e = {500, 600};
		String[] f = {"备注3", "备注4"};
		notelist.add(new CreditNotePO("FKD##-21110202-15234", "客户2", "财务人员2", 2, d, e, f, 1100, false, false));
		
		return notelist;
	}

	@Override
	public List<CreditNotePO> getAllPassedButNotInformedCreditNote() throws RemoteException {
		List<CreditNotePO> notelist = new ArrayList<CreditNotePO>();
		
		String[] a= {"账户1", "账户2"};
		double[] b = {100, 200};
		String[] c = {"备注1", "备注2"};
		notelist.add(new CreditNotePO("FKD##-20000101-12121", "客户1", "财务人员1", 2, a, b, c, 300, true, false));
		
		String[] d = {"账户1", "账户2"};
		double[] e = {500, 600};
		String[] f = {"备注3", "备注4"};
		notelist.add(new CreditNotePO("FKD##-20000202-15234", "客户2", "财务人员2", 2, d, e, f, 1100, true, false));
		
		return notelist;
	}

	@Override
	public boolean setCreditNoteInformed(CreditNotePO creditNote) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}
	
}
