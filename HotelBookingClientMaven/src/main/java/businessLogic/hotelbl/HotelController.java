package businessLogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businessLogicService.hotelblService.HotelblService;
import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelConditionVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.HotelSearchVO;
import vo.hotelVO.hoteluiVO.RoomInfoVO;

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
	 * 酒店工作人员或网站管理人员，根据酒店名称，获取酒店信息
	 * @param Hotelname 酒店名
	 * @return 酒店信息
	 */
	public HotelVO getHotelInfoByHotelworkerOrManager(String Hotelname){
		HotelVO result = null;
		try {
			result = hotel.getHotelInfoByHotelworkerOrManager(Hotelname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 客户根据酒店名称，获取酒店信息
	 * @param Hotelname 酒店名
	 * @return 酒店信息
	 */
	@Override
	public HotelVO getHotelInfoByPerson(String Hotelname) {
		// TODO Auto-generated method stub
		try {
			return hotel.getHotelInfoByPerson(Hotelname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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

	/**
	 * 返回符合条件的对应酒店的房间
	 * @param hotelname
	 * @param roomtype
	 * @param starttime
	 * @param endtime
	 * @return 符合条件的对应酒店的房间
	 */
	@Override
	public RoomInfoVO findReqRoom(String hotelname, String roomtype, String starttime, String endtime) {
		// TODO Auto-generated method stub
		try {
			return hotel.findReqRoom(hotelname, roomtype, starttime, endtime);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 返回符合条件的对应酒店的可用房间数量
	 * @param hotelname
	 * @param roomtype
	 * @param starttime
	 * @param endtime
	 * @return 返回对应的房间剩余数量
	 */
	@Override
	public int getAvailableNumber(String hotelname, String roomtype, String starttime, String endtime) {
		// TODO Auto-generated method stub
		try {
			return hotel.getAvailableNumber(hotelname,roomtype,starttime,endtime);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 根据酒店名称返回对应酒店的房间类型和价格的ArrayList
	 * @param hotelname
	 * @return ArrayList<RoomInfoVO>，若没有，返回空的ArrayList<RoomInfoVO>
	 */
	@Override
	public ArrayList<RoomInfoVO> getHotelRoomInfo(String hotelname) {
		// TODO Auto-generated method stub
		try {
			return hotel.getHotelRoomInfo(hotelname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 新增某酒店的某类型房间n个
	 * @param roomtype
	 * @param roomnum 新增房间类型的房间数量
	 * @param roomprice
	 * @param hotelname
	 * @return 若酒店已有此房间类型，返回false；否则添加房间并返回true
	 */
	@Override
	public boolean addRoom(String roomtype, int roomnum, int roomprice, String hotelname) {
		// TODO Auto-generated method stub
		try {
			return hotel.addRoom(roomtype, roomnum, roomprice, hotelname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 * 修改酒店某类型的房间数量和价格
	 * @param roomtype
	 * @param roomnum 要修改成的房间数量
	 * @param roomprice 要修改成的房间价格
	 * @param hotelname
	 * @return 是否修改成功
	 */
	@Override
	public boolean editRoom(String roomtype, int roomnum, int roomprice, String hotelname) {
		// TODO Auto-generated method stub
		try {
			return hotel.editRoom(roomtype, roomnum, roomprice, hotelname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 获取某酒店中最贵的房间价格
	 * @param hotelname
	 * @return
	 */
	@Override
	public int getHighestPrice(String hotelname) {
		// TODO Auto-generated method stub
		try {
			return hotel.getHighestPrice(hotelname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 删除某酒店的某类型的所有房间
	 * @param roomtype
	 * @param hotelName
	 * @return
	 */
	@Override
	public boolean removeRoom(String roomtype, String hotelName) {
		// TODO Auto-generated method stub
		try {
			return hotel.removeRoom(roomtype, hotelName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


}
