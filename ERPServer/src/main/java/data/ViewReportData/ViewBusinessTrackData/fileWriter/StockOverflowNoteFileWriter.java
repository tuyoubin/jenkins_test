package data.ViewReportData.ViewBusinessTrackData.fileWriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import po.popublic.NotePO;
import po.postock.StockOverflowNotePO;

/**
 * 库存报溢单导出模块
 * @author CharlieLei
 *
 */
public class StockOverflowNoteFileWriter extends NoteFileWriter {

	public StockOverflowNoteFileWriter(String time, String fileFolderPath) {
		super(time, fileFolderPath, "库存报溢单");
	}

	@Override
	public void write(List<NotePO> noteList) throws IOException {
		if(noteList == null) return;
		
		file.createNewFile();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
		
		StockOverflowNotePO tempStockOverflowNote = null;
		for(int i = 0; i < noteList.size(); i++) {
			tempStockOverflowNote = (StockOverflowNotePO) noteList.get(i);
			
			String noteNumber = tempStockOverflowNote.getNoteNumber();            
			String userID = tempStockOverflowNote.getUserID();
			int goodsListItemNum = tempStockOverflowNote.getGoodsListItemNum();
			String[] goodsIDList = tempStockOverflowNote.getGoodsIDList();
			String[] goodsNameList = tempStockOverflowNote.getGoodsNameList();
			int[] stockAmounts = tempStockOverflowNote.getStockAmounts();
			int[] realAmounts = tempStockOverflowNote.getRealAmounts();
			
			
			writer.append("单据编号" + "\t\t" + noteNumber + System.lineSeparator());
			writer.append("操作员" + "\t\t" + userID + System.lineSeparator());
			
			writer.append(System.lineSeparator());
			writer.append("商品编号" + "\t\t" + "商品名称" + "\t\t" + "系统库存数量" +
			             "\t\t" + "实际数量" + System.lineSeparator());
			for(int j = 0; j < goodsListItemNum; j++) {
				writer.append(goodsIDList[j] + "\t\t" + goodsNameList[j] + "\t\t" + 
						stockAmounts[j] + "\t\t" + realAmounts[j] + System.lineSeparator());
			}
			writer.append(System.lineSeparator());
			
			writer.append(System.lineSeparator());
		}
		writer.close();
	}

}
