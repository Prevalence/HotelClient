package businessLogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.hotelData.HotelData;
import dataService.hotelDataService.HotelDataService;
import po.HotelPO;
import vo.HotelVO;
import rmi.RemoteHelper;
/**
 * 
 * @author 武秀峰
 *
 */
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
	 * @param bestCondition TODO
	 * @param roomtype 酒店的要求
	 * @return 符合条件的酒店清单
	 * @throws RemoteException 
	 * <a>浏览酒店详细信息时，需要先明确地址和商圈，才能进行查看
	 */
	public ArrayList<HotelPO> findWithReq(HotelVO worstCondition, HotelVO bestCondition) throws RemoteException {
		boolean isConditionRight=(worstCondition.getAddress().equals(bestCondition.getAddress()))&&
				(worstCondition.getCircle().equals(bestCondition.getCircle()));//最坏和最好条件的地址和商圈需要相等
		boolean isConditionComplete=((worstCondition.getAddress()!=null)&&(worstCondition.getCircle()!=null));//需要先明确地址和商圈，才能进行查看
		if(isConditionRight&&isConditionComplete){//当输入的条件正确时，进行酒店搜索
			HotelPO worstConditionPO=worstCondition.toPO(worstCondition);
			HotelPO bestConditionPO=bestCondition.toPO(bestCondition);
			return (ArrayList<HotelPO>) hoteldataservice.findWithReq(worstConditionPO, bestConditionPO);
		}else{
			return null;//需要提醒客户先明确地址和商圈
		}
		
	}
	/**
	 * 构造方法
	 */
	public Hotel(){
		hoteldataservice=RemoteHelper.getInstance().getHotelDataService();
	}
}
