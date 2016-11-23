package po.promotionpo.hotelpromotionpo;

import java.util.Calendar;

import po.PromotionPO;
import vo.promotionvo.hotelpromotionvo.LargeAmountHotelproVO;
import vo.promotionvo.hotelpromotionvo.PeriodHotelproVO;

/**
 *  @author 武秀峰
 *  酒店促销策略：双11活动折扣（在特定的期间住宿有折扣）*/
public class PeriodHotelproPO extends PromotionPO {
	private String promotionID;
	private String promotionType="HotelPromtion";
	String hotelname;
	private Calendar startTime;
	private Calendar endTime;
	private int discount;//如打九五折时，discount=95
	
	public PeriodHotelproPO(String promotionID, String hotelname, Calendar startTime, Calendar endTime, int discount){
		this.promotionID=promotionID;
		this.hotelname=hotelname;
		this.startTime=startTime;
		this.endTime=endTime;
		this.discount=discount;
	}
	public PeriodHotelproPO(PeriodHotelproVO periodHotelproVO){
		this.hotelname=periodHotelproVO.getHotelname();
		this.startTime=periodHotelproVO.getStartTime();
		this.endTime=periodHotelproVO.getEndTime();
		this.discount=periodHotelproVO.getDiscount();
	}
	
	public PeriodHotelproPO() {
		// TODO Auto-generated constructor stub
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
	
}
