package businessLogic.promotionbl.promotionType.hotelpromotionCal;

import java.util.ArrayList;

import businessLogic.promotionbl.CalculatePrice;
import po.OrderPO;
import po.PromotionPO;
import po.hotelPO.RoomPO;
import po.personPO.PersonPO;
import po.promotionpo.hotelpromotionPO.LargeAmountHotelproPO;

/**
 *  @author 武秀峰
 *  酒店促销策略：三间及以上预订特惠*/
public class LargeAmountHotelproCal implements CalculatePrice{

	/**
	 * @param initialtotal
	 * @param promotionpo
	 * @param personpo
	 * @param orderpo
	 * @return double 返回价格
	 * */
	public double getprice(double initialtotal, PromotionPO promotionpo, PersonPO personpo,OrderPO orderpo) {
		double discountPrice=initialtotal;
		ArrayList<RoomPO> RoomnumList=orderpo.getRoom();
		
		if(RoomnumList.size()>=3){//当房间数量大于等于3时
			int discount=((LargeAmountHotelproPO) promotionpo).getDiscount();
			discountPrice=discountPrice*discount/100.0;
		}
		
		return discountPrice;
	}
}
