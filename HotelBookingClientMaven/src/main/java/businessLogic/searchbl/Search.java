package businessLogic.searchbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businessLogic.hotelbl.Hotel;
import businessLogic.hotelbl.HotelMock;
import businessLogic.userbl.HotelWorker;
import businessLogic.userbl.HotelWorkerMock;
import businessLogic.userbl.Market;
import businessLogic.userbl.MarketMock;
import businessLogic.userbl.Person;
import businessLogic.userbl.PersonMock;
import po.HotelWorkerPO;
import po.MarketPO;
import po.personPO.PersonPO;
import vo.HotelWorkerVO;
import vo.MarketVO;
import vo.hotelVO.hotelblVO.HotelVO;
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
	public ArrayList<HotelVO> findHotel(HotelVO condition) throws RemoteException{
		Hotel hotel=new Hotel();
		return hotel.findWithReq(condition, null);
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
