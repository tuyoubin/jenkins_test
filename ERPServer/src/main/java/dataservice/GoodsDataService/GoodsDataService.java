package dataservice.GoodsDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.postock.GoodsPO;

public interface GoodsDataService extends Remote{
	
			
	/**
	 * 新增商品
	 * @param Goods 商品信息
	 * @return 是否新建成功
	 */
	public boolean newGoods(GoodsPO Goods) throws RemoteException;
	
	/**
	 * 修改商品
	 * @param Goods 商品信息
	 * @return 是否修改成功
	 */
	public boolean modifyGoods(GoodsPO Goods) throws RemoteException;

	/**
	 * 删除商品
	 * @param GoodsID 商品编号
	 * @return 是否修改成功
	 */
	public boolean deleteGoods(String GoodsID) throws RemoteException;
	
	/**
	 * 获取所有商品
	 * @return 商品列表
	 */
	public List<GoodsPO> getAllGoods() throws RemoteException;
	
	/**
	 * 设置库存警戒值
	 * @param ID 商品编号
	 * @param warningValue 警戒值
	 * @return 是否设置成功
	 */
	public boolean setStockWarningValue(String ID, int warningValue) throws RemoteException;
	
}
