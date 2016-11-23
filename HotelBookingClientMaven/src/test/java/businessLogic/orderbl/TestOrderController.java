package businessLogic.orderbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import po.OrderPO;

public class TestOrderController {
	OrderController oc=new OrderController();
	@Test
	public void testPersonOrders() {
		assertEquals("1",oc.personOrders("xiekailian").get(0).getID());
	}
	
	@Test
	public void testHotelOrders() {
		assertEquals("xiekailian",oc.hotelOrders("nju").get(0).getPersonname());
		assertEquals("xiamutian",oc.hotelOrders("nju").get(1).getPersonname());
	}
	
	@Test
	public void testNetOrders() {
		assertEquals("xiekailian",oc.netOrders().get(0).getPersonname());
		assertEquals("xiamutian",oc.netOrders().get(1).getPersonname());
		assertEquals("xiekaihang",oc.netOrders().get(2).getPersonname());
	}
	
	@Test
	public void testPersonStateOrders() {
		assertNotNull(oc.personOrders("xiekailian"));
		assertEquals("nju",oc.personStateOrders(0).get(0).getHotelname());
	}
	
	@Test
	public void testHotelTimeOrders() {
		assertNotNull(oc.hotelOrders("nju"));
		assertEquals("xiamutian",oc.hotelTimeOrders("10/2").get(0).getPersonname());
	}
	
	@Test
	public void testnetNumOrders() {
		assertNotNull(oc.netOrders());
		assertEquals("xiekaihang",oc.netNumOrders("3").get(0).getPersonname());
	}
}
