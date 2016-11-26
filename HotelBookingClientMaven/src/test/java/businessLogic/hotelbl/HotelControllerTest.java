package businessLogic.hotelbl;

import static org.junit.Assert.*;

import org.junit.Test;

import businessLogic.hotelbl.HotelController;
import vo.HotelVO;

public class HotelControllerTest {
	HotelController hotel=new HotelController();
	@Test
	public void testshowHotelInfo() throws Exception {
		assertEquals(null, hotel.showHotelInfo("北京大酒店"));
	}
//	@Test
//	public void testmodifyHotelInfo() throws Exception {
//		HotelVO hotelinfo=new HotelVO();
//		hotelinfo.setCircle("新街口");
//		assertEquals(true,hotel.modifyHotelInfo(hotelinfo));
//		hotelinfo=null;
//		assertEquals(false, hotel.modifyHotelInfo(hotelinfo));
//	}
	@Test
	public void testaddComment() throws Exception {
		assertEquals(false, hotel.addComment("很好", "小李", "饭店"));
	}
	@Test
	public void testroomModify() throws Exception {
		assertEquals(false, hotel.roomModify(null,7));
		assertEquals(false, hotel.roomModify("单人房", 0));
	}

}
