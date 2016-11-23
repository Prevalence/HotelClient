package po.promotionpo.hotelpromotionpo;

import po.PromotionPO;
import vo.promotionvo.hotelpromotionvo.LargeAmountHotelproVO;

/**
 *  @author 武秀峰
 *  酒店促销策略：三间及以上预订特惠*/
public class LargeAmountHotelproPO extends PromotionPO {
	private String promotionID;
	private String promotionType="HotelPromtion";
	private String hotelname;
	private int discount;//如打九五折时，discount=95

	public LargeAmountHotelproPO(String promotionID, String hotelname, int dicount){
		this.promotionID=promotionID;
		this.hotelname=hotelname;
		this.discount=dicount;
	}
	public LargeAmountHotelproPO(LargeAmountHotelproVO largeAmountHotelproVO){
		this.hotelname=largeAmountHotelproVO.getHotelname();
		this.discount=largeAmountHotelproVO.getDiscount();
	}
	
	public LargeAmountHotelproPO() {
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
