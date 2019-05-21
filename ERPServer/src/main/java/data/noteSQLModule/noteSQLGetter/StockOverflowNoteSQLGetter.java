package data.noteSQLModule.noteSQLGetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.utility.DataStringHelper;
import po.popublic.NotePO;
import po.postock.StockOverflowNotePO;

public class StockOverflowNoteSQLGetter extends NoteSQLGetter{

	public StockOverflowNoteSQLGetter(String dataBaseName) {
		super(dataBaseName);
	}

	@Override
	public List<NotePO> getNoteList() {
		
		List<NotePO> list = new ArrayList<NotePO>();
		try {
			// 构建sql语句
			String sql = "select * from stock_overflow_note";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			// 获取结果集（查询数据库）
			ResultSet res = stmt.executeQuery();
			
			while(res.next()){
				String noteNumber = res.getString("note_number");
				String userID = res.getString("user_id");
				int  goodsListItemNum = res.getInt("goods_list_item_num");
				String[] goodsIDList = res.getString("goods_id_list").split(DataStringHelper.getSeparator());
				String[] goodsNameList = res.getString("goods_name_list").split(DataStringHelper.getSeparator());
				String[] stockNum = res.getString("stock_amounts").split(DataStringHelper.getSeparator());
				String[] realNum = res.getString("real_amounts").split(DataStringHelper.getSeparator());
				int[] stockAmounts = new int[stockNum.length];
				int[] realAmounts = new int[realNum.length];
				boolean isPassed = res.getBoolean("is_passed");
				
				for(int i = 0; i < goodsListItemNum; i++){
					stockAmounts[i] = Integer.parseInt(stockNum[i]);				
					realAmounts[i] = Integer.parseInt(realNum[i]);
				}
																 								
				StockOverflowNotePO stockOverflowNotePO = new StockOverflowNotePO(noteNumber, userID, goodsListItemNum,
						goodsIDList, goodsNameList, stockAmounts, realAmounts, isPassed);		
				list.add(stockOverflowNotePO);
			}
			// 若访问MySQL未出错，并且数据库内并无单据，则返回一个空的ArrayList（非null)
			return list;
			
		} catch (SQLException e) {
			System.out.println("StockOverflowNoteData_SQLException");
			e.printStackTrace();
		}
		return null;
	}

}
