package businessLogicService.hotelblService;

import java.util.ArrayList;

import vo.hotelVO.hotelblVO.HotelVO;


public interface HotelblService {
	/**
	 * 
	 * @param Hotelname 酒店名
	 * @return 获取酒店信息（PO）
	 */
	public HotelVO showHotelInfo(String Hotelname);
	/**
	 * 
	 * @param hotelinfo 修改的酒店信息（VO）
	 * @return 是否修改成功（成功则返回true,不能则返回false）
	 */
	public boolean modifyHotelInfo(HotelVO hotelinfo);
	/**
	 * 
	 * @param comment 酒店评价内容
	 * @param username 用户名
	 * @param hotelname 酒店名
	 * @return 是否增加评论成功
	 */
	public boolean addComment(String comment,String username,String hotelname);
	/**
	 * 
	 * @param roomtype 房间类型
	 * @param number 修改数量（包括正数和负数）
	 * @return 是否修改房间数量成功
	 */
	public boolean roomModify(String roomtype,int number);
	/**
	 * 
	 * @param condition 筛选条件
	 * @return 符合条件的酒店PO列表
	 */
	public ArrayList<HotelVO> findWithReq(HotelVO worstCondition, HotelVO bestCondition);
}
