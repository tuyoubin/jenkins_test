package StrategyData;

import java.rmi.RemoteException;

import dataservice.StrategyDataService.NewStrategyService;
import po.poMangaer.StrategyFPO;
import po.poMangaer.StrategySPO;
import po.poMangaer.StrategyTPO;

public class NewStrategyDataStub implements NewStrategyService{

	@Override
	public boolean newFStrategy(StrategyFPO Strategy) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean newSStrategy(StrategySPO Strategy) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean newTStrategy(StrategyTPO Strategy) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
