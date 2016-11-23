package dataService.searchDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SearchPO;

public interface SearchDataService extends Remote{
	public ArrayList<SearchPO> showSearchHistory(String username)throws RemoteException;
	public boolean addSearchHistory(SearchPO s)throws RemoteException;
	public boolean deleteSearchHistory(SearchPO s)throws RemoteException;
}
