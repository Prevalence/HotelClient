package vo.promotionvo.hotelpromotionVO;

import po.PromotionPO;
import po.promotionpo.hotelpromotionPO.BirthdayHotelproPO;
import vo.PromotionVO;

/**
 * @author 武秀峰
 * 酒店促销策略：生日特惠折扣*/
public class BirthdayHotelproVO extends PromotionVO{
//	private String promotionType="BirthdayHotelPromtion";
	private int discount;//如打九五折时，discount=95
	
	public BirthdayHotelproVO() {
		// TODO Auto-generated constructor stub
	}
	
	public BirthdayHotelproVO(int promotionID, String promotionName, String promotionType,
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
		BirthdayHotelproPO po=new BirthdayHotelproPO();
		po.setPromotionID(vo.getPromotionID());
		po.setPromotionName(vo.getPromotionName());
		po.setPromotionType(vo.getPromotionType());
		po.setHotelnameOrWeb(vo.getHotelnameOrWeb());
		po.setDiscount(((BirthdayHotelproVO)vo).getDiscount());
		return po;
	}

}
