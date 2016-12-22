package businessLogic.promotionbl.promotionType.hotelpromotionCal;

import java.util.Calendar;

import businessLogic.promotionbl.CalculatePrice;
import po.OrderPO;
import po.PromotionPO;
import po.personPO.PersonPO;
import po.promotionpo.hotelpromotionPO.BirthdayHotelproPO;

/**
 * @author 武秀峰
 * 酒店促销策略：生日特惠折扣*/
public class BirthdayHotelproCal implements CalculatePrice{

	/**
	 * @param initialtotal
	 * @param promotionpo
	 * @param personpo
	 * @param orderpo
	 * @return double 返回价格
	 * */
	public double getprice(double initialtotal, PromotionPO promotionpo, PersonPO personpo, OrderPO orderpo) {
		double discountPrice=initialtotal;
		if(personpo.getBirthday()!=null){
			Calendar calendar=Calendar.getInstance();
			boolean isMonthEqual=((calendar.get(Calendar.MONTH))==(personpo.getBirthday().get(Calendar.MONTH)));
			boolean isDateEqual=((calendar.get(Calendar.DATE))==(personpo.getBirthday().get(Calendar.DATE)));
			if(isMonthEqual&&isDateEqual){
				discountPrice=discountPrice*(((BirthdayHotelproPO) promotionpo).getDiscount())/100.0;
			}
			
		}
		
		return discountPrice;
	}
}
