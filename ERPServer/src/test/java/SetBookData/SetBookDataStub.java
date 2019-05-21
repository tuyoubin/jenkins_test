package SetBookData;

import dataservice.SetBookDataService.SetBookDataService;
import po.potreasurer.BookPO;

public class SetBookDataStub implements SetBookDataService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean doesBookExist() {
		System.out.println("data doesBookExist");
		return true;
	}

	@Override
	public boolean newBook(BookPO bookInfo) {
		System.out.println("data newBookManual");
		return true;
	}


	@Override
	public BookPO inquiryBook() {
		System.out.println("data inquiryBook");
		return new BookPO(null, null, null, null);
	}

}
