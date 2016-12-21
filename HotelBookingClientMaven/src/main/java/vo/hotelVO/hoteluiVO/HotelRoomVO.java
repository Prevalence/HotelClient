package vo.hotelVO.hoteluiVO;

import javafx.beans.property.SimpleStringProperty;

public class HotelRoomVO {
	private final SimpleStringProperty roomtype;
	private final SimpleStringProperty roomPrice;
	
	public HotelRoomVO(String roomtype, int roomPrice,int totalNumber) {
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
}
