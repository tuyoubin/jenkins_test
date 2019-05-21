package data.noteSQLModule.noteSQLWriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.SQLAttributeIndex;
import po.popublic.NotePO;
import po.postock.StockWarningNotePO;

public class StockWarningNoteSQLWriter  extends NoteSQLWriter{

	public StockWarningNoteSQLWriter(String dataBaseName) {
		super(dataBaseName);
	}

	@Override
	public boolean saveNote(NotePO po) {
		
		if(po == null) return false;
		
		//将单据po类型转换
		StockWarningNotePO warningNote = (StockWarningNotePO) po;
		
		String noteNumber = warningNote.getNoteNumber();
		String goodsID = warningNote.getGoodsID();
		String goodsName = warningNote.getGoodsName();
		int warningValue = warningNote.getWarningNum(); 
				
		try {
			// 构建sql语句
			String sql = "insert into stock_warning_note "+"values(?,?,?,?)";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(SQLAttributeIndex.StockWarningNote_NoteNumber.index(), noteNumber);
			stmt.setString(SQLAttributeIndex.StockWarningNote_GoodsID.index(), goodsID);
			stmt.setString(SQLAttributeIndex.StockWarningNote_GoodsName.index(), goodsName);
			stmt.setInt(SQLAttributeIndex.StockWarningNote_WarningNum.index(), warningValue);
						
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("保存库存报警单成功");
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("StockWarningNoteData_SQLException");
			e.printStackTrace();
		}
		
		return false;
	}

}
