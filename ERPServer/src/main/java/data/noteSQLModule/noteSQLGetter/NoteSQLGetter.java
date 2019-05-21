package data.noteSQLModule.noteSQLGetter;

import java.sql.Connection;
import java.util.List;

import data.utility.DataBaseHelper;
import po.popublic.NotePO;

public abstract class NoteSQLGetter {

	//数据库名称
	protected String dataBaseName;
	
	// 获取数据库连接
	protected Connection connection;
	
	public NoteSQLGetter(String dataBaseName){
		this.dataBaseName = dataBaseName;
		connection = DataBaseHelper.getDataBaseConnection(dataBaseName);
	}
	
	abstract public List<NotePO> getNoteList();
	
}
