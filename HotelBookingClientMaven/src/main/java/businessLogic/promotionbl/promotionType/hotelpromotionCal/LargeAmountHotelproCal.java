package businessLogic.promotionbl.promotionType.hotelpromotionCal;

import java.util.ArrayList;

import businessLogic.promotionbl.CalculatePrice;
import po.OrderPO;
import po.PromotionPO;
import po.personPO.PersonPO;
import po.promotionpo.hotelpromotionPO.LargeAmountHotelproPO;

/**
 *  @author 武秀峰
 *  酒店促销策略：三间及以上预订特惠*/
public class LargeAmountHotelproCal implements CalculatePrice{

	public double getprice(double initialtotal, PromotionPO po, PersonPO personpo,OrderPO orderpo) {
		double discountPrice=initialtotal;
		ArrayList<Integer> RoomnumList=orderpo.getRoomnum();
		int numOfRoom=0;//numOfRomm为房间的数量
		for(int i=0; i<RoomnumList.size(); i++){
			numOfRoom=numOfRoom+RoomnumList.get(i);
		}
		
		if(numOfRoom>=3){
			int discount=((LargeAmountHotelproPO) po).getDiscount();
			discountPrice=discountPrice*discount/100.0;
		}
		
		return discountPrice;
	}
}
