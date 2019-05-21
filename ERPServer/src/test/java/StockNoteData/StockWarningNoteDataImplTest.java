package StockNoteData;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data.StockNoteData.StockWarningNoteDataImpl;
import data.utility.DataBaseHelper;
import initialization.StockWarningNoteInitializer;
import po.postock.StockWarningNotePO;

public class StockWarningNoteDataImplTest {
	
	private static final String stockDataBaseName = "stock";
	private Connection connection = DataBaseHelper.getDataBaseConnection(stockDataBaseName);
	StockWarningNoteDataImpl impl = new StockWarningNoteDataImpl();
	
	@Before
	public void setUp() throws Exception {	
		StockWarningNoteInitializer.initNote();
	}

	@Test
	public void testSaveCashBill() {
		
		
		try {
			impl.saveStockWarningNote(new StockWarningNotePO("KCBJD-20171201-1248", "00010001", "goodsTest", 15));
			String sql = "select * from stock_warning_note;";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				if(res.getString("note_number").equals("KCZSD-20171201-1248")) {
					assertEquals(res.getString("goods_id"), "00010001");
					assertEquals(res.getString("goods_name"), "goodsTest");
					assertEquals(res.getInt("warning_num"), 15);

				}
			}
			
			sql = "delete from stock_warning_note where note_number = 'KCBJD-20171201-1248'";
			stmt = connection.prepareStatement(sql);
			stmt.executeUpdate();
			stmt.close();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllStockWarningNote() {
		List<StockWarningNotePO> list = null;
		
		try {
			list = impl.getAllStockWarningNote();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(list.size(), 2);
		assertEquals(list.get(0).getNoteNumber(), "KCBJD-20180101-1334");
		assertEquals(list.get(1).getNoteNumber(), "KCBJD-20180101-1812");
	}
	
}
