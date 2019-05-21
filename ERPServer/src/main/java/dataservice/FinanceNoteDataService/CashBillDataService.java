package dataservice.FinanceNoteDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.potreasurer.CashBillPO;
import queryItem.CashBillQueryItem;

/**
 * 制定现金费用单的数据接口
 * @author CharlieLei
 *
 */
public interface CashBillDataService extends Remote {
	/**
	 * 保存现金费用单
	 * @param cashbill 要加入列表的现金费用单
	 * @return 是否成功增加
	 */
	public boolean saveCashBill(CashBillPO cashbill) throws RemoteException;
	/**
	 * 获得符合条件的现金费用单
	 * @param cashBillQueryItem 筛选条件
	 * @return 符合条件的现金费用单
	 */
	public List<CashBillPO> inquiryCashBill(CashBillQueryItem cashBillQueryItem) throws RemoteException;
	/**
	 * 获得所有的通过审批但未通知的现金费用单
	 * @return 所有的通过审批但未通知的现金费用单
	 */
	public List<CashBillPO> getAllPassedButNotInformedCashBill() throws RemoteException;
	/**
	 * 将某个现金费用单设置成已通知状态
	 * @param cashBill 待设置现金费用单
	 * @return 是否成功设置
	 */
	public boolean setCashBillInformed(CashBillPO cashBill) throws RemoteException;
}
