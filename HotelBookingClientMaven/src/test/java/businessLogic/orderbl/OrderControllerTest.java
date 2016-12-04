package businessLogic.orderbl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.plaf.metal.OceanTheme;

import org.junit.Before;
import org.junit.Test;

import po.OrderPO;
import rmi.ClientRunner;
import vo.OrderVO;

public class OrderControllerTest {
	ClientRunner cr=new ClientRunner();

	OrderController oc=new OrderController();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHandleAbnormalOrder() {
//		OrderVO order=new OrderVO(String orderID, int orderprice, String ordernum, String orderstate, String hotelname,
//				ArrayList<String> roomtype, ArrayList<Integer> roomnum, ArrayList<String> theNumOfRoom, String personname,
//				String realname, int peoplenum, int childnum, Calendar producttime, Calendar executetime,
//				Calendar canceltime, Calendar latestExecutetime, Calendar predictLeaveTime, Calendar actualLeaveTime);
		OrderVO order1=new OrderVO(null, 300, null, null, "南京大酒店",
				null, null, null, "xiamutian",
				null, 1, 0, null, null,
				null, null, null, null);
		assertEquals(true,oc.handleAbnormalOrder(order1, 1));
		
		OrderVO order2=new OrderVO(null, 300, null, null, "酒店1",
				null, null, null, "wuxiufeng",
				null, 1, 0, null, null,
				null, null, null, null);
		assertEquals(true,oc.handleAbnormalOrder(order2, 2));
	}

	@Test
	public void testReverseOrder() {
//		OrderVO order=new OrderVO(String orderID, int orderprice, String ordernum, String orderstate, String hotelname,
//		ArrayList<String> roomtype, ArrayList<Integer> roomnum, ArrayList<String> theNumOfRoom, String personname,
//		String realname, int peoplenum, int childnum, Calendar producttime, Calendar executetime,
//		Calendar canceltime, Calendar latestExecutetime, Calendar predictLeaveTime, Calendar actualLeaveTime);
		Calendar latestExecutetime=Calendar.getInstance();
		latestExecutetime.set(2016, 11, 29);
		
		OrderVO order=new OrderVO(null, 300, null, "nonExecute", "酒店1",
				null, null, null, "xiamutian",
				null, 1, 0, null, null,
				null, latestExecutetime, null, null);
		assertEquals(true,oc.reverseOrder(order));
	}

//	@Test
//	public void testFinishOrder() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testCreateOrder() {
//		fail("Not yet implemented");
//	}

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
	
}





