package businessLogic.promotionbl.promotionType.hotelpromotionCal;

import java.util.Calendar;

import businessLogic.promotionbl.CalculatePrice;
import po.OrderPO;
import po.PromotionPO;
import po.personPO.PersonPO;
import po.promotionpo.hotelpromotionPO.PeriodHotelproPO;

/**
 *  @author 武秀峰
 *  酒店促销策略：双11活动折扣（在特定的期间住宿有折扣）*/
public class PeriodHotelproCal implements CalculatePrice {

	public double getprice(double initialtotal, PromotionPO po, PersonPO personpo, OrderPO orderpo) {
		double discountPrice=initialtotal;
		boolean isAfterStartTime=((PeriodHotelproPO) po).getStartTime().before(Calendar.getInstance());
		boolean isBeforeEndTime=((PeriodHotelproPO) po).getEndTime().after(Calendar.getInstance());
		if(isAfterStartTime&&isBeforeEndTime){
			int discount=((PeriodHotelproPO) po).getDiscount();
			discountPrice=discountPrice*discount/100.0;
		}
		return discountPrice;
	}
}
