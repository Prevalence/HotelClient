package businessLogic.promotionbl.promotionType.hotelpromotionCal;

import java.util.ArrayList;

import businessLogic.promotionbl.CalculatePrice;
import po.OrderPO;
import po.PromotionPO;
import po.personPO.PersonPO;
import po.promotionpo.hotelpromotionPO.EnterpriseHotelproPO;

/**
 *  @author 武秀峰
 *  酒店促销策略：合作企业客户折扣*/
public class EnterpriseHotelproCal implements CalculatePrice{
	
	/**
	 * @param initialtotal
	 * @param promotionpo
	 * @param personpo
	 * @param orderpo
	 * @return double 返回价格
	 * */
	public double getprice(double initialtotal,PromotionPO promotionpo,PersonPO personpo,OrderPO orderpo) {
		ArrayList<String> enterprise;//合作企业名称列表
		double discountPrice=initialtotal;
		boolean contains=false;
		enterprise=((EnterpriseHotelproPO)promotionpo).getEnterprise();
		for(int i=0;i<enterprise.size();i++){
			if(enterprise.get(i).equals(personpo.getEnterpriseName())){
				contains=true;
				break;
			}
		}
		if(contains)
			discountPrice=discountPrice*(((EnterpriseHotelproPO)promotionpo).getDiscount())/100.0;
		return discountPrice;
		
	}
	
}