//package businessLogic.orderbl;
//
//import static org.junit.Assert.*;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.Calendar;
//
//import javax.swing.plaf.metal.OceanTheme;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import po.OrderPO;
//import rmi.ClientRunner;
//import vo.OrderVO;
//
//public class OrderControllerTest {
//	ClientRunner cr=new ClientRunner();
//
//	OrderController oc=new OrderController();
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@Test
//	public void testHandleAbnormalOrder() {
////		OrderVO order=new OrderVO(String orderID, int orderprice, String ordernum, String orderstate, String hotelname,
////				ArrayList<String> roomtype, ArrayList<Integer> roomnum, ArrayList<String> theNumOfRoom, String personname,
////				String realname, int peoplenum, int childnum, Calendar producttime, Calendar executetime,
////				Calendar canceltime, Calendar latestExecutetime, Calendar predictLeaveTime, Calendar actualLeaveTime);
//		OrderVO order1=new OrderVO(null, 300, null, null, "南京大酒店",
//				null, null, null, "xiamutian",
//				null, 1, 0, null, null,
//				null, null, null, null);
//		assertEquals(true,oc.handleAbnormalOrder(order1, 1));
//		
//		OrderVO order2=new OrderVO(null, 300, null, null, "酒店1",
//				null, null, null, "wuxiufeng",
//				null, 1, 0, null, null,
//				null, null, null, null);
//		assertEquals(true,oc.handleAbnormalOrder(order2, 2));
//	}
//
//	@Test
//	public void testReverseOrder() {
////		OrderVO order=new OrderVO(String orderID, int orderprice, String ordernum, String orderstate, String hotelname,
////		ArrayList<String> roomtype, ArrayList<Integer> roomnum, ArrayList<String> theNumOfRoom, String personname,
////		String realname, int peoplenum, int childnum, Calendar producttime, Calendar executetime,
////		Calendar canceltime, Calendar latestExecutetime, Calendar predictLeaveTime, Calendar actualLeaveTime);
//		Calendar latestExecutetime=Calendar.getInstance();
//		latestExecutetime.set(2016, 11, 29);
//		
//		OrderVO order=new OrderVO(null, 300, null, "nonExecute", "酒店1",
//				null, null, null, "xiamutian",
//				null, 1, 0, null, null,
//				null, latestExecutetime, null, null);
//		assertEquals(true,oc.reverseOrder(order));
//	}
//
////	@Test
////	public void testFinishOrder() {
////		fail("Not yet implemented");
////	}
//
////	@Test
////	public void testCreateOrder() {
////		fail("Not yet implemented");
////	}
//
//	@Test
//	public void testPersonOrders() {
//		assertEquals("南京大酒店",oc.personOrders("小夏").get(0).getHotelname());
//	}
//
//	@Test
//	public void testHotelOrders() {
//		assertEquals(1,oc.hotelOrders("nju").size());
//	}
//
//	@Test
//	public void testNetOrders() {
//		assertEquals(null,oc.netOrders().get(0).getPersonname());
//		assertEquals(null,oc.netOrders().get(1).getPersonname());
//	}
//
//	@Test
//	public void testPersonStateOrders() {
//		assertEquals("南京大酒店",oc.personStateOrders("小夏", "nonExecute").get(0).getHotelname());
//	}
//
////	@Test
////	public void testHotelTimeOrders() {
////		fail("Not yet implemented");
////	}
////
////	@Test
////	public void testNetNumOrders() {
////		fail("Not yet implemented");
////	}
//	
//}
//
//
//
////package businessLogic.orderbl;
////
////import static org.junit.Assert.*;
////
////import java.rmi.RemoteException;
////import java.util.ArrayList;
////import java.util.Calendar;
////
////import javax.swing.plaf.metal.OceanTheme;
////
////import org.junit.Before;
////import org.junit.Test;
////
////import po.OrderPO;
////import rmi.ClientRunner;
////import vo.OrderVO;
////
////public class OrderControllerTest {
////	ClientRunner cr=new ClientRunner();
////
////	OrderController oc=new OrderController();
////
////	@Before
////	public void setUp() throws Exception {
////	}
////
////	@Test
////	public void testHandleAbnormalOrder() {
//////		OrderVO order=new OrderVO(String orderID, int orderprice, String ordernum, String orderstate, String hotelname,
//////				ArrayList<String> roomtype, ArrayList<Integer> roomnum, ArrayList<String> theNumOfRoom, String personname,
//////				String realname, int peoplenum, int childnum, Calendar producttime, Calendar executetime,
//////				Calendar canceltime, Calendar latestExecutetime, Calendar predictLeaveTime, Calendar actualLeaveTime);
////		OrderVO order1=new OrderVO(null, 300, null, null, "南京大酒店",
////				null, null, null, "xiamutian",
////				null, 1, 0, null, null,
////				null, null, null, null);
////		assertEquals(true,oc.handleAbnormalOrder(order1, 1));
////		
////		OrderVO order2=new OrderVO(null, 300, null, null, "酒店1",
////				null, null, null, "wuxiufeng",
////				null, 1, 0, null, null,
////				null, null, null, null);
////		assertEquals(false,oc.handleAbnormalOrder(order2, 2));
////	}
////
////	@Test
////	public void testReverseOrder() {
////		OrderVO order=new OrderVO(null, 300, null, "nonExecute", "酒店1",
////				null, null, null, "wuxiufeng",
////				null, 1, 0, null, null,
////				null, null, null, null);
////		assertEquals(true,oc.reverseOrder(order));
////	}
////
//////	@Test
//////	public void testFinishOrder() {
//////		fail("Not yet implemented");
//////	}
////
//////	@Test
//////	public void testCreateOrder() {
//////		fail("Not yet implemented");
//////	}
////
////	@Test
////	public void testPersonOrders() {
////		assertEquals("南京大酒店",oc.personOrders("小夏").get(0).getHotelname());
////	}
////
////	@Test
////	public void testHotelOrders() {
////		assertEquals(2,oc.hotelOrders("nju").size());
////	}
////
////	@Test
////	public void testNetOrders() {
////		assertEquals(null,oc.netOrders().get(0).getPersonname());
////		assertEquals(null,oc.netOrders().get(1).getPersonname());
////	}
////
////	@Test
////	public void testPersonStateOrders() {
////		assertEquals(null,oc.personStateOrders("nonExecute"));
////	}
////
//////	@Test
//////	public void testHotelTimeOrders() {
//////		fail("Not yet implemented");
//////	}
//////
//////	@Test
//////	public void testNetNumOrders() {
//////		fail("Not yet implemented");
//////	}
////	
////}
