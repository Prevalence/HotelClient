package businessLogic.promotionbl.promotionType.webpromotionCal;

import java.util.Calendar;

import businessLogic.promotionbl.CalculatePrice;
import po.OrderPO;
import po.PromotionPO;
import po.personPO.PersonPO;
import po.promotionpo.webpromotionPO.PeriodWebproPO;;


/**
 *  @author 武秀峰
 *  网站促销策略：双11活动折扣（在特定的期间预订有折扣）*/
public class PeriodWebproCal implements CalculatePrice {

	/**
	 * @param initialtotal
	 * @param promotionpo
	 * @param personpo
	 * @param orderpo
	 * @return double 返回价格
	 * */
	public double getprice(double initialtotal, PromotionPO promotionpo, PersonPO personpo, OrderPO orderpo) {
		double discountPrice=initialtotal;
		boolean isAfterStartTime=((PeriodWebproPO) promotionpo).getStartTime().before(Calendar.getInstance());
		boolean isBeforeEndTime=((PeriodWebproPO) promotionpo).getEndTime().after(Calendar.getInstance());
		if(isAfterStartTime&&isBeforeEndTime){
			int discount=((PeriodWebproPO) promotionpo).getDiscount();
			discountPrice=discountPrice*discount/100.0;
		}
		return discountPrice;
	}
}
