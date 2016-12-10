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
	 * 根据酒店名称，获取酒店信息
	 * @param Hotelname
	 * @return HotelVO
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
	 * 修改酒店信息
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
	 * 客户评论
	 * @param commentvo 评价内容
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
	 * 房间内容修改
	 * @param hotelname 酒店名称
	 * @param roomvoList 房间的信息
	 * @return 是否修改房间信息成功
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
	 * 客户给出要求的房间条件区间，筛选符合条件的酒店，返回酒店列表
	 * @param worstCondition 最坏酒店条件
	 * @param bestCondition 最好酒店条件
	 * @return 符合条件的酒店清单
	 * @throws RemoteException 
	 * 注意：浏览酒店详细信息时，需要先明确地址和商圈，才能进行查看
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
	 * @param hotelvo 待增加酒店信息
	 * @return 是否增加成功
	 * @throws RemoteException 
	 */
	@Override
	public boolean addHotel(HotelVO hotelvo) {
		// TODO Auto-generated method stub
		try {
			return hotel.addHotel(hotelvo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
