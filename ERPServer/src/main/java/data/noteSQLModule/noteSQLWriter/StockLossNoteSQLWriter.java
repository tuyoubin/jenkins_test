package data.noteSQLModule.noteSQLWriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.DataStringHelper;
import data.utility.SQLAttributeIndex;
import po.popublic.NotePO;
import po.postock.StockLossNotePO;

public class StockLossNoteSQLWriter extends NoteSQLWriter{
	
	public StockLossNoteSQLWriter(String dataBaseName) {
		super(dataBaseName);
	}

	@Override
	public boolean saveNote(NotePO po) {
		
		if(po == null) return false;
		
		//将单据po类型转换
		StockLossNotePO lossNote = (StockLossNotePO) po;
		
		String noteNumber = lossNote.getNoteNumber();
		String userID = lossNote.getUserID();
		int goodsListItemNum = lossNote.getGoodsListItemNum();
		String[] goodsIDList = lossNote.getGoodsIDList();
		String[] goodsNameList = lossNote.getGoodsNameList();
		int[] stockAmounts = lossNote.getStockAmounts();
		int[] realAmounts = lossNote.getRealAmounts();
		boolean isPassed = lossNote.isPassed();
		
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
			String sql = "insert into stock_loss_note "+"values(?,?,?,?,?,?,?,?)";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(SQLAttributeIndex.StockLossNote_NoteNumber.index(), noteNumber);
			stmt.setString(SQLAttributeIndex.StockLossNote_UserID.index(), userID);
			stmt.setInt(SQLAttributeIndex.StockLossNote_GoodsListItemNum.index(), goodsListItemNum);
			stmt.setString(SQLAttributeIndex.StockLossNote_GoodsIDList.index(), goodsIDString);
			stmt.setString(SQLAttributeIndex.StockLossNote_GoodsNameList.index(), goodsNameString);
			stmt.setString(SQLAttributeIndex.StockLossNote_StockAmounts.index(), stockString);
			stmt.setString(SQLAttributeIndex.StockLossNote_RealAmounts.index(), realString);
			stmt.setBoolean(SQLAttributeIndex.StockLossNote_IsPassed.index(), isPassed);
						
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("保存库存报损单成功");
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("StockLossNoteData_SQLException");
			e.printStackTrace();
		}
		return false;
	}
	
	
}
