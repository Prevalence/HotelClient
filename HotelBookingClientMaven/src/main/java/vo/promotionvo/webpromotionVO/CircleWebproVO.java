package vo.promotionvo.webpromotionVO;

import java.util.ArrayList;

import po.promotionpo.hotelpromotionPO.BirthdayHotelproPO;
import po.promotionpo.webpromotionPO.CircleWebproPO;
import vo.PromotionVO;
import vo.promotionvo.hotelpromotionVO.BirthdayHotelproVO;

/**
 * @author 武秀峰
 * 网站促销策略：VIP会员特定商圈专属折扣（不同等级不同商圈折扣不一样）*/
public class CircleWebproVO extends PromotionVO{
//	private String promotionType="CircleWebPromtion";
	/*会员等级、商圈、折扣为一组，即vipLevel[i]、circle[i]、discount[i]为对应一组某等级的会员在某商圈的折扣*/
	private ArrayList<Integer> vipLevel;
	private ArrayList<String> circle;//商圈
	private ArrayList<Integer> discount;//如打九五折时，discount=95
	
	public CircleWebproVO() {
		super();
	}
	
	public CircleWebproVO(String promotionID, String promotionName, String promotionType,
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

	public CircleWebproPO toPO(CircleWebproVO vo){
		CircleWebproPO po=new CircleWebproPO();
		po.setPromotionID(vo.getPromotionID());
		po.setPromotionName(vo.getPromotionName());
		po.setPromotionType(vo.getPromotionType());
		po.setHotelnameOrWeb(vo.getHotelnameOrWeb());
		po.setCircle(vo.getCircle());
		po.setVipLevel(vo.getVipLevel());
		po.setDiscount(vo.getDiscount());
		return po;
		
	}
}
