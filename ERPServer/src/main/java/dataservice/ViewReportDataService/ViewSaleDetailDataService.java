package dataservice.ViewReportDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.potreasurer.SaleDetailItemPO;

/**
 * 查看销售明细表数据层的接口
 * @author CharlieLei
 *
 */
public interface ViewSaleDetailDataService extends Remote {
	/**
	 * 导出销售明细表
	 * @return 是否成功导出
	 */
	public boolean exportSaleDetail(List<SaleDetailItemPO> saleDetailItemPOList) throws RemoteException;
}
