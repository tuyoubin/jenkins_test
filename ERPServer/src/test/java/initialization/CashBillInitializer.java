package initialization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.noteSQLModule.noteSQLWriter.CashBillSQLWriter;
import data.utility.DataBaseHelper;
import po.potreasurer.CashBillPO;

public class CashBillInitializer {

	private static final String treasurerDataBaseName = "treasurer";
	private static Connection connection = DataBaseHelper.getDataBaseConnection(treasurerDataBaseName);	
	
	public CashBillInitializer() {
		// TODO Auto-generated constructor stub
	}
	
	public static void initCashBill() {
		CashBillSQLWriter writer = new CashBillSQLWriter(treasurerDataBaseName);
		try {
			//构建sql语句
			String sql = "delete from cash_bill";
			//设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			System.out.println(stmt.toString());
			//尝试执行（更新数据库）
			stmt.executeUpdate();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		String[] a = {"条目1", "条目2"};
		double[] b = {100, 200};
		String[] c = {"备注1", "备注2"};
		writer.saveNote(new CashBillPO("XJFYD-20170101-12536", "财务人员1", "账户1", 2, a, b, c, 300, true, false));
		
		String[] x = {"条目1", "条目2"};
		double[] y = {1000, 2000};
		String[] z = {"备注1", "备注2"};
		writer.saveNote(new CashBillPO("XJFYD-20170202-12036", "财务人员1", "账户1", 2, x, y, z, 3000, true, false));
		
		String[] d = {"条目3", "条目4"};
		double[] e = {500, 1000};
		String[] f = {"备注3", "备注4"};
		writer.saveNote(new CashBillPO("XJFYD-20180101-52630", "财务人员2", "账户2", 2, d, e, f, 1500, true, false));
		
		
		
	}

}
