package vo.promotionvo.webpromotionVO;

import java.util.Calendar;

import po.PromotionPO;
import po.promotionpo.webpromotionPO.PeriodWebproPO;
import vo.PromotionVO;

/**
 * @author 武秀峰
 * 网站促销策略：双11活动折扣（在特定的期间预订有折扣）*/
public class PeriodWebproVO extends PromotionVO{
//	private String promotionType="PeriodWebPromtion";
	private Calendar startTime;
	private Calendar endTime;

	public PeriodWebproVO() {
		super();
	}

	public PeriodWebproVO(int promotionID, String promotionName, String promotionType,
			String hotelnameOrWeb,Calendar startTime, Calendar endTime, int discount) {
		super.setPromotionID(promotionID);
		super.setPromotionName(promotionName);
		super.setPromotionType(promotionType);
		super.setHotelnameOrWeb(hotelnameOrWeb);
		this.startTime = startTime;
		this.endTime = endTime;
		super.setDiscount(discount);
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


	public PromotionPO toPO(PromotionVO vo){
		PeriodWebproPO po=new PeriodWebproPO();
		po.setPromotionID(vo.getPromotionID());
		po.setPromotionName(vo.getPromotionName());
		po.setPromotionType(vo.getPromotionType());
		po.setHotelnameOrWeb(vo.getHotelnameOrWeb());
		po.setStartTime(((PeriodWebproVO)vo).getStartTime());
		po.setEndTime(((PeriodWebproVO)vo).getEndTime());
		po.setDiscount(((PeriodWebproVO)vo).getDiscount());
		return po;
	}
}
