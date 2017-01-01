package vo.promotionvo.hotelpromotionVO;

import po.PromotionPO;
import po.promotionpo.hotelpromotionPO.LargeAmountHotelproPO;
import vo.promotionvo.PromotionVO;

/**
 * @author 武秀峰
 * 酒店促销策略：多购优惠策略*/
public class LargeAmountHotelproVO extends PromotionVO{
	private int discount;//如打九五折时，discount=95
	
	public LargeAmountHotelproVO() {
		super();
	}

	public LargeAmountHotelproVO(int promotionID, String promotionName, String promotionType,
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

	public PromotionPO toPO(PromotionVO vo){
		LargeAmountHotelproPO po=new LargeAmountHotelproPO();
		po.setPromotionID(vo.getPromotionID());
		po.setPromotionName(vo.getPromotionName());
		po.setPromotionType(vo.getPromotionType());
		po.setHotelnameOrWeb(vo.getHotelnameOrWeb());
		po.setDiscount(((LargeAmountHotelproVO)vo).getDiscount());
		return po;
		
	}
}
