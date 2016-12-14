package businessLogic.userbl;

import java.rmi.RemoteException;

import dataService.userDataService.UserDataService;
import po.HotelWorkerPO;
import rmi.RemoteHelper;
import vo.HotelWorkerVO;
/**
 * @author xiamutian
 * @author 武秀峰
 * 
 */
public class HotelWorker {
	HotelWorkerPO hotelworker=new HotelWorkerPO();
	UserDataService userDataService;
	/**
	 * 构造函数
	 */
	public HotelWorker(){
		userDataService=RemoteHelper.getInstance().getUserDataService();
	}

	/**
	 * 酒店工作人员登陆
	 * @param hotelworkername
	 * @param password
	 * @return 是否登陆成功
	 * @throws RemoteException
	 */
	public boolean hotelworkerLogin(String hotelworkername,String password) throws RemoteException{
		return userDataService.hotelWorkerLogin(hotelworkername, password);
		
	}
	
	/**
	 * 获取酒店工作人员信息
	 * @param hotelWorkername
	 * @return 酒店工作人员信息
	 * @throws RemoteException 
	 */
	public HotelWorkerVO getHotelWorkerInfo(String hotelWorkername) throws RemoteException{
		HotelWorkerPO po=userDataService.findHotelWorker(hotelWorkername);
		HotelWorkerVO vo=new HotelWorkerVO();
		if(po!=null){
			vo=new HotelWorkerVO(po);
		}
		return vo;
		
	}
	
	/**
	 * 判断酒店工作人员是否存在
	 * @param hotelworkername
	 * @return 是否存在，存在返回true，不存在返回false
	 * @throws RemoteException
	 */
	public boolean isExist(String hotelworkername) throws RemoteException{
		UserController usercontroller=new UserController();
		if(usercontroller.getHotelWorkerInfo(hotelworkername)==null){
			return false;
		}
		return true;
	}
}
