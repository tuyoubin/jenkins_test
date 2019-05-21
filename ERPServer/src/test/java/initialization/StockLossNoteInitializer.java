package initialization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.noteSQLModule.noteSQLWriter.StockLossNoteSQLWriter;
import data.utility.DataBaseHelper;
import po.postock.StockLossNotePO;

public class StockLossNoteInitializer {

	private static final String stockDataBaseName = "stock";
	private static Connection connection = DataBaseHelper.getDataBaseConnection(stockDataBaseName);
	
	
	public StockLossNoteInitializer() {}
	
	public static void initNote() {
		
		try {
			//构建sql语句
			String sql = "delete from stock_loss_note";
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
 		int[] realNum = {48,18};
 		StockLossNotePO note1 = new StockLossNotePO("KCBSD-20171224-123111", "161250132", 2, id, name, stockNum, realNum, true);
 		StockLossNotePO note2 = new StockLossNotePO("KCBSD-20171223-165101", "161250132", 2, id, name, stockNum, realNum, true);
		
		StockLossNoteSQLWriter writer = new StockLossNoteSQLWriter(stockDataBaseName);
		writer.saveNote(note1);
		writer.saveNote(note2);
		
	}

}
