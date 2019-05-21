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

import data.StockNoteData.StockLossNoteDataImpl;
import data.utility.DataBaseHelper;
import data.utility.DataStringHelper;
import initialization.StockLossNoteInitializer;
import po.postock.StockLossNotePO;
import queryItem.StockLossNoteQueryItem;

public class StockLossNoteDataImplTest {
	
	private static final String stockDataBaseName = "stock";
	private Connection connection = DataBaseHelper.getDataBaseConnection(stockDataBaseName);
	StockLossNoteDataImpl impl = new StockLossNoteDataImpl();
	
	@Before
	public void setUp() throws Exception {	
		StockLossNoteInitializer.initNote();
	}

	@Test
	public void testSaveCashBill() {
		
 		String[]id = {"00020001","00020002"};
 		String[]name = {"goods1","goods2"};
 		int[] stockNum = {50,20};
 		int[] realNum = {48,18};
		
		try {
			impl.saveStockLossNote(new StockLossNotePO("KCBSD-20171201-1248", "库存管理人员1", 2, id, name, stockNum, realNum, true));
			String sql = "select * from stock_loss_note;";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				if(res.getString("note_number").equals("KCBSD-20171201-1248")) {
					assertEquals(res.getString("user_id"), "库存管理人员1");
					assertEquals(res.getInt("goods_list_item_num"), 2);
					assertEquals(res.getString("goods_id_list"), "00020001"+ DataStringHelper.getSeparator()+ "00020002" + DataStringHelper.getSeparator());
					assertEquals(res.getString("goods_name_list"), "goods1" + DataStringHelper.getSeparator()+ "goods2"+ DataStringHelper.getSeparator());
					assertEquals(res.getString("stock_amounts"), "50"+ DataStringHelper.getSeparator()+ "20"+ DataStringHelper.getSeparator());
					assertEquals(res.getString("real_amounts"), "48"+ DataStringHelper.getSeparator()+ "18"+ DataStringHelper.getSeparator());
					assertEquals(res.getBoolean("is_passed"), true);
				}
			}
			
			sql = "delete from stock_loss_note where note_number = 'KCBSD-20171201-1248'";
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
	public void testGetAllStockLossNote() {
		List<StockLossNotePO> list = null;
		
		try {
			list = impl.getAllStockLossNote();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(list.size(), 2);
		assertEquals(list.get(0).getNoteNumber(), "KCBSD-20171224-123111");
		assertEquals(list.get(1).getNoteNumber(), "KCBSD-20171223-165101");
	}
	

	@Test
	public void testInquiryStockLossNote() {
		
		List<StockLossNotePO> list = null;
		
		try {
			list = impl.inquiryStockLossNote(new StockLossNoteQueryItem("20171223", "20180102", ""));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getNoteNumber(), "KCBSD-20171224-123111");
	}
}
