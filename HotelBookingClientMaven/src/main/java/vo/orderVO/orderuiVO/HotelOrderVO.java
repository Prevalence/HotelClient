package vo.orderVO.orderuiVO;

import javafx.beans.property.SimpleStringProperty;

public class HotelOrderVO {
	private final SimpleStringProperty orderNumber;
	private final SimpleStringProperty time;
	private final SimpleStringProperty person;
	private final SimpleStringProperty state;

	public HotelOrderVO(String orderNumber,String time, String person, String state) {
		this.person = new SimpleStringProperty(person);
		this.orderNumber = new SimpleStringProperty(orderNumber);
		this.time = new SimpleStringProperty(time);
		this.state = new SimpleStringProperty(state);
	}

	public String getPerson() {
		return person.get();
	}

	public void setPerson(String content) {
		person.set(content);
	}

	public String getOrderNumber() {
		return orderNumber.get();
	}

	public void setOrderNumber(String content) {
		orderNumber.set(content);
	}

	public String getTime() {
		return time.get();
	}

	public void setTime(String content) {
		time.set(content);
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
