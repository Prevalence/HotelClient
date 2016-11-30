package businessLogic.searchbl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import businessLogic.searchbl.Search;
import businessLogic.searchbl.SearchController;
import businessLogic.searchbl.SearchHistory;
import po.HotelPO;
import po.HotelWorkerPO;
import po.MarketPO;
import po.PersonPO;
import po.SearchPO;
import rmi.ClientRunner;
import vo.HotelVO;

public class TestSearchController {
	ClientRunner cr=new ClientRunner();
	SearchController sc=new SearchController();
	
//	@Test
//	public void testFindHotel() {
//		HotelVO hotelReq=new HotelVO(null, -1, null, null, null, "商圈2", 0, null, null, null, null, null);
//		HotelVO hotelpo2=new HotelVO("南京大酒店2", 5, "高级酒店", null, "仙林168号", "商圈2", 0, null, null, null, null, "小李");
//		HotelVO hotelpo3=new HotelVO("南京大酒店3", 5, "高级酒店", null, "仙林168号", "商圈2", 0, null, null, null, null, "小李");
//		ArrayList<HotelVO> result=new ArrayList<HotelVO>();
//		result.add(hotelpo2);
//		result.add(hotelpo3);
//		assertEquals("南京大酒店2",sc.findHotel(hotelReq).get(0).getHotelname());
//		assertEquals("南京大酒店3",sc.findHotel(hotelReq).get(1).getHotelname());
//	}
	
	@Test
	public void TestSearchPersonInfo(){
		assertEquals(5000,sc.searchPersonInfo("xiamutian").getCredit());
		assertEquals("南京大学",sc.searchPersonInfo("xiamutian").getEnterpriseName());
//		PersonPO pp1=new PersonPO();
//		PersonPO pp2=new PersonPO();
//		pp1.setUsername("xiamutian");
//		pp2.setUsername("xiekailian");
//		pp1.setCredit(1000);
//		pp2.setCredit(900);
//		assertEquals(null,sc.searchPersonInfo("wuxiufeng"));
//		assertEquals(pp1.getCredit(),sc.searchPersonInfo("xiamutian").getCredit());
//		assertEquals(pp2.getCredit(),sc.searchPersonInfo("xiekailian").getCredit());
	}
	
	@Test
	public void TestSearchHotelWorkerInfo(){
		assertEquals("123",sc.searchHotelWorkerInfo("xiamutian").getPassword());
		assertEquals("南京大酒店",sc.searchHotelWorkerInfo("xiamutian").getHotelname());
	}

	@Test
	public void TestMarketInfo(){
		assertNull(sc.searchMarketInfo("wuxiufeng"));
	}

	@Test
	public void TestShowHistory(){
		assertEquals("酒店1",sc.showHistory("wuxiufeng").get(0).getHotelname());
		assertEquals("酒店2",sc.showHistory("wuxiufeng").get(1).getHotelname());
		assertEquals("酒店3",sc.showHistory("xiekaihang").get(0).getHotelname());
		assertEquals("酒店4",sc.showHistory("xiekailian").get(0).getHotelname());
	}

	@Test
	public void TestSaveHistory(){
		SearchPO s=new SearchPO("wuxiufeng", null, "酒店5");
		assertEquals(true,sc.saveHistory(s));
	}
	
	@Test
	public void TestDeleteHistory(){
		SearchPO s=new SearchPO("wuxiufeng", null, "酒店5");
		assertEquals(true,sc.deleteHistory(s));
	}



	
	

}
