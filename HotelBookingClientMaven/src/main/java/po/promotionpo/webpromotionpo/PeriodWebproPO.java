package po.promotionpo.webpromotionpo;

import java.util.Calendar;

import po.PromotionPO;
import vo.promotionvo.webpromotionvo.PeriodWebproVO;

/**
 *  @author 武秀峰
 *  网站促销策略：双11活动折扣（在特定的期间预订有折扣）*/
public class PeriodWebproPO extends PromotionPO {
	private String promotionID;
	private String promotionType="WebPromtion";
	private Calendar startTime;
	private Calendar endTime;
	private int discount;//如打九五折时，discount=95
	
	public PeriodWebproPO(String promotionID, Calendar startTime, Calendar endTime, int discount){
		this.promotionID=promotionID;
		this.startTime=startTime;
		this.endTime=endTime;
		this.discount=discount;
	}
	public PeriodWebproPO(PeriodWebproVO periodWeblproVO){
		this.startTime=periodWeblproVO.getStartTime();
		this.endTime=periodWeblproVO.getEndTime();
		this.discount=periodWeblproVO.getDiscount();
	}
	
	public PeriodWebproPO() {
		// TODO Auto-generated constructor stub
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
