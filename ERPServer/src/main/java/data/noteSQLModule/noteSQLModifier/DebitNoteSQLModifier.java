package data.noteSQLModule.noteSQLModifier;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.DataStringHelper;
import po.popublic.NotePO;
import po.potreasurer.DebitNotePO;

public class DebitNoteSQLModifier extends NoteSQLModifier {

	//项目名
	//note_number, seller_name, user_id, 
	//transfer_list_item_num, account_name_list, transfer_amount_list, remark_list, 
	//total_amount, is_passed, is_informed
	
	public DebitNoteSQLModifier(String dataBaseName) {
		super(dataBaseName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean modifyNote(NotePO noteNewState) {
		if(noteNewState == null) return false;
		
		DebitNotePO debitnote = (DebitNotePO)noteNewState;
		
		String noteNumber = debitnote.getNoteNumber();
		String sellerName = debitnote.getSellerName();
		String userID = debitnote.getUserID();
		int transferListItemNum = debitnote.getTransferListItemNum();
		String[] accountNameList = debitnote.getAccountNameList();
		double[] transferAmountList = debitnote.getTransferAmountList();
		String[] remarkList = debitnote.getRemarkList();
		double totalAmount = debitnote.getTotalAmount();
		boolean isPassed = debitnote.isPassed();
		boolean isInformed = debitnote.isInformed();
		
		String accountNameString = "";
		String transferAmountString = "";
		String remarkString = "";
		for(int i = 0; i < transferListItemNum; i++) {
			accountNameString = accountNameString + accountNameList[i] + DataStringHelper.getSeparator();
			transferAmountString = transferAmountString + Double.toString(transferAmountList[i]) + DataStringHelper.getSeparator();
			remarkString = remarkString + remarkList[i] + DataStringHelper.getSeparator();
		}
		
		try {
			String sql = "update debit_note set seller_name = ?, user_id = ?,"
					+ " transfer_list_item_num = ?, account_name_list = ?, transfer_amount_list = ?, remark_list = ?, "
					+ "total_amount = ?, is_passed = ?, is_informed = ? "
					+ "where note_number = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, sellerName);
			stmt.setString(2, userID);
			stmt.setInt(3, transferListItemNum);
			stmt.setString(4, accountNameString);
			stmt.setString(5, transferAmountString);
			stmt.setString(6, remarkString);
			stmt.setDouble(7, totalAmount);
			stmt.setBoolean(8, isPassed);
			stmt.setBoolean(9, isInformed);
			stmt.setString(10, noteNumber);
			
			System.out.println(stmt.toString());
			
			//更新数据库
			stmt.executeUpdate();
			System.out.println("数据库成功更新收款单");
			stmt.close();
			return true;
		}catch (SQLException e) {
			System.out.println("DebitNoteSQLWriter_SQLException");
			e.printStackTrace();	
		}
		
		return false;
	}

}
