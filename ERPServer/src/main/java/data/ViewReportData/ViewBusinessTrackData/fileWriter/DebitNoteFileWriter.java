package data.ViewReportData.ViewBusinessTrackData.fileWriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import po.popublic.NotePO;
import po.potreasurer.DebitNotePO;

/**
 * 收款单导出模块
 * @author CharlieLei
 *
 */
public class DebitNoteFileWriter extends NoteFileWriter {

	public DebitNoteFileWriter(String time, String fileFolderPath) {
		super(time, fileFolderPath, "收款单");
	}

	@Override
	public void write(List<NotePO> noteList) throws IOException {
		if(noteList == null) return;
		
		file.createNewFile();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
		
		DebitNotePO tempCreditNote = null;
		for(int i = 0; i < noteList.size(); i++) {
			tempCreditNote = (DebitNotePO) noteList.get(i);
			
			String noteNumber = tempCreditNote.getNoteNumber();
			String sellerName = tempCreditNote.getSellerName();
			String userID = tempCreditNote.getUserID();
			int transferListItemNum = tempCreditNote.getTransferListItemNum();
			String[] accountNameList = tempCreditNote.getAccountNameList();
			double[] transferAmountList = tempCreditNote.getTransferAmountList();
			String[] remarkList = tempCreditNote.getRemarkList();
			double totalAmount = tempCreditNote.getTotalAmount();
			
			
			writer.append("单据编号" + "\t\t" + noteNumber + System.lineSeparator());
			writer.append("销售商" + "\t\t" + sellerName + System.lineSeparator());
			writer.append("操作员" + "\t\t" + userID + System.lineSeparator());
			
			System.lineSeparator();
			writer.append("转账列表" + System.lineSeparator());
			writer.append("银行账户名" + "\t\t" + "转账金额" + "\t\t" + "备注" + System.lineSeparator());
			for(int j = 0; j < transferListItemNum; j++) {
				writer.append(accountNameList[j] + "\t\t" + transferAmountList[j] + "\t\t" + remarkList[j] + System.lineSeparator());
			}
			System.lineSeparator();
			
			writer.append("总额汇总" + "\t\t" + totalAmount + System.lineSeparator());
			
			writer.append(System.lineSeparator() + System.lineSeparator());
		}
		
		writer.close();
	}

}
