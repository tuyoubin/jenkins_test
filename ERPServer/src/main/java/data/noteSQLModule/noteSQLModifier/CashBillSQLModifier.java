package data.noteSQLModule.noteSQLModifier;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.DataStringHelper;
import po.popublic.NotePO;
import po.potreasurer.CashBillPO;

public class CashBillSQLModifier extends NoteSQLModifier {

	//项目名
	//note_number, user_id, account_name, 
	//expense_account_item_num, item_name_list, amount_list, remark_list, 
	//total_amount, is_passed, is_informed
	
	public CashBillSQLModifier(String dataBaseName) {
		super(dataBaseName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean modifyNote(NotePO noteNewState) {
		if(noteNewState == null) return false;
		
		CashBillPO cashbill = (CashBillPO) noteNewState;
		
		String noteNumber = cashbill.getNoteNumber();
		String userID = cashbill.getUserID();
		String accountName = cashbill.getCompanyAccountName();
		int expenseAccountItemNum = cashbill.getExpenseAccountItemNum();
		String[] itemNameList = cashbill.getItemNameList();
		double[] amountList = cashbill.getAmountList();
		String[] remarkList = cashbill.getRemarkList();
		double totalAmount = cashbill.getTotalAmount();
		boolean isPassed = cashbill.isPassed();
		boolean isInformed = cashbill.isInformed();
		
		String itemNameString = "";
		String amountString = "";
		String remarkString = "";
		for(int i = 0; i < expenseAccountItemNum; i++) {
			itemNameString = itemNameString + itemNameList[i] + DataStringHelper.getSeparator();
			amountString = amountString + Double.toString(amountList[i]) + DataStringHelper.getSeparator();
			remarkString = remarkString + remarkList[i] + DataStringHelper.getSeparator();				
		}
		
		try {
			String sql = "update cash_bill set user_id = ?, account_name = ?,"
					+ " expense_account_item_num = ?, item_name_list = ?, amount_list = ?, remark_list = ?, "
					+ "total_amount = ?, is_passed = ?, is_informed = ? "
					+ "where note_number = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, userID);
			stmt.setString(2, accountName);
			stmt.setInt(3, expenseAccountItemNum);
			stmt.setString(4, itemNameString);
			stmt.setString(5, amountString);
			stmt.setString(6, remarkString);
			stmt.setDouble(7, totalAmount);
			stmt.setBoolean(8, isPassed);
			stmt.setBoolean(9, isInformed);
			//where子句
			stmt.setString(10, noteNumber);
			
			System.out.println(stmt.toString());
			
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("成功修改数据库中现金费用单");
			stmt.close();
			return true;
		}catch (SQLException e) {
			System.out.println("CashBillSQLModifier_SQLException");
			e.printStackTrace();
		}
		
		return false;
	}

}
