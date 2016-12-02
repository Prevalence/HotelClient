package vo.hotelVO;

import java.io.Serializable;

import po.hotelpo.RoomPO;

public class RoomVO implements Serializable {
	private String roomType;
	private int roomnum;
	private int roomPrice;
	
	public RoomVO() {
		super();
	}

	public RoomVO(String roomType, int roomnum, int roomPrice) {
		super();
		this.roomType = roomType;
		this.roomnum = roomnum;
		this.roomPrice = roomPrice;
	}
	
	public RoomVO(RoomPO po) {
		super();
		this.roomType = po.getRoomType();
		this.roomnum = po.getRoomnum();
		this.roomPrice = po.getRoomPrice();
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
}
