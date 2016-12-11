package businessLogic.promotionbl.promotionType.webpromotionCal;

import java.rmi.RemoteException;

import businessLogic.hotelbl.Hotel;
import businessLogic.promotionbl.CalculatePrice;
import po.OrderPO;
import po.PromotionPO;
import po.personPO.PersonPO;
import po.promotionpo.webpromotionPO.CircleWebproPO;;

/**
 *  @author 武秀峰
 *  网站促销策略：VIP会员特定商圈专属折扣（不同等级不同商圈折扣不一样）*/
public class CircleWebproCal implements CalculatePrice {
	/*会员等级、商圈、折扣为一组，即vipLevel[i]、circle[i]、discount[i]为对应一组某等级的会员在某商圈的折扣*/

	public double getprice(double initialtotal, PromotionPO po, PersonPO personpo, OrderPO orderpo) {
		if(personpo.getVipType().equals("no")){//不是VIP会员时
			return initialtotal;
		}else{//是会员时
			double discountPrice=initialtotal;
			String hotelname=orderpo.getHotelname();
			Hotel hotel=new Hotel();
			String hotelCircle = null;
			try {
				hotelCircle = hotel.showHotelInfo(hotelname).getCircle();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//order中的hotel对应的商圈
//			ArrayList<Integer> vipLevel=((CircleWebproPO) po).getVipLevel();
//			ArrayList<String> circle=((CircleWebproPO) po).getCircle();
//			if(hotelCircle!=null)
//			for(int i=0; i<vipLevel.size(); i++){
//				if(vipLevel.get(i).equals(personpo.getVipLevel())&&(circle.get(i).equals(hotelCircle))){
//					int discount=((CircleWebproPO) po).getDiscount().get(i);
//					discountPrice=discountPrice*discount/100.0;
//				}
//			}
			int vipLevel=((CircleWebproPO) po).getVipLevel();
			String circle=((CircleWebproPO) po).getCircle();
			if(hotelCircle!=null)
			if(vipLevel==(personpo.getVipLevel())&&(circle.equals(hotelCircle))){
				int discount=((CircleWebproPO) po).getDiscount();
				discountPrice=discountPrice*discount/100.0;
			}
			
			return discountPrice;
		}
		
	}
}
