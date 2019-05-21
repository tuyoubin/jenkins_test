package data.noteSQLModule.noteSQLDeleter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.SQLAttributeIndex;
import po.popublic.NotePO;
import po.potreasurer.CreditNotePO;

public class CreditNoteSQLDeleter extends NoteSQLDeleter {

	//项目名
	//note_number, supplier_name, user_id, 
	//transfer_list_item_num, account_name_list, transfer_amount_list, remark_list, 
	//total_amount, is_passed, is_informed
	
	public CreditNoteSQLDeleter(String dataBaseName) {
		super(dataBaseName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean delete(NotePO notePO) {
		if(notePO == null) return false;
		
		try {
			//构建sql语句
			String sql = "delete from credit_note where note_number = ?";
			//设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(SQLAttributeIndex.CompanyAccount_AccountName.index(), ((CreditNotePO)notePO).getNoteNumber());
			
			//尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("现金费用单删除成功");
			stmt.close();
			return true;
		}catch (SQLException e) {
			System.out.println("CashBillSQLDeleter_SQLException");
			e.printStackTrace();
		}
		
		return false;
	}

}
