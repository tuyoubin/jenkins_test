package initialization;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.GoodsData.GoodsDataImpl;
import data.utility.DataBaseHelper;
import po.postock.GoodsPO;

public class GoodsInitializer {

	private static final String stockDataBaseName = "stock";
	private static Connection connection = DataBaseHelper.getDataBaseConnection(stockDataBaseName);
	
	
	public GoodsInitializer() {}
	
	public static void initGoods() {
		
		try {
			//构建sql语句
			String sql = "delete from goods";
			//设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			//尝试执行（更新数据库）
			stmt.executeUpdate();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		GoodsPO goods1 = new GoodsPO("00020001", "goods1", "type1", 100, 50, 50, 100, 100, 0, "0002");
		GoodsPO goods2 = new GoodsPO("00020002", "goods2", "type2", 100, 50, 50, 100, 100, 0, "0002");
		GoodsPO goods3 = new GoodsPO("00020003", "goods3", "type3", 100, 50, 50, 100, 100, 0, "0002");
		GoodsPO goods4 = new GoodsPO("00060001", "goods4", "type4", 100, 50, 50, 100, 100, 0, "0006");
		GoodsPO goods5 = new GoodsPO("00050001", "goods5", "type5", 100, 50, 50, 100, 100, 0, "0005");
		
		GoodsDataImpl helper = new GoodsDataImpl();
		try {
			helper.newGoods(goods1);
			helper.newGoods(goods2);
			helper.newGoods(goods3);
			helper.newGoods(goods4);
			helper.newGoods(goods5);			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
