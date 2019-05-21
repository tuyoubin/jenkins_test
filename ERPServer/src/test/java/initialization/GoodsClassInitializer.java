package initialization;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import data.GoodsClassData.GoodsClassDataImpl;
import data.utility.DataBaseHelper;
import po.postock.GoodsClassPO;

public class GoodsClassInitializer {

	private static final String stockDataBaseName = "stock";
	private static Connection connection = DataBaseHelper.getDataBaseConnection(stockDataBaseName);
	
	
	public GoodsClassInitializer() {}
	
	public static void initGoodsClass() {
		
		try {
			//构建sql语句
			String sql = "delete from goods_class";
			//设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			//尝试执行（更新数据库）
			stmt.executeUpdate();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("00020001");
		list1.add("00020002");
		list1.add("00020003");
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("00060001");
		
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("00050001");
		
		GoodsClassPO A = new GoodsClassPO("0001", "A", "0000", 1, null);
		GoodsClassPO AA = new GoodsClassPO("0002", "AA", "0001", 2, list1);
		GoodsClassPO AB = new GoodsClassPO("0003", "AB", "0001", 2, null);
		GoodsClassPO ABA = new GoodsClassPO("0006", "ABA", "0003", 3, list2);
		GoodsClassPO ABB = new GoodsClassPO("0007", "ABB", "0003", 3, null);
		GoodsClassPO B = new GoodsClassPO("0004", "B", "0000", 1, null);
		GoodsClassPO BA = new GoodsClassPO("0005", "BA", "0004", 2, list3);
		
		
		GoodsClassDataImpl helper = new GoodsClassDataImpl();
		try {
			helper.newClass(A);
			helper.newClass(AA);
			helper.newClass(AB);
			helper.newClass(ABA);
			helper.newClass(ABB);
			helper.newClass(B);
			helper.newClass(BA);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
