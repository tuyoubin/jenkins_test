package data.noteSQLModule.noteSQLGetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.utility.DataStringHelper;
import po.popublic.NotePO;
import po.potreasurer.CashBillPO;

public class CashBillSQLGetter extends NoteSQLGetter {

	//项目名
	//note_number, user_id, account_name, 
	//expense_account_item_num, item_name_list, amount_list, remark_list, 
	//total_amount, is_passed, is_informed
	
	public CashBillSQLGetter(String dataBaseName) {
		super(dataBaseName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<NotePO> getNoteList() {
		List<NotePO> noteList = null;
		
		String noteNumber = null;
		String userID = null;
		String accountName = null;
		int expenseAccountItemNum = 0;
		String[] itemNameList = null;
		double[] amountList = null;
		String[] remarkList = null;
		double totalAmount = 0.0;
		boolean isPassed = false;
		boolean isInformed = false;
		
		try {
			String sql = "select * from cash_bill order by note_number";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			
			noteList = new ArrayList<NotePO>();
			CashBillPO tempCashBillPO  = null;
			while(res.next()) {
				noteNumber = res.getString("note_number");
				userID = res.getString("user_id");
				accountName = res.getString("account_name");
				expenseAccountItemNum = res.getInt("expense_account_item_num");
				itemNameList = res.getString("item_name_list").split(DataStringHelper.getSeparator());
				
				String[] temp = res.getString("amount_list").split(DataStringHelper.getSeparator());
				amountList = new double[expenseAccountItemNum];
				for(int i = 0; i < expenseAccountItemNum; i++) {
					amountList[i] = Double.valueOf(temp[i]);
				}
				
				remarkList = res.getString("remark_list").split(DataStringHelper.getSeparator());
				totalAmount = res.getDouble("total_amount");
				isPassed = res.getBoolean("is_passed");
				isInformed = res.getBoolean("is_informed");
				
				tempCashBillPO = new CashBillPO(noteNumber, userID, accountName, expenseAccountItemNum, 
						itemNameList, amountList, remarkList, totalAmount, isPassed, isInformed);
				
				noteList.add(tempCashBillPO);
			}
		}catch(SQLException e) {
			System.out.println("CashBillData_SQLException");
			e.printStackTrace();
		}
		
		return noteList;
	}

}
