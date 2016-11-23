package businessLogic.orderbl;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businessLogicService.orderblService.OrderblService;
import vo.OrderVO;
public class OrderController implements OrderblService{
	Order order1;
	public OrderController(){
		order1=new Order();
	}
	@Override
	public boolean handleAbnormalOrder(OrderVO order, int credit) {
		 try {
			order1.handleAbnormalOrder(order,credit);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean reverseOrder(OrderVO order) {
		try {
			order1.reverseOrder(order);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean finishOrder(OrderVO order) {
		try {
			order1.finishOrder(order);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean createOrder(OrderVO order) {
		order1.createOrder(order);
		return false;
	}

	@Override
	public ArrayList<OrderVO> personOrders(String personname) {
		try {
			return order1.personOrders(personname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<OrderVO> hotelOrders(String hotelname) {
		try {
			return order1.hotelOrders(hotelname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<OrderVO> netOrders() {
		try {
			return order1.netOrders();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<OrderVO> personStateOrders(int state){
		return order1.personStateOrders(state);
		
	}
	
	@Override
	public ArrayList<OrderVO> hotelTimeOrders(String time){
		return order1.hotelTimeOrders(time);
		
	}
	
	@Override
	public ArrayList<OrderVO> netNumOrders(String num){
		return order1.netNumOrders(num);
		
	}
}
