package data.LogData;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.utility.DataBaseHelper;
import data.utility.SQLAttributeIndex;
import dataservice.LogDataService.LogDataService;
import po.poLog.LogPO;

/**
 * 日志DATA
 * @author CharlieLei
 *
 */
public class LogDataImpl implements LogDataService {

	//数据库名称
	private static final String adminDataBaseName = "admin";
	//数据库列表
	//date, activity
	
	private Connection connection;
	
	
	public LogDataImpl() {
		connection = DataBaseHelper.getDataBaseConnection(adminDataBaseName);
	}

	@Override
	public boolean addLog(String date, String activity) throws RemoteException {
		if(date == null && activity == null) return false;
		
		try {
			String sql = "insert into log values(?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(SQLAttributeIndex.Log_Date.index(), date);
			stmt.setString(SQLAttributeIndex.Log_Activity.index(), activity);
			
			System.out.println(stmt.toString());
			
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("日志增加成功");
			stmt.close();
			return true;
		}catch(SQLException e) {
			System.out.println("LogData_SQLException");
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public LogPO getLogOfERP() throws RemoteException {
		List<String> logInfo = new ArrayList<String>();
		
		try {
			String sql = "select * from log";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			
			String date = null;
			String activity = null;
			while(res.next()) {
				date = res.getString("date");
				activity = res.getString("activity");
				logInfo.add(date + " " + activity);
			}
		}catch(SQLException e) {
			System.out.println("LogData_SQLException");
			e.printStackTrace();	
		}
		
		return new LogPO(logInfo);
	}
}
