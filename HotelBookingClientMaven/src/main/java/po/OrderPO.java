package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import vo.OrderVO;
/**
 * 
 * @author xiamutian
 *
 */
public class OrderPO implements Serializable{
	private String personname;
	private String hotelname;
	private Calendar producttime;
	private Calendar executetime;
	private Calendar canceltime;
	private Calendar latestExecutetime;//订单最晚执行时间
	private ArrayList<String> roomtype;
	private ArrayList<Integer> roomnum;
	private String ID;
	private String realname;
	private int peoplenum;
	private int orderprice;
	public OrderPO(OrderVO vo){
		personname=vo.getPersonname();
		hotelname=vo.getHotelname();
		producttime=vo.getProducttime();
		executetime=vo.getExecutetime();
		canceltime=vo.getCanceltime();
		latestExecutetime=vo.getLatestExecutetime();
		roomtype=vo.getRoomtype();
		roomnum=vo.getRoomnum();
		ID=vo.getID();
		realname=vo.getRealname();
		peoplenum=vo.getPeoplenum();
		orderprice=vo.getOrderprice();
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public Calendar getProducttime() {
		return producttime;
	}
	public void setProducttime(Calendar producttime) {
		this.producttime = producttime;
	}
	public Calendar getExecutetime() {
		return executetime;
	}
	public void setExecutetime(Calendar executetime) {
		this.executetime = executetime;
	}
	public Calendar getCanceltime() {
		return canceltime;
	}
	public void setCanceltime(Calendar canceltime) {
		this.canceltime = canceltime;
	}
	public Calendar getLatestExecutetime() {
		return latestExecutetime;
	}
	public void setLatestExecutetime(Calendar latestExecutetime) {
		this.latestExecutetime = latestExecutetime;
	}
	public ArrayList<String> getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(ArrayList<String> roomtype) {
		this.roomtype = roomtype;
	}
	public ArrayList<Integer> getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(ArrayList<Integer> roomnum) {
		this.roomnum = roomnum;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getPeoplenum() {
		return peoplenum;
	}
	public void setPeoplenum(int peoplenum) {
		this.peoplenum = peoplenum;
	}
	public int getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(int orderprice) {
		this.orderprice = orderprice;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public int getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(int orderstate) {
		this.orderstate = orderstate;
	}
	private String ordernum;
	private int orderstate;
	public OrderPO() {
		
	}
	
}
