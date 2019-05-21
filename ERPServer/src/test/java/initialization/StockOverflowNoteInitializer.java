package initialization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.noteSQLModule.noteSQLWriter.StockOverflowNoteSQLWriter;
import data.utility.DataBaseHelper;
import po.postock.StockOverflowNotePO;

public class StockOverflowNoteInitializer {

	private static final String stockDataBaseName = "stock";
	private static Connection connection = DataBaseHelper.getDataBaseConnection(stockDataBaseName);
	
	
	public StockOverflowNoteInitializer() {}
	
	public static void initNote() {
		
		try {
			//构建sql语句
			String sql = "delete from stock_overflow_note";
			//设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			//尝试执行（更新数据库）
			stmt.executeUpdate();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
 		String[]id = {"00020001","00020002"};
 		String[]name = {"goods1","goods2"};
 		int[] stockNum = {50,20};
 		int[] realNum = {80,100};
 		StockOverflowNotePO note1 = new StockOverflowNotePO("KCBYD-20171224-123111", "161250132", 2, id, name, stockNum, realNum, true);
 		StockOverflowNotePO note2 = new StockOverflowNotePO("KCBYD-20171223-165101", "161250132", 2, id, name, stockNum, realNum, true);
		
		StockOverflowNoteSQLWriter writer = new StockOverflowNoteSQLWriter(stockDataBaseName);
		writer.saveNote(note1);
		writer.saveNote(note2);
		
	}

}
