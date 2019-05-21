package dataservice.StrategyDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.poMangaer.*;

public interface StrategyService extends Remote{
	public ArrayList<StrategyFPO> getStrategyF(String Time)throws RemoteException;
	public ArrayList<StrategySPO> getStrategyS(String Time)throws RemoteException;
	public ArrayList<StrategyTPO> getStrategyT(String Time)throws RemoteException;
}
