package vo.promotionvo.webpromotionvo;

import java.util.ArrayList;

import po.promotionpo.webpromotionpo.PeriodWebproPO;
import po.promotionpo.webpromotionpo.VipLevelWebproPO;

/**
 *@author 武秀峰
 *网站促销策略：制定会员等级及其折扣*/
public class VipLevelWebproVO {
	private String promotionID;
	private String promotionType="WebPromtion";
	/*会员等级、折扣为一组，即vipLevel[i]、discount[i]为对应一组某等级的会员在某商圈的折扣*/
	private ArrayList<Integer> vipLevel;
	private ArrayList<Integer> discount;//如打九五折时，discount=95
	
	public VipLevelWebproVO(String promotionID, ArrayList<Integer> vipLevel, ArrayList<Integer> discount){
		this.promotionID=promotionID;
		this.vipLevel=vipLevel;
		this.discount=discount;
	}
	
	public ArrayList<Integer> getVipLevel(){
		return vipLevel;
	}
	public void setVipLevel(ArrayList<Integer> vipLevel){
		this.vipLevel=vipLevel;
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

	public String getPromotionType() {
		return promotionType;
	}
	public VipLevelWebproPO toPO(VipLevelWebproVO vo){
		VipLevelWebproPO po=new VipLevelWebproPO();
		po.setDiscount(vo.getDiscount());
		po.setVipLevel(vo.getVipLevel());
		po.setPromotionID(vo.getPromotionID());
		return po;
	}
}
