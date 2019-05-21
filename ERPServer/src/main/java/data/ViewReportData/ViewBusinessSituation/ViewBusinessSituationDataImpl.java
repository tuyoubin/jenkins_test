package data.ViewReportData.ViewBusinessSituation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;

import data.utility.DataStringHelper;
import dataservice.ViewReportDataService.ViewBusinessSituationDataService;
import po.poMangaer.BusinessSituationPO;

public class ViewBusinessSituationDataImpl implements ViewBusinessSituationDataService {

	private File file;
	private BufferedWriter writer;
	private static final String fileFolderName = "报表" + File.separator + "经营情况表";
	
	public ViewBusinessSituationDataImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean exportBS(BusinessSituationPO BusinessSituation) throws RemoteException {
		if(BusinessSituation == null) return false;
		
		String fileName = DataStringHelper.getCurrentTime() + "_经营情况表";
		file = new File(fileFolderName + File.separator + fileName + ".txt");
		
		try {
			file.createNewFile();
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			
			writer.append(fileName + System.lineSeparator() + System.lineSeparator());
			
			//输出商品信息
			writer.append("时间" + System.lineSeparator());
			writer.append(BusinessSituation.getFDate() + "-" + BusinessSituation.getEDate() + System.lineSeparator());
			writer.append("销售收入：" + "\t\t" + BusinessSituation.getShou() + System.lineSeparator());
			writer.append("商品收入：" + "\t\t" + BusinessSituation.getDuo() + System.lineSeparator());
			writer.append("销售成本：" + "\t\t" + BusinessSituation.getChen() + System.lineSeparator());
			writer.append("商品支出：" + "\t\t" + BusinessSituation.getShao() + System.lineSeparator());
			writer.append("总利润：" + "\t\t" + BusinessSituation.getLi() + System.lineSeparator());
			
			writer.close();
			return true;
		} catch (IOException e) {
			System.out.println("ViewSaleDetailData_IOException");
			e.printStackTrace();
		}
		
		return false;
	}

}
