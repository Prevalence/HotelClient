package vo.promotionvo.webpromotionVO;

import java.util.Calendar;

import po.PromotionPO;
import po.promotionpo.webpromotionPO.PeriodWebproPO;
import vo.promotionvo.PromotionVO;
import businessLogic.TimeFormTrans;

/**
 * @author 武秀峰
 * 网站促销策略：网站特定时间优惠策略*/
public class PeriodWebproVO extends PromotionVO{
//	private String promotionType="网站特定时间优惠策略";
	private Calendar startTime;
	private Calendar endTime;

	public PeriodWebproVO() {
		super();
	}

	public PeriodWebproVO(int promotionID, String promotionName, String promotionType,
			String hotelnameOrWeb,String startTime, String endTime, int discount) {
		super.setPromotionID(promotionID);
		super.setPromotionName(promotionName);
		super.setPromotionType(promotionType);
		super.setHotelnameOrWeb(hotelnameOrWeb);
		TimeFormTrans t=new TimeFormTrans();
		Calendar sc=t.myToCalendar(startTime);
		this.startTime = sc;
		Calendar et=t.myToCalendar(endTime);
		this.endTime = et;
		super.setDiscount(discount);
	}


	public String getStartTime() {
		TimeFormTrans t=new TimeFormTrans();
		String sc=t.myToString(startTime);
		return sc;
	}


	public void setStartTime(String startTime) {
		TimeFormTrans t=new TimeFormTrans();
		Calendar sc=t.myToCalendar(startTime);
		this.startTime = sc;
	}


	public String getEndTime() {
		TimeFormTrans t=new TimeFormTrans();
		String et=t.myToString(endTime);
		return et;
	}


	public void setEndTime(String endTime) {
		TimeFormTrans t=new TimeFormTrans();
		Calendar et=t.myToCalendar(endTime);
		this.endTime = et;
	}


	public PromotionPO toPO(PromotionVO vo){
		PeriodWebproPO po=new PeriodWebproPO();
		po.setPromotionID(vo.getPromotionID());
		po.setPromotionName(vo.getPromotionName());
		po.setPromotionType(vo.getPromotionType());
		po.setHotelnameOrWeb(vo.getHotelnameOrWeb());
		
		TimeFormTrans t=new TimeFormTrans();
		Calendar sc=t.myToCalendar(((PeriodWebproVO)vo).getStartTime());
		Calendar et=t.myToCalendar(((PeriodWebproVO)vo).getEndTime());
		po.setStartTime(sc);
		po.setEndTime(et);
		po.setDiscount(((PeriodWebproVO)vo).getDiscount());
		return po;
	}
}
