package initialization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.noteSQLModule.noteSQLWriter.CreditNoteSQLWriter;
import data.utility.DataBaseHelper;
import po.potreasurer.CreditNotePO;

public class CreditNoteInitializer {

	private static final String treasurerDataBaseName = "treasurer";
	private static Connection connection = DataBaseHelper.getDataBaseConnection(treasurerDataBaseName);	

	
	public CreditNoteInitializer() {}
	
	public static void initCreditNote() {
		CreditNoteSQLWriter writer = new CreditNoteSQLWriter(treasurerDataBaseName);
		try {
			//构建sql语句
			String sql = "delete from credit_note";
			//设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			System.out.println(stmt.toString());
			//尝试执行（更新数据库）
			stmt.executeUpdate();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		String[] a= {"账户1", "账户2"};
		double[] b = {100, 200};
		String[] c = {"备注1", "备注2"};
		writer.saveNote(new CreditNotePO("FKD##-20170101-54321", "客户1", "财务人员1", 2, a, b, c, 300, true, false));
		
		String[] x= {"账户1", "账户2"};
		double[] y = {100, 200};
		String[] z = {"备注1", "备注2"};
		writer.saveNote(new CreditNotePO("FKD##-20170202-12121", "客户1", "财务人员1", 2, x, y, z, 300, true, false));
		
		String[] d = {"账户1", "账户2"};
		double[] e = {500, 600};
		String[] f = {"备注3", "备注4"};
		writer.saveNote(new CreditNotePO("FKD##-20180101-15234", "客户2", "财务人员2", 2, d, e, f, 1100, true, false));
	}

}
