package vo.promotionvo.webpromotionVO;

import po.PromotionPO;
import po.promotionpo.webpromotionPO.CircleWebproPO;
import vo.PromotionVO;

/**
 * @author 武秀峰
 * 网站促销策略：VIP会员特定商圈专属折扣（不同等级不同商圈折扣不一样）*/
public class CircleWebproVO extends PromotionVO{
//	private String promotionType="CircleWebPromtion";
	/*会员等级、商圈、折扣为一组，即vipLevel[i]、circle[i]、discount[i]为对应一组某等级的会员在某商圈的折扣*/
	private int vipLevel;
	private String circle;//商圈
	private int discount;//如打九五折时，discount=95
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	public CircleWebproVO() {
		super();
	}
	
	public CircleWebproVO(int promotionID, String promotionName, String promotionType,
			String hotelnameOrWeb,int vipLevel, String circle, int discount) {
		super.setPromotionID(promotionID);
		super.setPromotionName(promotionName);
		super.setPromotionType(promotionType);
		super.setHotelnameOrWeb(hotelnameOrWeb);
		this.vipLevel = vipLevel;
		this.circle = circle;
		this.discount = discount;
	}

	
	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public PromotionPO toPO(PromotionVO vo){
		CircleWebproPO po=new CircleWebproPO();
		po.setPromotionID(vo.getPromotionID());
		po.setPromotionName(vo.getPromotionName());
		po.setPromotionType(vo.getPromotionType());
		po.setHotelnameOrWeb(vo.getHotelnameOrWeb());
		po.setCircle(((CircleWebproVO)vo).getCircle());
		po.setVipLevel(((CircleWebproVO)vo).getVipLevel());
		po.setDiscount(((CircleWebproVO)vo).getDiscount());
		return po;
		
	}
}
