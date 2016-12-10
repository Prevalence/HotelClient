package businessLogic.searchbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businessLogic.hotelbl.Hotel;
import businessLogic.userbl.HotelWorker;
import businessLogic.userbl.Market;
import businessLogic.userbl.Person;
import vo.HotelWorkerVO;
import vo.MarketVO;
import vo.hotelVO.hotelblVO.HotelConditionVO;
import vo.hotelVO.hoteluiVO.HotelSearchVO;
import vo.personVO.PersonVO;
/**
 * 
 * @author 武秀峰
 *
 */
public class Search {
	
	/**
	 * 找到符合条件的酒店列表
	 * @param worstCondition 最坏酒店条件
	 * @param bestCondition 最好酒店条件
	 * @return 符合条件的酒店列表
	 * @throws RemoteException
	 */
	public ArrayList<HotelSearchVO> findHotel(HotelConditionVO worstCondition, HotelConditionVO bestCondition) throws RemoteException{
		Hotel hotel=new Hotel();
		return hotel.findWithReq(worstCondition, bestCondition);
	}
	
	/**
	 * 根据客户名称，找到客户信息
	 * @param personname
	 * @return PersonVO 客户信息
	 * @throws RemoteException
	 */
	public PersonVO searchPersonInfo (String personname) throws RemoteException{
		Person person=new Person();
		PersonVO personvo=person.getPersonInfo(personname);
		return personvo;
	}
	
	/**
	 * 根据酒店工作人员名称，返回酒店工作人员信息
	 * @param hotelWorkername
	 * @return 酒店工作人员信息
	 * @throws RemoteException
	 */
	public HotelWorkerVO searchHotelWorkerInfo (String hotelWorkername) throws RemoteException{
		HotelWorker hotelworker=new HotelWorker();
		HotelWorkerVO vo=hotelworker.getHotelWorkerInfo(hotelWorkername);
		return vo;
	}
	
	/**
	 * 根据网站营销人员名称，返回网站营销人员信息
	 * @param marketname
	 * @return 网站营销人员信息
	 * @throws RemoteException
	 */
	public MarketVO searchMarketInfo (String marketname) throws RemoteException{
		Market market=new Market();
		return market.getMarketInfo(marketname);
	}
	

}
