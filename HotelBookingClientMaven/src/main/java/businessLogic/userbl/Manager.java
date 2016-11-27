package businessLogic.userbl;

import java.rmi.RemoteException;

import dataService.userDataService.UserDataService;
import po.HotelWorkerPO;
import po.MarketPO;
import po.PersonPO;
import vo.HotelWorkerVO;
import vo.MarketVO;
/**
 * @author xiamutian
 * @author 武秀峰
 */
public class Manager {
	
	PersonPO person=new PersonPO();
	HotelWorkerPO hotelworker=new HotelWorkerPO();
	MarketPO market=new MarketPO();
	UserDataService userDataService;
	/**
	 * 网站管理人员登录
	 *@author xiamutian
	 * @throws RemoteException 
	 */
	public boolean managerLonin (String managername,String password) throws RemoteException{
		return userDataService.managerLogin(managername, password);
	}
	
	/**
	 * 保存网站营销人员信息
	 *@param marketInfo
	 */
	public boolean marketSave(MarketVO marketInfo){
		MarketPO marketPO=new MarketPO(marketInfo);
		return userDataService.modifyMarket(marketPO);
		
	}
	
	/**
	 * 保存酒店工作人员信息
	 * @throws RemoteException 
	 */
	public boolean hotelWorkerSave(HotelWorkerVO hotelWorkerInfo) throws RemoteException{
		HotelWorkerPO hotelWorkerPO=new HotelWorkerPO(hotelWorkerInfo);
		return userDataService.modifyHotelWorker(hotelWorkerPO);
	}
	
	/**
	 * 获取客户信息
	 * @throws RemoteException 
	 */
	public PersonPO getPersonInfo(String personname) throws RemoteException{
		return userDataService.findPerson(personname);
		
	}
	
	/**
	 * 获取酒店工作人员信息
	 * @throws RemoteException 
	 */
	public HotelWorkerPO getHotelWorkerInfo(String hotelWorkername) throws RemoteException{
		return userDataService.findHotelWorker(hotelWorkername);
	}
	
	/**
	 * 增加网站营销人员
	 * @throws RemoteException 
	 */
	public boolean marketAdd (MarketVO marketInfo) throws RemoteException{
		MarketPO marketPO=new MarketPO(marketInfo);
		return userDataService.addMarket(marketPO);
		
	}
	
	/**
	 * 增加酒店工作人员
	 * @throws RemoteException 
	 */
	public boolean hotelWorkerAdd (HotelWorkerVO hotelworkerInfo) throws RemoteException{
		HotelWorkerPO hotelworkerPO=new HotelWorkerPO(hotelworkerInfo);
		return userDataService.addHotelWorker(hotelworkerPO);
		
	}
	
	/**
	 * 获取网站营销人员信息
	 * @throws RemoteException 
	 */
	public MarketPO getMarketInfo(String marketname) throws RemoteException{
		return userDataService.findMarket(marketname);
	}
}
