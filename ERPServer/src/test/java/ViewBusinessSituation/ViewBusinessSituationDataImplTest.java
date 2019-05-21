package ViewBusinessSituation;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.ViewReportData.ViewBusinessSituation.ViewBusinessSituationDataImpl;
import po.poMangaer.BusinessSituationPO;

public class ViewBusinessSituationDataImplTest {

	ViewBusinessSituationDataImpl impl = new ViewBusinessSituationDataImpl();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExportBS() {
		boolean result = false;
		
		BusinessSituationPO b = new BusinessSituationPO();
		b.setFDate("20170101");
		b.setEDate("20170101");
		b.setShou(100);
		b.setDuo(50);
		b.setChen(50);
		b.setShao(10);
		b.setLi(90);
		
		try {
			result = impl.exportBS(b);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(result, true);
	}

}
