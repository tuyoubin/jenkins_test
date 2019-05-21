package data.noteSQLModule.noteSQLWriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.DataStringHelper;
import data.utility.SQLAttributeIndex;
import po.popublic.NotePO;
import po.postock.StockGiftNotePO;

public class StockGiftNoteSQLWriter extends NoteSQLWriter{

	public StockGiftNoteSQLWriter(String dataBaseName) {
		super(dataBaseName);
	}

	@Override
	public boolean saveNote(NotePO po) {
	
		if(po == null) return false;
		
		//将单据po类型转换
		StockGiftNotePO giftNote = (StockGiftNotePO) po;
		
		String giftNoteNumber = giftNote.getNoteNumber();
		String userID = giftNote.getUserID();
		int goodsListItemNum = giftNote.getGoodsListItemNum();
		String[] goodsIDList = giftNote.getGoodsIDList();
		String[] goodsNameList = giftNote.getGoodsNameList();
		String[] typeList = giftNote.getTypeList();
		int[] amounts = giftNote.getAmounts();
		String state = giftNote.getState();

		String goodsIDString = "";
		String goodsNameString = "";
		String typeString = "";
		String amountsString = "";
		for(int i = 0; i < goodsListItemNum; i++){
			goodsIDString = goodsIDString + goodsIDList[i] + DataStringHelper.getSeparator();
			goodsNameString = goodsNameString + goodsNameList[i] + DataStringHelper.getSeparator();
			typeString = typeString + typeList[i] + DataStringHelper.getSeparator();
			amountsString = amountsString + amounts[i] + DataStringHelper.getSeparator();
		}
				
		try {
			// 构建sql语句
			String sql = "insert into stock_gift_note "+"values(?,?,?,?,?,?,?,?)";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(SQLAttributeIndex.StockGiftNote_NoteNumber.index(), giftNoteNumber);
			stmt.setString(SQLAttributeIndex.StockGiftNote_UserID.index(), userID);
			stmt.setInt(SQLAttributeIndex.StockGiftNote_GoodsListItemNum.index(), goodsListItemNum);			
			stmt.setString(SQLAttributeIndex.StockGiftNote_GoodsIDList.index(), goodsIDString);
			stmt.setString(SQLAttributeIndex.StockGiftNote_GoodsNameList.index(), goodsNameString);
			stmt.setString(SQLAttributeIndex.StockGiftNote_TypeList.index(), typeString);
			stmt.setString(SQLAttributeIndex.StockGiftNote_Amounts.index(), amountsString);
			stmt.setString(SQLAttributeIndex.StockGiftNote_State.index(), state);
						
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("保存库存赠送单成功");
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("StockGiftNoteData_SQLException");
			e.printStackTrace();
		}
		
		return false;
	}

}
