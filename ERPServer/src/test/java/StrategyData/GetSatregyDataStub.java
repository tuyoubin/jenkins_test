package StrategyData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.StrategyDataService.GetStrategyService;
import po.poMangaer.StrategyFPO;
import po.poMangaer.StrategyPO;
import po.poMangaer.StrategySPO;
import po.poMangaer.StrategyTPO;

public class GetSatregyDataStub implements GetStrategyService{

	@Override
	public ArrayList<String> getAllStrategy() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> re = new ArrayList<String>();
		re.add("F2018-1-1-0-0-0");
		re.add("S2018-1-2-0-0-0");
		re.add("T2018-1-3-0-0-0");
		return re;
	}

	@Override
	public StrategyPO getStrategy(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		StrategyFPO a = new StrategyFPO("F2018-1-1-0-0-0","Strategy One","2018-01-01","2019-01-01","1",0.9,"00010001",10);
		ArrayList<String> pack = new ArrayList<String>();
		pack.add("00010001_0_0_1");
		StrategySPO b = new StrategySPO("S2018-1-2-0-0-0","Strategy Two","2018-01-01","2019-01-01",pack,10.5);
		StrategyTPO c = new StrategyTPO("T2018-1-3-0-0-0","Strategy There","2018-01-01","2019-01-01",100,200,0.9,"00010001");
		if(ID.equals(a.getID()))
			return a;
		else if(ID.equals(b.getID()))
			return b;
		else
			return c;
	}

	@Override
	public boolean deleteStrategy(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
