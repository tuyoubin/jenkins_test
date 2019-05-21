package dataservice.StrategyDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.poMangaer.*;


public interface NewStrategyService extends Remote{
	public boolean newFStrategy(StrategyFPO Strategy)throws RemoteException;
	public boolean newSStrategy(StrategySPO Strategy)throws RemoteException;
	public boolean newTStrategy(StrategyTPO Strategy)throws RemoteException;
}
