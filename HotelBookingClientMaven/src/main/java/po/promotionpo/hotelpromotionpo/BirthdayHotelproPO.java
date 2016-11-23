package po.promotionpo.hotelpromotionpo;

import po.PromotionPO;
import vo.promotionvo.hotelpromotionvo.BirthdayHotelproVO;

/**
 *  @author 武秀峰
 *  酒店促销策略：生日特惠折扣*/
public class BirthdayHotelproPO extends PromotionPO{
	private String promotionID;
	private String promotionType="BirthdayHotelPromtion";
	private String hotelname;
	private int discount;//如打九五折时，discount=95
	public BirthdayHotelproPO(String promotionID, String hotelname, int discount){
		this.promotionID=promotionID;
		this.hotelname=hotelname;
		this.discount=discount;
	}
	public BirthdayHotelproPO(BirthdayHotelproVO birthdayHotelproVO){
		this.hotelname=birthdayHotelproVO.getHotelname();
		this.discount=birthdayHotelproVO.getDiscount();
	}
	
	public BirthdayHotelproPO() {
		// TODO Auto-generated constructor stub
	}
	public String getHotelname(){
		return hotelname;
	}
	public void setHotelname(String hotelname){
		this.hotelname=hotelname;
	}
	public int getDiscount(){
		return discount;
	}
	public void setDiscount(int discount){
		this.discount=discount;
	}
	public int getdiscount(){
		return discount;
	}
	public String getPromotionID() {
		return promotionID;
	}
	public void setPromotionID(String promotionID) {
		this.promotionID = promotionID;
	}
	public String getPromotionType() {
		return this.promotionType;
	}
}
