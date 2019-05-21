package data.ViewReportData.ViewBusinessTrackData.fileWriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import po.popublic.NotePO;
import po.potreasurer.CashBillPO;

/**
 * 现金费用单导出模块
 * @author CharlieLei
 *
 */
public class CashBillFileWriter extends NoteFileWriter {

	public CashBillFileWriter(String time, String fileFolderPath) {
		super(time, fileFolderPath, "现金费用单");
	}

	@Override
	public void write(List<NotePO> noteList) throws IOException {
		if(noteList == null) return;	
		
		file.createNewFile();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
		
		CashBillPO tempCashBill = null;
		for(int i = 0; i < noteList.size(); i++) {
			tempCashBill = (CashBillPO) noteList.get(i);
			
			String noteNumber = tempCashBill.getNoteNumber();
			String userID = tempCashBill.getUserID();
			String companyAccountName = tempCashBill.getCompanyAccountName();
			int expenseAccountItemNum = tempCashBill.getExpenseAccountItemNum();
			String[] itemNameList = tempCashBill.getItemNameList();
			double[] amountList = tempCashBill.getAmountList();
			String[] remarkList = tempCashBill.getRemarkList();
			double totalAmount = tempCashBill.getTotalAmount();
			
			
			writer.append("单据编号" + "\t\t" + noteNumber + System.lineSeparator());
			writer.append("操作员" + "\t\t" + userID + System.lineSeparator());
			writer.append("银行账户名" + "\t\t" + companyAccountName + System.lineSeparator());
			
			writer.append(System.lineSeparator());
			writer.append("转账列表" + System.lineSeparator());
			writer.append("条目名" + "\t\t" + "金额" + "\t\t" + "备注" + System.lineSeparator());
			for(int j = 0; j < expenseAccountItemNum; j++) {
				writer.append(itemNameList[j] + "\t\t" + amountList[j] + "\t\t" + remarkList[j] + System.lineSeparator());
			}
			writer.append(System.lineSeparator());
			
			writer.append("总额" + "\t\t" + totalAmount + System.lineSeparator());
			
			writer.append(System.lineSeparator() + System.lineSeparator());
		}
			
		writer.close();
	}

}
