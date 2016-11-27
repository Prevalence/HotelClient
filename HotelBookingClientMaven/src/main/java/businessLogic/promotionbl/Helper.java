package businessLogic.promotionbl;

import businessLogic.promotionbl.promotionType.hotelpromotionCal.BirthdayHotelproCal;
import businessLogic.promotionbl.promotionType.hotelpromotionCal.EnterpriseHotelproCal;
import businessLogic.promotionbl.promotionType.hotelpromotionCal.LargeAmountHotelproCal;
import businessLogic.promotionbl.promotionType.hotelpromotionCal.PeriodHotelproCal;
import businessLogic.promotionbl.promotionType.webpromotionCal.CircleWebproCal;
import businessLogic.promotionbl.promotionType.webpromotionCal.PeriodWebproCal;
import businessLogic.promotionbl.promotionType.webpromotionCal.VipLevelWebproCal;

/**
 * 
 * @author John
 *根据不同的促销策略类型返回对应的计算类
 */
public class Helper {
	public static CalculatePrice getcalculateinstance(String promotionType){
		if(promotionType.equals("BirthdayHotelPromtion"))
			return new BirthdayHotelproCal();
		if(promotionType.equals("EnterpriseHotelPromtion"))
			return new EnterpriseHotelproCal();
		if(promotionType.equals("LargeAmountHotelPromtion"))
			return new LargeAmountHotelproCal();
		if(promotionType.equals("PeriodHotelPromtion"))
			return new PeriodHotelproCal();
		if(promotionType.equals("CircleWebPromtion"))
			return new CircleWebproCal();
		if(promotionType.equals("PeriodWebPromtion"))
			return new PeriodWebproCal();
		if(promotionType.equals("VipLevelWebPromtion"))
			return new VipLevelWebproCal();
		
		return null;
	}
}
