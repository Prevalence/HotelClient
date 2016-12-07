package businessLogic.promotion;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import businessLogic.promotionbl.PromotionController;
import rmi.ClientRunner;
import vo.PromotionVO;

public class PromotionControllerTest {
	ClientRunner cr=new ClientRunner();
	
	PromotionController promotioncontroller=new PromotionController();

	@Before
	public void setUp() throws Exception {
	}
	
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

	@Test
	public void testGetProm() {
		assertEquals(2, promotioncontroller.getProm("酒店1").size());
//		assertEquals("111", promotioncontroller.getProm("酒店1").get(1).getPromotionType());
	}

	@Test
	public void testAddProm() {
//		PromotionVO prom=new BirthdayHotelproVO("123", "生日折扣","BirthdayHotelPromtion",
//				"南京大酒店", 500);
//		System.out.println(prom.getPromotionID());
//		PromotionPO po=prom.toPO(prom);
//		System.out.println(po.getHotelnameOrWeb());
//		System.out.println(po);
		
//		BirthdayHotelproPO po=new BirthdayHotelproPO();
//		po.setPromotionID(vo.getPromotionID());
//		po.setPromotionName(vo.getPromotionName());
//		po.setPromotionType(vo.getPromotionType());
//		po.setHotelnameOrWeb(vo.getHotelnameOrWeb());
//		po.setDiscount(vo.getDiscount());
//		PromotionPO po1=((BirthdayHotelproVO)vo).topo((BirthdayHotelproVO)vo);
//		System.out.println(po1.getPromotionName());
//		System.out.println((((BirthdayHotelproVO)vo).topo((BirthdayHotelproVO)vo)).getHotelnameOrWeb());
//		System.out.println(((BirthdayHotelproPO)po1).getDiscount());
		
		
//		System.out.println(po);
//		PromotionPO po=prom.topo(prom);
//		String promotionID, String promotionName, String promotionType,
//		String hotelnameOrWeb, int discount
		
		PromotionVO vo=new PromotionVO();
		vo.setPromotionName("生日折扣");
		vo.setPromotionType("111");
		assertEquals(false, promotioncontroller.addProm(vo));
//		assertEquals(true, promotioncontroller.addProm(vo));
		
		
//		assertEquals("生日折扣",po.getPromotionName());
//		assertEquals("生日折扣",po.getPromotionName());
//		assertEquals(500,po.getDiscount());
//		System.out.println(new BirthdayHotelproVO("123", "生日折扣","BirthdayHotelPromtion",
//				"南京大酒店", 500).toPO(new BirthdayHotelproVO("123", "生日折扣","BirthdayHotelPromtion",
//				"南京大酒店", 500)).getHotelnameOrWeb());
//		System.out.println(prom.getHotelnameOrWeb());
		
	}

	@Test
	public void testDeleteProm() {
		PromotionVO prom=new PromotionVO();
		assertEquals(false, promotioncontroller.deleteProm(prom));
	}

	@Test
	public void testModifyProm() {
		PromotionVO prom=new PromotionVO();
		assertEquals(false, promotioncontroller.modifyProm(prom));
	}

}

