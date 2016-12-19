package businessLogic.promotionbl.promotionType.hotelpromotionCal;

import java.util.Calendar;

import businessLogic.promotionbl.CalculatePrice;
import po.OrderPO;
import po.PromotionPO;
import po.personPO.PersonPO;
import po.promotionpo.hotelpromotionPO1.PeriodHotelproPO;

/**
 *  @author 武秀峰
 *  酒店促销策略：双11活动折扣（在特定的期间住宿有折扣）*/
public class PeriodHotelproCal implements CalculatePrice {

	/**
	 * @param initialtotal
	 * @param promotionpo
	 * @param personpo
	 * @param orderpo
	 * @return double 返回价格
	 * */
	public double getprice(double initialtotal, PromotionPO promotionpo, PersonPO personpo, OrderPO orderpo) {
		double discountPrice=initialtotal;
		boolean isAfterStartTime=((PeriodHotelproPO) promotionpo).getStartTime().before(Calendar.getInstance());
		boolean isBeforeEndTime=((PeriodHotelproPO) promotionpo).getEndTime().after(Calendar.getInstance());
		if(isAfterStartTime&&isBeforeEndTime){
			int discount=((PeriodHotelproPO) promotionpo).getDiscount();
			discountPrice=discountPrice*discount/100.0;
		}
		return discountPrice;
	}
}
