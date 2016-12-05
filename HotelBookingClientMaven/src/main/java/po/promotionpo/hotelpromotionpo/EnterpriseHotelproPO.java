package po.promotionpo.hotelpromotionPO;

import java.util.ArrayList;

import po.PromotionPO;
import vo.promotionvo.hotelpromotionVO.BirthdayHotelproVO;
import vo.promotionvo.hotelpromotionVO.EnterpriseHotelproVO;

/**
 *  @author 武秀峰
 *  酒店促销策略：合作企业客户折扣*/
public class EnterpriseHotelproPO extends PromotionPO{
//	private String promotionType="EnterpriseHotelPromtion";
	private ArrayList<String> enterprise;//合作企业名称列表
	private int discount;//如打九五折时，discount=95
	private static final long serialVersionUID = 1L;
	public EnterpriseHotelproPO() {
		super();
	}

	public EnterpriseHotelproPO(String promotionID, String promotionName, String promotionType,
			String hotelnameOrWeb, ArrayList<String> enterprise, int discount) {
		super.setPromotionID(promotionID);
		super.setPromotionName(promotionName);
		super.setPromotionType(promotionType);
		super.setHotelnameOrWeb(hotelnameOrWeb);
		this.enterprise=enterprise;
		this.discount=discount;
	}

	public ArrayList<String> getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(ArrayList<String> enterprise) {
		this.enterprise = enterprise;
	}


	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
}
