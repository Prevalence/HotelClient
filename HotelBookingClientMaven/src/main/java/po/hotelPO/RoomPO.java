package po.hotelPO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import vo.hotelVO.hotelblVO.RoomVO;

public class RoomPO implements Serializable {
	private String roomType;
	private String roomnum;//房间号
	private int roomPrice;
	private ArrayList<Calendar> checkInTime;//入住日期
	private ArrayList<Calendar> checkOutTime;//退房日期
	
	public RoomPO() {
		super();
	}
	
	public RoomPO(String roomType, String roomnum, int roomPrice, ArrayList<Calendar> checkInTime,
			ArrayList<Calendar> checkOutTime) {
		super();
		this.roomType = roomType;
		this.roomnum = roomnum;
		this.roomPrice = roomPrice;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}

	public RoomPO(RoomVO vo) {
		super();
		this.roomType = vo.getRoomType();
		this.roomnum = vo.getRoomnum();
		this.roomPrice = vo.getRoomPrice();
		this.checkInTime = vo.getCheckInTime();
		this.checkOutTime = vo.getCheckOutTime();
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public ArrayList<Calendar> getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(ArrayList<Calendar> checkInTime) {
		this.checkInTime = checkInTime;
	}

	public ArrayList<Calendar> getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(ArrayList<Calendar> checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	

}
