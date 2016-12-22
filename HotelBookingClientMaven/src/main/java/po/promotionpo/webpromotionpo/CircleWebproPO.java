package po.promotionpo.webpromotionPO;


import po.PromotionPO;
import vo.PromotionVO;
import vo.promotionvo.webpromotionVO.CircleWebproVO;

/**
 *  @author 武秀峰
 *  网站促销策略：VIP会员特定商圈专属折扣（不同商圈不同等级圈折扣不一样）*/
public class CircleWebproPO extends PromotionPO {	
//	private String promotionType="网站商圈优惠策略";
	/*会员等级、商圈、折扣为一组，即vipLevel[i]、circle[i]、discount[i]为对应一组某等级的会员在某商圈的折扣*/
	private int vipLevel;
	private String circle;//商圈
	private int discount;//如打九五折时，discount=95
	private static final long serialVersionUID = 1L;
	
	public CircleWebproPO() {
		super();
	}
	
	public CircleWebproPO(int promotionID, String promotionName, String promotionType,
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

	public PromotionVO toVO(PromotionPO po){
		CircleWebproVO vo=new CircleWebproVO();
		vo.setPromotionID(po.getPromotionID());
		vo.setPromotionName(po.getPromotionName());
		vo.setPromotionType(po.getPromotionType());
		vo.setHotelnameOrWeb(po.getHotelnameOrWeb());
		vo.setCircle(((CircleWebproPO)po).getCircle());
		vo.setVipLevel(((CircleWebproPO)po).getVipLevel());
		vo.setDiscount(((CircleWebproPO)po).getDiscount());
		return vo;
		
	}

}
