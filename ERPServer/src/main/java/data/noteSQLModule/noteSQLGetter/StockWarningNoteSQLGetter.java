package data.noteSQLModule.noteSQLGetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import po.popublic.NotePO;
import po.postock.StockWarningNotePO;

public class StockWarningNoteSQLGetter extends NoteSQLGetter{

	public StockWarningNoteSQLGetter(String dataBaseName) {
		super(dataBaseName);
	}

	@Override
	public List<NotePO> getNoteList() {
		List<NotePO> list = new ArrayList<NotePO>();
		
		try {
			// 构建sql语句
			String sql = "select * from stock_warning_note";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			// 获取结果集（查询数据库）
			ResultSet res = stmt.executeQuery();
			
			while(res.next()){
				String noteNumber = res.getString("note_number");	
				String goodsID = res.getString("goods_id");
				String goodsName = res.getString("goods_name");
				int warningNum = res.getInt("warning_num");
																					 				
				StockWarningNotePO warningNote = new StockWarningNotePO(noteNumber, goodsID, goodsName, warningNum);		
				list.add(warningNote);
			}
			// 若访问MySQL未出错，并且数据库内并无单据，则返回一个空的ArrayList（非null)
			return list;
			
		} catch (SQLException e) {
			System.out.println("StockWarningNoteData_SQLException");
			e.printStackTrace();
		}
		return null;
	}

}
