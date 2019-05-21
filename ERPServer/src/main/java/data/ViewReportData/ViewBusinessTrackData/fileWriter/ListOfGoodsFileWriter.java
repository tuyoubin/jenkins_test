package data.ViewReportData.ViewBusinessTrackData.fileWriter;

import java.io.BufferedWriter;
import java.io.IOException;

import po.posale_purchase_client.ListOfGoodsPO;

/**
 * 输出商品列表
 * @author CharlieLei
 *
 */
public class ListOfGoodsFileWriter {

	public ListOfGoodsFileWriter() {
		// TODO Auto-generated constructor stub
	}
	
	public void write(ListOfGoodsPO goodsList, BufferedWriter writer) throws IOException {
		writer.append("商品编号" + "\t\t" + "名称" + "\t\t" + "型号" + "\t\t" + "数量" + "\t\t" + 
				"单价" + "\t\t" + "金额" + "\t\t" + "备注" + System.lineSeparator());
		if(goodsList == null) {
			writer.append("ListOfGoddsPO is null");
			writer.close();
			return;
		}
		for(int j = 0; j < goodsList.get_NameOfGoods().length ; j++) {
			String[] goodsNumbering = goodsList.get_numbering();
			String[] nameOfGoods = goodsList.get_NameOfGoods();
			String[] goodsType = goodsList.get_type();
			int[] goodsNum = goodsList.get_num();
			double[] unitPrice = goodsList.get_unit_price();
			double[] goodsTotal = goodsList.get_total();
			String[] goodsRemark = goodsList.get_remark();
			
			writer.append(goodsNumbering[j] + "\t\t" + nameOfGoods[j] + "\t\t" + goodsType[j] + "\t\t" +
					goodsNum[j] + "\t\t" + unitPrice[j] + "\t\t" + goodsTotal[j] + "\t\t" + goodsRemark[j] +
					System.lineSeparator());
		}
	}
}
