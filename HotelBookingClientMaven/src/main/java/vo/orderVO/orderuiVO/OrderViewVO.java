package vo.orderVO.orderuiVO;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.beans.property.SimpleStringProperty;

public class OrderViewVO {
	private final SimpleStringProperty hotelName;
	private final SimpleStringProperty orderNumber;
	private final SimpleStringProperty expectedTime;
	private final SimpleStringProperty state;

	public OrderViewVO(String hotelName, String orderNumber, String expectedTime, String state) {
		this.hotelName = new SimpleStringProperty(hotelName);
		this.orderNumber = new SimpleStringProperty(orderNumber);
		this.expectedTime = new SimpleStringProperty(expectedTime);
		this.state = new SimpleStringProperty(state);
	}

	public String getHotelName() {
		return hotelName.get();
	}

	public void setHotelName(String content) {
		hotelName.set(content);
	}

	public String getOrderNumber() {
		return orderNumber.get();
	}

	public void setOrderNumber(String content) {
		orderNumber.set(content);
	}

	public String getExpectedTime() {
		return expectedTime.get();
	}

	public void setExpectedTime(String content) {
		expectedTime.set(content);
	}

	public String getState() {
		return state.get();
	}

	public void setState(String content) {
		state.set(content);
	}
	//
	// public ButtonCell getSelectedButton(){
	// return selectedButton;
	// }
	//
	// public void setSelectedButton(ButtonCell selectedButton){
	// this.selectedButton=selectedButton;
	// }
}
