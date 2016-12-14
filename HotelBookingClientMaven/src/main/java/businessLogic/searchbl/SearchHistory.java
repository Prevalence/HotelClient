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
	 * 根据客户名称，返回客户搜索历史酒店
	 * @param personname
	 * @return 客户搜索历史酒店
	 * @throws RemoteException 
	 */
	public ArrayList<SearchVO> showHistory(String personname) throws RemoteException{
		ArrayList<SearchPO> searchpoList=searchdataservice.showSearchHistory(personname);
		ArrayList<SearchVO> searchvoList=new ArrayList<SearchVO>();
		if(searchpoList!=null){
			for(int i=0; i<searchpoList.size(); i++){
				SearchVO searchvo=new SearchVO(searchpoList.get(i));
				searchvoList.add(searchvo);
			}
		}
		return searchvoList;
	}

	/**
	 * 保存搜索历史
	 * @param searchHistory
	 * @return 是否保存成功
	 * @throws RemoteException
	 */
	public boolean saveHistory (SearchVO searchHistory) throws RemoteException{
		SearchPO po=new SearchPO(searchHistory);
		return searchdataservice.addSearchHistory(po);
	}

	/**
	 * 删除酒店搜索历史
	 * @param searchHistory
	 * @return 是否删除成功
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
