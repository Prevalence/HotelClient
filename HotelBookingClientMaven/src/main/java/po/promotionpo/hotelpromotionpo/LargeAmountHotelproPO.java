package po.promotionpo.hotelpromotionPO;

import java.util.ArrayList;

import po.PromotionPO;
import vo.promotionvo.hotelpromotionVO.LargeAmountHotelproVO;

/**
 *  @author 武秀峰
 *  酒店促销策略：三间及以上预订特惠*/
public class LargeAmountHotelproPO extends PromotionPO {
//	private String promotionType="LargeAmountHotelPromtion";
	private int discount;//如打九五折时，discount=95
	private static final long serialVersionUID = 1L;
	public LargeAmountHotelproPO() {
		super();
	}

	public LargeAmountHotelproPO(String promotionID, String promotionName, String promotionType,
			String hotelnameOrWeb, int discount) {
		super.setPromotionID(promotionID);
		super.setPromotionName(promotionName);
		super.setPromotionType(promotionType);
		super.setHotelnameOrWeb(hotelnameOrWeb);
		this.setDiscount(discount);
	}
	
	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
}
