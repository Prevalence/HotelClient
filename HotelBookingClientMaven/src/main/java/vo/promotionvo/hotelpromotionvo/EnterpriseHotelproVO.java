package vo.promotionvo.hotelpromotionvo;

import java.util.ArrayList;

import po.promotionpo.hotelpromotionpo.EnterpriseHotelproPO;

/**
 * @author 武秀峰
 * 酒店促销策略：合作企业客户折扣*/
public class EnterpriseHotelproVO {
	private String promotionID;
	private String promotionType="HotelPromtion";
	private String hotelname;
	private ArrayList<String> enterprise;//合作企业名称列表
	private int discount;//如打九五折时，discount=95
	
	public EnterpriseHotelproVO(String promotionID, String hotelname, ArrayList<String> enterprise, int discount){
		this.promotionID=promotionID;
		this.hotelname=hotelname;
		this.enterprise=enterprise;
		this.discount=discount;
	}
	
	public String getHotelname(){
		return hotelname;
	}
	public void setHotelname(String hotelname){
		this.hotelname=hotelname;
	}
	public ArrayList<String> getEnterprise(){
		return enterprise;
	}
	public void setEnterprise(ArrayList<String> enterprise){
		this.enterprise=enterprise;
	}
	public int getDiscount(){
		return discount;
	}
	public void setDiscount(int discount){
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
	public EnterpriseHotelproPO toPO(EnterpriseHotelproVO vo){
		EnterpriseHotelproPO po=new EnterpriseHotelproPO();
		po.setDiscount(vo.getDiscount());
		po.setHotelname(vo.getHotelname());
		po.setPromotionID(vo.getPromotionID());
		po.setEnterprise(vo.getEnterprise());
		return po;
		
	}
}
