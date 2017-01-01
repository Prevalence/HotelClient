package businessLogic.hotelbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businessLogic.hotelbl.HotelController;
import rmi.ClientRunner;
import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelConditionVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;

public class HotelControllerTest {
	ClientRunner cr=new ClientRunner();
	HotelController hotel=new HotelController();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShowHotelInfo() {
		assertEquals(5, hotel.getHotelInfoByPerson("天津酒店").getStar());
	}

	@Test
	public void testModifyHotelInfo() {
		HotelVO hotelinfo=new HotelVO();
		hotelinfo.setHotelname("南京大酒店");
		hotelinfo.setCircle("新街口");
		assertEquals(true,hotel.modifyHotelInfo(hotelinfo));
		hotelinfo=null;
		assertEquals(true, hotel.modifyHotelInfo(hotelinfo));
	}

	@Test
	public void testAddComment() {
		/*public CommentVO(String hotelname, String personname, 
		 * Calendar time, int score, String content)*/
		CommentVO comment=new CommentVO("南京大酒店","xiamutian", null, 5, "很好");
		assertEquals(true, hotel.addComment(comment));
	}

	@Test
	public void testRoomModify() {
		ArrayList<RoomVO> roomList=new ArrayList<RoomVO>();
		RoomVO room1=new RoomVO();
		room1.setRoomnum("111");
		room1.setRoomPrice(200);
		room1.setRoomType("单人间");
		RoomVO room2=new RoomVO();
		room2.setRoomnum("222");
		room2.setRoomPrice(300);
		room2.setRoomType("双人间");
		roomList.add(room1);
		roomList.add(room2);
		assertEquals(true, hotel.roomModify("南京大酒店", roomList));
	}

	@Test
	public void testFindWithReq() {
		HotelConditionVO po=new HotelConditionVO();
		po.setHotelName("111");
		po.setCircle("111");
		HotelConditionVO po2=new HotelConditionVO();
		po2.setHotelName("111");
		po2.setCircle("111");
		assertEquals("天津酒店",hotel.findWithReq(po, po2).get(0).getHotelName());
	}

}
