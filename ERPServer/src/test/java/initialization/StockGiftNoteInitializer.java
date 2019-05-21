package initialization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.noteSQLModule.noteSQLWriter.StockGiftNoteSQLWriter;
import data.utility.DataBaseHelper;
import po.postock.StockGiftNotePO;

public class StockGiftNoteInitializer {

	private static final String stockDataBaseName = "stock";
	private static Connection connection = DataBaseHelper.getDataBaseConnection(stockDataBaseName);
	
	
	public StockGiftNoteInitializer() {}
	
	public static void initNote() {
		
		try {
			//构建sql语句
			String sql = "delete from stock_gift_note";
			//设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			//尝试执行（更新数据库）
			stmt.executeUpdate();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		String[] id = {"00020001","00020002"};
		String[] name = {"goods1","goods1"};
		String[] type = {"type1", "type2"};
		int[] amounts = {5, 10};
		StockGiftNotePO note1 = new StockGiftNotePO("KCZSD-20171201-1148", "161250132", 2, id, name, type, amounts, "");
		StockGiftNotePO note2 = new StockGiftNotePO("KCZSD-20180101-0916", "161250132", 2, id, name, type, amounts, "");
		
		StockGiftNoteSQLWriter writer = new StockGiftNoteSQLWriter(stockDataBaseName);
		writer.saveNote(note1);
		writer.saveNote(note2);
		
	}

}
