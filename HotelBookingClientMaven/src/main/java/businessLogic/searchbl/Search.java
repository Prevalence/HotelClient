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
	 * @param 客户输入的房间筛选条件
	 * @return 符合条件的酒店列表
	 * @throws RemoteException 
	 */
	public ArrayList<HotelSearchVO> findHotel(HotelConditionVO worstCondition, HotelConditionVO bestCondition) throws RemoteException{
		Hotel hotel=new Hotel();
		return hotel.findWithReq(worstCondition, bestCondition);
	}
	
	/**
	 * @param personname
	 * @return
	 * @throws RemoteException 
	 */
	public PersonVO searchPersonInfo (String personname) throws RemoteException{
		Person person=new Person();
		PersonVO personvo=person.getPersonInfo(personname);
		return personvo;
	}
	
	/**
	 * @param hotelWorkername
	 * @return
	 * @throws RemoteException 
	 */
	public HotelWorkerVO searchHotelWorkerInfo (String hotelWorkername) throws RemoteException{
		HotelWorker hotelworker=new HotelWorker();
		HotelWorkerVO vo=hotelworker.getHotelWorkerInfo(hotelWorkername);
		return vo;
	}
	
	/**
	 * @param marketname
	 * @return
	 * @throws RemoteException 
	 */
	public MarketVO searchMarketInfo (String marketname) throws RemoteException{
		Market market=new Market();
		return market.getMarketInfo(marketname);
	}
	

}
