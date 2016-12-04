package vo;

import java.io.Serializable;

import po.HotelWorkerPO;


public class HotelWorkerVO {
	private String hotelname;
	private String username;
	private String password;

	public HotelWorkerVO(String username, String password,String hotelname) {
		this.hotelname=hotelname;
		this.username=username;
		this.password=password;
	}
	
	public HotelWorkerVO(HotelWorkerPO po) {
		this.hotelname=po.getHotelname();
		this.username=po.getUsername();
		this.password=po.getPassword();
	}

	public HotelWorkerVO(){
		this.hotelname=null;
		this.username=null;
		this.password=null;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getHotelName() {
		return hotelname;
	}
	public void setHotelName(String hotelName) {
		this.hotelname = hotelName;
	}

}
