package data.noteSQLModule.noteSQLWriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.DataStringHelper;
import data.utility.SQLAttributeIndex;
import po.popublic.NotePO;
import po.postock.StockOverflowNotePO;

public class StockOverflowNoteSQLWriter extends NoteSQLWriter{

	public StockOverflowNoteSQLWriter(String dataBaseName) {
		super(dataBaseName);
	}

	@Override
	public boolean saveNote(NotePO po) {
	
		if(po == null) return false;
		
		//将单据po类型转换
		StockOverflowNotePO overflowNote = (StockOverflowNotePO) po;
		
		String noteNumber = overflowNote.getNoteNumber();
		String userID = overflowNote.getUserID();
		int goodsListItemNum = overflowNote.getGoodsListItemNum();
		String[] goodsIDList = overflowNote.getGoodsIDList();
		String[] goodsNameList = overflowNote.getGoodsNameList();
		int[] stockAmounts = overflowNote.getStockAmounts();
		int[] realAmounts = overflowNote.getRealAmounts();
		boolean isPassed = overflowNote.isPassed();
		
		String goodsIDString = "";
		String goodsNameString = "";
		String stockString = "";
		String realString = "";
		for(int i = 0; i < goodsListItemNum; i++){
			goodsIDString = goodsIDString + goodsIDList[i] + DataStringHelper.getSeparator();
			goodsNameString = goodsNameString + goodsNameList[i] + DataStringHelper.getSeparator();
			stockString = stockString + stockAmounts[i] + DataStringHelper.getSeparator();
			realString = realString + realAmounts[i] + DataStringHelper.getSeparator();
		}
				
		try {
			// 构建sql语句
			String sql = "insert into stock_overflow_note "+"values(?,?,?,?,?,?,?,?)";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(SQLAttributeIndex.StockOverflowNote_NoteNumber.index(), noteNumber);
			stmt.setString(SQLAttributeIndex.StockOverflowNote_UserID.index(), userID);
			stmt.setInt(SQLAttributeIndex.StockOverflowNote_GoodsListItemNum.index(), goodsListItemNum);
			stmt.setString(SQLAttributeIndex.StockOverflowNote_GoodsIDList.index(), goodsIDString);
			stmt.setString(SQLAttributeIndex.StockOverflowNote_GoodsNameList.index(), goodsNameString);
			stmt.setString(SQLAttributeIndex.StockOverflowNote_StockAmounts.index(), stockString);
			stmt.setString(SQLAttributeIndex.StockOverflowNote_RealAmounts.index(), realString);
			stmt.setBoolean(SQLAttributeIndex.StockLossNote_IsPassed.index(), isPassed);
						
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("保存库存报溢单成功");
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("StockOverflowNoteData_SQLException");
			e.printStackTrace();
		}
		return false;
	}

}
