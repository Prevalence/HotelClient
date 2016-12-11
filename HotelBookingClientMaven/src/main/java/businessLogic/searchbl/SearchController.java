package businessLogic.searchbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businessLogicService.searchblService.SearchblService;
import vo.HotelWorkerVO;
import vo.MarketVO;
import vo.SearchVO;
import vo.hotelVO.hotelblVO.HotelConditionVO;
import vo.hotelVO.hoteluiVO.HotelSearchVO;
import vo.personVO.PersonVO;

/**
 * @author 武秀峰
 * */

public class SearchController implements SearchblService {
	private Search search=new Search();
	private SearchHistory searchhistory=new SearchHistory();

	public ArrayList<HotelSearchVO> findHotel(HotelConditionVO worstCondition, HotelConditionVO bestCondition) {
		try {
			return search.findHotel(worstCondition, bestCondition);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public PersonVO searchPersonInfo(String personname) {
		try {
			return search.searchPersonInfo(personname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public HotelWorkerVO searchHotelWorkerInfo(String hotelWorkername) {
		try {
			return search.searchHotelWorkerInfo(hotelWorkername);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public MarketVO searchMarketInfo(String marketname) {
		try {
			return search.searchMarketInfo(marketname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<SearchVO> showHistory(String username) {
		try {
			return searchhistory.showHistory(username);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean saveHistory(SearchVO searchHistory) {
		try {
			return searchhistory.saveHistory(searchHistory);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteHistory(SearchVO searchHistory) {
		try {
			return searchhistory.deleteHistory(searchHistory);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
