package data.noteSQLModule.noteSQLWriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.DataStringHelper;
import data.utility.SQLAttributeIndex;
import po.popublic.NotePO;
import po.posale_purchase_client.ListOfGoodsPO;
import po.posale_purchase_client.SaleListPO;

public class SaleListSQLWriter extends NoteSQLWriter{

	public SaleListSQLWriter(String dataBaseName) {
		super(dataBaseName);
	}

	@Override
	public boolean saveNote(NotePO po) {
		if(po == null) return false;
		
		//将单据po类型转换
		SaleListPO saleListPO = (SaleListPO)po;
						
		String state = saleListPO.get_state();
		String ListNumbering = saleListPO.get_ListNumbering();
		String client = saleListPO.get_client();
		String storehouse = saleListPO.storehouse();		
		String merchandiser = saleListPO.get_merchandiser();
		String operator_id = saleListPO.get_operator_id();
		String remark = saleListPO.get_remark();
		
		double tbd = saleListPO.get_total_Before_Discount();		
		double discount = saleListPO.get_discount();
		double voucher = saleListPO.get_voucher();
		double total = saleListPO.get_Total();
		double dis = saleListPO.get_dis();
	
		ListOfGoodsPO goodslist = saleListPO.get_ListOfGoodsPO();
		String state_list = DataStringHelper.getString(goodslist.get_state());
		String numbering_list =  DataStringHelper.getString(goodslist.get_numbering());
		String name_list =  DataStringHelper.getString(goodslist.get_NameOfGoods());
		String type_list =  DataStringHelper.getString(goodslist.get_type());
		String num_list =  DataStringHelper.getString(goodslist.get_num());
		String unit_price_list =  DataStringHelper.getString(goodslist.get_unit_price());
		String total_price_list =  DataStringHelper.getString(goodslist.get_total());
		String remark_list =  DataStringHelper.getString(goodslist.get_remark());
		double all_total = goodslist.get_all_total();
		
		ListOfGoodsPO gift = saleListPO.get_gift();
		String state_list_of_gift = DataStringHelper.getString(gift.get_state());
		String numbering_list_of_gift =  DataStringHelper.getString(gift.get_numbering());
		String name_list_of_gift =  DataStringHelper.getString(gift.get_NameOfGoods());
		String type_list_of_gift =  DataStringHelper.getString(gift.get_type());
		String num_list_of_gift =  DataStringHelper.getString(gift.get_num());
		String unit_price_list_of_gift =  DataStringHelper.getString(gift.get_unit_price());
		String total_price_list_of_gift =  DataStringHelper.getString(gift.get_total());
		String remark_list_of_gift =  DataStringHelper.getString(gift.get_remark());
		double all_total_of_gift = gift.get_all_total();
	
		try {
			// 构建sql语句
			String sql = "insert into sale_list "+"values(?,?,?,?,?,?,?," + "?,?,?,?,?," + "?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,?" + ")";
			// 设置预处理语句 
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(SQLAttributeIndex.SaleList_State.index(), state);
			stmt.setString(SQLAttributeIndex.SaleList_ListNumbering.index(), ListNumbering);		
			stmt.setString(SQLAttributeIndex.SaleList_Client.index(), client);
			stmt.setString(SQLAttributeIndex.SaleList_Storehouse.index(), storehouse);
			stmt.setString(SQLAttributeIndex.SaleList_Merchandiser.index(), merchandiser);			
			stmt.setString(SQLAttributeIndex.SaleList_OperatorID.index(), operator_id);
			stmt.setString(SQLAttributeIndex.SaleList_Remark.index(), remark);
			
			stmt.setDouble(SQLAttributeIndex.SaleList_TBD.index(), tbd);
			stmt.setDouble(SQLAttributeIndex.SaleList_Discount.index(), discount);
			stmt.setDouble(SQLAttributeIndex.SaleList_Voucher.index(), total);
			stmt.setDouble(SQLAttributeIndex.SaleList_Total.index(), voucher);
			stmt.setDouble(SQLAttributeIndex.SaleList_Dis.index(), dis);
		
			stmt.setString(12+SQLAttributeIndex.ListOfGoods_StateList.index(), state_list);
			stmt.setString(12+SQLAttributeIndex.ListOfGoods_NumberingList.index(), numbering_list);
			stmt.setString(12+SQLAttributeIndex.ListOfGoods_NameList.index(), name_list);
			stmt.setString(12+SQLAttributeIndex.ListOfGoods_TypeList.index(), type_list);
			stmt.setString(12+SQLAttributeIndex.ListOfGoods_NumList.index(), num_list);			
			stmt.setString(12+SQLAttributeIndex.ListOfGoods_UnitPriceList.index(), unit_price_list);
			stmt.setString(12+SQLAttributeIndex.ListOfGoods_TotalPriceList.index(), total_price_list);
			stmt.setString(12+SQLAttributeIndex.ListOfGoods_RemarkList.index(), remark_list);
			stmt.setDouble(12+SQLAttributeIndex.ListOfGoods_AllTotal.index(), all_total);
			
			stmt.setString(21+SQLAttributeIndex.ListOfGoods_StateList.index(), state_list_of_gift);
			stmt.setString(21+SQLAttributeIndex.ListOfGoods_NumberingList.index(), numbering_list_of_gift);
			stmt.setString(21+SQLAttributeIndex.ListOfGoods_NameList.index(), name_list_of_gift);
			stmt.setString(21+SQLAttributeIndex.ListOfGoods_TypeList.index(), type_list_of_gift);
			stmt.setString(21+SQLAttributeIndex.ListOfGoods_NumList.index(), num_list_of_gift);			
			stmt.setString(21+SQLAttributeIndex.ListOfGoods_UnitPriceList.index(), unit_price_list_of_gift);
			stmt.setString(21+SQLAttributeIndex.ListOfGoods_TotalPriceList.index(), total_price_list_of_gift);
			stmt.setString(21+SQLAttributeIndex.ListOfGoods_RemarkList.index(), remark_list_of_gift);
			stmt.setDouble(21+SQLAttributeIndex.ListOfGoods_AllTotal.index(), all_total_of_gift);
					
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("保存销售单成功");
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("StockGiftNoteData_SQLException");
			e.printStackTrace();
		}
		
		return false;
	}

}
