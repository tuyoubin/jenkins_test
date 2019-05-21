package DocumentData;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.DocumentData.DocumentDataImpl;
import po.postock.StockLossNotePO;

public class DcoumentImplTest {

	DocumentDataImpl Doc = new DocumentDataImpl();
	@Before
	
	@Test
	public void testSubmit(){
 		String[]id = {"00020001","00020002"};
 		String[]name = {"goods1","goods2"};
 		int[] stockNum = {50,20};
 		int[] realNum = {48,18};
 		StockLossNotePO note1 = new StockLossNotePO("KCBSD-20171224-123111", "161250132", 2, id, name, stockNum, realNum, true);
	    
 		try {
			assertEquals(true,Doc.ApprovalDoc(note1));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
