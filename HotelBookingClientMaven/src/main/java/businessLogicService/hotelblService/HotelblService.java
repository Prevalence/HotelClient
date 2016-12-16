package businessLogicService.hotelblService;

import java.util.ArrayList;

import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelConditionVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.HotelSearchVO;
import vo.hotelVO.hoteluiVO.RoomInfoVO;


public interface HotelblService {
	/**
	 * 根据酒店名称，获取酒店信息
	 * @param Hotelname 酒店名
	 * @return 酒店信息
	 */
	public HotelVO showHotelInfo(String Hotelname);
	
	/**
	 * 根据待修改的酒店信息（酒店名称不能修改）
	 * @param hotelinfo 修改的酒店信息（VO）
	 * @return 是否修改成功（成功则返回true,不能则返回false）
	 */
	public boolean modifyHotelInfo(HotelVO hotelinfo);
	
	/**
	 * 增加酒店评价
	 * @param commentvo 评价内容
	 * @return 是否增加评论成功
	 */
	public boolean addComment(CommentVO commentvo);
	
	/**
	 * 修改（或初步确定）某酒店的房间
	 * @param hotelname
	 * @param rooms 一系列房间，由该酒店所有房间组成的ArrayList<RoomVO>
	 * @return 是否修改成功
	 */
	public boolean roomModify(String hotelname, ArrayList<RoomVO> rooms);
	
	/**
	 * 根据搜索条件搜索酒店
	 * @param worstCondition 必须有商圈
	 * @param bestCondition 必须有商圈，且和worstCondition的商圈相同
	 * @return 符合的酒店列表.（若worstCondition和bestCondition里没有商圈，返回null；
	 * 			否则返回ArrayList<HotelSearchVO>，若没有符合酒店，list为空）
	 */
	public ArrayList<HotelSearchVO> findWithReq(HotelConditionVO worstCondition, HotelConditionVO bestCondition);
	
	/**
	 * 增加酒店
	 * @param hotelvo
	 * @return 是否成功增加酒店
	 */
	public boolean addHotel(HotelVO hotelvo);
	
	/**
	 * 返回符合条件的对应酒店的房间，包括房间类型和房间价格
	 * @param hotelname
	 * @param roomtype
	 * @param starttime 入住时间
	 * @param endtime 离开时间
	 * @return 若有符合的，返回符合条件的对应酒店的房间；若没有，返回null
	 */
	public RoomInfoVO findReqRoom(String hotelname, String roomtype, String starttime, String endtime);	
	
	/**
	 * 返回符合条件的对应酒店的可用房间数量
	 * @param hotelname
	 * @param roomtype
	 * @param starttime
	 * @param endtime
	 * @return 返回对应的房间剩余数量
	 */
	public int getAvailableNumber(String hotelname, String roomtype, String starttime, String endtime);
	
	
}
