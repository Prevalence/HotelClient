package businessLogic.orderbl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import po.OrderPO;
import vo.OrderVO;

public class TestOrderController {
	OrderController oc=new OrderController();

	@Test
	public void testPersonOrders(String personname) {
		assertEquals(null,oc.personOrders("wuxiufeng"));
	}
	
	@Test
	public void testHotelOrders() {
		assertEquals(null,oc.hotelOrders("nju"));
	}
	
	@Test
	public void testNetOrders() {
		assertEquals(null,oc.netOrders().get(0).getPersonname());
		assertEquals(null,oc.netOrders().get(1).getPersonname());
	}
	
	@Test
	public void testHotelTimeOrders() {
		assertNull(oc.hotelOrders("nju"));
		assertEquals(null,oc.hotelTimeOrders("10/2").get(0).getPersonname());
	}
	
	@Test
	public void testnetNumOrders() {
		assertNull(oc.netOrders());
		assertEquals(null,oc.netNumOrders("3").get(0).getPersonname());
	}
}
