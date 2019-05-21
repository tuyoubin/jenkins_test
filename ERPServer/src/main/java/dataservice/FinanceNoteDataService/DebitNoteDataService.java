package dataservice.FinanceNoteDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.potreasurer.DebitNotePO;
import queryItem.DebitNoteQueryItem;

/**
 * 制定收款单的数据接口
 * @author CharlieLei
 *
 */
public interface DebitNoteDataService extends Remote {
	/**
	 * 保存通过审批的收款单
	 * @param debitnote 通过审批的收款单
	 * @return 是否成功保存
	 */
	public boolean saveDebitNote(DebitNotePO debitnote) throws RemoteException;
	/**
	 * 获得筛选条件的收款单
	 * @param debitNoteQueryItem 筛选条件
	 * @return 收款单
	 */
	public List<DebitNotePO> inquiryDebitNote(DebitNoteQueryItem debitNoteQueryItem) throws RemoteException;
	/**
	 * 获得所有的通过审批但未通知的收款单
	 * @return 所有的通过审批但未通知的收款单
	 */
	public List<DebitNotePO> getAllPassedButNotInformedDebitNote() throws RemoteException;
	/**
	 * 将某个收款单设置成已通知状态
	 * @param debitNote 待设置的收款单
	 * @return 是否成功设置
	 * @throws RemoteException
	 */
	public boolean setDebitNoteInformed(DebitNotePO debitNote) throws RemoteException;
}
