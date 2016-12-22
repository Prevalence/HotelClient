package po.promotionpo.hotelpromotionPO;

import po.PromotionPO;
import vo.PromotionVO;
import vo.promotionvo.hotelpromotionVO.BirthdayHotelproVO;

/**
 *  @author 武秀峰
 *  酒店促销策略：生日特惠折扣*/
public class BirthdayHotelproPO extends PromotionPO{
//	private String promotionType="生日优惠策略";
	private int discount;//如打九五折时，discount=95
	private static final long serialVersionUID = 1L;
	
	public BirthdayHotelproPO() {
		// TODO Auto-generated constructor stub
	}
	
	public BirthdayHotelproPO(int promotionID, String promotionName, String promotionType,
			String hotelnameOrWeb, int discount) {
		super.setPromotionID(promotionID);
		super.setPromotionName(promotionName);
		super.setPromotionType(promotionType);
		super.setHotelnameOrWeb(hotelnameOrWeb);
		this.discount=discount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public PromotionVO toVO(PromotionPO po){
		BirthdayHotelproVO vo=new BirthdayHotelproVO();
		vo.setPromotionID(po.getPromotionID());
		vo.setPromotionName(po.getPromotionName());
		vo.setPromotionType(po.getPromotionType());
		vo.setHotelnameOrWeb(po.getHotelnameOrWeb());
		vo.setDiscount(((BirthdayHotelproPO)po).getDiscount());
		return vo;
	}

}
