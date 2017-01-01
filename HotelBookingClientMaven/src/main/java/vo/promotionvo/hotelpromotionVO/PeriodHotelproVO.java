package vo.promotionvo.hotelpromotionVO;

import java.util.Calendar;

import po.PromotionPO;
import po.promotionpo.hotelpromotionPO.PeriodHotelproPO;
import vo.promotionvo.PromotionVO;
import businessLogic.TimeFormTrans;

/**
 * @author 武秀峰
 * 酒店促销策略：特定时间优惠策略*/
public class PeriodHotelproVO extends PromotionVO{
	private Calendar startTime;
	private Calendar endTime;
	public PeriodHotelproVO() {
		super();
	}


	public PeriodHotelproVO(int promotionID, String promotionName, String promotionType,
			String hotelnameOrWeb,String startTime, String endTime, int discount) {
		super.setPromotionID(promotionID);
		super.setPromotionName(promotionName);
		super.setPromotionType(promotionType);
		super.setHotelnameOrWeb(hotelnameOrWeb);
		
		TimeFormTrans t=new TimeFormTrans();
		Calendar start=t.myToCalendar(startTime);
		this.startTime = start;
		Calendar end=t.myToCalendar(endTime);
		this.endTime = end;
		
		super.setDiscount(discount);
	}


	public Calendar getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		TimeFormTrans t=new TimeFormTrans();
		Calendar start=t.myToCalendar(startTime);
		this.startTime = start;
	}


	public Calendar getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		TimeFormTrans t=new TimeFormTrans();
		Calendar end=t.myToCalendar(endTime);
		this.endTime = end;
	}

	public PromotionPO toPO(PromotionVO vo){
		PeriodHotelproPO po=new PeriodHotelproPO();
		po.setPromotionID(vo.getPromotionID());
		po.setPromotionName(vo.getPromotionName());
		po.setPromotionType(vo.getPromotionType());
		po.setHotelnameOrWeb(vo.getHotelnameOrWeb());
		po.setStartTime(((PeriodHotelproVO)vo).getStartTime());
		po.setEndTime(((PeriodHotelproVO)vo).getEndTime());
		po.setDiscount(((PeriodHotelproVO)vo).getDiscount());
		return po;
		
	}

}
