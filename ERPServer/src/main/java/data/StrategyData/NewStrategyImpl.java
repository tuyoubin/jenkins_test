package data.StrategyData;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.utility.DataBaseHelper;
import dataservice.StrategyDataService.NewStrategyService;

import po.poMangaer.*;


public class NewStrategyImpl implements NewStrategyService{

	//数据库名称
	private static String dataBaseName = "Manager";
	
	// 获取数据库连接
	private Connection conn;
	
	public NewStrategyImpl(){
		conn = DataBaseHelper.getDataBaseConnection(dataBaseName);
	}
	@Override
	//新建策略
	public boolean newFStrategy(StrategyFPO Strategy) throws RemoteException {
		// TODO Auto-generated method stub
		try{
			String sql = "insert into StrategyF values(?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, Strategy.getID());
			stmt.setString(2, Strategy.getType());
			stmt.setString(3, Strategy.getFDate());
			stmt.setString(4, Strategy.getEDate());
			stmt.setString(5, Strategy.getlevel());
			stmt.setDouble(6, Strategy.getdiscount());
			stmt.setString(7, Strategy.getgive());
			stmt.setInt(8, Strategy.getcoupon());
			
			stmt.executeUpdate();
			stmt.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean newSStrategy(StrategySPO Strategy) throws RemoteException {
		// TODO Auto-generated method stub
		try{
			String sql = "insert into StrategyS values(?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, Strategy.getID());
			stmt.setString(2, Strategy.gettype());
			stmt.setString(3, Strategy.getFDate());
			stmt.setString(4, Strategy.getEDate());
			String pack = "";
			for(int i = 0;i < Strategy.getpack().size();i++){
				pack = pack + Strategy.getpack().get(i);
				if(i < Strategy.getpack().size() - 1)
					pack = pack + "-";
			}
			stmt.setString(5, pack);
			stmt.setDouble(6, Strategy.getprice());
			
			stmt.executeUpdate();
			stmt.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean newTStrategy(StrategyTPO Strategy) throws RemoteException {
		// TODO Auto-generated method stub

		try{
			String sql = "insert into StrategyT values(?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, Strategy.getID());
			stmt.setString(2, Strategy.gettype());
			stmt.setString(3, Strategy.getFDate());
			stmt.setString(4, Strategy.getEDate());
			stmt.setInt(5, Strategy.getdprice());
			stmt.setInt(6, Strategy.getGprice());
			stmt.setDouble(7, Strategy.getdiscount());
			stmt.setString(8, Strategy.getgive());
			
			stmt.executeUpdate();
			stmt.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

}
