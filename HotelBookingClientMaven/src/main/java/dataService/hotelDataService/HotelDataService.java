package dataService.hotelDataService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

import po.hotelPO.CommentPO;
import po.hotelPO.HotelPO;
import po.hotelPO.RoomPO;

public interface HotelDataService extends Remote{
	/**
	 * 依据酒店名返回酒店信息
	 * @param Hotelname
	 * @return 酒店信息
	 */
	public HotelPO showHotelinfo(String Hotelname)throws RemoteException;
	/**
	 * 修改酒店信息
	 * @param hotelinfo
	 * @return
	 */
	public  boolean modify(HotelPO hotelinfo)throws RemoteException;
	/**
	 * 增加酒店评价
	 * @param comment 评价内容
	 * @param username 用户名
	 * @param hotelname 酒店名
	 * @return
	 */
	public boolean addComment (CommentPO comment)throws RemoteException;
	/**
	 * 依据筛选条件返回满足条件的酒店列表
	 * @param condition 筛选条件
	 * @return 满足条件的酒店列表
	 */
	public ArrayList<HotelPO> findWithReq(HotelPO worstCondition, HotelPO bestCondition)throws RemoteException;
	/**
	 * 房间信息修改
	 * @param roomtype 房间类型
	 * @param number 修改数量
	 * @return
	 */
	public boolean roomModify(String hotelname, ArrayList<RoomPO> rooms)throws RemoteException;
	/**
	 * 增加酒店
	 * @return
	 */
	public boolean addHotel(HotelPO hotel) throws RemoteException ;
}
