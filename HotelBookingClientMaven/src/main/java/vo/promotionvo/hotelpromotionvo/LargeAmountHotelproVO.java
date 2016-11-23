package vo.promotionvo.hotelpromotionvo;

import java.util.ArrayList;

import po.promotionpo.hotelpromotionpo.LargeAmountHotelproPO;

/**
 * @author 武秀峰
 * 酒店促销策略：三间及以上预订特惠*/
public class LargeAmountHotelproVO {
	private String promotionID;
	private String promotionType="HotelPromtion";
	private String hotelname;
	private int discount;//如打九五折时，discount=95

	public LargeAmountHotelproVO(String promotionID,String hotelname, int dicount){
		this.promotionID=promotionID;
		this.hotelname=hotelname;
		this.discount=dicount;
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
	public LargeAmountHotelproPO toPO(LargeAmountHotelproVO vo){
		LargeAmountHotelproPO po=new LargeAmountHotelproPO();
		po.setDiscount(vo.getDiscount());
		po.setHotelname(vo.getHotelname());
		po.setPromotionID(vo.getPromotionID());
		return po;
		
	}
}
