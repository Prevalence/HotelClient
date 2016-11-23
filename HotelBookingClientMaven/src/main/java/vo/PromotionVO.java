package vo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import po.PromotionPO;


public class PromotionVO implements Serializable {
//	private String name;
//	private Calendar start;
//	private Calendar end;
//	private int type;
	private double discount;
//	private List <String> hotel;
	public PromotionVO(String name, Calendar start, Calendar end, int type,
			double discount, List<String> hotel) {
		super();
//		this.name = name;
//		this.start = start;
//		this.end = end;
//		this.type = type;
		this.discount = discount;
//		this.hotel = hotel;
	}
	public PromotionVO(){
		
	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Calendar getStart() {
//		return start;
//	}
//	public void setStart(Calendar start) {
//		this.start = start;
//	}
//	public Calendar getEnd() {
//		return end;
//	}
//	public void setEnd(Calendar end) {
//		this.end = end;
//	}
//	public int getType() {
//		return type;
//	}
//	public void setType(int type) {
//		this.type = type;
//	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
//	public List<String> getHotel() {
//		return hotel;
//	}
//	public void setHotel(List<String> hotel) {
//		this.hotel = hotel;
//	}
	public PromotionPO toPO(PromotionVO vo){
		return null;
	}
}
