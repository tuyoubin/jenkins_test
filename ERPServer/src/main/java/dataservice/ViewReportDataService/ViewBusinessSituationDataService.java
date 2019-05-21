package dataservice.ViewReportDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.poMangaer.BusinessSituationPO;

/**
 * 查看经营情况表数据层接口
 * @author CharlieLei
 *
 */
public interface ViewBusinessSituationDataService extends Remote{
	/**
	 * 导出经营情况表
	 * @param BSPO 经营情况表
	 * @return 是否成功到处
	 * @throws RemoteException rmi异常
	 */
	public boolean exportBS(BusinessSituationPO BSPO)throws RemoteException;
}
