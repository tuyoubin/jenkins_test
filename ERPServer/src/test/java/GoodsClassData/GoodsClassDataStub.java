package GoodsClassData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.GoodsClassDataService.GoodsClassDataService;
import po.postock.GoodsClassPO;

public class GoodsClassDataStub implements GoodsClassDataService {

	@Override
	public List<GoodsClassPO> getAllGoodsClass() throws RemoteException {
		GoodsClassPO A = new GoodsClassPO("0001", "A", null, 1, null);
		GoodsClassPO AA = new GoodsClassPO("0002", "AA", "0001", 2, null);
		GoodsClassPO AB = new GoodsClassPO("0003", "AB", "0001", 2, null);
		GoodsClassPO ABA = new GoodsClassPO("0006", "ABA", "0003", 3, null);
		GoodsClassPO ABB = new GoodsClassPO("0007", "ABB", "0003", 3, null);
		GoodsClassPO B = new GoodsClassPO("0004", "B", null, 1, null);
		GoodsClassPO B1 = new GoodsClassPO("0005", "B1", "0004", 2, null);
		List<GoodsClassPO> list = new ArrayList<GoodsClassPO>();
		list.add(A);
		list.add(AA);
		list.add(AB);
		list.add(ABA);
		list.add(ABB);
		list.add(B);
		list.add(B1);
		return list;
	}

	@Override
	public GoodsClassPO getClassByID(String ClassID) throws RemoteException {
		List<GoodsClassPO> list = getAllGoodsClass();
		for(GoodsClassPO po : list){
			if(ClassID.equals(po.getID()))
				return po;
		}
		return null;
	}

	@Override
	public boolean newClass(GoodsClassPO classification) throws RemoteException {
		System.out.println("创建分类");
		return false;
	}

	@Override
	public boolean modifyClass(GoodsClassPO classification) throws RemoteException {
		System.out.println("修改分类");
		return false;
	}

	@Override
	public boolean deleteClass(String ClassID) throws RemoteException {
		System.out.println("删除分类");
		return false;
	}

}
