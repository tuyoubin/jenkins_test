package StrategyData;
import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.StrategyData.NewStrategyImpl;
import po.poMangaer.StrategyFPO;
import po.poMangaer.StrategySPO;
import po.poMangaer.StrategyTPO;

public class StrtageyImplTest {
	
	NewStrategyImpl New = new NewStrategyImpl();

	@Before
	
	
	@Test
	public void testNewF(){
		StrategyFPO StrategyF = new StrategyFPO("F2018-1-1-0-0-0","Strategy One","20180101","20190101","1",0.9,"00020001",10);
		try {
			assertEquals(true,New.newFStrategy(StrategyF));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNewS(){
		ArrayList<String> pack = new ArrayList<String>();
		pack.add("00020001_50_100_1");
		StrategySPO StrategyS = new StrategySPO("S2018-1-2-0-0-0","Strategy Two","20180101","20190101",pack,90);
		
		try {
			assertEquals(true,New.newSStrategy(StrategyS));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNewT(){
		StrategyTPO StrategyT = new StrategyTPO("T2018-1-3-0-0-0","Strategy There","20180101","20190101",100,200,0.9,"00020001");

		try {
			assertEquals(true,New.newTStrategy(StrategyT));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
