package vo.promotionvo.webpromotionvo;

import java.util.Calendar;

import po.promotionpo.hotelpromotionpo.BirthdayHotelproPO;
import po.promotionpo.webpromotionpo.PeriodWebproPO;
import vo.promotionvo.hotelpromotionvo.BirthdayHotelproVO;

/**
 * @author 武秀峰
 * 网站促销策略：双11活动折扣（在特定的期间预订有折扣）*/
public class PeriodWebproVO {
	private String promotionID;
	private String promotionType="WebPromtion";
	private Calendar startTime;
	private Calendar endTime;
	private int discount;//如打九五折时，discount=95
	
	public PeriodWebproVO(String promotionID, Calendar startTime, Calendar endTime, int discount){
		this.promotionID=promotionID;
		this.startTime=startTime;
		this.endTime=endTime;
		this.discount=discount;
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
	public PeriodWebproPO toPO(PeriodWebproVO vo){
		PeriodWebproPO po=new PeriodWebproPO();
		po.setDiscount(vo.getDiscount());
		po.setStartTime(vo.getStartTime());
		po.setEndTime(vo.getEndTime());
		po.setPromotionID(vo.getPromotionID());
		return po;
	}
}
