package GoodsClassData;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data.GoodsClassData.GoodsClassDataImpl;
import initialization.GoodsClassInitializer;
import po.postock.GoodsClassPO;

public class GoodsClassDataImplTest {
	GoodsClassDataImpl impl = new GoodsClassDataImpl();
	
	@Before
	public void setUp() throws Exception {
		GoodsClassInitializer.initGoodsClass();
	}
	
	@Test
	public void testGetAllGoodsClass(){
		
		List<GoodsClassPO> list = null;
		
		try {
			list = impl.getAllGoodsClass();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("A", list.get(0).getName());
		assertEquals("AA", list.get(1).getName());
		assertEquals("AB", list.get(2).getName());
		assertEquals("ABA", list.get(3).getName());
		assertEquals("ABB", list.get(4).getName());
		assertEquals("B", list.get(5).getName());
		assertEquals("BA", list.get(6).getName());	
	}
	
	@Test
	public void testGetClassByID(){

		GoodsClassPO po = null;
		
		try {
			po = impl.getClassByID("0002");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> goodsIDList = new ArrayList<String>();
		goodsIDList.add("00020001");
		goodsIDList.add("00020002");
		goodsIDList.add("00020003");
		
		assertEquals("0002", po.getID());
		assertEquals("AA", po.getName());
		assertEquals("0001", po.getParentID());
		assertEquals(2, po.getLevel());
		assertEquals(goodsIDList, po.getGoodsIDList());		
	}
	
	@Test
	public void testNewClass(){
		GoodsClassPO po = new GoodsClassPO("2018","Test", "0018", 2, null);

		GoodsClassPO goods = null;
		try {
			impl.newClass(po);
			goods = impl.getClassByID("2018");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Test", goods.getName());
		assertEquals("0018", goods.getParentID());
		assertEquals(2, goods.getLevel());
		
		try {
			impl.deleteClass("2018");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testModifyClass(){
		ArrayList<String> goodsIDList = new ArrayList<String>();	
		goodsIDList.add("00020001");
		goodsIDList.add("00020002");
		goodsIDList.add("00020003");
		GoodsClassPO po = new GoodsClassPO("0002","Test", "0000", 1, goodsIDList);

		GoodsClassPO goods = null;
		try {
			impl.modifyClass(po);
			goods = impl.getClassByID("0002");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Test", goods.getName());
		assertEquals("0000", goods.getParentID());
		assertEquals(1, goods.getLevel());
	}
	
	@Test
	public void testDeleteClass(){
		boolean flag = false;		
		GoodsClassPO goods = null;
		try {
			impl.deleteClass("0002");
			goods = impl.getClassByID("0002");
			if(goods == null)
				flag = true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true , flag);
	}
	
}
