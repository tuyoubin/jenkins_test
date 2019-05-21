package data.noteSQLModule.noteSQLDeleter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import po.popublic.NotePO;
import po.postock.StockLossNotePO;

public class StockLossNoteSQLDeleter extends NoteSQLDeleter{

	public StockLossNoteSQLDeleter(String dataBaseName) {
		super(dataBaseName);
	}

	@Override
	public boolean delete(NotePO po) {
		if(po == null) return false;
		
		//将单据po类型转换
		StockLossNotePO lossNote = (StockLossNotePO) po;
		
		String noteNumber = lossNote.getNoteNumber();
		
		try {
			// 构建sql语句
			String sql = "delete from stock_loss_note where note_number = ?";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, noteNumber);
						
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("删除库存报损单成功");
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("StockGiftNoteData_SQLException");
			e.printStackTrace();
		}
		return false;
	}

}
