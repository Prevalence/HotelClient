package businessLogic.promotionbl;

import businessLogic.promotionbl.promotionType.hotelpromotionCal.BirthdayHotelproCal;
import businessLogic.promotionbl.promotionType.hotelpromotionCal.EnterpriseHotelproCal;
import businessLogic.promotionbl.promotionType.hotelpromotionCal.LargeAmountHotelproCal;
import businessLogic.promotionbl.promotionType.hotelpromotionCal.PeriodHotelproCal;
import businessLogic.promotionbl.promotionType.webpromotionCal.CircleWebproCal;
import businessLogic.promotionbl.promotionType.webpromotionCal.PeriodWebproCal;
//import businessLogic.promotionbl.promotionType.webpromotionCal.VipLevelWebproCal;

/**
 * 
 * @author John
 *根据不同的促销策略类型返回对应的计算类
 */
public class Helper {
	/*
	 * 生日优惠策略、企业优惠策略、多购优惠策略、特定时间优惠策略、网站商圈优惠策略、网站特定时间优惠策略
	 */
	public static CalculatePrice getcalculateinstance(String promotionType){
		if(promotionType.equals("生日优惠策略")){
			return new BirthdayHotelproCal();
		}
		if(promotionType.equals("企业优惠策略")){
			return new EnterpriseHotelproCal();
		}
		if(promotionType.equals("多购优惠策略"))
			return new LargeAmountHotelproCal();
		if(promotionType.equals("特定时间优惠策略"))
			return new PeriodHotelproCal();
		if(promotionType.equals("网站商圈优惠策略"))
			return new CircleWebproCal();
		if(promotionType.equals("网站特定时间优惠策略"))
			return new PeriodWebproCal();
//		if(promotionType.equals("VipLevelWebPromotion"))
//			return new VipLevelWebproCal();
		
		return null;
	}
}
