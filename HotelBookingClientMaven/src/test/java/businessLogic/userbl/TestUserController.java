package businessLogic.userbl;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUserController {
	UserController uc=new UserController();







	

	@Test
	public void testGetPersonInfo() {
		assertEquals(1000,uc.getPersonInfo("xiamutian").getCredit());
		assertEquals(900,uc.getPersonInfo("xiekailian").getCredit());
		assertNull(uc.getPersonInfo(""));

	}

	@Test
	public void testGetHotelWorkerInfo() {
		assertEquals("123",uc.getHotelWorkerInfo("xiamutian").getHotelname());
		assertEquals("456",uc.getHotelWorkerInfo("xiekailian").getHotelname());
		

	}

	@Test
	public void testUserLonin() {
		assertEquals(true,uc.userLogin("xiamutian", "123", ""));
		assertEquals(true,uc.userLogin("xiekailian", "456", ""));
		assertEquals(false,uc.userLogin("xiekailian", "123", ""));
		assertEquals(false,uc.userLogin("465465", "123", ""));



	}

	@Test
	public void testGetMarketInfo() {
		assertEquals("123",uc.getMarketInfo("xiamutian").getPassword());
//		assertEquals("456",uc.getMarketInfo("xiekailian").getPassword());
//		assertEquals("456",uc.getMarketInfo("xiamutian").getPassword());


	}

}
