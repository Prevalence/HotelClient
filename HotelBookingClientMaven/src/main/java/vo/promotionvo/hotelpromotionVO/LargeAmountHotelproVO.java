package vo.promotionvo.hotelpromotionvo;

import java.util.ArrayList;

import po.promotionpo.hotelpromotionpo.LargeAmountHotelproPO;
import vo.PromotionVO;

/**
 * @author 武秀峰
 * 酒店促销策略：三间及以上预订特惠*/
public class LargeAmountHotelproVO extends PromotionVO{
//	private String promotionType="LargeAmountHotelPromtion";
	private int discount;//如打九五折时，discount=95
	
	public LargeAmountHotelproVO() {
		super();
	}

	public LargeAmountHotelproVO(String promotionID, String promotionName, String promotionType,
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

	public LargeAmountHotelproPO toPO(LargeAmountHotelproVO vo){
		LargeAmountHotelproPO po=new LargeAmountHotelproPO();
		po.setPromotionID(vo.getPromotionID());
		po.setPromotionName(vo.getPromotionName());
		po.setPromotionType(vo.getPromotionType());
		po.setHotelnameOrWeb(vo.getHotelnameOrWeb());
		po.setDiscount(vo.discount);
		return po;
		
	}
}
