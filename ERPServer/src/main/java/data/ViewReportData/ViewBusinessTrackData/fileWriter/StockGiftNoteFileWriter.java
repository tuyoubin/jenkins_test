package data.ViewReportData.ViewBusinessTrackData.fileWriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import po.popublic.NotePO;
import po.postock.StockGiftNotePO;

/**
 * 库存赠送单导出模块
 * @author CharlieLei
 *
 */
public class StockGiftNoteFileWriter extends NoteFileWriter {

	public StockGiftNoteFileWriter(String time, String fileFolderPath) {
		super(time, fileFolderPath, "库存赠送单");
	}

	@Override
	public void write(List<NotePO> noteList) throws IOException {
		if(noteList == null) return;
		
		file.createNewFile();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
		
		StockGiftNotePO tempStockGiftNote = null;
		for(int i = 0; i < noteList.size(); i++) {
			tempStockGiftNote = (StockGiftNotePO) noteList.get(i);
			
			String noteNumber = tempStockGiftNote.getNoteNumber();
			String userID = tempStockGiftNote.getUserID();
			int goodsListItemNum = tempStockGiftNote.getGoodsListItemNum();
			String[] goodsIDList = tempStockGiftNote.getGoodsIDList();
			String[] goodsNameList = tempStockGiftNote.getGoodsNameList();
			String[] typeList = tempStockGiftNote.getTypeList();
			int[] amounts = tempStockGiftNote.getAmounts();
			
			writer.append("单据编号" + "\t\t" + noteNumber + System.lineSeparator());
			writer.append("操作员" + "\t\t" + userID + System.lineSeparator());
			
			writer.append(System.lineSeparator());
			writer.append("商品编号" + "\t\t" + "商品名称" + "\t\t" + 
			"赠品型号" + "\t\t" + "赠送数量" + System.lineSeparator());
			for(int j = 0; j < goodsListItemNum; j++) {
				writer.append(goodsIDList[j] + "\t\t" + goodsNameList[j] + "\t\t" + 
			typeList[j] + "\t\t" + amounts[j] + System.lineSeparator());
			}
			writer.append(System.lineSeparator());
			
			writer.append(System.lineSeparator());
		}
		writer.close();

	}

}
