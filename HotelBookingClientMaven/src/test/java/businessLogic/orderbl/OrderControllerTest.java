package businessLogic.orderbl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.plaf.metal.OceanTheme;

import org.junit.Before;
import org.junit.Test;

import po.OrderPO;
import po.hotelPO.RoomPO;
import rmi.ClientRunner;
import vo.OrderVO;
import vo.hotelVO.hotelblVO.RoomVO;

public class OrderControllerTest {
	ClientRunner cr=new ClientRunner();

	OrderController oc=new OrderController();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHandleAbnormalOrder() {
//		public OrderVO(String orderID, int orderprice, String orderstate, String hotelname, ArrayList<RoomVO> room,
//				String personname, String realname, int peoplenum, int childnum, Calendar producttime, Calendar executetime,
//				Calendar canceltime, Calendar latestExecutetime, Calendar predictLeaveTime, Calendar actualLeaveTime)

//		public RoomVO(String roomType, String roomnum, int roomPrice, ArrayList<Calendar> checkInTime,
//				ArrayList<Calendar> checkOutTime) 
		RoomVO room1=new RoomVO("单人间", "111", 300, null, null);
		RoomVO room2=new RoomVO("双人间", "222", 500, null, null);
		ArrayList<RoomVO> roomList=new ArrayList<RoomVO>();
		roomList.add(room1);
		roomList.add(room2);
		OrderVO order=new OrderVO("2016020205121234512345", 800, "nonExecute", "南京大酒店", roomList,
				"xiamutian","xiamutian", 3, 0, null, null,
				null, null, null, null);
		assertEquals(true,oc.handleAbnormalOrder(order, 2));
	}

	@Test
	public void testReverseOrder() {
		Calendar latestExecutetime=Calendar.getInstance();
		latestExecutetime.set(2016, 11, 29);
		RoomVO room1=new RoomVO("单人间", "111", 300, null, null);
		RoomVO room2=new RoomVO("双人间", "222", 500, null, null);
		ArrayList<RoomVO> roomList=new ArrayList<RoomVO>();
		roomList.add(room1);
		roomList.add(room2);
		OrderVO order=new OrderVO("2016020205121234512345", 800, "nonExecute", "南京大酒店", roomList,
				"xiamutian","xiamutian", 3, 0, null, null,
				null, latestExecutetime, null, null);
		
		assertEquals(true,oc.reverseOrder(order));
	}

	@Test
	public void testFinishOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testPersonOrders() {
		assertEquals("南京大酒店",oc.personOrders("小夏").get(0).getHotelname());
	}

	@Test
	public void testHotelOrders() {
		assertEquals(1,oc.hotelOrders("nju").size());
	}

	@Test
	public void testNetOrders() {
		assertEquals(null,oc.netOrders().get(0).getPersonname());
		assertEquals(null,oc.netOrders().get(1).getPersonname());
	}

	@Test
	public void testPersonStateOrders() {
		assertEquals("南京大酒店",oc.personStateOrders("小夏", "nonExecute").get(0).getHotelname());
	}
	
	@Test
	public void testHotelStateOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testNetNumOrders() {
		fail("Not yet implemented");
	}
	
}


