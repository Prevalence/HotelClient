package businessLogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.hotelDataService.HotelDataService;
import po.hotelPO.HotelPO;
import rmi.RemoteHelper;
import vo.hotelVO.hotelblVO.HotelConditionVO;
import vo.hotelVO.hotelblVO.HotelVO;

public class Hotel {
	private HotelDataService hoteldataservice;
	/**
	 * 
	 * @param Hotelname
	 * @return 获取酒店信息（PO）
	 * @throws RemoteException 
	 */
	public HotelVO showHotelInfo(String Hotelname) throws RemoteException{
		HotelPO hotelpo=hoteldataservice.showHotelinfo(Hotelname);
		HotelVO hotelvo=new HotelVO(hotelpo);
		return hotelvo;
	}
	/**
	 * 
	 * @param hotelinfo
	 * @return 是否修改成功（成功则返回true,不能则返回false）
	 * @throws RemoteException 
	 */
	public boolean modifyHotelInfo(HotelVO hotelinfo) throws RemoteException{
		HotelPO PO=new HotelPO(hotelinfo);
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
	public ArrayList<HotelVO> findWithReq(HotelConditionVO worstCondition, HotelConditionVO bestCondition) throws RemoteException {
		ArrayList<HotelVO> hotelvoList=new ArrayList<HotelVO>();//hotelvoList为返回结果
		boolean isConditionRight=(worstCondition.getAddress().equals(bestCondition.getAddress()))&&
				(worstCondition.getCircle().equals(bestCondition.getCircle()))&&
				(worstCondition.isBooked()==bestCondition.isBooked());//最坏和最好条件的地址、商圈、是否预订过需要相等
		boolean isConditionComplete=((worstCondition.getAddress()!=null)&&(worstCondition.getCircle()!=null));//需要先明确地址和商圈，才能进行查看
		if(isConditionRight&&isConditionComplete){//当输入的条件正确时，进行酒店搜索
			HotelPO worstConditionPO=new HotelPO(worstCondition.toHotelVO(worstCondition));
			HotelPO bestConditionPO=new HotelPO(bestCondition.toHotelVO(bestCondition));
			ArrayList<HotelPO> hotelpoList= hoteldataservice.findWithReq(worstConditionPO, bestConditionPO);
			
			for(int i=0; i<hotelpoList.size(); i++){
				HotelVO hotelvo=new HotelVO(hotelpoList.get(i));
				hotelvoList.add(hotelvo);
			}
			
		}else{
			return null;//需要提醒客户先明确地址和商圈
		}
		
		//做是否预订过的筛选
		if(!worstCondition.isBooked()){//如果没有限制是自己已预订过的，直接返回hotelvoList
			return hotelvoList;
		}else{//如果限制是自己已预订过的，则对hotelvoList进行筛选
			//待修正
			
			return hotelvoList;
		}
		
	}
	/**
	 * 构造方法
	 */
	public Hotel(){
		hoteldataservice=RemoteHelper.getInstance().getHotelDataService();
	}

}
