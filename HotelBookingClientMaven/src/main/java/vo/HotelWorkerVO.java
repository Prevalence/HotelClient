package vo;

import java.io.Serializable;


public class HotelWorkerVO  implements Serializable {
	private String hotelname;
	private String username;
	private String password;

	public HotelWorkerVO(String username, String password, int userType,String hotelname) {
		this.hotelname=hotelname;
		this.username=username;
		this.password=password;
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
