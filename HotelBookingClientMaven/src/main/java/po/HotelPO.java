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
	private int star;//酒店星级
	private String feature;//酒店简介
	private ArrayList <Boolean> service;//设施服务
	private String address;
	private String circle;
	private double score;//酒店平均评分
	private ArrayList <String> roomType;
	private ArrayList <Integer>roomnum;
	private ArrayList <Integer>roomPrice;
	private ArrayList <String> comment;//“评分_时间_用户名_评价内容”，例如“5_2016-02-06_xiamutian_酒店很好” 酒店评价中_是非法字符
	private String hotelworker;
	
	public HotelPO(String hotelName,int star,String feature,ArrayList <Boolean> service,String address,String circle,double score,ArrayList <String> roomType,ArrayList <Integer>roomNum,ArrayList <Integer>roomPrice,ArrayList <String> comment,String hotelWorker){
		this.address=address;
		this.circle=circle;
		this.setScore(score);
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
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
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
	public ArrayList<Boolean> getService() {
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
	public ArrayList<Integer> getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(ArrayList<Integer> roomnum) {
		this.roomnum = roomnum;
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
	public String getHotelworker() {
		return hotelworker;
	}
	public void setHotelworker(String hotelworker) {
		this.hotelworker = hotelworker;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}


}
