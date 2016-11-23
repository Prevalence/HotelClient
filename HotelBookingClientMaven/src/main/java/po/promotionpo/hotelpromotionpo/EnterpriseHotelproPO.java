package po.promotionpo.hotelpromotionpo;

import java.util.ArrayList;

import po.PromotionPO;
import vo.promotionvo.hotelpromotionvo.BirthdayHotelproVO;
import vo.promotionvo.hotelpromotionvo.EnterpriseHotelproVO;

/**
 *  @author 武秀峰
 *  酒店促销策略：合作企业客户折扣*/
public class EnterpriseHotelproPO extends PromotionPO{
	private String promotionID;
	private String promotionType="HotelPromtion";
	private String hotelname;
	private ArrayList<String> enterprise;//合作企业名称列表
	private int discount;//如打九五折时，discount=95
	
	public EnterpriseHotelproPO(String promotionID, String hotelname, ArrayList<String> enterprise, int discount){
		this.promotionID=promotionID;
		this.hotelname=hotelname;
		this.enterprise=enterprise;
		this.discount=discount;
	}
	public EnterpriseHotelproPO(EnterpriseHotelproVO enterpriseHotelproVO){
		this.hotelname=enterpriseHotelproVO.getHotelname();
		this.enterprise=enterpriseHotelproVO.getEnterprise();
		this.discount=enterpriseHotelproVO.getDiscount();
	}
	
	public EnterpriseHotelproPO() {
		// TODO Auto-generated constructor stub
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
	
}
