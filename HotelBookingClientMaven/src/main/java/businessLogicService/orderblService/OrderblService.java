package businessLogicService.orderblService;

import java.util.ArrayList;
import java.util.List;

import vo.OrderVO;
	/**
	 * 
	 * @author 谢铠联
	 *
	 */
public interface OrderblService {
	/**
	 * 处理异常订单，将订单状态变为已执行并且增加用户被扣除的信用值
	 * @param order
	 * @param percentOfCredit 为网站营销人员选择的恢复信用值的一半还是全部，1代表一半，2代表全部
	 * @return boolean
	 */
	public boolean handleAbnormalOrder(OrderVO order, int percentOfCredit);
	
	/**
	 * 撤销订单，将订单状态变为已撤销，根据撤销时间减少用户信用值
	 * @param order
	 * @return boolean
	 */
	public boolean reverseOrder(OrderVO order);
	
	/**
	 * 执行订单，将订单状态变为已执行并且增加客户信用值
	 * @param order
	 * @return boolean
	 */
	public boolean finishOrder(OrderVO order);
	
	/**
	 * 生成订单，持久化保存订单信息
	 * @param order
	 * @return boolean
	 */
	public boolean createOrder(OrderVO order);
	
	/**
	 * 查看个人订单，根据用户名返回个人订单列表
	 * @param order
	 * @return List<OrderVO>
	 */
	public ArrayList<OrderVO> personOrders(String username);
	
	/**
	 * 浏览酒店订单，根据酒店名称返回酒店订单列表
	 * @param order
	 * @return List<OrderVO>
	 */
	public ArrayList<OrderVO> hotelOrders(String hotelname); 
	
	/**
	 * 浏览网站订单，返回网站未执行和异常订单列表
	 * @param order
	 * @return List<OrderVO>
	 */
	public ArrayList<OrderVO> netOrders();
	
	/**
	 * 在个人订单查看过程中，进一步查看某个状态（未执行，已执行，已撤销，异常）的订单
	 * @param state
	 * @return
	 */
	public ArrayList<OrderVO> personStateOrders(int state);
	
	/**
	 * 在酒店订单查看过程中，进一步查看某个状态（未执行，已执行，已撤销，异常）的订单
	 * @param time
	 * @return
	 */
	public ArrayList<OrderVO> hotelTimeOrders(String time);
	
	/**
	 * 在浏览网站订单的过程中，进一步查看某个编号的订单
	 * @param num
	 * @return
	 */
	public ArrayList<OrderVO> netNumOrders(String num);
}
