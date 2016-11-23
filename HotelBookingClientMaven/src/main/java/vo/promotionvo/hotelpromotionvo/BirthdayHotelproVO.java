package vo.promotionvo.hotelpromotionvo;

import po.promotionpo.hotelpromotionpo.BirthdayHotelproPO;

/**
 * @author 武秀峰
 * 酒店促销策略：生日特惠折扣*/
public class BirthdayHotelproVO {
	private String promotionID;
	private String promotionType="HotelPromtion";
	private String hotelname;
	private int discount;//如打九五折时，discount=95
	public BirthdayHotelproVO(String promotionID, String hotelname, int discount){
		this.promotionID=promotionID;
		this.hotelname=hotelname;
		this.discount=discount;
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

	public String getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(String promotionID) {
		this.promotionID = promotionID;
	}

	public String getPromotionType() {
		return promotionType;
	}
	public BirthdayHotelproPO toPO(BirthdayHotelproVO vo){
		BirthdayHotelproPO po=new BirthdayHotelproPO();
		po.setDiscount(vo.getDiscount());
		po.setHotelname(vo.getHotelname());
		po.setPromotionID(vo.getPromotionID());
		return po;
		
	}

}
