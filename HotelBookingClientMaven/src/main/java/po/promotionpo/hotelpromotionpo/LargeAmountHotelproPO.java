package po.promotionpo.hotelpromotionPO;


import po.PromotionPO;
import vo.promotionvo.PromotionVO;
import vo.promotionvo.hotelpromotionVO.LargeAmountHotelproVO;

/**
 *  @author 武秀峰
 *  酒店促销策略：三间及以上预订特惠*/
public class LargeAmountHotelproPO extends PromotionPO {
//	private String promotionType="多购优惠策略";
	private int discount;//如打九五折时，discount=95
	private static final long serialVersionUID = 1L;
	public LargeAmountHotelproPO() {
		super();
	}

	public LargeAmountHotelproPO(int promotionID, String promotionName, String promotionType,
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
	
	public PromotionVO toVO(PromotionPO po){
		LargeAmountHotelproVO vo=new LargeAmountHotelproVO();
		vo.setPromotionID(po.getPromotionID());
		vo.setPromotionName(po.getPromotionName());
		vo.setPromotionType(po.getPromotionType());
		vo.setHotelnameOrWeb(po.getHotelnameOrWeb());
		vo.setDiscount(((LargeAmountHotelproPO)po).discount);
		return vo;
		
	}
}
