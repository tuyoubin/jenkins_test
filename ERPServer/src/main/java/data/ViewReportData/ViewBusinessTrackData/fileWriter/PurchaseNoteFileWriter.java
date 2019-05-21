package data.ViewReportData.ViewBusinessTrackData.fileWriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import po.popublic.NotePO;
import po.posale_purchase_client.ListOfGoodsPO;
import po.posale_purchase_client.PurchaseNotePO;

/**
 * 进货单导出模块
 * @author CharlieLei
 *
 */
public class PurchaseNoteFileWriter extends NoteFileWriter {

	public PurchaseNoteFileWriter(String time, String fileFolderPath) {
		super(time, fileFolderPath, "进货单");
	}

	@Override
	public void write(List<NotePO> noteList) throws IOException {
		if(noteList == null) return;
		
		file.createNewFile();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
		
		PurchaseNotePO tempPurchaseNote = null;
		for(int i = 0; i < noteList.size(); i++) {
			tempPurchaseNote = (PurchaseNotePO) noteList.get(i);
			
			String ListNumbering = tempPurchaseNote.get_ListNumbering();
			String provider = tempPurchaseNote.get_provider();
			String storehouse = tempPurchaseNote.get_storehouse();
			String operator_id = tempPurchaseNote.operator_id();
			ListOfGoodsPO po = tempPurchaseNote.get_ListOfGoodsPO();
			String remark = tempPurchaseNote.get_remark();
			double total = tempPurchaseNote.get_total();
			
			
			writer.append("单据编号" + "\t\t" + ListNumbering + System.lineSeparator());
			writer.append("供应商" + "\t\t" + provider + System.lineSeparator());
			writer.append("仓库" + "\t\t" + storehouse + System.lineSeparator());
			writer.append("操作员" + "\t\t" + operator_id + System.lineSeparator());
			
			writer.append("入库商品列表" +  System.lineSeparator());
			ListOfGoodsFileWriter goodsListFileWriter = new ListOfGoodsFileWriter();
			goodsListFileWriter.write(po, writer);
			writer.append(System.lineSeparator());
			
			writer.append("备注" + "\t\t" + remark + System.lineSeparator());
			writer.append("总额合计" + "\t\t" + total + System.lineSeparator());
			
			writer.append(System.lineSeparator() + System.lineSeparator());
		}
		writer.close();
	}

}
