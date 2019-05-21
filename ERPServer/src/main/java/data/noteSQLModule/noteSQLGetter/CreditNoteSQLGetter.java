package data.noteSQLModule.noteSQLGetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.utility.DataStringHelper;
import po.popublic.NotePO;
import po.potreasurer.CreditNotePO;

public class CreditNoteSQLGetter extends NoteSQLGetter {

	//项目名
	//note_number, supplier_name, user_id, 
	//transfer_list_item_num, account_name_list, transfer_amount_list, remark_list, 
	//total_amount, is_passed, is_informed
	
	public CreditNoteSQLGetter(String dataBaseName) {
		super(dataBaseName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<NotePO> getNoteList() {
		List<NotePO> noteList = null;
		
		try {
			String sql = "select * from credit_note order by note_number";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			
			noteList = new ArrayList<NotePO>();
			CreditNotePO tempCreditNotePO = null;
			while(res.next()) {
				tempCreditNotePO = constructCreditNotePOByResultSet(res);
				
				noteList.add(tempCreditNotePO);
			}
		}catch(SQLException e) {
			System.out.println("CreditNoteSQLGetter_SQLException");
			e.printStackTrace();
		}
		
		return noteList;
	}
	
	private CreditNotePO constructCreditNotePOByResultSet(ResultSet res) throws SQLException {
		String noteNumber = res.getString("note_number");
		String supplierName = res.getString("supplier_name");
		String userID = res.getString("user_id");
		int transferListItemNum = res.getInt("transfer_list_item_num");
		String[] accountNameList = res.getString("account_name_list").split(DataStringHelper.getSeparator());
				
		String[] temp = res.getString("transfer_amount_list").split(DataStringHelper.getSeparator());
		double[] transferAmountList = new double[transferListItemNum];
		for(int i = 0; i < transferListItemNum; i++) {
			transferAmountList[i] = Double.valueOf(temp[i]);
		}
				
		String[] remarkList = res.getString("remark_list").split(DataStringHelper.getSeparator());
		double totalAmount = res.getDouble("total_amount");
		boolean isPassed = res.getBoolean("is_passed");
		boolean isInformed = res.getBoolean("is_informed");

		return new CreditNotePO(noteNumber, supplierName, userID, 
				transferListItemNum, accountNameList, transferAmountList, remarkList,
				totalAmount, isPassed, isInformed);
	}

}
