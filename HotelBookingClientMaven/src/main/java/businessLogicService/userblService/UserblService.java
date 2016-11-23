package businessLogicService.userblService;

import java.text.ParseException;

import po.HotelWorkerPO;
import po.MarketPO;
import po.PersonPO;
import vo.HotelWorkerVO;
import vo.MarketVO;
import vo.PersonVO;

public interface UserblService {

	public boolean register(PersonVO personinfo);
	
	/**
	 * 客户注册，已知注册信息,根据注册信息更新网站用户信息并返回注册结果
	 * @param price
	 * @param number
	 * @param type
	 * @return boolean
	 */
	public boolean personSave(PersonVO personinfo);
	
	/**
	 * 已知更改客户信息,更新用户信息并返回保存结果
	 * @param user_info
	 * @return boolean
	 */
	public boolean marketSave(MarketVO marketinfo);
	
	/**
	 * 已知更改网站营销人员信息,更新用户信息并返回保存结果
	 * @param username
	 * @return addCredit
	 */
	public boolean hotelWorkerSave(HotelWorkerVO hotelWorker_info);	
	/**
	 * 已知更改酒店工作人员人员信息,更新用户信息并返回保存结果
	 * @param user_info
	 * @return boolean
	 */
	public boolean changeCredit (String username,int credit);	
	/**
	 * 修改信用值
	 * @param username
	 * @return PersonPO
	 * @throws ParseException 
	 */
	public boolean registeMember(PersonVO personInfo, int vipType, String vipInfo) throws ParseException;
	/**
	 * 注册会员
	 * @param userinfo
	 * @return boolean
	 */
	public PersonPO getPersonInfo(String username);
	/**
	 * 获取会员信息
	 * @author xiamutian
	 * @return boolean
	 */
	public HotelWorkerPO getHotelWorkerInfo(String hotelWorkername);
	/**
	 * 获取酒店工作人员信息
	 * @author xiamutian
	 * @return HotelWorkerPO
	 */
	public boolean userLogin (String username,String password,String usertype);
	/**
	 * 用户登录
	 * @author xiamutian
	 * @return boolean
	 */
	public boolean marketAdd (MarketVO Marketinfo);
	/**
	 * 增加一个 网站营销人员
	 * @author xiamutian
	 * @return boolean
	 */
	public boolean hotelWorkerAdd (HotelWorkerVO Marketinfo);
	/**
	 * 增加一个酒店工作人员
	 * @author xiamutian
	 * @return boolean
	 */
	public MarketPO getMarketInfo(String marketname);
	/**
	 * 获取网站营销人员信息
	 * @author xiamutian
	 * @return boolean
	 */

}
