package data.GoodsData;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.utility.DataBaseHelper;
import dataservice.GoodsDataService.GoodsDataService;
import po.postock.GoodsPO;

public class GoodsDataImpl implements GoodsDataService{
			
	//数据库名称
	private static String dataBaseName = "stock";
	
	// 获取数据库连接
	private Connection conn;
	
		
	public GoodsDataImpl() {
		conn = DataBaseHelper.getDataBaseConnection(dataBaseName);
	}
	
	@Override
	public boolean newGoods(GoodsPO Goods) throws RemoteException {
		
		String ID = Goods.getID();
		String name = Goods.getName();
		String type = Goods.getType();			  
		int amount = Goods.getAmount();
		double purchasePrice = Goods.getPurchasePrice();
		double recentPurchasePrice = Goods.getRecentPurchasePrice();
		double salePrice = Goods.getSalePrice();
		double recentSalePrice = Goods.getRecentSalePrice();
		int warningValue = Goods.getWarningValue();
		String classID = Goods.getClassID();
		
		try {
			// 构建sql语句
			String sql = "insert into goods "+"values(?,?,?,?,?,?,?,?,?,?)";
			// 设置预处理语句
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ID);
			stmt.setString(2, name);
			stmt.setString(3, type);
			stmt.setInt(4, amount);
			stmt.setDouble(5, purchasePrice);
			stmt.setDouble(6, recentPurchasePrice);
			stmt.setDouble(7, salePrice);
			stmt.setDouble(8, recentSalePrice);
			stmt.setInt(9, warningValue);
			stmt.setString(10, classID);
						
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("创建商品成功");
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("GoodsData_SQLException");
			e.printStackTrace();
		}
		return false;
		
		

	}

	@Override
	public boolean modifyGoods(GoodsPO Goods) throws RemoteException {
		String ID = Goods.getID();
		String name = Goods.getName();						
		String type = Goods.getType();			  
		int amount = Goods.getAmount();
		double purchasePrice = Goods.getPurchasePrice();
		double recentPurchasePrice = Goods.getRecentPurchasePrice();
		double salePrice = Goods.getSalePrice();
		double recentSalePrice = Goods.getRecentSalePrice();
		
		try {
			// 构建sql语句
			String sql = "update goods set name = ?, type = ?, amount = ?,"
					+ " purchase_price = ?, recent_purchase_price = ?,"
					+ " sale_price = ?, recent_sale_price = ?"
					+ " where id = ?";
			// 设置预处理语句
			PreparedStatement stmt = conn.prepareStatement(sql);			
			stmt.setString(1, name);
			stmt.setString(2, type);
			stmt.setInt(3, amount);
			stmt.setDouble(4, purchasePrice);
			stmt.setDouble(5, recentPurchasePrice);
			stmt.setDouble(6, salePrice);
			stmt.setDouble(7, recentSalePrice);
			stmt.setString(8, ID);	
			
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("修改商品成功");
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("GoodsData_SQLException");
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean deleteGoods(String GoodsID) throws RemoteException {

		try {
			// 构建sql语句
			String sql = "delete from goods where id = ?";
			// 设置预处理语句
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, GoodsID);
						
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("删除商品成功");
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("GoodsData_SQLException");
			e.printStackTrace();
		}
		return false;
		

	}


	@Override
	public List<GoodsPO> getAllGoods() throws RemoteException {
		List<GoodsPO> list = new ArrayList<GoodsPO>();

		try {
			// 构建sql语句
			String sql = "select * from goods";
			// 设置预处理语句						
			PreparedStatement stmt = conn.prepareStatement(sql);
			// 获取结果集（查询数据库）
			ResultSet res = stmt.executeQuery();
			
			while(res.next()){
				String ID = res.getString("id");
				String name = res.getString("name");
				String type = res.getString("type");				  
				int amount = res.getInt("amount");
				double purchasePrice = res.getDouble("purchase_price");
				double recentPurchasePrice = res.getDouble("recent_purchase_price");
				double salePrice = res.getDouble("sale_price");
				double recentSalePrice = res.getDouble("recent_sale_price");
				int warningValue = res.getInt("warning_value");
				String classID = res.getString("class_id");
												 				
				GoodsPO goods = new GoodsPO(ID, name, type, amount, purchasePrice,
						recentPurchasePrice, salePrice,  recentSalePrice, warningValue, classID);				
				list.add(goods);
			}
									
		} catch (SQLException e) {
			System.out.println("GoodsData_SQLException");
			e.printStackTrace();
		}
						
		return list;
	}

	@Override
	public boolean setStockWarningValue(String ID, int warningValue) throws RemoteException {
		
		try {
			// 构建sql语句
			String sql = "update goods set warning_value = ? where id = ?";
			// 设置预处理语句
			PreparedStatement stmt = conn.prepareStatement(sql);			
			
			stmt.setInt(1, warningValue);
			stmt.setString(2, ID);
			
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("设定商品报警数量成功");
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("GoodsData_SQLException");
			e.printStackTrace();
		}
		return false;
	}


	
	
}
