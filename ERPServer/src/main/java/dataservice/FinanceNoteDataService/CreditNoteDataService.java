package dataservice.FinanceNoteDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.potreasurer.CreditNotePO;
import queryItem.CreditNoteQueryItem;

/**
 * 制定付款单的数据接口
 * @author CharlieLei
 *
 */
public interface CreditNoteDataService extends Remote {
	/**
	 * 保存通过审批的付款单
	 * @param creditnote 通过审批的付款单
	 * @return 是否成功保存
	 */
	public boolean saveCreditNote(CreditNotePO creditnote) throws RemoteException;
	/**
	 * 获得符合筛选条件的付款单
	 * @param creditNoteQueryitem 筛选条件
	 * @return 符合筛选条件的付款单
	 */
	public List<CreditNotePO> inquiryCreditNote(CreditNoteQueryItem creditNoteQueryitem) throws RemoteException;
	/**
	 * 获得所有的通过审批但未通知的付款单
	 * @return 所有的通过审批但未通知的付款单
	 */
	public List<CreditNotePO> getAllPassedButNotInformedCreditNote() throws RemoteException;
	/**
	 * 将某个付款单设置成已通知状态
	 * @param creditNote 待设置的付款单
	 * @return 是否成功设置
	 * @throws RemoteException
	 */
	public boolean setCreditNoteInformed(CreditNotePO creditNote)  throws RemoteException;
}
