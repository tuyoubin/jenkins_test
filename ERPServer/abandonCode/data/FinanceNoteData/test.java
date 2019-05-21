package data.FinanceNoteData;

import java.rmi.RemoteException;
import java.util.List;

import po.potreasurer.DebitNotePO;
import queryItem.DebitNoteQueryItem;

public class test {

	public test() {
		DebitNoteDataImpl i = new DebitNoteDataImpl();
		List<DebitNotePO> list = null;
		try {
			list = i.inquiryDebitNote(new DebitNoteQueryItem("20151210", "","", ""));
		}catch(RemoteException e) {
			
		}
		
	}
	
	public static void main(String[] args) {
		new test();
	}

}
