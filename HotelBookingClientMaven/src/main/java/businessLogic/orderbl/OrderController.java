package businessLogic.orderbl;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import businessLogicService.orderblService.OrderblService;
import vo.OrderVO;
public class OrderController implements OrderblService{
	Order order1;
	public OrderController(){
		order1=new Order();
	}
	public boolean handleAbnormalOrder(OrderVO order, int percentOfCredit) {
		 try {
			return order1.handleAbnormalOrder(order,percentOfCredit);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean reverseOrder(OrderVO order) {
		try {
			return order1.reverseOrder(order);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean finishOrder(OrderVO order) {
		try {
			return order1.finishOrder(order);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean createOrder(OrderVO order) {
		return order1.createOrder(order);
	}

	public ArrayList<OrderVO> personOrders(String personname) {
		try {
			return order1.personOrders(personname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<OrderVO> hotelOrders(String hotelname) {
		try {
			return order1.hotelOrders(hotelname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<OrderVO> netOrders() {
		try {
			return order1.netOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<OrderVO> personStateOrders(String personname, String state){
		return order1.personStateOrders(personname, state);
		
	}
	
	public ArrayList<OrderVO> hotelStateOrders(String hotelname, String state){
		return order1.hotelStateOrders(hotelname, state);
		
	}
	
	public ArrayList<OrderVO> netNumOrders(Calendar date){
		return order1.netNumOrders(date);
		
	}

}


