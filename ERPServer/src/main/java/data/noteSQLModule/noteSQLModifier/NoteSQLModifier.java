package data.noteSQLModule.noteSQLModifier;

import java.sql.Connection;

import data.utility.DataBaseHelper;
import po.popublic.NotePO;

public abstract class NoteSQLModifier {

	//数据库名称
	protected String dataBaseName;
	
	// 获取数据库连接
	protected Connection connection;
	
	public NoteSQLModifier(String dataBaseName){
		this.dataBaseName = dataBaseName;
		connection = DataBaseHelper.getDataBaseConnection(dataBaseName);
	}
	
	/**
	 * 根据单据编号修改单据
	 * @param noteNewState 单据的新状态
	 * @return 是否成功修改
	 */
	abstract public boolean modifyNote(NotePO noteNewState);
}
