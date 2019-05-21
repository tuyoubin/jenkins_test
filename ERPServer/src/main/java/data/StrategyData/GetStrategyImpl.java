package data.StrategyData;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.utility.DataBaseHelper;
import dataservice.StrategyDataService.GetStrategyService;
import po.poMangaer.StrategyFPO;
import po.poMangaer.StrategyPO;
import po.poMangaer.StrategySPO;
import po.poMangaer.StrategyTPO;

public class GetStrategyImpl implements GetStrategyService{

	//数据库名称
	private static String dataBaseName = "Manager";
	
	// 获取数据库连接
	private Connection conn;
	
	public GetStrategyImpl(){
		conn = DataBaseHelper.getDataBaseConnection(dataBaseName);
	}
	
	@Override
	public ArrayList<String> getAllStrategy() throws RemoteException {
		// TODO Auto-generated method stub
		//策略名_起始时间_终止时间
		//返回null到界面
		ArrayList<String> Result = new ArrayList<String>();
		try{
			String sql = "select * from StrategyF";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet res = stmt.executeQuery();
			
			while(res.next()){
				String s = res.getString("ID") + "_" + res.getString("FDate") + "_" + res.getString("EDate");
				Result.add(s);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			String sql = "select * from StrategyS";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet res = stmt.executeQuery();
			
			while(res.next()){
				String s = res.getString("ID") + "_" + res.getString("FDate") + "_" + res.getString("EDate");
				Result.add(s);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			String sql = "select * from StrategyT";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet res = stmt.executeQuery();
			
			while(res.next()){
				String s = res.getString("ID") + "_" + res.getString("FDate") + "_" + res.getString("EDate");
				Result.add(s);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return Result;
	}

	@Override
	public StrategyPO getStrategy(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		//策略一三赠品为    编号
		//策略二赠品为      商品编号_进价_售价_数量
		//返回null到界面
		StrategyPO Result = null;
		try{
			String sql = "select * from StrategyF where ID = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ID);
			
			ResultSet res = stmt.executeQuery();
			while(res.next()){
				String Type = res.getString("Type");
				String FDate = res.getString("FDate");
				String EDate = res.getString("EDate");
				String Level = res.getString("Level");
				double Discount  = res.getDouble("Discount");
				String Give = res.getString("Give");
				int Coupon = res.getInt("Coupon");
				Result = new StrategyFPO(ID,Type,FDate,EDate,Level,Discount,Give,Coupon);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try{
			String sql = "select * from StrategyS where ID = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ID);
			
			ResultSet res = stmt.executeQuery();
			while(res.next()){
				String Type = res.getString("Type");
				String FDate = res.getString("FDate");
				String EDate = res.getString("EDate");
				String pack = res.getString("Pack");
				String[] a = pack.split("-");
				ArrayList<String> Pack = new ArrayList<String>();
				for(int i = 0;i < a.length;i++)
					Pack.add(a[i]);
				double Price = res.getDouble("Price");
				Result = new StrategySPO(ID,Type,FDate,EDate,Pack,Price);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try{
			String sql = "select * from StrategyT where ID = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ID);
			
			ResultSet res = stmt.executeQuery();
			while(res.next()){
				String Type = res.getString("Type");
				String FDate = res.getString("FDate");
				String EDate = res.getString("EDate");
				int DPrice = res.getInt("DPrice");
				int GPrice = res.getInt("GPrice");
				String Give = res.getString("Give");
				double Discount = res.getDouble("Discount");
				Result = new StrategyTPO(ID,Type,FDate,EDate,DPrice,GPrice,Discount,Give);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return Result;
	}

	@Override
	public boolean deleteStrategy(String ID) throws RemoteException {
		//删除策略
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			String sql = "delete from StrategyF where ID = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ID);
			
			stmt.executeUpdate();
			stmt.close();
			result = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try{
			String sql = "delete from StrategyS where ID = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ID);
			
			stmt.executeUpdate();
			stmt.close();
			result = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try{
			String sql = "delete from StrategyT where ID = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ID);
			
			stmt.executeUpdate();
			stmt.close();
			result = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}

}
