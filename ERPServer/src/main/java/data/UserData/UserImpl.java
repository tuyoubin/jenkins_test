package data.UserData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.utility.DataBaseHelper;
import dataservice.UserDataService.UserService;
import po.poUser.UserPO;

public class UserImpl implements UserService{

	//数据库名称
	private static String dataBaseName = "admin";
	
	// 获取数据库连接
	private Connection conn;
	
	public UserImpl(){
		conn = DataBaseHelper.getDataBaseConnection(dataBaseName);
	}
	
	@Override
	public boolean newUser(UserPO User) throws RemoteException {
		//新建用户
		// TODO Auto-generated method stub
		String ID = User.getID();
		String PassWord = User.getPassWord();
		String Position = User.getposition();
		String Potence = User.getPotence();
		try{
			String sql = "insert into User " + "values(?,?,?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, ID);
			stmt.setString(2, PassWord);
			stmt.setString(3, Position);
			stmt.setString(4, Potence);
			
			stmt.executeUpdate();
			stmt.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUser(String ID) throws RemoteException {
		//删除用户
		// TODO Auto-generated method stub
		try{
			String sql = "delete from user where id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, ID);
			
			stmt.executeUpdate();
			stmt.close();
			
			return true;
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<UserPO> getAllUser() throws RemoteException {
		// TODO Auto-generated method stub
		// 用户名_密码    没有返回null
		
		ArrayList<UserPO> AllUser = new ArrayList<UserPO>();
		
		try{
			String sql = "select * from User";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet res = stmt.executeQuery();
			
			while(res.next()){
				String ID = res.getString("ID");
				String PassWord = res.getString("PassWord");
				String Position = res.getString("Position");
				String Potence = res.getString("Potence");
				UserPO a = new UserPO(ID,PassWord,Position,Potence);
				AllUser.add(a);
			}
			stmt.close();
			return AllUser;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UserPO Login(String ID, String PassWord) throws RemoteException {
		//登陆      
		// TODO Auto-generated method stub
		try{
			UserPO a = null;
			String sql = "select * from User";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			while(res.next()){
				if((res.getString("ID").equals(ID))&(res.getString("PassWord").equals(PassWord))){
					a = new UserPO(ID,PassWord,res.getString("Position"),res.getString("Potence"));
					break;
				}
			}
			stmt.close();
			return a;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

}
