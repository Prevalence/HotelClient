package businessLogic.userbl;

import java.rmi.RemoteException;

import dataService.userDataService.UserDataService;
import po.HotelWorkerPO;
import rmi.RemoteHelper;
/**
 * @author xiamutian
 * @author 武秀峰
 * 
 */
public class HotelWorker {
	HotelWorkerPO hotelworker=new HotelWorkerPO();
	UserDataService userdataservice;

	/**
	 * 酒店工作人员登陆
	 * @param hotelworkername
	 * @param password
	 * @return
	 * @throws RemoteException
	 */
	public boolean hotelworkerLogin(String hotelworkername,String password) throws RemoteException{
		return userdataservice.hotelWorkerLogin(hotelworkername, password);
		
	}
	
	/**
	 * 获取酒店工作人员信息
	 * @param hotelWorkername
	 * @throws RemoteException 
	 */
	public HotelWorkerPO getHotelWorkerInfo(String hotelWorkername) throws RemoteException{
		return userdataservice.findHotelWorker(hotelWorkername);
		
	}
	
	public HotelWorker(){
		userdataservice=RemoteHelper.getInstance().getUserDataService();
	}
}
