package po.promotionpo.webpromotionPO;

import java.util.Calendar;

import po.PromotionPO;
import vo.PromotionVO;
import vo.promotionvo.webpromotionVO.PeriodWebproVO;

/**
 *  @author 武秀峰
 *  网站促销策略：双11活动折扣（在特定的期间预订有折扣）*/
public class PeriodWebproPO extends PromotionPO {
//	private String promotionType="网站特定时间优惠策略";
	private Calendar startTime;
	private Calendar endTime;
	private int discount;//如打九五折时，discount=95
	private static final long serialVersionUID = 1L;
	

	public PeriodWebproPO() {
		super();
	}

	public PeriodWebproPO(int promotionID, String promotionName, String promotionType,
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
	
	public PromotionVO toVO(PromotionPO po){
		PeriodWebproVO vo=new PeriodWebproVO();
		vo.setPromotionID(po.getPromotionID());
		vo.setPromotionName(po.getPromotionName());
		vo.setPromotionType(po.getPromotionType());
		vo.setHotelnameOrWeb(po.getHotelnameOrWeb());
		vo.setStartTime(((PeriodWebproPO)po).getStartTime());
		vo.setEndTime(((PeriodWebproPO)po).getEndTime());
		vo.setDiscount(((PeriodWebproPO)po).getDiscount());
		return vo;
	}
	
}
