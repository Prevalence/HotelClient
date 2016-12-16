package businessLogicService.searchblService;

import java.util.ArrayList;

import vo.HotelWorkerVO;
import vo.MarketVO;
import vo.SearchVO;
import vo.personVO.PersonVO;
/**
 * 
 * @author 武秀峰
 *
 */
public interface SearchblService {
	
	/**
	 * 已知客户名称，返回客户信息
	 * @param personname
	 * @return
	 */
	public PersonVO searchPersonInfo (String personname);

	/**
	 * 已知客户名称，返回客户信息
	 * @param hotelWorkername
	 * @return
	 */
	public HotelWorkerVO searchHotelWorkerInfo (String hotelWorkername);
	
	/**
	 * 已知网站营销人员名称，返回网站营销人员信息
	 * @param marketname
	 * @return
	 */
	public MarketVO searchMarketInfo (String marketname);

	/**
	 * 已知客户名称，返回客户搜索酒店历史
	 * @param username
	 * @return 若没有搜索历史，返回空的ArrayList<SearchVO>
	 */
	public ArrayList<SearchVO> showHistory(String username); 

	/**
	 * 客户搜索酒店后，保存新的搜索酒店记录
	 * @param searchHistory
	 * @return 是否保存成功
	 */
	public boolean saveHistory (SearchVO searchHistory);
	
	/**
	 * 客户选择删除相应酒店的搜索记录后，删除对应搜索记录
	 * @param searchHistory
	 * @return 是否删除成功
	 */
	public boolean deleteHistory(SearchVO searchHistory);
	
	
}
