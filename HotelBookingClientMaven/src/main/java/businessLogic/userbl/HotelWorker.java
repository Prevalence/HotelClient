package businessLogic.userbl;

import java.rmi.RemoteException;

import data.userData.UserDataMock;
import dataService.userDataService.UserDataService;
import po.HotelWorkerPO;
import rmi.RemoteHelper;
/**
 * @author xiamutian
 * 
 */
public class HotelWorker {
	HotelWorkerPO hotelworker=new HotelWorkerPO();
	UserDataService userdataservice;

	/**
	 * 获取酒店工作人员信息
	 * @param hotelWorkername
	 * @throws RemoteException 
	 */
	public HotelWorkerPO getHotelWorkerInfo(String hotelWorkername) throws RemoteException{
		return userdataservice.findHotelWorker(hotelWorkername);
		
	}
	
	/**
	 * 酒店工作人员登陆
	 * @throws RemoteException 
	 */
	public boolean HotelWorkerLogin(String hotelWorkername,String password) throws RemoteException{
		return userdataservice.hotelWorkerLogin(hotelWorkername, password);
	}
	public HotelWorker(){
		userdataservice=RemoteHelper.getInstance().getUserDataService();
	}
}
