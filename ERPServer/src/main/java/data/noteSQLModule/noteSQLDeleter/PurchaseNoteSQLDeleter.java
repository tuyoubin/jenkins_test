package data.noteSQLModule.noteSQLDeleter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import po.popublic.NotePO;
import po.posale_purchase_client.PurchaseNotePO;

public class PurchaseNoteSQLDeleter extends NoteSQLDeleter{

	public PurchaseNoteSQLDeleter(String dataBaseName) {
		super(dataBaseName);
	}

	@Override
	public boolean delete(NotePO po) {
		if(po == null) return false;
		
		//将单据po类型转换
		PurchaseNotePO purchaseNotePO = (PurchaseNotePO)po;
		
		String ListNumbering = purchaseNotePO.get_ListNumbering();
		
		try {
			// 构建sql语句
			String sql = "delete from purchase_note where list_numbering = ?";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, ListNumbering);
						
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("删除进货单成功");
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("PurchaseNoteData_SQLException");
			e.printStackTrace();
		}		
		
		return false;
	}

}
