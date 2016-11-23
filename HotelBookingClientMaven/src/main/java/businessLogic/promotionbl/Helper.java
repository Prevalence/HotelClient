package businessLogic.promotionbl;

import businessLogic.promotionbl.promotionType.hotelpromotionCal.BirthdayHotelproCal;
import businessLogic.promotionbl.promotionType.hotelpromotionCal.EnterpriseHotelproCal;

/**
 * 
 * @author John
 *根据不同的促销策略类型返回对应的计算类
 */
public class Helper {
	public static CalculatePrice getcalculateinstance(String name){
		if(name.equals("生日"))
			return new BirthdayHotelproCal();
		if(name.equals("企业"))
			return new EnterpriseHotelproCal();
		return null;
	}
}
