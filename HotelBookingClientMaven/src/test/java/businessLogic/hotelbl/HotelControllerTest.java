package businessLogic.hotelbl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businessLogic.hotelbl.HotelController;
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
		assertEquals(null, hotel.showHotelInfo("北京大酒店"));
	}

	@Test
	public void testModifyHotelInfo() {
		HotelVO hotelinfo=new HotelVO();
//		hotelinfo.setCircle("新街口");
//		assertEquals(true,hotel.modifyHotelInfo(hotelinfo));
//		hotelinfo=null;
		assertEquals(false, hotel.modifyHotelInfo(hotelinfo));
	}

	@Test
	public void testAddComment() {
		assertEquals(false, hotel.addComment("很好", "小李", "饭店"));
	}

	@Test
	public void testRoomModify() {
		assertEquals(false, hotel.roomModify(null,7));
		assertEquals(false, hotel.roomModify("单人房", 0));
	}

	@Test
	public void testFindWithReq() {
		assertNull(hotel.findWithReq(null, null));
	}

}
