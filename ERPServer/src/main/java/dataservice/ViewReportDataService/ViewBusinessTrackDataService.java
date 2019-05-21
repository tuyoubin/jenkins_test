package dataservice.ViewReportDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.popublic.NotePO;

/**
 * 查看经营历程表数据层接口
 * @author CharlieLei
 *
 */
public interface ViewBusinessTrackDataService extends Remote {
	/**
	 * 导出经营历程表
	 * @return 是否成功导出
	 */
	public boolean exportBusinessTrack(List<List<NotePO>> allNoteList) throws RemoteException;
}
