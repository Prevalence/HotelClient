package businessLogic.promotion;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businessLogic.promotionbl.PromotionController;
import po.PromotionPO;
import po.promotionpo.hotelpromotionPO.BirthdayHotelproPO;
import rmi.ClientRunner;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.orderVO.orderblVO.OrderVO;
import vo.promotionvo.PromotionVO;
import vo.promotionvo.hotelpromotionVO.BirthdayHotelproVO;
import vo.promotionvo.hotelpromotionVO.EnterpriseHotelproVO;

public class PromotionControllerTest {
	ClientRunner cr=new ClientRunner();
	
	PromotionController promotioncontroller=new PromotionController();

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testPriceCut() {
		/**
		 * 	public HotelVO(int hotelID, String hotelname, int star, String feature, ArrayList<Boolean> service, String address,
			String circle, double score, ArrayList<RoomVO> room, ArrayList<CommentVO> comment, String hotelworker)
			
			public RoomVO(String roomType, String roomnum, int roomPrice, ArrayList<Calendar> checkInTime,
			ArrayList<Calendar> checkOutTime)
			
			public OrderVO(String orderID, int orderprice, String orderstate, String hotelname, ArrayList<RoomVO> room,
			String personname, String realname, int peoplenum, int childnum, Calendar producttime, Calendar executetime,
			Calendar canceltime, Calendar latestExecutetime, Calendar predictLeaveTime, Calendar actualLeaveTime)
		 */

		RoomVO room1=new RoomVO("标准单人间", "111", 200, null, null);
		RoomVO room2=new RoomVO("双人间", "222", 400, null, null);
		RoomVO room3=new RoomVO("豪华单人间", "333", 300, null, null);
		ArrayList<RoomVO> hotelRooms=new ArrayList<RoomVO>();
		hotelRooms.add(room1);
		hotelRooms.add(room2);
		hotelRooms.add(room3);
		ArrayList<RoomVO> orderRooms=new ArrayList<RoomVO>();
		orderRooms.add(room2);
		orderRooms.add(room3);
		
		HotelVO hotel=new HotelVO(12345, "南京大酒店", 5, "五星级", null, "仙林大道", 
				"仙林大学城", 4.8, hotelRooms, null, "xiamutian", null);
		
		OrderVO order=new OrderVO("2016020205121234512345", 700, "nonExecute", "南京大酒店", orderRooms,
				0, "xiamutian","xiamutian", null, 3, 0, null, null,
				null, null, null, null);
		
		/*因此获得的person的viplevel是5级，得到7折*/
		assertEquals(490.0,promotioncontroller.priceCut(hotel,order), 0.0);
	}


	@Test
	public void testGetProm() {
		assertEquals(2, promotioncontroller.getProm("酒店").size());
		assertEquals("hotelPro1", promotioncontroller.getProm("酒店").get(0).getPromotionName());
		assertEquals(1, promotioncontroller.getProm("WebPromotion").size());
		
		
		//另外加的
		ArrayList<String> enterprise=new ArrayList<String>();
		enterprise.add("南京大学");
		enterprise.add("企业2");
		enterprise.add("企业3");
		/*public EnterpriseHotelproPO(String promotionID, String promotionName, String promotionType,
			String hotelnameOrWeb, ArrayList<String> enterprise, int discount)*/
		PromotionVO hotelPro=new EnterpriseHotelproVO();
		PromotionPO t=(hotelPro).toPO(hotelPro);
		System.out.println(t.getHotelnameOrWeb());//应为“酒店1”
	}

	@Test
	public void testAddProm() {
		PromotionVO prom=new BirthdayHotelproVO(123, "生日折扣","BirthdayHotelPromtion",
				"南京大酒店", 500);
		
		BirthdayHotelproPO po=new BirthdayHotelproPO();
		po.setPromotionID(prom.getPromotionID());
		po.setPromotionName(prom.getPromotionName());
		po.setPromotionType(prom.getPromotionType());
		po.setHotelnameOrWeb(prom.getHotelnameOrWeb());
		po.setDiscount(prom.getDiscount());
		PromotionPO po1=((BirthdayHotelproVO)prom).toPO((BirthdayHotelproVO)prom);
	
		
		PromotionVO vo=new PromotionVO();
		vo.setPromotionName("生日折扣");
		vo.setPromotionType("111");
		assertEquals(false, promotioncontroller.addProm(vo));
		assertEquals(true, promotioncontroller.addProm(vo));
		
		
		assertEquals("生日折扣",po.getPromotionName());
		assertEquals("生日折扣",po.getPromotionName());
		assertEquals(500,po.getDiscount());
		
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

