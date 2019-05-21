package GoodsData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.GoodsDataService.GoodsDataService;
import po.postock.GoodsPO;

public class GoodsDataStub implements GoodsDataService{

	@Override
	public boolean newGoods(GoodsPO Goods) throws RemoteException {
		System.out.println("创建商品");
		return false;
	}

	@Override
	public boolean modifyGoods(GoodsPO Goods) throws RemoteException {
		System.out.println("修改商品");
		return false;
	}

	@Override
	public boolean deleteGoods(String GoodsID) throws RemoteException {
		System.out.println("删除商品");
		return false;
	}

	@Override
	public List<GoodsPO> getAllGoods() throws RemoteException {
		List<GoodsPO> allGoods = new ArrayList<GoodsPO>();
		GoodsPO goods1 = new GoodsPO("00010001", "goods1", null, 0, 0, 0, 0, 0, 0, "0002");
		GoodsPO goods2 = new GoodsPO("00010002", "goods2", null, 0, 0, 0, 0, 0, 0, "0002");
		GoodsPO goods3 = new GoodsPO("00010003", "goods3", null, 0, 0, 0, 0, 0, 0, "0006");
		GoodsPO goods4 = new GoodsPO("00010004", "goods4", null, 0, 0, 0, 0, 0, 0, "0006");
		GoodsPO goods5 = new GoodsPO("00010005", "goods5", null, 0, 0, 0, 0, 0, 0, "0007");
		allGoods.add(goods1);
		allGoods.add(goods2);
		allGoods.add(goods3);
		allGoods.add(goods4);
		allGoods.add(goods5);
		return allGoods;
	}

	@Override
	public boolean setStockWarningValue(String ID, int warningValue) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("修改库存警戒值");
		return false;
	}

}
