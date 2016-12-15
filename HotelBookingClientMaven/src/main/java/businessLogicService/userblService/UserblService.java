package businessLogicService.userblService;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import po.personPO.RecordPO;
import vo.HotelWorkerVO;
import vo.MarketVO;
import vo.personVO.PersonVO;
import vo.personVO.RecordVO;

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
	 * @throws RemoteException 
	 */
	public boolean marketSave(MarketVO marketinfo) throws RemoteException;
	
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
	public boolean registeMember(PersonVO personInfo, String vipType, String vipInfo) throws ParseException;
	/**
	 * 注册会员
	 * @param userinfo
	 * @return boolean
	 */
	public PersonVO getPersonInfo(String username);
	/**
	 * 用客户名称获取客户信息
	 * @author xiamutian
	 * @return boolean
	 */
	public PersonVO getPersonInfo(int personID);
	/**
	 * 用客户ID获取客户信息
	 * @author xiamutian
	 * @return boolean
	 */
	public HotelWorkerVO getHotelWorkerInfo(String hotelWorkername);
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
	public MarketVO getMarketInfo(String marketname);
	/**
	 * 获取网站营销人员信息
	 * @author xiamutian
	 * @return boolean
	 */
	public boolean isExist(String username, String usertype);
	
	/**
	 * 写入客户信用记录
	 * @param personname
	 * @param record
	 * @return
	 */
	public boolean writeRecord(String personname, RecordVO record);
	
	/**
	 * 获取客户信用记录
	 * @param personID
	 * @return
	 */
	public ArrayList<RecordVO> getRecord(String personname);
	
}
