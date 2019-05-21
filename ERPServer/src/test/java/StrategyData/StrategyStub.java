package StrategyData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.StrategyDataService.StrategyService;
import po.poMangaer.StrategyFPO;
import po.poMangaer.StrategySPO;
import po.poMangaer.StrategyTPO;

public class StrategyStub implements StrategyService{

	@Override
	public ArrayList<StrategyFPO> getStrategyF(String Time) throws RemoteException {
		// TODO Auto-generated method stub
		StrategyFPO a = new StrategyFPO("F2018-1-1-0-0-0","Strategy One","2018-01-01","2019-01-01","1",0.9,"00010001",10);
		ArrayList<StrategyFPO> b = new ArrayList<StrategyFPO>();
		b.add(a);
		return b;
	}

	@Override
	public ArrayList<StrategySPO> getStrategyS(String Time) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> pack = new ArrayList<String>();
		pack.add("00010001_0_0_1");
		StrategySPO a = new StrategySPO("S2018-1-2-0-0-0","Strategy Two","2018-01-01","2019-01-01",pack,10.5);
		ArrayList<StrategySPO> b = new ArrayList<StrategySPO>();
		b.add(a);
		return b;
	}

	@Override
	public ArrayList<StrategyTPO> getStrategyT(String Time) throws RemoteException {
		// TODO Auto-generated method stub
		StrategyTPO a = new StrategyTPO("T2018-1-3-0-0-0","Strategy There","2018-01-01","2019-01-01",100,200,0.9,"00010001");
		ArrayList<StrategyTPO> b = new ArrayList<StrategyTPO>();
		b.add(a);
		return b;
	}

}
