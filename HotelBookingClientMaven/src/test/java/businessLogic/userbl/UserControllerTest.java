package businessLogic.userbl;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import rmi.ClientRunner;
import vo.HotelWorkerVO;
import vo.MarketVO;
import vo.personVO.PersonVO;

public class UserControllerTest {
	ClientRunner cr=new ClientRunner();
	UserController uc=new UserController();
//	PersonVO personvo=new PersonVO(String username, String password, int personID, int credit, Calendar birthday, String vipType,
//			int vipLevel, String enterpriseName, String phoneNumber);

	PersonVO personvo1=new PersonVO("xiamutian", "123", 12345, 3000, null, "enterprise",
			3, "南京大学", "11122223333");
	PersonVO personvo2=new PersonVO("wuxiufeng", "123", 23456, 2000, null, "no",
			2, null, "22233334444");

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRegister() {
		assertEquals(true,uc.register(personvo1));
		assertEquals(false,uc.register(personvo2));
	}

	@Test
	public void testPersonSave() {
		assertEquals(false,uc.personSave(personvo2));
	}

	@Test
	public void testMarketSave() {
		assertEquals(false,uc.personSave(personvo2));
	}

	@Test
	public void testHotelWorkerSave() {
		assertEquals(false,uc.personSave(personvo2));
	}

//	@Test
//	public void testChangeCredit() {
//		assertEquals(true,uc.changeCredit("wuxiufeng", 100));
//		assertEquals(true,uc.changeCredit("xiamutian", 100));
//	}

	@Test
	public void testRegisteMember() throws ParseException {
		assertEquals(true,uc.registeMember(personvo2, "enterprise", "nju"));
	}

	@Test
	public void testGetPersonInfo() {
		assertEquals("南京大学",uc.getPersonInfo("xiamutian").getEnterpriseName());
	}

	@Test
	public void testGetHotelWorkerInfo() {
		assertEquals("南京大酒店",uc.getHotelWorkerInfo("xiamutian").getHotelName());
	}

	@Test
	public void testUserLogin() {
		assertEquals(true, uc.userLogin("xiamutian", "123", "person"));
		assertEquals(true, uc.userLogin("xiamutian", "123", "manager"));
		assertEquals(true, uc.userLogin("xiamutian", "123", "market"));
		assertEquals(true, uc.userLogin("xiamutian", "123", "hotelworker"));
		assertEquals(false, uc.userLogin("xiamutian", "789", "person"));
	}

	@Test
	public void testMarketAdd() {
		MarketVO marketvo1=new MarketVO("xiamutian", "123456");
		assertEquals(true, uc.marketAdd(marketvo1));
		
		MarketVO marketvo2=new MarketVO("wuxiufeng", "123456");
		assertEquals(false, uc.marketAdd(marketvo2));
	}

	@Test
	public void testHotelWorkerAdd() {
		HotelWorkerVO hotelworkervo=new HotelWorkerVO("xiamutian", "123", "酒店1");
		assertEquals(true, uc.hotelWorkerAdd(hotelworkervo));
	}

	@Test
	public void testGetMarketInfo() {
		MarketVO marketvo=new MarketVO("xiamutian", "123");
		assertEquals(true, uc.marketAdd(marketvo));
	}

}
