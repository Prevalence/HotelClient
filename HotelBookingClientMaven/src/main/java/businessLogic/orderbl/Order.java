package businessLogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import businessLogic.userbl.UserController;
import po.OrderPO;
import rmi.RemoteHelper;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.orderVO.orderblVO.OrderVO;
import vo.personVO.PersonVO;
import dataService.orderDataService.OrderDataService;
import businessLogic.TimeFormTrans;
import businessLogic.hotelbl.HotelController;
import businessLogic.promotionbl.PriceCalc;

/**
 * 
 * @author 谢铠联
 * @author 武秀峰
 *
 */
public class Order{
	
	private OrderDataService orderDataService;
	
	/**
	 * 构造方法
	 */
	public Order(){
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
		order.setOrderstate("已执行");//此步将异常订单变为已执行
		OrderPO orderpo=new OrderPO(order);
		orderpo.setExecutetime(Calendar.getInstance());
		boolean orderChange=orderDataService.modify(orderpo);
		//恢复信用值
		UserController user=new UserController();
		int credit=percentOfCredit* order.getOrderprice() /2;
		boolean creditChange=user.changeCredit(order.getPersonname(), credit);
		return orderChange&&creditChange;
	}

	/**
	 * 撤销订单，将订单状态变为已撤销，根据撤销时间减少客户信用值
	 * @param order 订单信息
	 * @return boolean 是否撤销成功
	 * @throws RemoteException 
	 */
	public boolean reverseOrder(OrderVO order) throws RemoteException {
		if(order.getOrderstate().equals("未执行")){//当订单是未执行订单时，进行操作；否则报错
			//撤销订单
			TimeFormTrans t=new TimeFormTrans();
			String cancleTime=t.myToString(Calendar.getInstance());
			order.setCanceltime(cancleTime);
			order.setOrderstate("已撤销");
			OrderPO orderPO=new OrderPO(order);
			orderPO.setCanceltime(Calendar.getInstance());
			boolean isReverse=orderDataService.modify(orderPO);
			//减少客户信用值
			boolean isCreditChange=true;
			Calendar executeTime=t.myToCalendar(order.getPredictExecutetime());
			if(Calendar.getInstance().compareTo(executeTime)<6*60*60*1000){//如果撤销的订单距离最晚订单执行时间不足6个小时，扣除信用值
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
	 * @return boolean 是否执行成功
	 * @throws RemoteException 
	 */
	public boolean finishOrder(OrderVO order) throws RemoteException {
		//将订单状态变为已执行
		TimeFormTrans t=new TimeFormTrans();
		String executeTime=t.myToString(Calendar.getInstance());
		order.setExecutetime(executeTime);
		order.setOrderstate("已执行");
		OrderPO orderPO=new OrderPO(order);
		boolean orderChange=orderDataService.modify(orderPO);
		//增加客户信用值
		UserController user=new UserController();
		boolean creditChange=user.changeCredit(order.getPersonname(), order.getOrderprice());
		return orderChange&&creditChange;
	}

	/**
	 * 生成订单，持久化保存订单信息
	 * @param order
	 * @return boolean 是否成功生成订单
	 * @throws RemoteException 
	 */
	public boolean createOrder(OrderVO order) throws RemoteException {
		UserController user=new UserController();
		if(user.getPersonInfo(order.getPersonname()).getCredit()<0){//如果客户的信用值小于0，用户不能生成订单
			return false;
		}
		OrderPO orderPO=new OrderPO(order);
		//orderID共20位，时间201602020512（4年2月2日2时2分）+酒店ID（5位）+客户ID(5位)
		String hotelname=order.getHotelname();
		HotelController hotel=new HotelController();
		HotelVO hotelvo=hotel.getHotelInfoByHotelworkerOrManager(hotelname);
		String hotelID=Integer.toString(hotelvo.getHotelID());
		int hotelIDLength=hotelID.length();
		for(int i=0;i<5-hotelIDLength;i++){
			hotelID="0"+hotelID;
		}
		
		String personname=order.getPersonname();
		UserController usercontroller=new UserController();
		PersonVO personvo= usercontroller.getPersonInfo(personname);
		String personID=Integer.toString(personvo.getPersonID());
		int personIDLength=personID.length();
		for(int i=0;i<5-personIDLength;i++){
			personID="0"+personID;
		}
		
		Calendar calendar=Calendar.getInstance();
		TimeFormTrans t=new TimeFormTrans();
		String time=t.myToString(calendar);
		String year=time.substring(0, 4);
		String month=time.substring(5, 7);
		String date=time.substring(8, 10);
		String hour=time.substring(11, 13);
		String minute=time.substring(14, 16);
		time=year+month+date+hour+minute;
		String orderID=time+hotelID+personID;
		orderPO.setOrderID(orderID);//确定好了20位的酒店ID
		
		PriceCalc priceCalc=new PriceCalc();
		int orderprice=(int)(priceCalc.priceCut(hotelvo, order));
		orderPO.setOrderprice(orderprice);//确定订单价格，已经用了促销策略
		
		orderPO.setProducttime(calendar);
		
		return orderDataService.add(orderPO);
	}

	/**
	 * 查看个人订单，根据用户名返回个人订单列表
	 * @param personname
	 * @return ArrayList<OrderVO> 订单列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> personOrders(String personname) throws RemoteException {
		ArrayList<OrderPO> personList=orderDataService.personFind(personname);
		ArrayList<OrderVO> personListVO=new ArrayList<OrderVO>();
		if(personList!=null){
			for(int i=0; i<personList.size(); i++){
				OrderVO ordervo=new OrderVO(personList.get(i));
				personListVO.add(ordervo);
			}
		}
		return personListVO;
	}

	/**
	 * 酒店工作人员浏览酒店订单，根据酒店名称返回酒店订单列表
	 * @param hotelname
	 * @return ArrayList<OrderVO> 订单列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> hotelOrders(String hotelname) throws RemoteException {
		ArrayList<OrderPO> hotelList=orderDataService.hotelFind(hotelname);
		ArrayList<OrderVO> hotelListVO=new ArrayList<OrderVO>();
		if(hotelList!=null){
			for (OrderPO hotelPO : hotelList) {
				OrderVO hotelVO = new OrderVO(hotelPO);
				hotelListVO.add(hotelVO);
			}	
		}
		return hotelListVO;
	}

	/**
	 * 网站营销人员浏览网站订单，返回网站未执行和异常订单列表
	 * @param  无参数
	 * @return ArrayList<OrderVO> 网站订单列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> netOrders() throws RemoteException {
		ArrayList<OrderPO> netList=orderDataService.exceptionFind();
		ArrayList<OrderVO> netListVO=new ArrayList<OrderVO>();
		if(netList!=null){
			for (OrderPO netPO : netList) {
				OrderVO netVO = new OrderVO(netPO);
				netListVO.add(netVO);
			}			
		}

		return netListVO;
	}

	/**
	 * 在个人订单查看过程中，进一步查看某个状态（未执行，已执行，已撤销，异常，异常）的订单
	 * @param personname
	 * @param 订单状态，分为“未执行”、“已执行”、“已撤销”、“异常”、“延期”
	 * @return 符合条件的订单列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> personStateOrders(String personname, String state)throws RemoteException{
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
				i--;
			}
		}
		return personStateList;
	}
	
	/**
	 * 在酒店订单查看过程中，进一步查看某状态订单
	 * @param hotelname
	 * @param state 订单状态,“未执行”、“已执行”、“已撤销”、“异常”、“延期”
	 * @return ArrayList<OrderVO> 订单列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> hotelStateOrders(String hotelname, String state)throws RemoteException{
		ArrayList<OrderVO> hotelStateList=new ArrayList<OrderVO>();
		try {
			hotelStateList.addAll(hotelOrders(hotelname));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<hotelStateList.size(); i++){
			if(!hotelStateList.get(i).getOrderstate().equals(state)){
				hotelStateList.remove(i);
				i--;
			}
		}
		System.out.println("size:::"+hotelStateList.size());
		return hotelStateList;
	}
	
	/**
	 * 在浏览网站订单的过程中，进一步查看某日订单
	 * @param date1 需要精确到年月日，格式“2016-02-02”
	 * @return ArrayList<OrderVO> 订单列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> netNumOrders(String date1)throws RemoteException{
		if(date1.length()!=10){
			return null;
		}
		TimeFormTrans t=new TimeFormTrans();
		Calendar date=t.myToCalendar(date1+" 00:00:00");
		ArrayList<OrderVO> netNumList=new ArrayList<OrderVO>();
		try {
			netNumList.addAll(netOrders());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<netNumList.size(); i++){
			OrderVO ordervo=netNumList.get(i);
			Calendar producttime=t.myToCalendar(ordervo.getProducttime());
			boolean isYearEqual=((producttime.get(Calendar.YEAR))
					==(date.get(Calendar.YEAR)));
			boolean isMonthEqual=((producttime.get(Calendar.MONTH))
					==(date.get(Calendar.MONTH)));
			boolean isDateEqual=((producttime.get(Calendar.DATE))
					==(date.get(Calendar.DATE)));
			if(!(isYearEqual&&isMonthEqual&&isDateEqual)){//只要三个钟有一个不等
				netNumList.remove(i);
				i--;
			}
			
		}
		return netNumList;
	}
	
	/**
	 * 根据订单ID返回订单详细信息
	 * @param orderID
	 * @return
	 */
	public OrderVO getOrderInfo(String orderID) throws RemoteException{
		// TODO Auto-generated method stub
		if(orderDataService.getOrderInfo(orderID)!=null){
			OrderPO orderpo=orderDataService.getOrderInfo(orderID);
			OrderVO ordervo=new OrderVO(orderpo);
			return ordervo;
		}else{
			return null;
		}
		
	}
	
	/**
	 * 酒店工作人员改变订单状态
	 * @param orderID
	 * @param newState
	 * @return 是否修改成功
	 */
	public boolean changeOrderState(String orderID, String newState)  throws RemoteException{
		// TODO Auto-generated method stub
		OrderController oc=new OrderController();
		if(oc.getOrderInfo(orderID)!=null){
			OrderVO ordervo=oc.getOrderInfo(orderID);
			ordervo.setOrderstate(newState);
			OrderPO orderpo=new OrderPO(ordervo);
			return orderDataService.modify(orderpo);
		}else{
			return false;
		}
		
	}
	
}


