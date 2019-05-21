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
 * 进货退货单导出模块
 * @author CharlieLei
 *
 */
public class PurchaseReturnNoteFileWriter extends NoteFileWriter {

	public PurchaseReturnNoteFileWriter(String time, String fileFolderPath) {
		super(time, fileFolderPath, "进货退货单");
	}

	@Override
	public void write(List<NotePO> noteList) throws IOException {
if(noteList == null) return;
		
		file.createNewFile();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
		
		PurchaseNotePO tempPurchaseReturnNote = null;
		for(int i = 0; i < noteList.size(); i++) {
			tempPurchaseReturnNote = (PurchaseNotePO) noteList.get(i);
			
			String ListNumbering = tempPurchaseReturnNote.get_ListNumbering();
			String provider = tempPurchaseReturnNote.get_provider();
			String storehouse = tempPurchaseReturnNote.get_storehouse();
			String operator_id = tempPurchaseReturnNote.operator_id();
			ListOfGoodsPO po = tempPurchaseReturnNote.get_ListOfGoodsPO();
			String remark = tempPurchaseReturnNote.get_remark();
			double total = tempPurchaseReturnNote.get_total();
			
			
			writer.append("单据编号" + "\t\t" + ListNumbering + System.lineSeparator());
			writer.append("供应商" + "\t\t" + provider + System.lineSeparator());
			writer.append("仓库" + "\t\t" + storehouse + System.lineSeparator());
			writer.append("操作员" + "\t\t" + operator_id + System.lineSeparator());
			
			writer.append("入库商品列表" +  System.lineSeparator());
			writer.append("商品编号" + "\t\t" + "名称" + "\t\t" + "型号" + "\t\t" + "数量" + "\t\t" + 
					"单价" + "\t\t" + "金额" + "\t\t" + "备注" + System.lineSeparator());
			if(po == null) {
				writer.append("ListOfGoddsPO is null");
				writer.close();
				return;
			}
			for(int j = 0; j < po.get_NameOfGoods().length ; j++) {
				String[] goodsNumbering = po.get_numbering();
				String[] nameOfGoods = po.get_NameOfGoods();
				String[] goodsType = po.get_type();
				int[] goodsNum = po.get_num();
				double[] unitPrice = po.get_unit_price();
				double[] goodsTotal = po.get_total();
				String[] goodsRemark = po.get_remark();
				
				writer.append(goodsNumbering[j] + "\t\t" + nameOfGoods[j] + "\t\t" + goodsType[j] + "\t\t" +
						goodsNum[j] + "\t\t" + unitPrice[j] + "\t\t" + goodsTotal[j] + "\t\t" + goodsRemark[j] +
						System.lineSeparator());
			}
			writer.append(System.lineSeparator());
			
			writer.append("备注" + "\t\t" + remark + System.lineSeparator());
			writer.append("总额合计" + "\t\t" + total + System.lineSeparator());
			
			writer.append(System.lineSeparator() + System.lineSeparator());
		}
		writer.close();

	}

}
