package data.noteSQLModule.noteSQLGetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.utility.DataStringHelper;
import po.popublic.NotePO;
import po.postock.StockGiftNotePO;

public class StockGiftNoteSQLGetter extends NoteSQLGetter{

	public StockGiftNoteSQLGetter(String dataBaseName) {
		super(dataBaseName);
	}

	@Override
	public List<NotePO> getNoteList() {
		List<NotePO> list = new ArrayList<NotePO>();
		try {
			// 构建sql语句
			String sql = "select * from stock_gift_note";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			// 获取结果集（查询数据库）
			ResultSet res = stmt.executeQuery();
			
			while(res.next()){
				String noteNumber = res.getString("note_number");
				String userID = res.getString("user_id");
				int goodsListItemNum = res.getInt("goods_list_item_num");				
				String[] goodsIDList = res.getString("goods_id_list").split(DataStringHelper.getSeparator());
				String[] goodsNameList = res.getString("goods_name_list").split(DataStringHelper.getSeparator());
				String[] typeList = res.getString("type_list").split(DataStringHelper.getSeparator());
				String[] num = res.getString("amounts").split(DataStringHelper.getSeparator());
				String state = res.getString("state");
				
				int[] amounts = new int[goodsListItemNum];				
				for(int i = 0; i < goodsListItemNum; i++)
					amounts[i] = Integer.parseInt(num[i]);
																	 				
				StockGiftNotePO stockGiftNotePO = new StockGiftNotePO(noteNumber, userID, goodsListItemNum, goodsIDList,goodsNameList, typeList, amounts, state);		
				list.add(stockGiftNotePO);
			}
			// 若访问MySQL未出错，并且数据库内并无单据，则返回一个空的ArrayList（非null)
			return list;
			
		} catch (SQLException e) {
			System.out.println("StockGiftNoteData_SQLException");
			e.printStackTrace();
		}
		return null;
	}

}
