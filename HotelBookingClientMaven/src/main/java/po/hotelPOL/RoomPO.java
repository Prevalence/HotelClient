package po.hotelPOL;

import java.io.Serializable;
import java.util.ArrayList;

import vo.hotelVO.hotelblVO.RoomVO;

public class RoomPO implements Serializable {
	private String roomType;
	private int roomnum;
	private int roomPrice;
	
	public RoomPO() {
		super();
	}

	public RoomPO(String roomType, int roomnum, int roomPrice) {
		super();
		this.roomType = roomType;
		this.roomnum = roomnum;
		this.roomPrice = roomPrice;
	}
	
	public RoomPO(RoomVO vo) {
		super();
		this.roomType = vo.getRoomType();
		this.roomnum = vo.getRoomnum();
		this.roomPrice = vo.getRoomPrice();
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
