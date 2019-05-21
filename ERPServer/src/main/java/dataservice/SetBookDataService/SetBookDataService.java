package dataservice.SetBookDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.potreasurer.BookPO;

/**
 * 期初建账的数据接口
 * @author CharlieLei
 *
 */
public interface SetBookDataService extends Remote {
	/**
	 * 判断期初账单是否已经存在
	 * @return 期初账单是否存在
	 */
	public boolean doesBookExist() throws RemoteException;
	/**
	 * 期初建账
	 * @param bookInfo 期初账单
	 * @return 是否成功建账
	 */
	public boolean newBook(BookPO bookInfo) throws RemoteException;
	/**
	 * 查询期初账单
	 * @return 期初账单
	 */
	public BookPO inquiryBook() throws RemoteException;
}
