package businessLogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.hotelDataService.HotelDataService;
import po.HotelPO;
import vo.HotelVO;
import rmi.RemoteHelper;

public class Hotel {
	
	private HotelDataService hoteldataservice;
	private HotelPO hotelpo;
	/**
	 * 
	 * @param Hotelname
	 * @return 获取酒店信息（PO）
	 * @throws RemoteException 
	 */
	public HotelPO showHotelInfo(String Hotelname) throws RemoteException{
		hotelpo=hoteldataservice.showHotelinfo(Hotelname);
		return hotelpo;
	}
	/**
	 * 
	 * @param hotelinfo
	 * @return 是否修改成功（成功则返回true,不能则返回false）
	 * @throws RemoteException 
	 */
	public boolean modifyHotelInfo(HotelVO hotelinfo) throws RemoteException{
		HotelPO PO=hotelinfo.toPO(hotelinfo);
		return hoteldataservice.modify(PO);
	}
	/**
	 * 
	 * @param comment 酒店评价内容
	 * @param username 用户名
	 * @param hotelname 酒店名
	 * @return 是否增加评论成功
	 * @throws RemoteException 
	 */
	public boolean addComment(String comment,String username,String hotelname) throws RemoteException{
		return hoteldataservice.addComment(comment, username, hotelname);
	}
	/**
	 * 
	 * @param roomtype 房间类型
	 * @param number 修改数量（包括正数和负数）
	 * @return 是否修改房间数量成功
	 * @throws RemoteException 
	 */
	public boolean roomModify(String roomtype,int number) throws RemoteException{
		return hoteldataservice.roomModify(roomtype,number);
	}
	/**
	 * 
	 * @param roomtype 酒店的要求
	 * @return 符合条件的酒店清单
	 * @throws RemoteException 
	 */
	public ArrayList<HotelPO> findWithReq(HotelVO condition) throws RemoteException {
		HotelPO hotelcondition=condition.toPO(condition);
		return (ArrayList<HotelPO>) hoteldataservice.findWithReq(hotelcondition);
	}
	/**
	 * 构造方法
	 */
	public Hotel(){
		hoteldataservice=RemoteHelper.getInstance().getHotelDataService();
	}
}
