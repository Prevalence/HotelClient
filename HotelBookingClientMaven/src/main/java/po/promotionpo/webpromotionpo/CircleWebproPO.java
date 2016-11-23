package po.promotionpo.webpromotionpo;

import java.util.ArrayList;

import po.PromotionPO;
import vo.promotionvo.webpromotionvo.CircleWebproVO;

/**
 *  @author 武秀峰
 *  网站促销策略：VIP会员特定商圈专属折扣（不同等级不同商圈折扣不一样）*/
public class CircleWebproPO extends PromotionPO {
	private String promotionID;
	private String promotionType="WebPromtion";
	/*会员等级、商圈、折扣为一组，即vipLevel[i]、circle[i]、discount[i]为对应一组某等级的会员在某商圈的折扣*/
	private ArrayList<Integer> vipLevel;
	private ArrayList<String> circle;//商圈
	private ArrayList<Integer> discount;//如打九五折时，discount=95
	
	public CircleWebproPO(String promotionID, ArrayList<Integer> vipLevel, ArrayList<String> circle,ArrayList<Integer> discount){
		this.promotionID=promotionID;
		this.vipLevel=vipLevel;
		this.circle=circle;
		this.discount=discount;
	}
	public CircleWebproPO(CircleWebproVO circleWebproVO){
		this.vipLevel=circleWebproVO.getVipLevel();
		this.circle=circleWebproVO.getCircle();
		this.discount=circleWebproVO.getDiscount();
	}
	
	public CircleWebproPO() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Integer> getVipLevel(){
		return vipLevel;
	}
	public void setVipLevel(ArrayList<Integer> vipLevel){
		this.vipLevel=vipLevel;
	}
	public ArrayList<String> getCircle(){
		return circle;
	}
	public void setCircle(ArrayList<String> circle){
		this.circle=circle;
	}
	public ArrayList<Integer> getDiscount(){
		return discount;
	}
	public void setDiscount(ArrayList<Integer> discount){
		this.discount=discount;
	}
	public String getPromotionID() {
		return promotionID;
	}
	public void setPromotionID(String promotionID) {
		this.promotionID = promotionID;
	}
	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

}
