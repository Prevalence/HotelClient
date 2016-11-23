package businessLogic.searchbl;

import static org.junit.Assert.assertEquals;

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

public class TestSearchController {
	SearchController sc=new SearchController();
	
	@Test
	public void testFindHotel() {
		HotelPO hotelReq=new HotelPO(null, -1, null, null, null, "商圈2", null, null, null, null, null);
		HotelPO hotelpo2=new HotelPO("南京大酒店2", 5, "高级酒店", null, "仙林168号", "商圈2", null, null, null, null, "小李");
		HotelPO hotelpo3=new HotelPO("南京大酒店3", 5, "高级酒店", null, "仙林168号", "商圈2", null, null, null, null, "小李");
		ArrayList<HotelPO> result=new ArrayList<HotelPO>();
		result.add(hotelpo2);
		result.add(hotelpo3);
		assertEquals("南京大酒店2",sc.findHotel(hotelReq).get(0).getHotelName());
		assertEquals("南京大酒店3",sc.findHotel(hotelReq).get(1).getHotelName());
		
	}
	
	@Test
	public void TestSearchPersonInfo(){
		PersonPO pp1=new PersonPO();
		PersonPO pp2=new PersonPO();
		pp1.setuserName("xiamutian");
		pp2.setuserName("xiekailian");
		pp1.setCredit(1000);
		pp2.setCredit(900);
		assertEquals(null,sc.searchPersonInfo("wuxiufeng"));
		assertEquals(pp1.getCredit(),sc.searchPersonInfo("xiamutian").getCredit());
		assertEquals(pp2.getCredit(),sc.searchPersonInfo("xiekailian").getCredit());
	}
	
	@Test
	public void TestSearchHotelWorkerInfo(){
		assertEquals("123456",sc.searchHotelWorkerInfo("大酒店").getPassword());
		assertEquals("XIAMUTIAN",sc.searchHotelWorkerInfo("大酒店").getUsername());
	}

	@Test
	public void TestMarketInfo(){
		assertEquals("123",sc.searchMarketInfo("xiamutian").getPassword());
		assertEquals("456",sc.searchMarketInfo("xiekailian").getPassword());
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
