package data.ViewReportData.ViewSaleDetailData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;
import java.util.List;

import data.utility.DataStringHelper;
import dataservice.ViewReportDataService.ViewSaleDetailDataService;
import po.potreasurer.SaleDetailItemPO;

/**
 * 查看销售明细表
 * @author CharlieLei
 *
 */
public class ViewSaleDetailDataImpl implements ViewSaleDetailDataService {

	private File file;
	private BufferedWriter writer;
	private static final String fileFolderName = "报表" + File.separator + "销售明细表";
	
	public ViewSaleDetailDataImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean exportSaleDetail(List<SaleDetailItemPO> saleDetailItemPOList) throws RemoteException {
		SaleDetailItemPO tempSaleDetailItem = null;
		String fileName = DataStringHelper.getCurrentTime() + "_销售明细表";
		file = new File(fileFolderName + File.separator + fileName + ".txt");
		
		try {
			file.createNewFile();
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			
			writer.append(fileName + System.lineSeparator() + System.lineSeparator());
			
			//输出商品信息
			for(int i = 0; i < saleDetailItemPOList.size(); i++) {
				tempSaleDetailItem = saleDetailItemPOList.get(i);
				
				writer.append("时间" + "\t\t" + 
						tempSaleDetailItem.getTime() + System.lineSeparator());	
				writer.append("商品名" + "\t" + 
						tempSaleDetailItem.getGoodsName() + System.lineSeparator());
				writer.append("型号" + "\t\t" + 
						tempSaleDetailItem.getTypeName() + System.lineSeparator());
				writer.append("数量" + "\t\t" + 
						tempSaleDetailItem.getAmount() + System.lineSeparator());
				writer.append("单价" + "\t\t" + 
						tempSaleDetailItem.getUnitPrice() + System.lineSeparator());
				writer.append("总额" + "\t\t" + 
						tempSaleDetailItem.getTotalPrice() + System.lineSeparator());
				
				writer.append(System.lineSeparator());
			}
			
			writer.close();
			return true;
		} catch (IOException e) {
			System.out.println("ViewSaleDetailData_IOException");
			e.printStackTrace();
		}
		
		return false;
	}

}
