package po;

import java.io.Serializable;
import java.util.Calendar;

import vo.SearchVO;
/**
 * 
 * @author 武秀峰
 *
 */
public class SearchPO implements Serializable{
	private String personname;
	private Calendar time;
	private String hotelname;
	
	public SearchPO() {
		super();
	}
	public SearchPO(String personname, Calendar time, String hotelname) {
		super();
		this.personname = personname;
		this.time = time;
		this.hotelname = hotelname;
	}
	public SearchPO(SearchVO vo) {
		this.personname = vo.getPersonname();
		this.time = vo.getTime();
		this.hotelname = vo.getHotelname();
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
