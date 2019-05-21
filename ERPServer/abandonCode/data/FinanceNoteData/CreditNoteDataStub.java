package data.FinanceNoteData;

import java.util.List;

import dataservice.FinanceNoteDataService.CreditNoteDataService;
import po.potreasurer.CreditNotePO;

public class CreditNoteDataStub implements CreditNoteDataService {

	public boolean saveCreditNote(CreditNotePO creditnote) {
		System.out.println("data saveCreditNote");
		return true;
	}

	public List<CreditNotePO> getAllCreditNote() {
		System.out.println("data getAllCreditNote");
		return null;
	}

	public List<CreditNotePO> getAllPassedButNotInformedCreditNote() {
		System.out.println("data getAllPassedButNotInformedCreditNote");
		return null;
	}
	
}
