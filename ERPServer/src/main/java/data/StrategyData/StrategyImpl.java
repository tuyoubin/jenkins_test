package data.StrategyData;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.utility.DataBaseHelper;
import dataservice.StrategyDataService.StrategyService;
import po.poMangaer.*;

public class StrategyImpl implements StrategyService{

	//数据库名称
	private static String dataBaseName = "Manager";
	
	// 获取数据库连接
	private Connection conn;
	
	public StrategyImpl(){
		conn = DataBaseHelper.getDataBaseConnection(dataBaseName);
	}
	@Override
	
	//供销售时获取符合时间条件的策略
	public ArrayList<StrategyFPO> getStrategyF(String Time) throws RemoteException {
		// TODO Auto-generated method stub
		try{
			ArrayList<StrategyFPO> Result = new ArrayList<StrategyFPO>();
			String sql = "select * from StrategyF";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			while(res.next()){
				String f = res.getString("FDate");
				String e = res.getString("EDate");
				int FD = Integer.parseInt(f);
				int ED = Integer.parseInt(e);
				int T = Integer.parseInt(Time);
				if((T >= FD)&&(T <= ED)){
					String ID = res.getString("ID");
					String Type = res.getString("Type");
					String FDate = res.getString("FDate");
					String EDate = res.getString("EDate");
					String Level = res.getString("Level");
					double Discount  = res.getDouble("Discount");
					String Give = res.getString("Give");
					int Coupon = res.getInt("Coupon");
					StrategyFPO A = new StrategyFPO(ID,Type,FDate,EDate,Level,Discount,Give,Coupon);
					Result.add(A);
				}
			}
			return Result;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<StrategySPO> getStrategyS(String Time) throws RemoteException {
		// TODO Auto-generated method stub
		try{
			ArrayList<StrategySPO> Result = new ArrayList<StrategySPO>();
			String sql = "select * from StrategyS";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			while(res.next()){
				String f = res.getString("FDate");
				String e = res.getString("EDate");
				int FD = Integer.parseInt(f);
				int ED = Integer.parseInt(e);
				int T = Integer.parseInt(Time);
				if((T >= FD)&&(T <= ED)){
					String ID = res.getString("ID");
					String Type = res.getString("Type");
					String FDate = res.getString("FDate");
					String EDate = res.getString("EDate");
					String pack = res.getString("Pack");
					System.out.println(pack);
					String[] a = pack.split("-");
					
					ArrayList<String> Pack = new ArrayList<String>();
					for(int i = 0;i < a.length;i++)
						Pack.add(a[i]);
					double Price = res.getDouble("Price");
					StrategySPO A = new StrategySPO(ID,Type,FDate,EDate,Pack,Price);
					Result.add(A);
				}
			}
			return Result;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<StrategyTPO> getStrategyT(String Time) throws RemoteException {
		// TODO Auto-generated method stub
		try{
			ArrayList<StrategyTPO> Result = new ArrayList<StrategyTPO>();
			String sql = "select * from StrategyT";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			while(res.next()){
				String f = res.getString("FDate");
				String e = res.getString("EDate");
				int FD = Integer.parseInt(f);
				int ED = Integer.parseInt(e);
				int T = Integer.parseInt(Time);
				if((T >= FD)&&(T <= ED)){
					String ID = res.getString("ID");
					String Type = res.getString("Type");
					String FDate = res.getString("FDate");
					String EDate = res.getString("EDate");
					int DPrice = res.getInt("DPrice");
					int GPrice = res.getInt("GPrice");
					String Give = res.getString("Give");
					double Discount = res.getDouble("Discount");
					StrategyTPO A = new StrategyTPO(ID,Type,FDate,EDate,DPrice,GPrice,Discount,Give);
					Result.add(A);
				}
			}
			return Result;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

}
