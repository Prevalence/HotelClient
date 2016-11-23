package businessLogic.promotionbl.promotionType.hotelpromotionCal;

import java.util.Calendar;

import businessLogic.promotionbl.CalculatePrice;
import po.OrderPO;
import po.PersonPO;
import po.PromotionPO;
import po.promotionpo.hotelpromotionpo.BirthdayHotelproPO;

/**
 * @author 武秀峰
 * 酒店促销策略：生日特惠折扣*/
public class BirthdayHotelproCal implements CalculatePrice{

	/**
	 * @param discount 如打九五折时，discount=95
	 * */
	public double getprice(double initialtotal, PromotionPO po, PersonPO personpo, OrderPO orderpo) {
		double discountPrice=initialtotal;
		Calendar calendar=Calendar.getInstance();
		//临时假逻辑，具体数字要从personpo里获得，personpo的属性可能需要修改，或者根据Calendar的API找一个String的返回值方法
		boolean isMonthEqual=((calendar.get(Calendar.MONTH)+1)==Integer.parseInt(personpo.getBirthday().substring(2, 4)));//(calendar.get(Calendar.MONTH)+1)为当前月份
		boolean isDateEqual=(calendar.get(Calendar.DATE)==Integer.parseInt(personpo.getBirthday().substring(4, 6)));
		if(isMonthEqual&&isDateEqual){
			discountPrice=discountPrice*(((BirthdayHotelproPO) po).getdiscount())/100.0;
		}
		return discountPrice;
	}
}
