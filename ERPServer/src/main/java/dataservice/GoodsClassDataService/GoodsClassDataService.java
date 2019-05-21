package dataservice.GoodsClassDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import po.postock.GoodsClassPO;


public interface GoodsClassDataService extends Remote{

	/**
	 * 获取所有商品分类
	 * @return 商品分类列表
	 */
	public List<GoodsClassPO> getAllGoodsClass() throws RemoteException;
	
	
	/**
	 * 获取一项商品分类
	 * @param ClassID 商品分类编号
	 * @return 商品分类持续化对象
	 */
	public GoodsClassPO getClassByID(String ClassID) throws RemoteException;
	
	
	/**
	 * 新增商品分类
	 * @param classification 商品分类
	 * @return 是否新建成功
	 */
	public boolean newClass(GoodsClassPO classification) throws RemoteException;
	
	/**
	 * 模糊查找
	 * @param classification 商品分类
	 * @return 是否修改成功
	 */
	public boolean modifyClass(GoodsClassPO classification) throws RemoteException;
	
	/**
	 * 模糊查找
	 * @param ClassID 商品分类编号
	 * @return 是否删除成功
	 */
	public boolean deleteClass(String ClassID) throws RemoteException;
	
	
	
}
