package data.ViewReportData.ViewBusinessTrackData.fileWriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import po.popublic.NotePO;
import po.postock.StockLossNotePO;

/**
 * 库存报损单导出模块
 * @author CharlieLei
 *
 */
public class StockLossNoteFileWriter extends NoteFileWriter {

	public StockLossNoteFileWriter(String time, String fileFolderPath) {
		super(time, fileFolderPath, "库存报损单");
	}

	@Override
	public void write(List<NotePO> noteList) throws IOException {
		if(noteList == null) return;
		
		file.createNewFile();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
		
		StockLossNotePO tempStockLossNote = null;
		for(int i = 0; i < noteList.size(); i++) {
			tempStockLossNote = (StockLossNotePO) noteList.get(i);
			
			String noteNumber = tempStockLossNote.getNoteNumber();            
			String userID = tempStockLossNote.getUserID();
			int goodsListItemNum = tempStockLossNote.getGoodsListItemNum();
			String[] goodsIDList = tempStockLossNote.getGoodsIDList();
			String[] goodsNameList = tempStockLossNote.getGoodsNameList();
			int[] stockAmounts = tempStockLossNote.getStockAmounts();
			int[] realAmounts = tempStockLossNote.getRealAmounts();
			
			
			writer.append("单据编号" + "\t\t" + noteNumber + System.lineSeparator());
			writer.append("操作员" + "\t\t" + userID + System.lineSeparator());
			
			writer.append(System.lineSeparator());
			writer.append("商品编号" + "\t\t" + "商品名称" + "\t\t" +
			        "系统库存数量" + "\t\t" + "实际数量" + System.lineSeparator());
			for(int j = 0 ; j < goodsListItemNum; j++) {
				writer.append(goodsIDList[j] + "\t\t" + goodsNameList[j] + "\t\t" + 
						stockAmounts[j] + "\t\t" + realAmounts[j] + System.lineSeparator());
			}
			writer.append(System.lineSeparator());
			
			writer.append(System.lineSeparator());
		}
		writer.close();
	}

}
