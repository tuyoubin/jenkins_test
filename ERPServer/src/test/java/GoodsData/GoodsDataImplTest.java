package GoodsData;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data.GoodsData.GoodsDataImpl;
import initialization.GoodsInitializer;
import po.postock.GoodsPO;

public class GoodsDataImplTest {
	GoodsDataImpl impl = new GoodsDataImpl();
	
	@Before
	public void setUp() throws Exception {
		GoodsInitializer.initGoods();
	}
	
	@Test
	public void testGetAllGoods(){
		List<GoodsPO> list = null;
		try {
			list = impl.getAllGoods();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		assertEquals("00020001", list.get(0).getID());
		assertEquals("00020002", list.get(1).getID());
		assertEquals("00020003", list.get(2).getID());
		assertEquals("00060001", list.get(3).getID());
		assertEquals("00050001", list.get(4).getID());
	}
	
	
	@Test
	public void testNewGoods(){
		GoodsPO po = new GoodsPO("20182018", "test1", "type1", 100, 20, 40, 60, 80, 10, "2018");
		GoodsPO goods = null;
		List<GoodsPO> list = null;
		try {
			impl.newGoods(po);
			list = impl.getAllGoods();
			goods = list.get(list.size() - 1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("20182018", goods.getID());
		assertEquals("test1", goods.getName());
		assertEquals("type1", goods.getType());
		assertEquals(100, goods.getAmount());
		assertEquals(20, goods.getPurchasePrice(), 0);
		assertEquals(40, goods.getRecentPurchasePrice(), 0);
		assertEquals(60, goods.getSalePrice(), 0);
		assertEquals(80, goods.getRecentSalePrice(), 0);
		assertEquals(10, goods.getWarningValue());
		
		try {
			impl.deleteGoods("20182018");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testModifyGoods(){
		GoodsPO test2 = new GoodsPO("00020001", "test2", "type2", 0, 10, 20, 30, 40, 0, "0002");
		GoodsPO goods = null;
		List<GoodsPO> list = null;
		try {
			impl.modifyGoods(test2);
			list = impl.getAllGoods();
			goods = list.get(0);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("test2", goods.getName());
		assertEquals("type2", goods.getType());
		assertEquals(0, goods.getAmount());
		assertEquals(10, goods.getPurchasePrice(), 0);
		assertEquals(20, goods.getRecentPurchasePrice(), 0);
		assertEquals(30, goods.getSalePrice(), 0);
		assertEquals(40, goods.getRecentSalePrice(), 0);
		assertEquals("0002", goods.getClassID());
	}
	
	@Test
	public void testDeleteGoods(){
		List<GoodsPO> list = null;
		try {
			impl.deleteGoods("00050001");
			list = impl.getAllGoods();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(4, list.size());
	}
	
	@Test
	public void testSetStockWarningValue(){
		GoodsPO goods = null;
		List<GoodsPO> list = null;
		try {
			impl.setStockWarningValue("00020001", 888);
			list = impl.getAllGoods();
			goods = list.get(0);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(888, goods.getWarningValue());
	}
	
}
