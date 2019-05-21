package data.ViewReportData.ViewBusinessTrackData.fileWriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import po.popublic.NotePO;
import po.posale_purchase_client.ListOfGoodsPO;
import po.posale_purchase_client.SaleListPO;

/**
 * 销售单导出模块
 * @author CharlieLei
 *
 */
public class SaleListFileWriter extends NoteFileWriter {

	public SaleListFileWriter(String time, String fileFolderPath) {
		super(time, fileFolderPath, "销售单");
	}

	@Override
	public void write(List<NotePO> noteList) throws IOException {
		if(noteList == null) return;
		
		file.createNewFile();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
		
		SaleListPO tempSaleList = null;		
		for(int i = 0; i < noteList.size(); i++) {
			tempSaleList = (SaleListPO) noteList.get(i);
			
			String ListNumbering = tempSaleList.get_ListNumbering();
			String client = tempSaleList.get_client();
			String merchandiser = tempSaleList.get_merchandiser();
			String operator_id = tempSaleList.get_operator_id();
			String storehouse = tempSaleList.storehouse();
			
			ListOfGoodsPO po = tempSaleList.get_ListOfGoodsPO();
			double Total_Before_Discount = tempSaleList.get_total_Before_Discount();
			
			double dis = tempSaleList.get_dis();			
			ListOfGoodsPO gift = tempSaleList.get_gift();
			double discount = tempSaleList.get_discount();
			double voucher = tempSaleList.get_voucher();
			
			double Total = tempSaleList.get_Total();
			String remark = tempSaleList.get_remark();
			
			
			writer.append("单据编号" + "\t\t" + ListNumbering + System.lineSeparator());
			writer.append("客户" + "\t\t" + client + System.lineSeparator());
			writer.append("业务员" + "\t\t" + merchandiser + System.lineSeparator());
			writer.append("操作员" + "\t\t" + operator_id + System.lineSeparator());
			writer.append("仓库" + "\t\t" + storehouse + System.lineSeparator());
			
			//出货商品
			writer.append(System.lineSeparator());
			writer.append("出货商品清单" + System.lineSeparator());
			ListOfGoodsFileWriter goodsListFileWriter = new ListOfGoodsFileWriter();
			goodsListFileWriter.write(po, writer);
			writer.append(System.lineSeparator());
			
			//折让部分
			{
			writer.append("折让前总额" + "\t\t" + Total_Before_Discount + System.lineSeparator());
			
			writer.append(System.lineSeparator());
			writer.append("折让" + System.lineSeparator());
			writer.append("销售人员所给折扣" + "\t\t" + dis + System.lineSeparator());
			
			writer.append(System.lineSeparator());
			writer.append("赠品清单" + System.lineSeparator());
			goodsListFileWriter.write(gift, writer);
			writer.append(System.lineSeparator());
			
			writer.append("总经理所给折扣" + "\t\t" + discount + System.lineSeparator());
			writer.append("代金卷金额" + "\t\t" + voucher + System.lineSeparator());
			writer.append(System.lineSeparator());
			}
			
			writer.append("折让后总额" + "\t\t" + Total + System.lineSeparator());
			writer.append("备注" + remark + "\t\t" + System.lineSeparator());
		}
		writer.close();
	}

}
