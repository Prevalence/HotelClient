package vo.promotionvo.hotelpromotionVO;

import java.util.ArrayList;

import po.PromotionPO;
import po.promotionpo.hotelpromotionPO.EnterpriseHotelproPO;
import vo.PromotionVO;

/**
 * @author 武秀峰
 * 酒店促销策略：合作企业客户折扣*/
public class EnterpriseHotelproVO extends PromotionVO {
//	private String promotionType="EnterpriseHotelPromtion";
	private ArrayList<String> enterprise;//合作企业名称列表
	private int discount;//如打九五折时，discount=95
	
	public EnterpriseHotelproVO() {
		super();
	}
	
	public EnterpriseHotelproVO(String promotionID, String promotionName, String promotionType,
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
	
//	public EnterpriseHotelproPO toPO(EnterpriseHotelproVO vo){
//		EnterpriseHotelproPO po=new EnterpriseHotelproPO();
//		po.setPromotionID(vo.getPromotionID());
//		po.setPromotionName(vo.getPromotionName());
//		po.setPromotionType(vo.getPromotionType());
//		po.setHotelnameOrWeb(vo.getHotelnameOrWeb());
//		po.setEnterprise(vo.getEnterprise());
//		po.setDiscount(vo.getDiscount());
//		return po;
//	}
	
	public PromotionPO toPO(PromotionVO vo){
		EnterpriseHotelproPO po=new EnterpriseHotelproPO();
		po.setPromotionID(vo.getPromotionID());
		po.setPromotionName(vo.getPromotionName());
		po.setPromotionType(vo.getPromotionType());
		po.setHotelnameOrWeb(vo.getHotelnameOrWeb());
		po.setEnterprise(((EnterpriseHotelproVO)vo).getEnterprise());
		po.setDiscount(((EnterpriseHotelproVO)vo).getDiscount());
		return po;
	}
	
}
