package data.noteSQLModule.noteSQLWriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.DataStringHelper;
import data.utility.SQLAttributeIndex;
import po.popublic.NotePO;
import po.potreasurer.CreditNotePO;

public class CreditNoteSQLWriter extends NoteSQLWriter {

	//项目名
	//note_number, supplier_name, user_id, 
	//transfer_list_item_num, account_name_list, transfer_amount_list, remark_list, 
	//total_amount, is_passed, is_informed
	
	public CreditNoteSQLWriter(String dataBaseName) {
		super(dataBaseName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveNote(NotePO notePO) {
		if(notePO == null) return false;
		
		CreditNotePO creditnote = (CreditNotePO)notePO;
		
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
			String sql = "insert into credit_note values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(SQLAttributeIndex.CreditNote_NoteNumber.index(), noteNumber);
			stmt.setString(SQLAttributeIndex.CreditNote_SupplierName.index(), supplierName);
			stmt.setString(SQLAttributeIndex.CreditNote_UserID.index(), userID);
			stmt.setInt(SQLAttributeIndex.CreditNote_TransferListItemNum.index(), transferListItemNum);
			stmt.setString(SQLAttributeIndex.CreditNote_AccountNameList.index(), accountNameString);
			stmt.setString(SQLAttributeIndex.CreditNote_TransferAmountList.index(), transferAmountString);
			stmt.setString(SQLAttributeIndex.CreditNote_RemarkList.index(), remarkString);
			stmt.setDouble(SQLAttributeIndex.CreditNote_TotalAmount.index(), totalAmount);
			stmt.setBoolean(SQLAttributeIndex.CreditNote_IsPassed.index(), isPassed);
			stmt.setBoolean(SQLAttributeIndex.CreditNote_IsInformed.index(), isInformed);
			
			System.out.println(stmt.toString());
			
			//更新数据库
			stmt.executeUpdate();
			System.out.println("付款单保存到数据库");
			stmt.close();
			return true;
		}catch (SQLException e) {
			System.out.println("CreditNoteData_SQLException");
			e.printStackTrace();	
		}
		
		return false;
	}

}
