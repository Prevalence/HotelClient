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
		Calendar calendar=Calendar.getInstance();
		//临时假逻辑，具体数字要从personpo里获得，personpo的属性可能需要修改，或者根据Calendar的API找一个String的返回值方法
		@SuppressWarnings("deprecation")
		boolean isMonthEqual=((calendar.get(Calendar.MONTH))==(personpo.getBirthday().getTime().getMonth()));
		@SuppressWarnings("deprecation")
		boolean isDateEqual=((calendar.get(Calendar.DATE))==(personpo.getBirthday().getTime().getDate()));
		if(isMonthEqual&&isDateEqual){
			discountPrice=discountPrice*(((BirthdayHotelproPO) promotionpo).getDiscount())/100.0;
		}
		return discountPrice;
	}
}
