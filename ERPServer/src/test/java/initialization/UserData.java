package initialization;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import data.UserData.UserImpl;
import data.utility.DataBaseHelper;
import po.poUser.UserPO;

public class UserData {
	//数据库名称
	private static String dataBaseName = "admin";
	
	// 获取数据库连接
	private Connection conn;
	
	public UserData(){
		conn = DataBaseHelper.getDataBaseConnection(dataBaseName);
	}
	
	public void insert(){
		try{
			String sql = "delete from User";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.executeUpdate();
			
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try{
			String sql = "delete from admin";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.executeUpdate();
			
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		ArrayList<UserPO> userlist = new ArrayList<UserPO>();
		userlist.add(new UserPO("库存管理人员", "123456", "Stock", "1"));
		userlist.add(new UserPO("销售管理人员", "123456", "Salesman", "1"));
		userlist.add(new UserPO("财务人员1", "123456", "Treasurer", "1"));
		userlist.add(new UserPO("财务人员2", "123456", "Treasurer", "2"));
		userlist.add(new UserPO("总经理", "123456", "Manager", "1"));
		
		UserImpl user = new UserImpl();
		
		for(int i = 0;i < userlist.size();i++)
			try {
				user.newUser(userlist.get(i));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try{
			String sql = "insert into admin " + "values(?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, "admin");
			stmt.setString(2, "123456");
			
			stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
