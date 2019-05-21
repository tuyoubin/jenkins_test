package data.noteSQLModule.noteSQLWriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.DataStringHelper;
import data.utility.SQLAttributeIndex;
import po.popublic.NotePO;
import po.posale_purchase_client.ListOfGoodsPO;
import po.posale_purchase_client.PurchaseNotePO;

public class PurchaseNoteSQLWriter extends NoteSQLWriter{

	public PurchaseNoteSQLWriter(String dataBaseName) {
		super(dataBaseName);
	}

	@Override
	public boolean saveNote(NotePO po) {
		if(po == null) return false;
		
		//将单据po类型转换
		PurchaseNotePO purchaseNotePO = (PurchaseNotePO)po;
		
		String state = purchaseNotePO.get_state();
		String ListNumbering = purchaseNotePO.get_ListNumbering();
		String provider = purchaseNotePO.get_provider();
		String storehouse = purchaseNotePO.get_storehouse();
		String operator_id = purchaseNotePO.operator_id();
		String remark = purchaseNotePO.get_remark();
		double total = purchaseNotePO.get_total();
		
		ListOfGoodsPO list = purchaseNotePO.get_ListOfGoodsPO();
		String state_list = DataStringHelper.getString(list.get_state());
		String numbering_list =  DataStringHelper.getString(list.get_numbering());
		String name_list =  DataStringHelper.getString(list.get_NameOfGoods());
		String type_list =  DataStringHelper.getString(list.get_type());
		String num_list =  DataStringHelper.getString(list.get_num());
		String unit_price_list =  DataStringHelper.getString(list.get_unit_price());
		String total_price_list =  DataStringHelper.getString(list.get_total());
		String remark_list =  DataStringHelper.getString(list.get_remark());
		double all_total = list.get_all_total();
				
		try {
			// 构建sql语句
			String sql = "insert into purchase_note "+"values(?,?,?,?,?,?,?,"+ "?,?,?,?,?,?,?,?,?" + ")";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(SQLAttributeIndex.PurchaseNote_State.index(), state);
			stmt.setString(SQLAttributeIndex.PurchaseNote_ListNumbering.index(), ListNumbering);		
			stmt.setString(SQLAttributeIndex.PurchaseNote_Provider.index(), provider);
			stmt.setString(SQLAttributeIndex.PurchaseNote_Storehouse.index(), storehouse);
			stmt.setString(SQLAttributeIndex.PurchaseNote_OperatorID.index(), operator_id);
			stmt.setString(SQLAttributeIndex.PurchaseNote_Remark.index(), remark);
			stmt.setDouble(SQLAttributeIndex.PurchaseNote_Total.index(), total);
			
			stmt.setString(7+SQLAttributeIndex.ListOfGoods_StateList.index(), state_list);
			stmt.setString(7+SQLAttributeIndex.ListOfGoods_NumberingList.index(), numbering_list);
			stmt.setString(7+SQLAttributeIndex.ListOfGoods_NameList.index(), name_list);
			stmt.setString(7+SQLAttributeIndex.ListOfGoods_TypeList.index(), type_list);
			stmt.setString(7+SQLAttributeIndex.ListOfGoods_NumList.index(), num_list);			
			stmt.setString(7+SQLAttributeIndex.ListOfGoods_UnitPriceList.index(), unit_price_list);
			stmt.setString(7+SQLAttributeIndex.ListOfGoods_TotalPriceList.index(), total_price_list);
			stmt.setString(7+SQLAttributeIndex.ListOfGoods_RemarkList.index(), remark_list);
			stmt.setDouble(7+SQLAttributeIndex.ListOfGoods_AllTotal.index(), all_total);
						
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("保存进货单成功");
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("StockGiftNoteData_SQLException");
			e.printStackTrace();
		}
		
		return false;
	}

}
