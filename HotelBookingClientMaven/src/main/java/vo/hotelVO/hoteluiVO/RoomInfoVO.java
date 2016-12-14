package vo.hotelVO.hoteluiVO;

import javafx.beans.property.SimpleStringProperty;

public class RoomInfoVO {
	private final SimpleStringProperty roomtype;
	private final SimpleStringProperty roomPrice;
	
	public RoomInfoVO(String roomtype, int roomPrice) {
        this.roomtype = new SimpleStringProperty(roomtype);
        this.roomPrice = new SimpleStringProperty(String.valueOf(roomPrice));
    }
	
	 public String getRoomtype() {
	        return roomtype.get();
	    }

	    public void setRoomtype(String content) {
	        roomtype.set(content);
	    }

	    public String getRoomPrice() {
	        return roomPrice.get();
	    }

	    public void setRoomPrice(int content) {
	        roomPrice.set(String.valueOf(content));
	    }
//
//	    public String getNumberOfRoom() {
//	        return numberOfRoom.get();
//	    }
//
//	    public void setNumberOfRoom(int content) {
//	        numberOfRoom.set(String.valueOf(content));
//	    }
}
