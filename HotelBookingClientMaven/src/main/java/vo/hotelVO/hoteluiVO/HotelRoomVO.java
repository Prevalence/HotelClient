package vo.hotelVO.hoteluiVO;

import javafx.beans.property.SimpleStringProperty;

public class HotelRoomVO {
	private final SimpleStringProperty roomtype;
	private final SimpleStringProperty totalNumber;
	private final SimpleStringProperty roomPrice;
	
	public HotelRoomVO(String roomtype, int roomPrice,int totalNumber) {
        this.roomtype = new SimpleStringProperty(roomtype);
        this.roomPrice = new SimpleStringProperty(String.valueOf(roomPrice));
        this.totalNumber = new SimpleStringProperty(String.valueOf(totalNumber));
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
	    
	    public String getTotalNumber() {
	        return totalNumber.get();
	    }

	    public void setTotalNumber(int content) {
	    	totalNumber.set(String.valueOf(content));
	    }
}
