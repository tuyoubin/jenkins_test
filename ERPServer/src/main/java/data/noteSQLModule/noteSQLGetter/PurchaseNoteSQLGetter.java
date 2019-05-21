package data.noteSQLModule.noteSQLGetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.utility.DataStringHelper;
import po.popublic.NotePO;
import po.posale_purchase_client.ListOfGoodsPO;
import po.posale_purchase_client.PurchaseNotePO;

public class PurchaseNoteSQLGetter extends NoteSQLGetter{

	public PurchaseNoteSQLGetter(String dataBaseName) {
		super(dataBaseName);
	}

	@Override
	public List<NotePO> getNoteList() {
		List<NotePO> list = new ArrayList<NotePO>();
		try {
			// 构建sql语句
			String sql = "select * from purchase_note";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			// 获取结果集（查询数据库）
			ResultSet res = stmt.executeQuery();
			
			while(res.next()){
				String state = res.getString("state");
				String ListNumbering = res.getString("list_numbering");
				String provider = res.getString("provider");
				String storehouse = res.getString("storehouse");
				String operator_id = res.getString("operator_id");
				String remark = res.getString("remark");
				double total = res.getDouble("total");				
				
				String[] state1 = DataStringHelper.getStringArray(res.getString("state_list"));
				String[] numbering1 = DataStringHelper.getStringArray(res.getString("numbering_list"));
				String[] nameOfGoods1 = DataStringHelper.getStringArray(res.getString("name_list"));
				String[] type1 = DataStringHelper.getStringArray(res.getString("type_list")); 
				int[] num1 = DataStringHelper.getIntArray(res.getString("num_list"));				
				double[] unit_price1 = DataStringHelper.getDoubleArray(res.getString("unit_price_list"));
				double[] total1 = DataStringHelper.getDoubleArray(res.getString("total_price_list"));
				String[] remark1 = DataStringHelper.getStringArray(res.getString("remark_list"));
				double all_total1 = res.getDouble("all_total");
				
				ListOfGoodsPO po = new ListOfGoodsPO(state1, numbering1, nameOfGoods1, type1, num1, unit_price1, total1, remark1, all_total1);
				PurchaseNotePO purchaseNotePO = new PurchaseNotePO(ListNumbering, provider, storehouse, operator_id, remark, total, state, po);
				list.add(purchaseNotePO);
			}
			// 若访问MySQL未出错，并且数据库内并无单据，则返回一个空的ArrayList（非null)
			return list;
			
		} catch (SQLException e) {
			System.out.println("PurchaseNoteData_SQLException");
			e.printStackTrace();
		}
		return null;
	}

}
