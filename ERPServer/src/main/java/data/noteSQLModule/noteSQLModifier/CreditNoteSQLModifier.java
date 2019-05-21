package data.noteSQLModule.noteSQLModifier;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.DataStringHelper;
import po.popublic.NotePO;
import po.potreasurer.CreditNotePO;

public class CreditNoteSQLModifier extends NoteSQLModifier {

	//项目名
	//note_number, supplier_name, user_id, 
	//transfer_list_item_num, account_name_list, transfer_amount_list, remark_list, 
	//total_amount, is_passed, is_informed
	
	public CreditNoteSQLModifier(String dataBaseName) {
		super(dataBaseName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean modifyNote(NotePO noteNewState) {
		if(noteNewState == null) return false;
		
		CreditNotePO creditnote = (CreditNotePO)noteNewState;
		
		String noteNumber = creditnote.getNoteNumber();
		String supplierName = creditnote.getSupplierName();
		String userID = creditnote.getUserID();
		int transferListItemNum = creditnote.getTransferListItemNum();
		String[] accountNameList = creditnote.getAccountNameList();
		double[] transferAmountList = creditnote.getTransferAmountList();
		String[] remarkList = creditnote.getRemarkList();
		double totalAmount = creditnote.getTotalAmount();
		boolean isPassed = creditnote.isPassed();
		boolean isInformed = creditnote.isInformed();
		
		String accountNameString = "";
		String transferAmountString = "";
		String remarkString = "";
		for(int i = 0; i < transferListItemNum; i++) {
			accountNameString = accountNameString + accountNameList[i] + DataStringHelper.getSeparator();
			transferAmountString = transferAmountString + Double.toString(transferAmountList[i]) + DataStringHelper.getSeparator();
			remarkString = remarkString + remarkList[i] + DataStringHelper.getSeparator();
		}
		
		try {
			String sql = "update credit_note set supplier_name = ?, user_id = ?,"
					+ " transfer_list_item_num = ?, account_name_list = ?, transfer_amount_list = ?, remark_list = ?, "
					+ "total_amount = ?, is_passed = ?, is_informed = ? "
					+ "where note_number = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, supplierName);
			stmt.setString(2, userID);
			stmt.setInt(3, transferListItemNum);
			stmt.setString(4, accountNameString);
			stmt.setString(5, transferAmountString);
			stmt.setString(6, remarkString);
			stmt.setDouble(7, totalAmount);
			stmt.setBoolean(8, isPassed);
			stmt.setBoolean(9, isInformed);
			//where子句
			stmt.setString(10, noteNumber);
			
			System.out.println(stmt.toString());
			
			//更新数据库
			stmt.executeUpdate();
			System.out.println("成功修改数据库中付款单");
			stmt.close();
			return true;
		}catch (SQLException e) {
			System.out.println("CreditNoteSQLModifier_SQLException");
			e.printStackTrace();	
		}
		
		return false;
	}

}
