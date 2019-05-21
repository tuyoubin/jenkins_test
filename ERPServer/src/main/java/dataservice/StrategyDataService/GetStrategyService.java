package dataservice.StrategyDataService;

import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.poMangaer.StrategyPO;

public interface GetStrategyService extends Remote{
	public ArrayList<String> getAllStrategy()throws RemoteException;
	public StrategyPO getStrategy(String ID)throws RemoteException;
	public boolean deleteStrategy(String ID)throws RemoteException;
}
