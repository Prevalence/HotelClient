package po;
import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author xiamutian
 *
 */

public class HotelPO implements Serializable{
	private String hotelname;
	private int star;
	private String feature;
	private ArrayList <Boolean> service;
	private String address;
	private String circle;
	private ArrayList <String> roomType;
	private ArrayList <Integer>roomnum;
	private ArrayList <Integer>roomPrice;
	private ArrayList <String> comment;
	private String hotelworker;
	
	public HotelPO(String hotelName,int star,String feature,ArrayList <Boolean> service,String address,String circle,ArrayList <String> roomType,ArrayList <Integer>roomNum,ArrayList <Integer>roomPrice,ArrayList <String> comment,String hotelWorker){
		this.address=address;
		this.circle=circle;
		this.comment=comment;
		this.feature=feature;
		this.hotelname=hotelName;
		this.hotelworker=hotelWorker;
		this.roomnum=roomNum;
		this.roomPrice=roomPrice;
		this.roomType=roomType;
		this.service=service;
		this.star=star;
	}
	public HotelPO(){
		this.address=null;
		this.circle=null;
		this.comment=null;
		this.feature=null;
		this.hotelname=null;
		this.hotelworker=null;
		this.roomnum=null;
		this.roomPrice=null;
		this.roomType=null;
		this.service=null;
		this.star=0;
	}


	public String getHotelName() {
		return hotelname;
	}

	public void setHotelName(String hotelName) {
		this.hotelname = hotelName;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public List<Boolean> getService() {
		return service;
	}

	public void setService(ArrayList<Boolean> service) {
		this.service = service;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public ArrayList<String> getRoomType() {
		return roomType;
	}

	public void setRoomType(ArrayList<String> roomType) {
		this.roomType = roomType;
	}

	public ArrayList<Integer> getRoomNum() {
		return roomnum;
	}

	public void setRoomNum(ArrayList<Integer> roomNum) {
		this.roomnum = roomNum;
	}

	public ArrayList<Integer> getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(ArrayList<Integer> roomPrice) {
		this.roomPrice = roomPrice;
	}

	public ArrayList<String> getComment() {
		return comment;
	}

	public void setComment(ArrayList<String> comment) {
		this.comment = comment;
	}

	public String getHotelWorker() {
		return hotelworker;
	}

	public void setHotelWorker(String hotelWorker) {
		this.hotelworker = hotelWorker;
	}
}
