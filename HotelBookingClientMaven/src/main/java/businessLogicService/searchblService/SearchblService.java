package businessLogicService.searchblService;

import java.util.ArrayList;

import po.HotelPO;
import po.HotelWorkerPO;
import po.MarketPO;
import po.PersonPO;
import po.SearchPO;
import vo.HotelVO;

public interface SearchblService {
	
	/*已知客户筛选条件，返回符合条件的酒店*/
	public ArrayList<HotelPO> findHotel(HotelVO condition); 

	/*已知客户名称，返回客户信息*/
	public PersonPO searchPersonInfo (String personname);

	/*已知酒店工作人员名称，返回酒店工作人员信息*/
	public HotelWorkerPO searchHotelWorkerInfo (String hotelWorkername);
	
	/*已知网站营销人员名称，返回网站营销人员信息*/
	public MarketPO searchMarketInfo (String marketname);

	/*已知客户名称，返回客户搜索酒店历史*/
	public ArrayList<SearchPO> showHistory(String username); 

	/*客户搜索酒店后，保存新的搜索酒店记录*/
	public boolean saveHistory (SearchPO searchHistory);
	
	/*客户选择删除相应酒店的搜索记录后，删除对应搜索记录*/
	public boolean deleteHistory(SearchPO searchHistory);
	
	
}
