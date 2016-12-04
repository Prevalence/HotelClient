package businessLogic.searchbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.searchDataService.SearchDataService;
import po.SearchPO;
import rmi.RemoteHelper;
import vo.SearchVO;
/**
 * 
 * @author 武秀峰
 *
 */
public class SearchHistory {
	
	SearchDataService searchdataservice;
	/**
	 * @param username
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<SearchVO> showHistory(String username) throws RemoteException{
		ArrayList<SearchPO> searchpoList=searchdataservice.showSearchHistory(username);
		ArrayList<SearchVO> searchvoList=new ArrayList<SearchVO>();
		for(int i=0; i<searchpoList.size(); i++){
			SearchVO searchvo=new SearchVO(searchpoList.get(i));
			searchvoList.add(searchvo);
		}
		return searchvoList;
	}

	/**
	 * @param VO
	 * @return
	 * @throws RemoteException 
	 */
	public boolean saveHistory (SearchVO searchHistory) throws RemoteException{
		SearchPO po=new SearchPO(searchHistory);
		return searchdataservice.addSearchHistory(po);
	}

	/**
	 * @param hotelname
	 * @return
	 * @throws RemoteException 
	 */
	public boolean deleteHistory(SearchVO searchHistory) throws RemoteException{
		SearchPO po=new SearchPO(searchHistory);
		return searchdataservice.deleteSearchHistory(po);
	}
	public SearchHistory(){
		searchdataservice=RemoteHelper.getInstance().getSearchDataService();
	}
	
}
