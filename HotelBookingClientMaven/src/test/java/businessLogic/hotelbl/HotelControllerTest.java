package businessLogic.hotelbl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businessLogic.hotelbl.HotelController;
import po.HotelPO;
import rmi.ClientRunner;
import vo.HotelVO;

public class HotelControllerTest {
	ClientRunner cr=new ClientRunner();
	HotelController hotel=new HotelController();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShowHotelInfo() {
		assertEquals(5, hotel.showHotelInfo("南京大酒店").getStar());
	}

	@Test
	public void testModifyHotelInfo() {
		HotelVO hotelinfo=new HotelVO();
		hotelinfo.setHotelName("南京大酒店");
//		hotelinfo.setCircle("新街口");
//		assertEquals(true,hotel.modifyHotelInfo(hotelinfo));
//		hotelinfo=null;
		assertEquals(true, hotel.modifyHotelInfo(hotelinfo));
	}

	@Test
	public void testAddComment() {
		assertEquals(true, hotel.addComment("很好", "小李", "饭店"));
	}

	@Test
	public void testRoomModify() {
		assertEquals(false, hotel.roomModify(null,7));
		assertEquals(false, hotel.roomModify("单人房", 0));
	}

	@Test
	public void testFindWithReq() {
		HotelVO po=new HotelVO();
		po.setHotelName("111");
		po.setAddress("111");
		po.setCircle("111");
		HotelVO po2=new HotelVO();
		po2.setHotelName("111");
		po2.setAddress("111");
		po2.setCircle("111");
		assertEquals("很好，很棒",hotel.findWithReq(po, po2).get(0).getComment().get(0));
	}

}
