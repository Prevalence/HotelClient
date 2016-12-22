package po.promotionpo.hotelpromotionPO;

import java.util.Calendar;

import po.PromotionPO;
import vo.PromotionVO;
import vo.promotionvo.hotelpromotionVO.PeriodHotelproVO;
import businessLogic.TimeFormTrans;

/**
 *  @author 武秀峰
 *  酒店促销策略：双11活动折扣（在特定的期间住宿有折扣）*/
public class PeriodHotelproPO extends PromotionPO {
//	private String promotionType="特定时间优惠策略";
	private static final long serialVersionUID = 1L;
	private Calendar startTime;
	private Calendar endTime;
	private int discount;//如打九五折时，discount=95
	

	public PeriodHotelproPO() {
		super();
	}


	public PeriodHotelproPO(int promotionID, String promotionName, String promotionType,
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
		PeriodHotelproVO vo=new PeriodHotelproVO();
		vo.setPromotionID(po.getPromotionID());
		vo.setPromotionName(po.getPromotionName());
		vo.setPromotionType(po.getPromotionType());
		vo.setHotelnameOrWeb(po.getHotelnameOrWeb());
		TimeFormTrans t=new TimeFormTrans();
		String start=t.myToString(((PeriodHotelproPO)po).getStartTime());
		vo.setStartTime(start);
		String end=t.myToString(((PeriodHotelproPO)po).getEndTime());
		vo.setEndTime(end);
		vo.setDiscount(((PeriodHotelproPO)po).getDiscount());
		return vo;
		
	}
	
}
