package initialization;

import java.sql.PreparedStatement;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import data.StrategyData.NewStrategyImpl;
import data.utility.DataBaseHelper;
import po.poMangaer.StrategyFPO;
import po.poMangaer.StrategySPO;
import po.poMangaer.StrategyTPO;

public class StrategyData {

	//数据库名称
	private static String dataBaseName = "Manager";
	
	// 获取数据库连接
	private Connection conn;
	
	public StrategyData(){
		conn = DataBaseHelper.getDataBaseConnection(dataBaseName);
	}
	
	public void insert(){
		StrategyFPO StrategyF = new StrategyFPO("F2018-1-1-0-0-0","Strategy One","20180101","20190101","1",0.9,"00020001",10);
		ArrayList<String> pack = new ArrayList<String>();
		pack.add("00020001_50_100_1");
		StrategySPO StrategyS = new StrategySPO("S2018-1-2-0-0-0","Strategy Two","20180101","20190101",pack,90);
		StrategyTPO StrategyT = new StrategyTPO("T2018-1-3-0-0-0","Strategy There","20180101","20190101",100,200,0.9,"00020001");

		try{
			String sql = "delete from StrategyF";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.executeUpdate();
			
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try{
			String sql = "delete from StrategyS";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.executeUpdate();
			
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try{
			String sql = "delete from StrategyT";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.executeUpdate();
			
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		NewStrategyImpl S = new NewStrategyImpl();
		
		try {
			S.newFStrategy(StrategyF);
			S.newSStrategy(StrategyS);
			S.newTStrategy(StrategyT);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
