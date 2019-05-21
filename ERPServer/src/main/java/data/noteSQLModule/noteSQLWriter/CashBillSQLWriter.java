package data.noteSQLModule.noteSQLWriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.DataStringHelper;
import data.utility.SQLAttributeIndex;
import po.popublic.NotePO;
import po.potreasurer.CashBillPO;

public class CashBillSQLWriter extends NoteSQLWriter{

	//项目名
	//note_number, user_id, account_name, 
	//expense_account_item_num, item_name_list, amount_list, remark_list, 
	//total_amount, is_passed, is_informed
	
	public CashBillSQLWriter(String dataBaseName) {
		super(dataBaseName);
	}

	@Override
	public boolean saveNote(NotePO notePO) {
		if(notePO == null) return false;
		
		CashBillPO cashbill = (CashBillPO)notePO;
		
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
			//构建sql语句
			String sql = "insert into cash_bill values(?,?,?,?,?,?,?,?,?,?)";
			//设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(SQLAttributeIndex.CashBill_NoteNumber.index(), noteNumber);
			stmt.setString(SQLAttributeIndex.CashBill_UserID.index(), userID);
			stmt.setString(SQLAttributeIndex.CashBill_AccountName.index(), accountName);
			
			stmt.setInt(SQLAttributeIndex.CashBill_ExpenseAccountItemNum.index(), expenseAccountItemNum);
			stmt.setString(SQLAttributeIndex.CashBill_ItemNameList.index(), itemNameString);
			stmt.setString(SQLAttributeIndex.CashBill_AmountList.index(), amountString);
			stmt.setString(SQLAttributeIndex.CashBill_RemarkList.index(), remarkString);
			
			stmt.setDouble(SQLAttributeIndex.CashBill_TotalAmount.index(), totalAmount);
			stmt.setBoolean(SQLAttributeIndex.CashBill_IsPassed.index(), isPassed);
			stmt.setBoolean(SQLAttributeIndex.CashBill_IsInformed.index(), isInformed);
			
			System.out.println(stmt.toString());
			
			//更新数据库
			stmt.executeUpdate();
			System.out.println("现金费用单保存到数据库");
			stmt.close();
			return true;
		}catch(SQLException e) {
			System.out.println("CashBillData_SQLException");
			e.printStackTrace();
		}
		
		return false;
	}

}
