package businessLogic.searchbl;

import static org.junit.Assert.*;


import org.junit.Test;

import businessLogic.searchbl.SearchController;
import rmi.ClientRunner;
import vo.SearchVO;

public class TestSearchController {
	ClientRunner cr=new ClientRunner();
	SearchController sc=new SearchController();
	
	//因为我电脑不能运行服务器的hotel模块，而此方法需要hotel模块，所以不能写测试用例
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
	}
	
	@Test
	public void TestSearchHotelWorkerInfo(){
		assertEquals("123",sc.searchHotelWorkerInfo("xiamutian").getPassword());
		assertEquals("南京大酒店",sc.searchHotelWorkerInfo("xiamutian").getHotelName());
	}

	@Test
	public void TestMarketInfo(){
		assertEquals("123", sc.searchMarketInfo("xiamutian").getPassword());
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
		SearchVO s=new SearchVO("wuxiufeng", null, "酒店5");
		assertEquals(true,sc.saveHistory(s));
	}
	
	@Test
	public void TestDeleteHistory(){
		SearchVO s=new SearchVO("wuxiufeng", null, "酒店5");
		assertEquals(true,sc.deleteHistory(s));
	}



	
	

}
