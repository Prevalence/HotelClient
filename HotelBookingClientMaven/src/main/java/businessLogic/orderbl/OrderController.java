package businessLogic.orderbl;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import businessLogicService.orderblService.OrderblService;
import vo.orderVO.orderblVO.OrderVO;
public class OrderController implements OrderblService{
	Order order1;
	
	/**
	 * 构造方法
	 */
	public OrderController(){
		order1=new Order();
	}
	
	/**
	 * 处理异常订单，将订单状态变为已执行并且增加用户被扣除的信用值
	 * @param order
	 * @param percentOfCredit 为网站营销人员选择的恢复信用值的一半还是全部，1代表一半，2代表全部
	 * @return boolean
	 */
	public boolean handleAbnormalOrder(OrderVO order, int percentOfCredit) {
		 try {
			return order1.handleAbnormalOrder(order,percentOfCredit);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 撤销订单，将订单状态变为已撤销，根据撤销时间减少客户信用值
	 * @param order 订单信息
	 * @return boolean 是否撤销成功
	 */
	public boolean reverseOrder(OrderVO order) {
		try {
			return order1.reverseOrder(order);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 执行订单，将订单状态变为已执行并且增加客户信用值
	 * @param order
	 * @return boolean 是否执行成功
	 */
	public boolean finishOrder(OrderVO order) {
		try {
			return order1.finishOrder(order);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 生成订单，持久化保存订单信息
	 * @param order
	 * @return boolean 是否成功生成订单
	 */
	public boolean createOrder(OrderVO order) {
		try {
			return order1.createOrder(order);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 查看个人订单，根据用户名返回个人订单列表
	 * @param personname
	 * @return ArrayList<OrderVO> 订单列表
	 */
	public ArrayList<OrderVO> personOrders(String personname) {
		try {
			return order1.personOrders(personname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 酒店工作人员浏览酒店订单，根据酒店名称返回酒店订单列表
	 * @param hotelname
	 * @return ArrayList<OrderVO> 订单列表
	 */
	public ArrayList<OrderVO> hotelOrders(String hotelname) {
		try {
			return order1.hotelOrders(hotelname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 网站营销人员浏览网站订单，返回网站未执行和异常订单列表
	 * @param  无参数
	 * @return ArrayList<OrderVO> 网站订单列表
	 */
	public ArrayList<OrderVO> netOrders() {
		try {
			return order1.netOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 在个人订单查看过程中，进一步查看某个状态（未执行，已执行，已撤销，异常）的订单
	 * @param personname
	 * @param 订单状态
	 * 	 附：订单状态,"nonExecute"代表未执行订单、"alreadyExecute"代表已执行订单、
			"cancel"代表已撤销订单、"abnormal"代表异常订单、"delay"代表延期订单
	 * @return 符合条件的酒店列表
	 */
	public ArrayList<OrderVO> personStateOrders(String personname, String state){
		try {
			return order1.personStateOrders(personname, state);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 在酒店订单查看过程中，进一步查看某状态订单
	 * @param hotelname
	 * @param state 订单状态
	 * 	 附：订单状态,"nonExecute"代表未执行订单、"alreadyExecute"代表已执行订单、
			"cancel"代表已撤销订单、"abnormal"代表异常订单、"delay"代表延期订单
	 * @return ArrayList<OrderVO> 订单列表
	 */
	public ArrayList<OrderVO> hotelStateOrders(String hotelname, String state){
		try {
			return order1.hotelStateOrders(hotelname, state);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 在浏览网站订单的过程中，进一步查看某日订单
	 * @param date 需要精确到年月日
	 * @return ArrayList<OrderVO> 订单列表
	 */
	public ArrayList<OrderVO> netNumOrders(Calendar date){
		try {
			return order1.netNumOrders(date);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}


