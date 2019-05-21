package data.noteSQLModule.noteSQLDeleter;

import java.sql.Connection;

import data.utility.DataBaseHelper;
import po.popublic.NotePO;

public abstract class NoteSQLDeleter {

	//数据库名称
	protected String dataBaseName;
	
	// 获取数据库连接
	protected Connection connection;
	
	public NoteSQLDeleter(String dataBaseName){
		this.dataBaseName = dataBaseName;
		connection = DataBaseHelper.getDataBaseConnection(dataBaseName);
	}
	
	abstract public boolean delete(NotePO notePO);
	
}
