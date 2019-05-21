package data.noteSQLModule.noteSQLGetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.utility.DataStringHelper;
import po.popublic.NotePO;
import po.posale_purchase_client.ListOfGoodsPO;
import po.posale_purchase_client.SaleListPO;

public class SaleListSQLGetter extends NoteSQLGetter{

	public SaleListSQLGetter(String dataBaseName) {
		super(dataBaseName);
	}

	@Override
	public List<NotePO> getNoteList() {
		List<NotePO> list = new ArrayList<NotePO>();
		try {
			// 构建sql语句
			String sql = "select * from sale_list";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			// 获取结果集（查询数据库）
			ResultSet res = stmt.executeQuery();
			
			while(res.next()){
				String state = res.getString("state");
				String ListNumbering = res.getString("list_numbering");
				String client = res.getString("client");
				String storehouse = res.getString("storehouse");
				String merchandiser = res.getString("merchandiser");
				String operator_id = res.getString("operator_id");
				String remark = res.getString("remark");
				double T_B_D = res.getDouble("t_b_d");
				double discount = res.getDouble("discount");
				double voucher = res.getDouble("voucher");
				double Total = res.getDouble("total");
				double dis = res.getDouble("dis");
				
				String[] state1 = DataStringHelper.getStringArray(res.getString("state_list"));
				String[] numbering1 = DataStringHelper.getStringArray(res.getString("numbering_list"));
				String[] nameOfGoods1 = DataStringHelper.getStringArray(res.getString("name_list"));
				String[] type1 = DataStringHelper.getStringArray(res.getString("type_list")); 
				int[] num1 = DataStringHelper.getIntArray(res.getString("num_list"));				
				double[] unit_price1 = DataStringHelper.getDoubleArray(res.getString("unit_price_list"));
				double[] total1 = DataStringHelper.getDoubleArray(res.getString("total_price_list"));
				String[] remark1 = DataStringHelper.getStringArray(res.getString("remark_list"));
				double all_total1 = res.getDouble("all_total");
				
				String[] state2 = DataStringHelper.getStringArray(res.getString("state_list_of_gift"));
				String[] numbering2 = DataStringHelper.getStringArray(res.getString("numbering_list_of_gift"));
				String[] nameOfGoods2 = DataStringHelper.getStringArray(res.getString("name_list_of_gift"));
				String[] type2 = DataStringHelper.getStringArray(res.getString("type_list_of_gift")); 
				int[] num2 = DataStringHelper.getIntArray(res.getString("num_list_of_gift"));				
				double[] unit_price2 = DataStringHelper.getDoubleArray(res.getString("unit_price_list_of_gift"));
				double[] total2 = DataStringHelper.getDoubleArray(res.getString("total_price_list_of_gift"));
				String[] remark2 = DataStringHelper.getStringArray(res.getString("remark_list_of_gift"));
				double all_total2 = res.getDouble("all_total_of_gift");
								
				ListOfGoodsPO po = new ListOfGoodsPO(state1, numbering1, nameOfGoods1, type1, num1, unit_price1, total1, remark1, all_total1);
				ListOfGoodsPO gift = new ListOfGoodsPO(state2, numbering2, nameOfGoods2, type2, num2, unit_price2, total2, remark2, all_total2);
				SaleListPO saleListPO = new SaleListPO(state, ListNumbering, client, storehouse, merchandiser, operator_id, remark,
				 T_B_D, discount, voucher, Total, po , gift, dis);
				
				list.add(saleListPO);
											
			}
			// 若访问MySQL未出错，并且数据库内并无单据，则返回一个空的ArrayList（非null)
			return list;
			
		} catch (SQLException e) {
			System.out.println("SaleListData_SQLException");
			e.printStackTrace();
		}
		return null;
	}

}
