package vo;

import java.util.Calendar;

import po.SearchPO;
import businessLogic.TimeFormTrans;
/**
 * 
 * @author 武秀峰
 *
 */

public class SearchVO {
	private String personname;
	private String time;
	private String hotelname;
	
	public SearchVO() {
		super();
	}
	public SearchVO(String personname, String time, String hotelname) {
		super();
		this.personname = personname;
		this.setTime(time);
		this.hotelname = hotelname;
	}
	public SearchVO(SearchPO po) {
		this.personname = po.getPersonname();
		
		TimeFormTrans t=new TimeFormTrans();
		String potime=t.myToString(po.getTime());
		this.setTime(potime);
		this.hotelname = po.getHotelname();
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
