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

import data.StockNoteData.StockGiftNoteDataImpl;
import data.utility.DataBaseHelper;
import data.utility.DataStringHelper;
import initialization.StockGiftNoteInitializer;
import po.postock.StockGiftNotePO;
import queryItem.StockGiftNoteQueryItem;

public class StockGiftNoteDataImplTest {
	
	private static final String stockDataBaseName = "stock";
	private Connection connection = DataBaseHelper.getDataBaseConnection(stockDataBaseName);
	StockGiftNoteDataImpl impl = new StockGiftNoteDataImpl();
	
	@Before
	public void setUp() throws Exception {	
		StockGiftNoteInitializer.initNote();
	}

	@Test
	public void testSaveCashBill() {
		
		String[] id = {"0001","0002"};
		String[] name = {"A","B"};
		String[] type = {"type1", "type2"};
		int[] amounts = {5, 10};
		
		try {
			impl.saveStockGiftNote(new StockGiftNotePO("KCZSD-20171201-1248", "库存管理人员1", 2, id, name, type, amounts, "Return"));
			String sql = "select * from stock_gift_note;";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				if(res.getString("note_number").equals("KCZSD-20171201-1248")) {
					assertEquals(res.getString("user_id"), "库存管理人员1");
					assertEquals(res.getInt("goods_list_item_num"), 2);
					assertEquals(res.getString("goods_id_list"), "0001"+ DataStringHelper.getSeparator()+ "0002" + DataStringHelper.getSeparator());
					assertEquals(res.getString("goods_name_list"), "A" + DataStringHelper.getSeparator()+ "B"+ DataStringHelper.getSeparator());
					assertEquals(res.getString("type_list"), "type1"+ DataStringHelper.getSeparator()+ "type2"+ DataStringHelper.getSeparator());
					assertEquals(res.getString("amounts"), "5"+ DataStringHelper.getSeparator()+ "10"+ DataStringHelper.getSeparator());
					assertEquals(res.getString("state"), "Return");	
				}
			}
			
			sql = "delete from stock_gift_note where note_number = 'KCZSD-20171201-1248'";
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
	public void testGetAllStockGiftNote() {
		List<StockGiftNotePO> list = null;
		
		try {
			list = impl.getAllStockGiftNote();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(list.size(), 2);
		assertEquals(list.get(0).getNoteNumber(), "KCZSD-20171201-1148");
		assertEquals(list.get(1).getNoteNumber(), "KCZSD-20180101-0916");
	}
	

	@Test
	public void testInquiryStockGiftNote() {
		
		List<StockGiftNotePO> list = null;
		
		try {
			list = impl.inquiryStockGiftNote(new StockGiftNoteQueryItem("20171201", "20180102", ""));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getNoteNumber(), "KCZSD-20180101-0916");
	}
}
