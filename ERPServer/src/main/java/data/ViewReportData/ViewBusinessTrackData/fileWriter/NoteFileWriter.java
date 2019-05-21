package data.ViewReportData.ViewBusinessTrackData.fileWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

import po.popublic.NotePO;

public abstract class NoteFileWriter {
	//时间
	protected String time;
	//输出文件夹路径
	protected String fileFolderPath;
	
	protected File file;
	
	public NoteFileWriter(String time, String fileFolderPath, String noteType) {
		this.time = time;
		this.fileFolderPath = fileFolderPath;
		
		file = new File(fileFolderPath + File.separator + time + "_" + noteType + ".txt");
	}
	
	abstract public void write(List<NotePO> noteList) throws IOException;
}
