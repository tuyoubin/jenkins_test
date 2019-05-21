package data.CompanyAccountData;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.utility.DataBaseHelper;
import data.utility.SQLAttributeIndex;
import dataservice.CompanyAccountDataService.CompanyAccountDataService;
import po.potreasurer.CompanyAccountPO;

/**
 * 账户管理Data
 * @author CharlieLei
 *
 */
public class CompanyAccountDataImpl implements CompanyAccountDataService {

	//数据库名称
	private static final String treasurerDataBaseName = "treasurer";
	//数据库列表
//	private static String accountNameColumn = "account_name";
//	private static String accountBalanceColumn = "account_balance";
	
	private Connection connection;
	
	
	public CompanyAccountDataImpl() {
		connection = DataBaseHelper.getDataBaseConnection(treasurerDataBaseName);
	}
	
	@Override
	public boolean isExist(CompanyAccountPO account) throws RemoteException {
		if(account == null) return false;
		
		try {
			String sql = "select account_name from company_account order by account_name";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			
			while(res.next()) {
				String currentAccountName = res.getString("account_name");
				if(currentAccountName.equals(account.getAccountName())) {
					return true;
				}
			}			
			
		}catch(SQLException e) {
			System.out.println("CompanyAccountData_SQLException");
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean addCompanyAccount(CompanyAccountPO account) throws RemoteException {
		if(account == null) return false;
		
		String accountName = account.getAccountName();
		double accountBalance = account.getAccountBalance();
		
		try {
			String sql = "insert into company_account values(?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(SQLAttributeIndex.CompanyAccount_AccountName.index(), accountName);
			stmt.setDouble(SQLAttributeIndex.CompanyAccount_AccountBalance.index(), accountBalance);
			
			System.out.println(stmt.toString());
			
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("账户增加成功");
			stmt.close();
			return true;
			
		}catch (SQLException e) {
			System.out.println("CompanyAccountData_SQLException");
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteCompanyAccount(CompanyAccountPO account) throws RemoteException {
		if(account == null) return false;
		
		try {
			//构建sql语句
			String sql = "delete from company_account where account_name = ?";
			//设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(SQLAttributeIndex.CompanyAccount_AccountName.index(), account.getAccountName());
			
			//尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("账户删除成功");
			stmt.close();
			return true;
		}catch (SQLException e) {
			System.out.println("CompanyAccountData_SQLException");
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean modifyCompanyAccount(CompanyAccountPO oldAccountState, CompanyAccountPO newAccountState) throws RemoteException {
		if(newAccountState == null) return false;
		
		String oldAccountName = oldAccountState.getAccountName();
		String newAccountName = newAccountState.getAccountName();
		double newAccountBalance = newAccountState.getAccountBalance();
		//账户余额小于0说明不能修改
		if(newAccountBalance < 0) return false;
		
		try {
			// 构建sql语句
			String sql = "update company_account set account_name = ?, account_balance = ? where account_name = ?";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, newAccountName);
			stmt.setDouble(2, newAccountBalance);
			stmt.setString(3, oldAccountName);
			
			// 尝试执行（更新数据库）
			stmt.executeUpdate();
			System.out.println("账户修改成功");
			stmt.close();
			return true;
		}catch(SQLException e) {
			System.out.println("CompanyAccountData_SQLException");
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<CompanyAccountPO> inquiryCompanyAccount(String inquiryInput) throws RemoteException {
		if(inquiryInput == null) return null;
		
		List<CompanyAccountPO> accountPOList = null;
		
		try {
			// 构建sql语句
			String sql = "select * from company_account;";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			// 获取结果集（查询数据库）
			ResultSet res = stmt.executeQuery();
			
			accountPOList = new ArrayList<CompanyAccountPO>();
			while(res.next()) {
				String currentAccountName = res.getString("account_name");
				double currentAccountBalance = res.getDouble("account_balance");
				
				if(currentAccountName != null) {
					if(currentAccountName.contains(inquiryInput)) {
						accountPOList.add(new CompanyAccountPO(currentAccountName, currentAccountBalance));
					}					
				}
			}
		}catch(SQLException e) {
			System.out.println("CompanyAccountData_SQLException");
			e.printStackTrace();
		}
		
		return accountPOList;
	}

	@Override
	public CompanyAccountPO getOneCompanyAccount(String accountName) throws RemoteException {
		if(accountName == null || accountName.equals("")) return null;
		
		CompanyAccountPO targetAccountPO = null;
		
		try {
			// 构建sql语句
			String sql = "select * from company_account;";
			// 设置预处理语句
			PreparedStatement stmt = connection.prepareStatement(sql);
			// 获取结果集（查询数据库）
			ResultSet res = stmt.executeQuery();
			
			while(res.next()) {
				String currentAccountName = res.getString("account_name");
				double currentAccountBalance = res.getDouble("account_balance");
				
				if(accountName.equals(currentAccountName)) {
					targetAccountPO = new CompanyAccountPO(currentAccountName, currentAccountBalance);
				}
			}
		}catch(SQLException e) {
			System.out.println("CompanyAccountData_SQLException");
			e.printStackTrace();
		}
		
		return targetAccountPO;
	}

}
