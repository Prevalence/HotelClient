package businessLogic.searchbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.searchData.SearchDataMock;
import dataService.searchDataService.SearchDataService;
import po.HotelPO;
import po.SearchPO;
import rmi.RemoteHelper;

public class SearchHistory {
	
	SearchDataService searchdataservice;
	/**
	 * @param username
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<SearchPO> showHistory(String username) throws RemoteException{
		return searchdataservice.showSearchHistory(username);
	}

	/**
	 * @param VO
	 * @return
	 * @throws RemoteException 
	 */
	public boolean saveHistory (SearchPO searchHistory) throws RemoteException{
		return searchdataservice.addSearchHistory(searchHistory);
	}

	/**
	 * @param hotelname
	 * @return
	 * @throws RemoteException 
	 */
	public boolean deleteHistory(SearchPO searchHistory) throws RemoteException{
		return searchdataservice.deleteSearchHistory(searchHistory);
	}
	public SearchHistory(){
		searchdataservice=RemoteHelper.getInstance().getSearchDataService();
	}
	
}
