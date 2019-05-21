package data.GoodsClassData;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import data.utility.DataBaseHelper;
import data.utility.DataStringHelper;
import dataservice.GoodsClassDataService.GoodsClassDataService;
import po.postock.GoodsClassPO;

public class GoodsClassDataImpl implements GoodsClassDataService{
	
	//数据库名称
	private static String dataBaseName = "stock";
	
	// 获取数据库连接
	private Connection conn;
	
		
	public GoodsClassDataImpl(){
		conn = DataBaseHelper.getDataBaseConnection(dataBaseName);
	}
	
	@Override
	public List<GoodsClassPO> getAllGoodsClass() throws RemoteException {	
		List<GoodsClassPO> list = new ArrayList<GoodsClassPO>();
		
		try {
			// 构建sql语句
			String sql = "select * from goods_class";
			// 设置预处理语句
			PreparedStatement stmt = conn.prepareStatement(sql);
			// 获取结果集（查询数据库）
			ResultSet res = stmt.executeQuery();
			
			while(res.next()){
				String ID = res.getString("id");
				String name = res.getString("name");
				String parentID = res.getString("parent_id");
				int level = res.getInt("level");
				ArrayList<String> goodsIDList = new ArrayList<String>();
				String infor = res.getString("goods_id_list");
				//若数据库内 goods_id_list项 为null，则返回一个 空的ArrayList（非null）作为 商品分类PO的goodsIDList值
				if(infor != null){
					String[] goods = infor.split(DataStringHelper.getSeparator());
					goodsIDList = new ArrayList<String>(Arrays.asList(goods));
				}
								 				
				GoodsClassPO goodsclass = new GoodsClassPO(ID, name, parentID, level, goodsIDList);				
				list.add(goodsclass);
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("GoodsClassData_SQLException");
			e.printStackTrace();
		}					
		
		return null;
	}


	@Override
	public GoodsClassPO getClassByID(String ClassID) throws RemoteException {
		GoodsClassPO po = null;
		List<GoodsClassPO> goodsClassList = this.getAllGoodsClass();
		for(GoodsClassPO goodsclass : goodsClassList){
			if(ClassID.equals(goodsclass.getID())){
				po = goodsclass;
				break;
			}
		}
		return po;
	}
	
	
	@Override
	public boolean newClass(GoodsClassPO classification) throws RemoteException {
		String ID = classification.getID();
		String name = classification.getName(); 
		String parentID  = classification.getParentID();
		int level = classification.getLevel();
		String goodsInfor = "";
		ArrayList<String> goodsIDList = classification.getGoodsIDList();
		if(goodsIDList == null || goodsIDList.isEmpty())
			goodsInfor = null;
		else{
			for(String goodsID : goodsIDList){
				goodsInfor = goodsInfor + goodsID + DataStringHelper.getSeparator();
			}
		}
						
		try {
			// 构建sql语句
			String sql = "insert into goods_class "+"values(?,?,?,?,?)";
			// 设置预处理语句
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ID);
			stmt.setString(2, name);
			stmt.setString(3, parentID);
			stmt.setInt(4, level);
			stmt.setString(5, goodsInfor);
						
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("创建分类成功");
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("GoodsClassData_SQLException");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modifyClass(GoodsClassPO classification) throws RemoteException {
		String ID = classification.getID();
		String name = classification.getName(); 
		String parentID  = classification.getParentID();
		int level = classification.getLevel();
		String goodsInfor = "";
		ArrayList<String> goodsIDList = classification.getGoodsIDList();
		if(goodsIDList == null || goodsIDList.isEmpty())
			goodsInfor = null;
		else{
			for(String goodsID : goodsIDList){
				goodsInfor = goodsInfor + goodsID + DataStringHelper.getSeparator();
			}
		}
		
		// 检测该商品分类是否在库中存在
		if(this.getClassByID(ID) == null)
			return false;
		else{			

			try {
				// 构建sql语句
				String sql = "update goods_class set name = ?, parent_id = ?, level = ?, goods_id_list = ? where id = ?";
				// 设置预处理语句
				PreparedStatement stmt = conn.prepareStatement(sql);				
				stmt.setString(1, name);
				stmt.setString(2, parentID);
				stmt.setInt(3, level);
				stmt.setString(4, goodsInfor);
				stmt.setString(5, ID);
				
				// 尝试执行（更新数据库）
				stmt.executeUpdate();
				System.out.println("修改分类成功");
				stmt.close();
				return true;
			} catch (SQLException e) {
				System.out.println("GoodsClassData_SQLException");
				e.printStackTrace();
			}
			
		}
		
		
		
		return false;
	}

	@Override
	public boolean deleteClass(String ClassID) throws RemoteException {
		if(this.getClassByID(ClassID) == null)
			return false;
		else{			
		
			try {
				// 构建sql语句
				String sql = "delete from goods_class where id = ?";
				// 设置预处理语句
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, ClassID);				
				
				// 尝试执行（更新数据库）
				stmt.executeUpdate();
				System.out.println("删除分类成功");
				stmt.close();
				return true;
			} catch (SQLException e) {
				System.out.println("GoodsClassData_SQLException");
				e.printStackTrace();
			}
		}
		
		return false;
	}

	
}
