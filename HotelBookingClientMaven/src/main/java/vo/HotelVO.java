package vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import po.HotelPO;

/**
 * 
 * @author 武秀峰
 *
 */
public class HotelVO implements Serializable {
	private String hotelname;
	private int star;//酒店星级
	private String feature;//酒店简介
	private ArrayList <Boolean> service;//设施服务
	private String address;
	private String circle;
	private double score;//酒店平均评分
	private ArrayList <String> roomType;
	private ArrayList <Integer>roomnum;
	private ArrayList<Integer> roomPrice;
	private ArrayList <String> comment;//“评分_时间_用户名_评价内容”，例如“5_2016-02-06_xiamutian_酒店很好” 酒店评价中_是非法字符
	private String hotelworker;
	
	public HotelVO(String hotelName,int star,String feature,ArrayList<Boolean> service,String address,String circle,double score,ArrayList<String> roomType,ArrayList<Integer> roomNum,ArrayList<Integer> roomPrice,ArrayList<String> comment,String hotelWorker){
		this.address=address;
		this.circle=circle;
		this.score=score;
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
	public HotelVO(){
		
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
	
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
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
	public HotelPO toPO(HotelVO vo){
		HotelPO po=new HotelPO();
		po.setAddress(vo.getAddress());
		po.setCircle(vo.getCircle());
		po.setScore(vo.getScore());
		po.setComment(vo.getComment());
		po.setFeature(vo.getFeature());
		po.setHotelname(vo.getHotelName());
		po.setHotelworker(vo.getHotelWorker());
		po.setRoomnum(vo.getRoomNum());
		po.setRoomPrice(vo.getRoomPrice());
		po.setRoomType(vo.getRoomType());
		po.setService(vo.getService());
		po.setStar(vo.getStar());
		return po;
	}

}
