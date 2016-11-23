package businessLogic.userbl;
import po.HotelWorkerPO;
import po.MarketPO;
import po.PersonPO;
import vo.HotelWorkerVO;
import vo.MarketVO;
import vo.PersonVO;

import java.rmi.RemoteException;
import java.text.ParseException;

import businessLogicService.userblService.UserblService;
public class UserController  implements UserblService{
	private Person person=new Person();
	private Market market=new Market();
	private Manager manager=new Manager();
	private HotelWorker hotelworker=new HotelWorker();
	
	/**
	 * 客户注册，已知注册信息,根据注册信息更新网站用户信息并返回注册结果
	 * @param price
	 * @param number
	 * @param type
	 * @return boolean
	 */
	@Override
	public boolean register(PersonVO userinfo) {
		try {
			return person.register(userinfo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	
	}

	/**
	 * 已知更改客户信息,更新用户信息并返回保存结果
	 * @param personInfo
	 * @return boolean
	 */
	@Override
	public boolean personSave(PersonVO personInfo) {
		try {
			return person.personSave(personInfo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 已知更改网站营销人员信息,更新用户信息并返回保存结果
	 * @param marketInfo
	 * @return boolean
	 */
	@Override
	public boolean marketSave(MarketVO marketInfo) {
		return manager.marketSave(marketInfo);
	}

	/**
	 * 已知更改酒店工作人员人员信息,更新用户信息并返回保存结果
	 * @param hotelWorkerInfo
	 * @return boolean
	 */
	@Override
	public boolean hotelWorkerSave(HotelWorkerVO hotelWorkerInfo) {
		try {
			return manager.hotelWorkerSave(hotelWorkerInfo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改信用值
	 * @param personname
	 * @return boolean
	 */
	@Override
	public boolean changeCredit(String personname, int credit) {
		try {
			return market.changeCredit(personname, credit);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 注册会员
	 * @param personInfo
	 * @return boolean
	 * @throws ParseException 
	 */
	@Override
	public boolean registeMember(PersonVO personInfo, int vipType, String vipInfo) throws ParseException {
		try {
			return person.registeMember(personInfo, vipType, vipInfo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 获取会员信息
	 * @return boolean
	 */	
	@Override
	public PersonPO getPersonInfo(String personname) {
	try {
		return person.getPersonInfo(personname);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}

	/**
	 * 获取酒店工作人员信息
	 * @return HotelWorkerPO
	 */
	@Override
	public HotelWorkerPO getHotelWorkerInfo(String hotelWorkername) {
		try {
			return hotelworker.getHotelWorkerInfo(hotelWorkername);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 用户登录
	 * @return boolean
	 */
	@Override
	public boolean userLogin(String username, String password, String usertype) {
		try {
			return person.Personlogin(username, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 增加一个网站营销人员
	 * @return boolean
	 */
	@Override
	public boolean marketAdd(MarketVO marketInfo) {
		try {
			return manager.marketAdd(marketInfo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 增加一个酒店工作人员
	 * @return boolean
	 */
	@Override
	public boolean hotelWorkerAdd(HotelWorkerVO marketInfo) {
		return manager.hotelWorkerAdd(marketInfo);
	}

	/**
	 * 获取网站营销人员信息
	 * @return boolean
	 */
	@Override
	public MarketPO getMarketInfo(String marketname) {
		try {
			return market.getMarketInfo(marketname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}	
