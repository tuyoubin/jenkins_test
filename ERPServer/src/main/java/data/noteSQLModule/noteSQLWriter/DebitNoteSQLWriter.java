package data.noteSQLModule.noteSQLWriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.DataStringHelper;
import data.utility.SQLAttributeIndex;
import po.popublic.NotePO;
import po.potreasurer.DebitNotePO;

public class DebitNoteSQLWriter extends NoteSQLWriter {

	//项目名
	//note_number, seller_name, user_id, 
	//transfer_list_item_num, account_name_list, transfer_amount_list, remark_list, 
	//total_amount, is_passed, is_informed
	
	public DebitNoteSQLWriter(String dataBaseName) {
		super(dataBaseName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveNote(NotePO notePO) {
		if(notePO == null) return false;
		
		DebitNotePO debitnote = (DebitNotePO)notePO;
		
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
			String sql = "insert into debit_note values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(SQLAttributeIndex.DebitNote_NoteNumber.index(), noteNumber);
			stmt.setString(SQLAttributeIndex.DebitNote_SellerName.index(), sellerName);
			stmt.setString(SQLAttributeIndex.DebitNote_UserID.index(), userID);
			stmt.setInt(SQLAttributeIndex.DebitNote_TransferListItemNum.index(), transferListItemNum);
			stmt.setString(SQLAttributeIndex.DebitNote_AccountNameList.index(), accountNameString);
			stmt.setString(SQLAttributeIndex.DebitNote_TransferAmountList.index(), transferAmountString);
			stmt.setString(SQLAttributeIndex.DebitNote_RemarkList.index(), remarkString);
			stmt.setDouble(SQLAttributeIndex.DebitNote_TotalAmount.index(), totalAmount);
			stmt.setBoolean(SQLAttributeIndex.DebitNote_IsPassed.index(), isPassed);
			stmt.setBoolean(SQLAttributeIndex.DebitNote_IsInformed.index(), isInformed);
			
			System.out.println(stmt.toString());
			
			//更新数据库
			stmt.executeUpdate();
			System.out.println("收款单保存到数据库");
			stmt.close();
			return true;
		}catch (SQLException e) {
			System.out.println("DebitNoteSQLWriter_SQLException");
			e.printStackTrace();	
		}
		
		return false;
	}

}
