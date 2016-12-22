package businessLogicService.orderblService;

import java.util.ArrayList;

import vo.orderVO.orderblVO.OrderVO;
	/**
	 * 
	 * @author 谢铠联
	 * @author 武秀峰
	 *
	 */
public interface OrderblService {
	/**
	 * 处理异常订单，将订单状态变为已执行并且增加用户被扣除的信用值
	 * @param order
	 * @param percentOfCredit 为网站营销人员选择的恢复信用值的一半还是全部，1代表一半，2代表全部
	 * @return boolean 是否处理成功
	 */
	public boolean handleAbnormalOrder(OrderVO order, int percentOfCredit);
	
	/**
	 * 撤销订单，将订单状态变为已撤销，根据撤销时间减少用户信用值
	 * @param order
	 * @return boolean 是否撤销成功
	 */
	public boolean reverseOrder(OrderVO order);
	
	/**
	 * 执行订单，将订单状态变为已执行并且增加客户信用值
	 * @param order
	 * @return boolean 是否执行成功
	 */
	public boolean finishOrder(OrderVO order);
	
	/**
	 * 生成订单
	 * @param order
	 * @return boolean 订单是否生成成功
	 */
	public boolean createOrder(OrderVO order);
	
	/**
	 * 查看个人订单，根据用户名返回个人订单列表
	 * @param username
	 * @return 返回个人的ArrayList<OrderVO>，若个人没有订单，返回空的ArrayList<OrderVO>
	 */
	public ArrayList<OrderVO> personOrders(String username);
	
	/**
	 * 查看酒店的订单
	 * @param hotelname
	 * @return 返回酒店的ArrayList<OrderVO>，若酒店没有订单，返回空的ArrayList<OrderVO>
	 */
	public ArrayList<OrderVO> hotelOrders(String hotelname); 
	
	/**
	 * 网站营销人员浏览网站订单，返回网站未执行和异常订单列表
	 * @param  无参数
	 * @return ArrayList<OrderVO> 返回网站未执行和异常订单列表，若没有订单，返回空的ArrayList<OrderVO>
	 */
	public ArrayList<OrderVO> netOrders();
	
	/**
	 * 在个人订单查看过程中，进一步查看某个状态（未执行，已执行，已撤销，异常，异常）的订单
	 * @param personname
	 * @param 订单状态，分为“未执行”、“已执行”、“已撤销”、“异常”、“延期”
	 * @return 符合条件的订单列表，若没有，返回空的 ArrayList<OrderVO>
	 */
	public ArrayList<OrderVO> personStateOrders(String personname, String state);
	
	/**
	 * 在酒店订单查看过程中，进一步查看某状态订单
	 * @param hotelname
	 * @param state 订单状态,“未执行”、“已执行”、“已撤销”、“异常”、“延期”
	 * @return ArrayList<OrderVO> 订单列表，若没有，返回空的 ArrayList<OrderVO>
	 */
	public ArrayList<OrderVO> hotelStateOrders(String hotelname, String state);
	
	/**
	 * 在浏览网站订单的过程中，进一步查看某日订单
	 * @param date1 需要精确到年月日，格式“2016-02-02”
	 * @return ArrayList<OrderVO> 订单列表，若没有，返回空的 ArrayList<OrderVO>
	 */
	public ArrayList<OrderVO> netNumOrders(String date);
	
	/**
	 * 根据订单ID返回订单详细信息
	 * @param orderID
	 * @return
	 */
	public OrderVO getOrderInfo(String orderID);
	
	/**
	 * 酒店工作人员改变订单状态
	 * @param orderID
	 * @param newState
	 * @return 是否修改成功
	 */
	public boolean changeOrderState(String orderID,String newState);
	
	/**
	 * 客户离开酒店，增添订单中的离开酒店时间
	 * @param orderID
	 * @return 是否操作成功
	 */
	public boolean leaveRoom(String orderID);
}

