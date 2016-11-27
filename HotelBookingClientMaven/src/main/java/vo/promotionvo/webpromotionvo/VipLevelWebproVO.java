package vo.promotionvo.webpromotionvo;

import java.util.ArrayList;

import po.promotionpo.webpromotionpo.PeriodWebproPO;
import po.promotionpo.webpromotionpo.VipLevelWebproPO;
import vo.PromotionVO;

/**
 *@author 武秀峰
 *网站促销策略：制定会员等级及其折扣*/
public class VipLevelWebproVO extends PromotionVO{
//	private String promotionType="VipLevelWebPromtion";
	/*会员等级、折扣为一组，即vipLevel[i]、discount[i]为对应一组某等级的会员在某商圈的折扣*/
	private ArrayList<Integer> vipLevel;
	private ArrayList<Integer> discount;//如打九五折时，discount=95
	
	public VipLevelWebproVO() {
		super();
	}

	public VipLevelWebproVO(String promotionID, String promotionName, String promotionType,
			String hotelnameOrWeb,ArrayList<Integer> vipLevel, ArrayList<Integer> discount) {
		super.setPromotionID(promotionID);
		super.setPromotionName(promotionName);
		super.setPromotionType(promotionType);
		super.setHotelnameOrWeb(hotelnameOrWeb);
		this.vipLevel = vipLevel;
		this.discount = discount;
	}
	
	public ArrayList<Integer> getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(ArrayList<Integer> vipLevel) {
		this.vipLevel = vipLevel;
	}

	public ArrayList<Integer> getDiscount() {
		return discount;
	}

	public void setDiscount(ArrayList<Integer> discount) {
		this.discount = discount;
	}

	public VipLevelWebproPO toPO(VipLevelWebproVO vo){
		VipLevelWebproPO po=new VipLevelWebproPO();
		po.setPromotionID(vo.getPromotionID());
		po.setPromotionName(vo.getPromotionName());
		po.setPromotionType(vo.getPromotionType());
		po.setHotelnameOrWeb(vo.getHotelnameOrWeb());
		po.setVipLevel(vo.getVipLevel());
		po.setDiscount(vo.getDiscount());
		return po;
	}
}
