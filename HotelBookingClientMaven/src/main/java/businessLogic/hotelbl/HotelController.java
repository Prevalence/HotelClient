package businessLogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businessLogicService.hotelblService.HotelblService;
import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelConditionVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.HotelSearchVO;

/**
 * HotelController 控制hotel相关的逻辑操作
 * @author John
 * @author 武秀峰
 *
 */
public class HotelController implements HotelblService{
	private Hotel hotel;
	public HotelController(){
		hotel=new Hotel();
	}
	/**
	 * 
	 * @param Hotelname
	 * @return 获取酒店信息（PO）
	 */
	public HotelVO showHotelInfo(String Hotelname){
		HotelVO result = null;
		try {
			result = hotel.showHotelInfo(Hotelname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 * @param hotelinfo
	 * @return 是否修改成功（成功则返回true,不能则返回false）
	 */
	public boolean modifyHotelInfo(HotelVO hotelinfo){
		boolean result = false;
		try {
			result = hotel.modifyHotelInfo(hotelinfo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 * @param comment 酒店评价内容
	 * @param username 用户名
	 * @param hotelname 酒店名
	 * @return 是否增加评论成功
	 */
	public boolean addComment(CommentVO commentvo){
		boolean result = false;
		try {
			result = hotel.addComment(commentvo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 * @param roomtype 房间类型
	 * @param number 修改数量（包括正数和负数）
	 * @return 是否修改房间数量成功
	 */
	public boolean roomModify(String hotelname, ArrayList<RoomVO> roomvoList){
		boolean result = false;
		try {
			result = hotel.roomModify(hotelname, roomvoList);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 */
	public ArrayList<HotelSearchVO> findWithReq(HotelConditionVO worstCondition, HotelConditionVO bestCondition) {
		try {
			return hotel.findWithReq(worstCondition, bestCondition);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 增加酒店
	 */
	@Override
	public boolean addHotel(HotelVO hotelvo) {
		// TODO Auto-generated method stub
		return hotel.addHotel(hotelvo);
	}
}
