package data.UserData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.utility.DataBaseHelper;

import java.rmi.RemoteException;

import dataservice.UserDataService.AdminisDataService;
import po.poUser.AdministratorPO;

public class AdministratorDataImpl implements AdminisDataService{

	//数据库名称
	private static String dataBaseName = "admin";
	
	// 获取数据库连接
	private Connection conn;
	
	public AdministratorDataImpl (){
		conn = DataBaseHelper.getDataBaseConnection(dataBaseName);
	}
	@Override
	public AdministratorPO getADPO() throws RemoteException {
		//获取管理员数据
		// TODO Auto-generated method stub
		try{
			String sql = "select * from Admin;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			AdministratorPO re =null;
			while(res.next()){
				String ID = res.getString("ID");
				String PassWord = res.getString("PassWord");
				re = new AdministratorPO(ID,PassWord);
				
			}
				return re;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean reviseAD(AdministratorPO ADPO) throws RemoteException {
		//更改信息
		// TODO Auto-generated method stub
		try{
			String sql = "update Admin set ID = ?,PassWord = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ADPO.getID());
			stmt.setString(2,ADPO.getPassWord());
			stmt.executeUpdate();
			stmt.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean AdminLogin(String ID, String PassWord) throws RemoteException {
		//登陆
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			String sql = "select * from Admin";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			while(res.next()){
				if((ID.equals(res.getString("ID")))&&(PassWord.equals(res.getString("PassWord"))))
					result = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

}
