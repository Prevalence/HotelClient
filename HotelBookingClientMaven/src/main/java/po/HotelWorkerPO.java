package po;
import java.io.Serializable;

import vo.HotelWorkerVO;
/**
 * 
 * @author xiamutian
 *
 */
 public class HotelWorkerPO  implements Serializable{
		private String username;
		private String password;
		private String hotelname;
	

	public HotelWorkerPO(String username, String password, String hotelname) {
			super();
			this.username = username;
			this.password = password;
			this.hotelname = hotelname;
		}

	public HotelWorkerPO() {
		this.username = null;
		this.password = null;
		this.hotelname = null;	}

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

		public String getHotelname() {
			return hotelname;
		}

		public void setHotelname(String hotelname) {
			this.hotelname = hotelname;
		}
		public HotelWorkerPO(HotelWorkerVO vo){
			username=vo.getUsername();
			password=vo.getPassword();
			hotelname=vo.getHotelName();
		}

	}