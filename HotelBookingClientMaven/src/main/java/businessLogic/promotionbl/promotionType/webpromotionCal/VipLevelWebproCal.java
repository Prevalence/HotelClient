package businessLogic.promotionbl.promotionType.webpromotionCal;

import java.util.ArrayList;

import businessLogic.promotionbl.CalculatePrice;
import po.OrderPO;
import po.PromotionPO;
import po.personPO.PersonPO;
import po.promotionpo.webpromotionPO.VipLevelWebproPO;;

/**
 *  @author 武秀峰
 *  网站促销策略：制定会员等级及其折扣*/
public class VipLevelWebproCal implements CalculatePrice {
	/*会员等级、折扣为一组，即vipLevel[i]、discount[i]为对应一组某等级的会员在某商圈的折扣*/

	public double getprice(double initialtotal, PromotionPO po, PersonPO personpo, OrderPO orderpo) {
		
		if(personpo.getVipType().equals("no")){//不是VIP会员时
			return initialtotal;
		}else{//是会员时
			double discountPrice=initialtotal;
			ArrayList<Integer> vipLevel=((VipLevelWebproPO) po).getVipLevel();
			for(int i=0; i<vipLevel.size(); i++){
				if(vipLevel.get(i).equals(personpo.getVipLevel())){
					int discount=((VipLevelWebproPO) po).getDiscount().get(i);
					discountPrice=discountPrice*discount/100.0;
				}
			}
			
			return discountPrice;
		}
	}
}
