package data.FinanceNoteData;

import java.util.ArrayList;
import java.util.List;

import dataservice.FinanceNoteDataService.DebitNoteDataService;
import po.potreasurer.DebitNotePO;

public class DebitNoteDataStub implements DebitNoteDataService {

	public boolean saveDebitNote(DebitNotePO debitnote) {
		System.out.println("data saveDebitNote");
		return true;
	}

	public List<DebitNotePO> getAllDebitNote() {
		System.out.println("data getAllDebitNote");
		List<DebitNotePO> listPO = new ArrayList<DebitNotePO>();	
		
		listPO.add(new DebitNotePO("all522_data", null, null, null, null, 2.03, true));
		listPO.add(new DebitNotePO("all963_data", null, null, null, null, 2.03, true));
		
		return listPO;
	}

	public List<DebitNotePO> getAllPassedButNotInformedDebitNote() {
		System.out.println("data getAllPassedButNotInformedDebitNote");
		List<DebitNotePO> listPO = new ArrayList<DebitNotePO>();	
		
		listPO.add(new DebitNotePO("asgd555_data", null, null, null, null, 2.03, true));
		listPO.add(new DebitNotePO("trfg9965_data", null, null, null, null, 2.03, true));
		
		return listPO;
	}
}
