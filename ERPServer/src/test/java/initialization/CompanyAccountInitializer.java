package initialization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.DataBaseHelper;

public class CompanyAccountInitializer {

	private static final String treasurerDataBaseName = "treasurer";
	private static Connection connection = DataBaseHelper.getDataBaseConnection(treasurerDataBaseName);
	
	
	public CompanyAccountInitializer() {}
	
	public static void initAccount() {
		String[] accountName = {"账户1","账户2","账户3","账户4","账户5","账户6"};
		double[] accountBalance = {10000, 9000, 8000, 7000, 6000, 5000, 4000};
		
		try {
			//构建sql语句
			String sql = "delete from company_account";
			//设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			System.out.println(stmt.toString());
			//尝试执行（更新数据库）
			stmt.executeUpdate();
			stmt.close();
			
			for(int i = 0; i < 6; i++) {
				sql = "insert into company_account values(?,?)";
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, accountName[i]);
				stmt.setDouble(2, accountBalance[i]);
				
				System.out.println(stmt.toString());
				
				// 尝试执行（更新数据库）
				stmt.executeUpdate();
				System.out.println("账户增加成功");
				stmt.close();				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
