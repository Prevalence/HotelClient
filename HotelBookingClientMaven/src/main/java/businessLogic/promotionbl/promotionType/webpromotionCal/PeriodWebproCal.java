package businessLogic.promotionbl.promotionType.webpromotionCal;

import java.util.Calendar;

import businessLogic.promotionbl.CalculatePrice;
import po.OrderPO;
import po.PersonPO;
import po.PromotionPO;
import po.promotionpo.webpromotionpo.PeriodWebproPO;;


/**
 *  @author 武秀峰
 *  网站促销策略：双11活动折扣（在特定的期间预订有折扣）*/
public class PeriodWebproCal implements CalculatePrice {

	public double getprice(double initialtotal, PromotionPO po, PersonPO personpo, OrderPO orderpo) {
		double discountPrice=initialtotal;
		boolean isAfterStartTime=((PeriodWebproPO) po).getStartTime().before(Calendar.getInstance());
		boolean isBeforeEndTime=((PeriodWebproPO) po).getEndTime().after(Calendar.getInstance());
		if(isAfterStartTime&&isBeforeEndTime){
			int discount=((PeriodWebproPO) po).getDiscount();
			discountPrice=discountPrice*discount/100.0;
		}
		return discountPrice;
	}
}
