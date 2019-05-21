package FinanceNoteData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.FinanceNoteDataService.DebitNoteDataService;
import po.potreasurer.DebitNotePO;
import queryItem.DebitNoteQueryItem;

public class DebitNoteDataStub implements DebitNoteDataService {

	@Override
	public boolean saveDebitNote(DebitNotePO debitnote) throws RemoteException {
		System.out.println("noteNumber:" + debitnote.getNoteNumber());
		System.out.println("sellerName:" + debitnote.getSellerName());
		System.out.println("userID:" + debitnote.getUserID());
		System.out.println("transferListItemNum:" + debitnote.getTransferListItemNum());
		for(int i = 0; i < debitnote.getTransferListItemNum(); i++) {
			System.out.println(debitnote.getAccountNameList()[i] + 
					" " + debitnote.getTransferAmountList()[i] + 
					" " + debitnote.getRemarkList()[i]);
		}
		System.out.println("totalAmount:" + debitnote.getTotalAmount());
		System.out.println("isPassed:" + debitnote.isPassed());
		System.out.println("isInformed:" + debitnote.isInformed());
		return true;
	}

	@Override
	public List<DebitNotePO> inquiryDebitNote(DebitNoteQueryItem debitNoteQueryItem) throws RemoteException {
		List<DebitNotePO> notelist = new ArrayList<DebitNotePO>();
		
		String[] a= {"账户1", "账户2"};
		double[] b = {100, 200};
		String[] c = {"备注1", "备注2"};
		notelist.add(new DebitNotePO("SKD##-20000101-12121", "客户1", "财务人员1", 2, a, b, c, 300, false, false));
		
		String[] d = {"账户1", "账户2"};
		double[] e = {500, 600};
		String[] f = {"备注3", "备注4"};
		notelist.add(new DebitNotePO("SKD##-20000202-15234", "客户2", "财务人员2", 2, d, e, f, 1100, false, false));
		
		return notelist;
	}

	@Override
	public List<DebitNotePO> getAllPassedButNotInformedDebitNote() throws RemoteException {
		List<DebitNotePO> notelist = new ArrayList<DebitNotePO>();
		
		String[] a= {"账户1", "账户2"};
		double[] b = {100, 200};
		String[] c = {"备注1", "备注2"};
		notelist.add(new DebitNotePO("SKD##-20000101-12121", "客户1", "财务人员1", 2, a, b, c, 300, true, false));
		
		String[] d = {"账户1", "账户2"};
		double[] e = {500, 600};
		String[] f = {"备注3", "备注4"};
		notelist.add(new DebitNotePO("SKD##-20000202-15234", "客户2", "财务人员2", 2, d, e, f, 1100, true, false));
		
		return notelist;
	}

	@Override
	public boolean setDebitNoteInformed(DebitNotePO debitNote) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
