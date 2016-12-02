package vo.promotionvo.hotelpromotionVO;

import java.util.ArrayList;
import java.util.Calendar;

import po.promotionpo.hotelpromotionPO.PeriodHotelproPO;
import vo.PromotionVO;

/**
 * @author 武秀峰
 * 酒店促销策略：双11活动折扣（在特定的期间住宿有折扣）*/
public class PeriodHotelproVO extends PromotionVO{
//	private String promotionType="PeriodHotelPromtion";
	private Calendar startTime;
	private Calendar endTime;
	private int discount;//如打九五折时，discount=95
	

	public PeriodHotelproVO() {
		super();
	}


	public PeriodHotelproVO(String promotionID, String promotionName, String promotionType,
			String hotelnameOrWeb,Calendar startTime, Calendar endTime, int discount) {
		super.setPromotionID(promotionID);
		super.setPromotionName(promotionName);
		super.setPromotionType(promotionType);
		super.setHotelnameOrWeb(hotelnameOrWeb);
		this.startTime = startTime;
		this.endTime = endTime;
		this.discount = discount;
	}


	public Calendar getStartTime() {
		return startTime;
	}


	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}


	public Calendar getEndTime() {
		return endTime;
	}


	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public PeriodHotelproPO toPO(PeriodHotelproVO vo){
		PeriodHotelproPO po=new PeriodHotelproPO();
		po.setPromotionID(vo.getPromotionID());
		po.setPromotionName(vo.getPromotionName());
		po.setPromotionType(vo.getPromotionType());
		po.setHotelnameOrWeb(vo.getHotelnameOrWeb());
		po.setStartTime(vo.getStartTime());
		po.setEndTime(vo.getEndTime());
		po.setDiscount(vo.getDiscount());
		return po;
		
	}

}
