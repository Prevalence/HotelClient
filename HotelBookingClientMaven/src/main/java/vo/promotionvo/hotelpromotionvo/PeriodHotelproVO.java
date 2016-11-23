package vo.promotionvo.hotelpromotionvo;

import java.util.Calendar;

import po.promotionpo.hotelpromotionpo.PeriodHotelproPO;

/**
 * @author 武秀峰
 * 酒店促销策略：双11活动折扣（在特定的期间住宿有折扣）*/
public class PeriodHotelproVO {
	private String promotionID;
	private String promotionType="HotelPromtion";
	String hotelname;
	private Calendar startTime;
	private Calendar endTime;
	private int discount;//如打九五折时，discount=95
	
	public PeriodHotelproVO(String promotionID, String hotelname, Calendar startTime, Calendar endTime, int discount){
		this.promotionID=promotionID;
		this.hotelname=hotelname;
		this.startTime=startTime;
		this.endTime=endTime;
		this.discount=discount;
	}
	
	public String getHotelname(){
		return hotelname;
	}
	public void setHotelname(String hotelname){
		this.hotelname=hotelname;
	}
	public Calendar getStartTime(){
		return startTime;
	}
	public void setStartTime(Calendar startTime){
		this.startTime=startTime;
	}
	public Calendar getEndTime(){
		return endTime;
	}
	public void setEndTime(Calendar endTime){
		this.endTime=endTime;
	}
	public int getDiscount(){
		return discount;
	}
	public void setDiscount(int discount){
		this.discount=discount;
	}

	public String getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(String promotionID) {
		this.promotionID = promotionID;
	}

	public String getPromotionType() {
		return promotionType;
	}
	public PeriodHotelproPO toPO(PeriodHotelproVO vo){
		PeriodHotelproPO po=new PeriodHotelproPO();
		po.setDiscount(vo.getDiscount());
		po.setHotelname(vo.getHotelname());
		po.setPromotionID(vo.getPromotionID());
		po.setStartTime(vo.getStartTime());
		po.setEndTime(vo.getEndTime());
		return po;
		
	}

}
