package dataservice.CompanyAccountDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.potreasurer.CompanyAccountPO;

/**
 * 账户管理的数据层接口
 * @author CharlieLei
 *
 */
public interface CompanyAccountDataService extends Remote {
	/**
	 * 判断该账户是否存在
	 * @param account 账户
	 * @return 该账户是否存在
	 */
	public boolean isExist(CompanyAccountPO account) throws RemoteException;
	/**
	 * 增加账户
	 * @param account 账户名
	 * @return 是否成功增加账户
	 */
	public boolean addCompanyAccount(CompanyAccountPO account) throws RemoteException;
	/**
	 * 删除账户
	 * @param account 账户
	 * @return 是否成功删除账户
	 */
	public boolean deleteCompanyAccount(CompanyAccountPO account) throws RemoteException;
	/**
	 * 修改账户
	 * @param oldAccountState 账户的旧状态
	 * @param newAccountState 账户的新状态
	 * @return 是否成功修改账户
	 */
	public boolean modifyCompanyAccount(CompanyAccountPO oldAccountState, CompanyAccountPO newAccountState) throws RemoteException;
	/**
	 * 获得符合条件的账户
	 * @param inquiryInput 查询条件
	 * @return 符合条件的账户PO
	 */
	public List<CompanyAccountPO> inquiryCompanyAccount(String inquiryInput) throws RemoteException;
	/**
	 * 获得某一个账户
	 * @param accountName 账户的名字
	 * @return 账户
	 */
	public CompanyAccountPO getOneCompanyAccount(String accountName) throws RemoteException;
}
