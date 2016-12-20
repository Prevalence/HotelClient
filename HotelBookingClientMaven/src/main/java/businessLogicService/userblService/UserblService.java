package businessLogicService.userblService;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import vo.HotelWorkerVO;
import vo.MarketVO;
import vo.personVO.PersonVO;
import vo.personVO.RecordVO;

public interface UserblService {

	public boolean register(PersonVO personinfo);
	
	/**
	 * 客户信息修改，信用不能修改，只能查看
	 * @param personInfo
	 * @return boolean 是否修改成功
	 */
	public boolean personSave(PersonVO personinfo);
	
	/**
	 * 保存或修改网站营销人员信息
	 * @param marketInfo
	 * @return 是否保存或修改成功
	 */
	public boolean marketSave(MarketVO marketinfo) throws RemoteException;
	
	/**
	 * 保存或修改酒店工作人员信息
	 * @param hotelWorkerInfo
	 * @return 是否保存或修改成功
	 */
	public boolean hotelWorkerSave(HotelWorkerVO hotelWorker_info);
	
	/**
	 * 修改信用值
	 * @param personname
	 * @param credit
	 * @return 是否修改成功
	 * @throws RemoteException
	 */
	public boolean changeCredit (String personname,RecordVO recordvo);	
	
	/**
	 * 会员注册
	 * @param personvo
	 * @param vipType
	 * @param vipInfo 若是普通VIP，info为生日，格式如：20160120；若是企业VIP，格式为非空字符
	 * @return 是否注册成功
	 * @throws ParseException
	 */
	public boolean registeMember(PersonVO personInfo, String vipType, String vipInfo) throws ParseException;

	/**
	 * 根据客户名称获取客户信息
	 * @param personname
	 * @return 客户信息,若没有，返回null
	 */
	public PersonVO getPersonInfo(String personname);
	
	/**
	 * 根据客户ID获取客户信息
	 * @param personID
	 * @return 客户信息，若没有，返回null
	 */
	public PersonVO getPersonInfo(int personID);
	
	/**
	 * 获取酒店工作人员信息
	 * @param hotelWorkername
	 * @return 酒店工作人员信息，若没有，返回null
	 */
	public HotelWorkerVO getHotelWorkerInfo(String hotelWorkername);
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @param usertype，分为“person”，“hotelworker”，“market”，“manager”
	 * @return 是否登陆成功
	 */
	public boolean userLogin (String username,String password,String usertype);
	
	/**
	 * 增加网站营销人员
	 * @param marketInfo
	 * @return 是否增加成功
	 */
	public boolean marketAdd (MarketVO Marketinfo);
	
	/**
	 * 增加一个 网站营销人员
	 * @param Marketinfo
	 * @return 是否增加成功
	 */
	public boolean hotelWorkerAdd (HotelWorkerVO Marketinfo);
	
	/**
	 * 增加一个酒店工作人员
	 * @param marketname
	 * @return 是否增加成功
	 */
	public MarketVO getMarketInfo(String marketname);
	
	/**
	 * 盘对某类的某人是否存在
	 * @param username
	 * @param usertype，分为“person”，“hotelworker”，“market”，“manager”
	 * @return
	 */
	public boolean isExist(String username, String usertype);
	
	/**
	 * 写入客户信用记录
	 * @param personname
	 * @param record
	 * @return 是否写入成功
	 */
	public boolean writeRecord(String personname, RecordVO record);
	
	/**
	 * 获取客户信用记录
	 * @param personID
	 * @return 若改客户没有信用记录，返回空的ArrayList<RecordVO>
	 */
	public ArrayList<RecordVO> getRecord(String personname);
	
}
