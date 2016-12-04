package vo;

import java.io.Serializable;
import java.util.Calendar;

import po.SearchPO;
/**
 * 
 * @author 武秀峰
 *
 */

public class SearchVO {
	private String personname;
	private Calendar time;
	private String hotelname;
	
	public SearchVO() {
		super();
	}
	public SearchVO(String personname, Calendar time, String hotelname) {
		super();
		this.personname = personname;
		this.time = time;
		this.hotelname = hotelname;
	}
	public SearchVO(SearchPO po) {
		this.personname = po.getPersonname();
		this.time = po.getTime();
		this.hotelname = po.getHotelname();
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public Calendar getTime() {
		return time;
	}
	public void setTime(Calendar time) {
		this.time = time;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
}
