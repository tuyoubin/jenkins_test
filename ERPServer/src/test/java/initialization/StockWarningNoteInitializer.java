package initialization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.noteSQLModule.noteSQLWriter.StockWarningNoteSQLWriter;
import data.utility.DataBaseHelper;
import po.postock.StockWarningNotePO;

public class StockWarningNoteInitializer {

	private static final String stockDataBaseName = "stock";
	private static Connection connection = DataBaseHelper.getDataBaseConnection(stockDataBaseName);
	
	
	public StockWarningNoteInitializer() {}
	
	public static void initNote() {
		
		try {
			//构建sql语句
			String sql = "delete from stock_warning_note";
			//设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			//尝试执行（更新数据库）
			stmt.executeUpdate();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		StockWarningNotePO note1 = new StockWarningNotePO("KCBJD-20180101-1334", "00020001", "goods1", 10);
		StockWarningNotePO note2 = new StockWarningNotePO("KCBJD-20180101-1812", "00020002", "goods2", 10);
		
		StockWarningNoteSQLWriter writer = new StockWarningNoteSQLWriter(stockDataBaseName);
		writer.saveNote(note1);
		writer.saveNote(note2);
		
	}

}
