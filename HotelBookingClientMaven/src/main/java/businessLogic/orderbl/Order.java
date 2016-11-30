package businessLogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import businessLogic.userbl.Person;
import businessLogic.userbl.UserController;
import po.OrderPO;
import rmi.RemoteHelper;
import vo.OrderVO;
import dataService.orderDataService.OrderDataService;
/**
 * 
 * @author 谢铠联
 * @author 武秀峰
 *
 */
public class Order{
//	private Person person;
//	
//	private ArrayList<OrderPO> personList = null;
//	
//	private ArrayList<OrderPO> hotelList = null;
//	
//	private ArrayList<OrderPO> netList = null;
	
	private OrderDataService orderDataService;
	
	public Order(){
		Person person=new Person();
		orderDataService=RemoteHelper.getInstance().getOrderDataService();
	}
	
	/**
	 * 处理异常订单，将订单状态变为已执行并且增加用户被扣除的信用值
	 * @param order
	 * @param percentOfCredit 为网站营销人员选择的恢复信用值的一半还是全部，1代表一半，2代表全部
	 * @return boolean
	 * @throws RemoteException 
	 */
	public boolean handleAbnormalOrder(OrderVO order, int percentOfCredit) throws RemoteException {
		//改变订单状态
		order.setOrderstate("alreadyExecute");//此步将异常订单变为已执行
		OrderPO orderpo=new OrderPO(order);
		orderDataService.modify(orderpo);
		//恢复信用值
		UserController user=new UserController();
		int credit=percentOfCredit* order.getOrderprice() /2;
		return user.changeCredit(order.getPersonname(), credit);
	}

	/**
	 * 撤销订单，将订单状态变为已撤销，根据撤销时间减少客户信用值
	 * @param order
	 * @return boolean
	 * @throws RemoteException 
	 */
	public boolean reverseOrder(OrderVO order) throws RemoteException {
		if(order.getOrderstate().equals("nonExecute")){//当订单是未执行订单时，进行操作；否则报错
			//撤销订单
			order.setCanceltime(Calendar.getInstance());
			order.setOrderstate("cancel");
			OrderPO orderPO=new OrderPO(order);
			boolean isReverse=orderDataService.modify(orderPO);
			//减少客户信用值
			boolean isCreditChange=true;
			if(Calendar.getInstance().compareTo(order.getLatestExecutetime())<6*60*60*1000){//如果撤销的订单距离最晚订单执行时间不足6个小时，扣除信用值
				UserController user=new UserController();
				isCreditChange=user.changeCredit(order.getPersonname(), -(order.getOrderprice()/2));
			}

			return isReverse&&isCreditChange;
		}else{
			return false;
		}
	}

	/**
	 * 执行订单，将订单状态变为已执行并且增加客户信用值
	 * @param order
	 * @return boolean
	 * @throws RemoteException 
	 */
	public boolean finishOrder(OrderVO order) throws RemoteException {
		//将订单状态变为已执行
		order.setExecutetime(Calendar.getInstance());
		order.setOrderstate("alreadyExecute");
		OrderPO orderPO=new OrderPO(order);
		orderDataService.modify(orderPO);
		//增加客户信用值
		UserController user=new UserController();
		return user.changeCredit(order.getPersonname(), order.getOrderprice());
	}

	/**
	 * 生成订单，持久化保存订单信息
	 * @param order
	 * @return boolean
	 */
	public boolean createOrder(OrderVO order) {
		UserController user=new UserController();
		if(user.getPersonInfo(order.getPersonname()).getCredit()<0){//如果客户的信用值小于0，用户不能生成订单
			return false;
		}
		OrderPO orderPO=new OrderPO(order);
		orderDataService.add(orderPO);
		return true;
	}

	/**
	 * 查看个人订单，根据用户名返回个人订单列表
	 * @param order
	 * @return List<OrderVO>
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> personOrders(String personname) throws RemoteException {
		ArrayList<OrderPO> personList=orderDataService.personFind(personname);
		ArrayList<OrderVO> personListVO=new ArrayList<OrderVO>();
		for (OrderPO personPO : personList) {
			OrderVO personVO = new OrderVO(personPO);
			personListVO.add(personVO);
		}
		return personListVO;
	}

	/**
	 * 酒店工作人员浏览酒店订单，根据酒店名称返回酒店订单列表
	 * @param order
	 * @return List<OrderVO>
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> hotelOrders(String hotelname) throws RemoteException {
		ArrayList<OrderPO> hotelList=orderDataService.hotelFind(hotelname);
		ArrayList<OrderVO> hotelListVO=new ArrayList<OrderVO>();
		for (OrderPO hotelPO : hotelList) {
			OrderVO hotelVO = new OrderVO(hotelPO);
			hotelListVO.add(hotelVO);
		}
		return hotelListVO;
	}

	/**
	 * 网站营销人员浏览网站订单，返回网站未执行和异常订单列表
	 * @param order
	 * @return List<OrderVO>
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> netOrders() throws RemoteException {
		ArrayList<OrderPO> netList=orderDataService.exceptionFind();
		ArrayList<OrderVO> netListVO=new ArrayList<OrderVO>();
		for (OrderPO netPO : netList) {
			OrderVO netVO = new OrderVO(netPO);
			netListVO.add(netVO);
		}
		return netListVO;
	}

	/**
	 * 在个人订单查看过程中，进一步查看某个状态（未执行，已执行，已撤销，异常）的订单
	 * @param time
	 * @return
	 */
	public ArrayList<OrderVO> personStateOrders(String personname, String state){
		Order order=new Order();
		ArrayList<OrderVO> personStateList=new ArrayList<OrderVO>();
		try {
			personStateList = order.personOrders(personname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<personStateList.size(); i++){
			if(!(personStateList.get(i).getOrderstate().equals(state))){
				personStateList.remove(i);
			}
		}
		return personStateList;
	}
	
	/**
	 * 在酒店订单查看过程中，进一步查看某日的订单
	 * @param time 格式举例：    20160321
	 * @return
	 */
	public ArrayList<OrderVO> hotelStateOrders(String hotelname, String state){
		ArrayList<OrderVO> hotelStateList=new ArrayList<OrderVO>();
		try {
			hotelStateList.addAll(hotelOrders(hotelname));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<hotelStateList.size(); i++){
			if(!(hotelStateList.get(i).equals(state))){
				hotelStateList.remove(i);
			}
		}
		return hotelStateList;
	}
	
	/**
	 * 在浏览网站订单的过程中，进一步查看某个编号的订单
	 * @param date
	 * @return
	 */
	public ArrayList<OrderVO> netNumOrders(Calendar date){
		ArrayList<OrderVO> netNumList=new ArrayList<OrderVO>();
		try {
			netNumList.addAll(netOrders());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<netNumList.size(); i++){
			OrderVO ordervo=netNumList.get(i);
//			OrderVO ordervo=new OrderVO();
			if((ordervo.getProducttime().getTime().getYear()!=date.getTime().getYear())
					||(ordervo.getProducttime().getTime().getMonth()!=date.getTime().getMonth())
					||(ordervo.getProducttime().getTime().getDate()!=date.getTime().getDate())){
				netNumList.remove(i);
			}
		}
		return netNumList;
	}
}


