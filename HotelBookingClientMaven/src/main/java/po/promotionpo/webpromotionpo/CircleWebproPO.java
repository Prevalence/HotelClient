package po.promotionpo.webpromotionPO;

import java.util.ArrayList;

import po.PromotionPO;
import vo.promotionvo.webpromotionVO.CircleWebproVO;

/**
 *  @author 武秀峰
 *  网站促销策略：VIP会员特定商圈专属折扣（不不同商同等级圈折扣不一样）*/
public class CircleWebproPO extends PromotionPO {
//	private String promotionType="CircleWebPromtion";
	/*会员等级、商圈、折扣为一组，即vipLevel[i]、circle[i]、discount[i]为对应一组某等级的会员在某商圈的折扣*/
	private ArrayList<Integer> vipLevel;
	private ArrayList<String> circle;//商圈
	private ArrayList<Integer> discount;//如打九五折时，discount=95
	private static final long serialVersionUID = 1L;
	
	public CircleWebproPO() {
		super();
	}
	
	public CircleWebproPO(String promotionID, String promotionName, String promotionType,
			String hotelnameOrWeb,ArrayList<Integer> vipLevel, ArrayList<String> circle, ArrayList<Integer> discount) {
		super.setPromotionID(promotionID);
		super.setPromotionName(promotionName);
		super.setPromotionType(promotionType);
		super.setHotelnameOrWeb(hotelnameOrWeb);
		this.vipLevel = vipLevel;
		this.circle = circle;
		this.discount = discount;
	}
	public ArrayList<Integer> getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(ArrayList<Integer> vipLevel) {
		this.vipLevel = vipLevel;
	}
	public ArrayList<String> getCircle() {
		return circle;
	}
	public void setCircle(ArrayList<String> circle) {
		this.circle = circle;
	}
	public ArrayList<Integer> getDiscount() {
		return discount;
	}
	public void setDiscount(ArrayList<Integer> discount) {
		this.discount = discount;
	}

}
