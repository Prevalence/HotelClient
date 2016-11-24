package businessLogic.hotelbl;

import java.util.ArrayList;

import po.HotelPO;
import vo.HotelVO;

public class HotelMock extends Hotel{
	/**
	 * 
	 * @param Hotelname
	 * @return 获取酒店信息（PO）
	 */
	public HotelPO showHotelInfo(String Hotelname){
		HotelPO hotelpo=new HotelPO("南京大酒店", 5, "高级酒店", null, "仙林168号", "仙林大学城",4.7, null, null, null, null, "小李");
		return hotelpo;
	}
	/**
	 * 
	 * @param hotelinfo
	 * @return 是否修改成功（成功则返回true,不能则返回false）
	 */
	public boolean modifyHotelInfo(HotelVO hotelinfo){
		boolean result=false;
		if(hotelinfo!=null)
			result=true;
		return result;
	}
	/**
	 * 
	 * @param comment 酒店评价内容
	 * @param username 用户名
	 * @param hotelname 酒店名
	 * @return 是否增加评论成功
	 */
	public boolean addComment(String comment,String username,String hotelname){
		boolean result=false;
		if(comment!=null)
			result=true;
		return result;
	}
	/**
	 * 
	 * @param roomtype 房间类型
	 * @param number 修改数量（包括正数和负数）
	 * @return 是否修改房间数量成功
	 */
	public boolean roomModify(String roomtype,int number){
		boolean result=false;
		if(roomtype!=null&&number!=0)
			result=true;
		return result;
	}
	public ArrayList<HotelPO> findWithReq(HotelPO p) {
		HotelPO hotelpo=new HotelPO("南京大酒店1", 5, "高级酒店", null, "仙林168号", "商圈1",4.7, null, null, null, null, "小李");
		HotelPO hotelpo2=new HotelPO("南京大酒店2", 5, "高级酒店", null, "仙林168号", "商圈2", 4.5,null, null, null, null, "小李");
		HotelPO hotelpo3=new HotelPO("南京大酒店3", 5, "高级酒店", null, "仙林168号", "商圈2",4.9, null, null, null, null, "小李");
		ArrayList<HotelPO> hotels=new ArrayList<HotelPO>();
		if(p.getCircle().equals(hotelpo.getCircle()))
			hotels.add(hotelpo);
		if(p.getCircle().equals(hotelpo2.getCircle()))
			hotels.add(hotelpo2);
		if(p.getCircle().equals(hotelpo3.getCircle()))
			hotels.add(hotelpo3);
		return hotels;
	}
}
