package dataService.orderDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderPO;
/**
 * 
 * @author 铠联
 * @author 武秀峰
 *
 */
public interface OrderDataService extends Remote{
	/**
	 * 新增一个订单信息
	 * @param order
	 */
	public boolean add(OrderPO order);
	
	/**
	 * 根据客户名返回客户个人订单列表
	 * @param username
	 * @return ArrayList<OrderPO>
	 */
	public ArrayList<OrderPO> personFind(String personname)throws RemoteException;
	
	/**
	 * 改变一个订单的状态
	 * @param order
	 */
	public boolean modify(OrderPO order)throws RemoteException;
	
	/**
	 * 返回酒店订单列表
	 * @param hotelname
	 * @return ArrayList<OrderPO>
	 */
	public ArrayList<OrderPO> hotelFind(String hotelname)throws RemoteException;
	
	/**
	 * 返回未执行和异常订单列表，给网站营销人员查看
	 * @return ArrayList<OrderPO>
	 */
	public ArrayList<OrderPO> exceptionFind()throws RemoteException;
	
	/**
	 * 根据订单ID返回订单详细信息
	 * @param orderID
	 * @return
	 */
	public OrderPO getOrderInfo(String orderID)throws RemoteException;
}
