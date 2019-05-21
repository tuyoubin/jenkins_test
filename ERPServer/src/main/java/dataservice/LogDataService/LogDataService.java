package dataservice.LogDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.poLog.LogPO;

/**
 * 查看日志数据层接口
 * @author CharlieLei
 *
 */
public interface LogDataService extends Remote {
	/**
	 * 增加日志
	 * @param date 活动发生时间
	 * @param activity 发生的活动
	 * 
	 * @return是否成功增加日志
	 */
	public boolean addLog(String date, String activity) throws RemoteException;
	/**
	 * 获得日志
	 * @return日志PO
	 */
	public LogPO getLogOfERP() throws RemoteException;
}
