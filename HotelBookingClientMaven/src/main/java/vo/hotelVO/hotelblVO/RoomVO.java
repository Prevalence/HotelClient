package vo.hotelVO.hotelblVO;

import java.util.ArrayList;
import java.util.Calendar;

import po.hotelPO.RoomPO;

public class RoomVO {
	/*房间（类型、原始价格区间、有空房期间（房间数量、入住日期，退房日期））*/
	private String roomType;
	private int roomPrice;
	private String roomnum;//房间号
	private ArrayList<Calendar> checkInTime;//入住日期
	private ArrayList<Calendar> checkOutTime;//退房日期
	
	public RoomVO() {
		super();
	}
	
	public RoomVO(String roomType, String roomnum, int roomPrice, ArrayList<Calendar> checkInTime,
			ArrayList<Calendar> checkOutTime) {
		super();
		this.roomType = roomType;
		this.roomnum = roomnum;
		this.roomPrice = roomPrice;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}

	public RoomVO(RoomPO po) {
		super();
		this.roomType = po.getRoomType();
		this.roomnum = po.getRoomnum();
		this.roomPrice = po.getRoomPrice();
		this.checkInTime = po.getCheckInTime();
		this.checkOutTime = po.getCheckOutTime();
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
