package data.ViewReportData.ViewBusinessTrackData;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.ViewReportData.ViewBusinessTrackData.fileWriter.*;
import data.utility.DataStringHelper;
import dataservice.ViewReportDataService.ViewBusinessTrackDataService;
import po.popublic.NotePO;

/**
 * 单据导出模块列表的下标
 * @author CharlieLei
 *
 */
enum FileWriterIndex{
	SaleList, SaleReturnList, PurchaseNote, PurchaseReturnNote, 
	DebitNote, CreditNote, CashBill, 
	StockGiftNote, StockLossNote, StockOverflowNote;
	
	public static int getIndex(String noteType) {
		FileWriterIndex[] arr = FileWriterIndex.values();
		for(FileWriterIndex e : arr) {
			if(e.toString().equals(noteType))
				return e.ordinal();
		}
		return -1;
	}
}

/**
 * 查看经营历程表DATA
 * @author CharlieLei
 *
 */
public class ViewBusinessTrackDataImpl implements ViewBusinessTrackDataService {

	private File file;
	
	private static final String fileFolderName = "报表" + File.separator + "经营历程表";	
	private String time;
	private String fileFolderPath;
	
	private List<NoteFileWriter> fileWriterList;
	
	public ViewBusinessTrackDataImpl() {
		time = DataStringHelper.getCurrentTime();
		fileFolderPath = fileFolderName + File.separator + time + "_经营历程表";
		file = new File(fileFolderPath);
		
		fileWriterList = new ArrayList<NoteFileWriter>();
		fileWriterList.add(FileWriterIndex.SaleList.ordinal(), new SaleListFileWriter(time, fileFolderPath));
		fileWriterList.add(FileWriterIndex.SaleReturnList.ordinal(), new SaleReturnListFileWriter(time, fileFolderPath));
		fileWriterList.add(FileWriterIndex.PurchaseNote.ordinal(), new PurchaseNoteFileWriter(time, fileFolderPath));
		fileWriterList.add(FileWriterIndex.PurchaseReturnNote.ordinal(), new PurchaseReturnNoteFileWriter(time, fileFolderPath));
		fileWriterList.add(FileWriterIndex.DebitNote.ordinal(), new DebitNoteFileWriter(time, fileFolderPath));
		fileWriterList.add(FileWriterIndex.CreditNote.ordinal(), new CreditNoteFileWriter(time, fileFolderPath));
		fileWriterList.add(FileWriterIndex.CashBill.ordinal(), new CashBillFileWriter(time, fileFolderPath));
		fileWriterList.add(FileWriterIndex.StockGiftNote.ordinal(), new StockGiftNoteFileWriter(time, fileFolderPath));
		fileWriterList.add(FileWriterIndex.StockLossNote.ordinal(), new StockLossNoteFileWriter(time, fileFolderPath));
		fileWriterList.add(FileWriterIndex.StockOverflowNote.ordinal(), new StockOverflowNoteFileWriter(time, fileFolderPath));
	}

	@Override
	public boolean exportBusinessTrack(List<List<NotePO>> allNoteList) throws RemoteException {	
		try {
			file.mkdir();
			
			String noteType = null;
			List<NotePO> tempNoteList = null;
			int noteFileWriterIndex = -1;
			for(int i = 0; i < allNoteList.size(); i++) {
				tempNoteList = allNoteList.get(i);
				
				if(tempNoteList == null || tempNoteList.size() == 0) continue;
				else noteType = tempNoteList.get(0).getNoteType();
				
				noteFileWriterIndex = FileWriterIndex.getIndex(noteType);
				
				if(noteFileWriterIndex == -1) return false;
				else fileWriterList.get(noteFileWriterIndex).write(tempNoteList);
			}
			
			return true;
		} catch (IOException e) {
			System.out.println("ViewBusinessTrackData_IOException");
			e.printStackTrace();
		}
		
		return false;
	}
}
