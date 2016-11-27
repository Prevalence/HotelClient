package businessLogic.promotion;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businessLogic.promotionbl.PromotionController;
import po.HotelPO;
import po.PromotionPO;
import rmi.ClientRunner;
import ui.hotelworkerui.promotionuiController.PromotionuiController;
import vo.OrderVO;
import vo.PromotionVO;

public class PromotionControllerTest {
	ClientRunner cr=new ClientRunner();
	
	PromotionController promotioncontroller=new PromotionController();
	PromotionVO prom=new PromotionVO();
	
//	@Test
//	public void testPriceCut() {
//		HotelPO hotel=new HotelPO();
//		ArrayList<Integer> roomprice=new ArrayList<Integer>();
//		ArrayList<String> roomtype=new ArrayList<String>();
//		roomtype.add("单人房");
//		roomtype.add("双人房");
//		roomprice.add(200);
//		roomprice.add(300);
//		hotel.setRoomPrice(roomprice);
//		hotel.setRoomType(roomtype);
//		OrderVO order=new OrderVO();
//		ArrayList<Integer> roomnum=new ArrayList<Integer>();
//		roomnum.add(5);
//		ArrayList<String> roomty=new ArrayList<String>();
//		roomty.add("单人房");
//		order.setRoomnum(roomnum);
//		order.setRoomtype(roomty);
//		assertEquals(400,promotioncontroller.priceCut(hotel,order),0.8);
//	}
//
//	@Test
//	public void testGetProm() {
//		String hotelname="南京大酒店";
//		ArrayList<PromotionPO> a=(ArrayList<PromotionPO>) promotioncontroller.getProm(hotelname);
//		assertEquals(0.6, a.get(0).getDiscount(),0.1);
//	}

//	@Test
//	public void testAddProm() {
//		PromotionVO v=new PromotionVO();
//		v.setDiscount(80);
//		assertEquals(true, promotioncontroller.addProm(v));
//		v.setDiscount(0);
//		assertEquals(false, promotioncontroller.addProm(v));
//	}
//
//	@Test
//	public void testDeleteProm() {
//		PromotionVO v=new PromotionVO();
//		v.setName("打折");;
//		assertEquals(true, promotioncontroller.deleteProm(v));
//		v.setName("促销");;
//		assertEquals(false, promotioncontroller.deleteProm(v));
//	}
//
//	@Test
//	public void testModifyProm() {
//		PromotionVO v=new PromotionVO();
//		v.setDiscount(0.9);
//		assertEquals(true, promotioncontroller.modifyProm(v));
//		v.setDiscount(0);
//		assertEquals(false, promotioncontroller.modifyProm(v));
//	}
	
	
	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void testPriceCut() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetProm() {
		assertEquals(null, promotioncontroller.getProm("酒店1"));
	}

	@Test
	public void testAddProm() {
		assertEquals(false, promotioncontroller.addProm(prom));
	}

	@Test
	public void testDeleteProm() {
		assertEquals(false, promotioncontroller.deleteProm(prom));
	}

	@Test
	public void testModifyProm() {
		assertEquals(false, promotioncontroller.modifyProm(prom));
	}

}
