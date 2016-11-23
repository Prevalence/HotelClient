package businessLogic.searchbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businessLogicService.searchblService.SearchblService;
import po.HotelPO;
import po.HotelWorkerPO;
import po.MarketPO;
import po.PersonPO;
import po.SearchPO;
import vo.HotelVO;

/*
 * @author 武秀峰
 * */

public class SearchController implements SearchblService {
	private Search search=new Search();
	private SearchHistory searchhistory=new SearchHistory();

	public ArrayList<HotelPO> findHotel(HotelVO condition) {
			try {
			return search.findHotel(condition);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public PersonPO searchPersonInfo(String personname) {
		try {
			return search.searchPersonInfo(personname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public HotelWorkerPO searchHotelWorkerInfo(String hotelWorkername) {
		try {
			return search.searchHotelWorkerInfo(hotelWorkername);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public MarketPO searchMarketInfo(String marketname) {
		try {
			return search.searchMarketInfo(marketname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<SearchPO> showHistory(String username) {
		try {
			return searchhistory.showHistory(username);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean saveHistory(SearchPO searchHistory) {
		try {
			return searchhistory.saveHistory(searchHistory);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteHistory(SearchPO searchHistory) {
		try {
			return searchhistory.deleteHistory(searchHistory);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
