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

	/**
	 * 找到符合条件的酒店列表
	 * @param worstCondition 最坏酒店条件
	 * @param bestCondition 最好酒店条件
	 * @return 符合条件的酒店列表
	 */
	public ArrayList<HotelSearchVO> findHotel(HotelConditionVO worstCondition, HotelConditionVO bestCondition) {
		try {
			return search.findHotel(worstCondition, bestCondition);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据客户名称，找到客户信息
	 * @param personname
	 * @return PersonVO 客户信息
	 */
	public PersonVO searchPersonInfo(String personname) {
		try {
			return search.searchPersonInfo(personname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据酒店工作人员名称，返回酒店工作人员信息
	 * @param hotelWorkername
	 * @return 酒店工作人员信息
	 */
	public HotelWorkerVO searchHotelWorkerInfo(String hotelWorkername) {
		try {
			return search.searchHotelWorkerInfo(hotelWorkername);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据网站营销人员名称，返回网站营销人员信息
	 * @param marketname
	 * @return 网站营销人员信息
	 */
	public MarketVO searchMarketInfo(String marketname) {
		try {
			return search.searchMarketInfo(marketname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据客户名称，返回客户搜索历史酒店
	 * @param personname
	 * @return 客户搜索历史酒店
	 */
	public ArrayList<SearchVO> showHistory(String username) {
		try {
			return searchhistory.showHistory(username);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 保存搜索历史
	 * @param searchHistory
	 * @return 是否保存成功
	 */
	public boolean saveHistory(SearchVO searchHistory) {
		try {
			return searchhistory.saveHistory(searchHistory);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除酒店搜索历史
	 * @param searchHistory
	 * @return 是否删除成功
	 */
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
