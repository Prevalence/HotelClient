package businessLogic.userbl;

import static org.junit.Assert.*;

import org.junit.Test;

import po.PersonPO;

public class TestUserController {
	UserController uc=new UserController();

	@Test
	public void testGetPersonInfo() {
		assertEquals(5000,uc.getPersonInfo("xiamutian").getCredit());
		assertEquals("企业会员",uc.getPersonInfo("xiamutian").getVipType());
		assertEquals(5,uc.getPersonInfo("xiamutian").getVipLevel());
	}
	
	@Test
	public void testUserLogin() {
		assertEquals(true,uc.userLogin("xiamutian", "123", "person"));
		assertEquals(false,uc.userLogin("xiamutian", "456", "person"));
	}

	@Test
	public void testGetHotelWorkerInfo() {
		assertEquals("南京大酒店",uc.getHotelWorkerInfo("xiamutian").getHotelname());
		assertEquals(null,uc.getHotelWorkerInfo("wuxiufeng"));
	}

	@Test
	public void testUserLonin() {
		assertEquals(true,uc.userLogin("xiamutian", "123", "person"));
		assertEquals(false,uc.userLogin("xiamutian", "456", "person"));
		assertEquals(true,uc.userLogin("wuxiufeng", "123", "hotelworker"));

	}

	@Test
	public void testGetMarketInfo() {
		assertEquals("123",uc.getMarketInfo("xiamutian").getPassword());
	}

}
