package businessLogic.orderbl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;


import org.junit.Before;
import org.junit.Test;

import rmi.ClientRunner;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.orderVO.orderblVO.OrderVO;

public class OrderControllerTest {
	ClientRunner cr=new ClientRunner();

	OrderController oc=new OrderController();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHandleAbnormalOrder() {
		RoomVO room1=new RoomVO("单人间", "111", 300, null, null);
		RoomVO room2=new RoomVO("双人间", "222", 500, null, null);
		ArrayList<RoomVO> roomList=new ArrayList<RoomVO>();
		roomList.add(room1);
		roomList.add(room2);
		OrderVO order=new OrderVO("2016020205121234512345", 800, "nonExecute", "南京大酒店", roomList,0
				,"xiamutian","","xiamutian", 3, 0, null, null,
				null, null, null, null);
		assertEquals(true,oc.handleAbnormalOrder(order, 2));
	}

	@Test
	public void testReverseOrder() {
		String latestExecutetime="2016-11-29 21:20:00";
		RoomVO room1=new RoomVO("单人间", "111", 300, null, null);
		RoomVO room2=new RoomVO("双人间", "222", 500, null, null);
		ArrayList<RoomVO> roomList=new ArrayList<RoomVO>();
		roomList.add(room1);
		roomList.add(room2);
		OrderVO order=new OrderVO("2016020205121234512345", 800, "nonExecute", "南京大酒店", roomList,
				0, "xiamutian","xiamutian", latestExecutetime, 3, 0, null, null,
				null, latestExecutetime, null, null);
		
		assertEquals(true,oc.reverseOrder(order));
	}

	@Test
	public void testFinishOrder() {
		String latestExecutetime="2016-11-29 21:20:00";
		RoomVO room1=new RoomVO("单人间", "111", 300, null, null);
		RoomVO room2=new RoomVO("双人间", "222", 500, null, null);
		ArrayList<RoomVO> roomList=new ArrayList<RoomVO>();
		roomList.add(room1);
		roomList.add(room2);
		OrderVO order=new OrderVO("2016020205121234512345", 800, "nonExecute", "南京大酒店", roomList,
				0, "xiamutian","xiamutian", latestExecutetime, 3, 0, null, null,
				null, latestExecutetime, null, null);
		
		assertEquals(true,oc.finishOrder(order));
	}

	@Test
	public void testCreateOrder() {
		String latestExecutetime="2016-11-29 21:20:00";
		RoomVO room1=new RoomVO("单人间", "111", 300, null, null);
		RoomVO room2=new RoomVO("双人间", "222", 500, null, null);
		ArrayList<RoomVO> roomList=new ArrayList<RoomVO>();
		roomList.add(room1);
		roomList.add(room2);
		OrderVO order=new OrderVO("2016020205121234512345", 800, "nonExecute", "南京大酒店", roomList,
				0, "xiamutian","xiamutian", latestExecutetime, 3, 0, null, null,
				null, latestExecutetime, null, null);
		
		assertEquals(true,oc.createOrder(order));
	}

	@Test
	public void testPersonOrders() {
		assertEquals("南京大酒店",oc.personOrders("小夏").get(0).getHotelname());
		assertEquals("nonExecute",oc.personOrders("小夏").get(0).getOrderstate());
		assertEquals("nonExecute",oc.personOrders("小夏").get(1).getOrderstate());
		
	}

	@Test
	public void testHotelOrders() {
		assertEquals(1,oc.hotelOrders("nju").size());
	}

	@Test
	public void testNetOrders() {
		assertEquals("未执行",oc.netOrders().get(0).getOrderstate());
		assertEquals(3,oc.netOrders().size());
	}

	@Test
	public void testPersonStateOrders() {
		assertEquals("南京大酒店",oc.personStateOrders("小夏", "nonExecute").get(0).getHotelname());
		assertEquals(2,oc.personStateOrders("小夏", "nonExecute").size());
	}
	
	@Test
	public void testHotelStateOrders() {
		assertEquals(0,oc.hotelStateOrders("nju", "nonExecute").size());
	}

	@Test
	public void testNetNumOrders() {
		String date="2016-11-21";
		assertEquals(3,oc.netNumOrders(date).size());
	}
	
}


