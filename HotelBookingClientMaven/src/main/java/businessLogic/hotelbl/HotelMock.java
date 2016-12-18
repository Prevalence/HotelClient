package businessLogic.hotelbl;

import java.util.ArrayList;

import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;

public class HotelMock extends Hotel{
	/**
	 * 
	 * @param Hotelname
	 * @return 获取酒店信息（PO）
	 */
	public HotelVO getHotelInfoByHotelworkerOrManager(String Hotelname){
		RoomVO roomvo=new RoomVO("单人间", "111", 300, null, null);
		ArrayList<RoomVO> roomvoList=new ArrayList<RoomVO>();
		roomvoList.add(roomvo);
		CommentVO commentvo=new CommentVO("南京大酒店", "小李", null, 5, "很好");
		ArrayList<CommentVO> commentvoList=new ArrayList<CommentVO>();
		commentvoList.add(commentvo);
//		public HotelVO(String hotelname, int star, String feature, ArrayList<Boolean> service, String address,
//				String circle, double score, RoomPO room, CommentPO comment, String hotelworker)
		HotelVO hotelvo=new HotelVO(11111,"南京大酒店", 5, "高级酒店", null, "仙林168号", 
				"仙林大学城",4.7, roomvoList, commentvoList, "小李","5130000");
		
		return hotelvo;
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
	public ArrayList<HotelVO> findWithReq(HotelVO p) {
		/*	public RoomVO(String roomType, String roomnum, int roomPrice, ArrayList<Calendar> checkInTime,
			ArrayList<Calendar> checkOutTime)*/
		RoomVO roomvo=new RoomVO("单人间", "111", 300, null, null);
		ArrayList<RoomVO> roomvoList=new ArrayList<RoomVO>();
		roomvoList.add(roomvo);
		CommentVO commentvo=new CommentVO("南京大酒店", "小李", null, 5, "很好");
		ArrayList<CommentVO> commentvoList=new ArrayList<CommentVO>();
		commentvoList.add(commentvo);
		
		HotelVO hotelvo1=new HotelVO(11111,"南京大酒店1", 5, "高级酒店", null, "仙林168号", "商圈1",4.7,roomvoList, commentvoList, "小李","5130000");
		HotelVO hotelvo2=new HotelVO(22222,"南京大酒店2", 5, "高级酒店", null, "仙林168号", "商圈2", 4.5,roomvoList, commentvoList, "小李","5130000");
		HotelVO hotelvo3=new HotelVO(33333,"南京大酒店3", 5, "高级酒店", null, "仙林168号", "商圈2",4.9, roomvoList, commentvoList, "小李","5130000");
		ArrayList<HotelVO> hotels=new ArrayList<HotelVO>();
		if(p.getCircle().equals(hotelvo1.getCircle()))
			hotels.add(hotelvo1);
		if(p.getCircle().equals(hotelvo2.getCircle()))
			hotels.add(hotelvo2);
		if(p.getCircle().equals(hotelvo3.getCircle()))
			hotels.add(hotelvo3);
		return hotels;
	}
}
