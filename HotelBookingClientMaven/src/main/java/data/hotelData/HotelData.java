package data.hotelData;

import java.util.ArrayList;
import java.util.List;
import dataService.hotelDataService.HotelDataService;
import po.HotelPO;
import po.SearchPO;

public class HotelData implements HotelDataService{
	private static HotelData hoteldata;
	/**
	 * 
	 * @return 唯一的HotelData对象
	 */
	public static HotelData getInstance(){
		if(hoteldata==null)
			hoteldata=new HotelDataMock();
		return hoteldata;
	}
	public HotelPO showHotelinfo(String Hotelname) {
		HotelPO test;
		if(Hotelname.equals("南京大酒店"))
			test=new HotelPO("南京大酒店", 5, "高级酒店", null, "仙林168号", "仙林大学城", null, null, null, null, Hotelname);
		else
			test=null;
		return test;
	}
	public boolean addComment (String comment,String username,String hotelname){
		boolean result=true;
		if(comment==null||username==null||hotelname==null)
			result=false;
		return result;
		
	}
	public ArrayList<HotelPO> findWithReq(HotelPO a) {
		System.out.println("findWithReq is called");
		return null;
	}
	public boolean modify(HotelPO hotelinfo) {
		boolean result=true;
		if(hotelinfo==null)
			result=false;
		return result;
	}
	public boolean roomModify(String roomtype, int number) {
		boolean result=true;
		if(roomtype==null||number==0)
			result=false;
		return result;
	}

	
}
