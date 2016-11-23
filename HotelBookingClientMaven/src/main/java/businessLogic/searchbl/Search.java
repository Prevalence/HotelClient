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
import po.HotelPO;
import po.HotelWorkerPO;
import po.MarketPO;
import po.PersonPO;
import vo.HotelVO;

public class Search {
	
	/**
	 * @param 客户输入的房间筛选条件
	 * @return 符合条件的酒店列表
	 * @throws RemoteException 
	 */
	public ArrayList<HotelPO> findHotel(HotelVO condition) throws RemoteException{
		Hotel hotel=new Hotel();
		return hotel.findWithReq(condition);
	}
	
	/**
	 * @param personname
	 * @return
	 * @throws RemoteException 
	 */
	public PersonPO searchPersonInfo (String personname) throws RemoteException{
		Person person=new Person();
		return person.getPersonInfo(personname);
	}
	
	/**
	 * @param hotelWorkername
	 * @return
	 * @throws RemoteException 
	 */
	public HotelWorkerPO searchHotelWorkerInfo (String hotelWorkername) throws RemoteException{
		HotelWorker hotelworker=new HotelWorker();
		return hotelworker.getHotelWorkerInfo(hotelWorkername);
	}
	
	/**
	 * @param marketname
	 * @return
	 * @throws RemoteException 
	 */
	public MarketPO searchMarketInfo (String marketname) throws RemoteException{
		Market market=new Market();
		return market.getMarketInfo(marketname);
	}
	

}
