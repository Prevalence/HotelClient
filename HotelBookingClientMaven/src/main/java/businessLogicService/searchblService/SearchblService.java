package businessLogicService.searchblService;

import java.util.ArrayList;

import vo.HotelWorkerVO;
import vo.MarketVO;
import vo.SearchVO;
import vo.hotelvo.HotelVO;
import vo.personvo.PersonVO;
/**
 * 
 * @author 武秀峰
 *
 */
public interface SearchblService {
	
	/*已知客户筛选条件，返回符合条件的酒店*/
	public ArrayList<HotelVO> findHotel(HotelVO condition); 

	/*已知客户名称，返回客户信息*/
	public PersonVO searchPersonInfo (String personname);

	/*已知酒店工作人员名称，返回酒店工作人员信息*/
	public HotelWorkerVO searchHotelWorkerInfo (String hotelWorkername);
	
	/*已知网站营销人员名称，返回网站营销人员信息*/
	public MarketVO searchMarketInfo (String marketname);

	/*已知客户名称，返回客户搜索酒店历史*/
	public ArrayList<SearchVO> showHistory(String username); 

	/*客户搜索酒店后，保存新的搜索酒店记录*/
	public boolean saveHistory (SearchVO searchHistory);
	
	/*客户选择删除相应酒店的搜索记录后，删除对应搜索记录*/
	public boolean deleteHistory(SearchVO searchHistory);
	
	
}
