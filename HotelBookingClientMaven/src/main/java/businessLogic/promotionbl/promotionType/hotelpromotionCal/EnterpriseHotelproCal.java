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
	
	
	public double getprice(double initialtotal,PromotionPO po,PersonPO personpo,OrderPO orderpo) {
		ArrayList<String> enterprise;//合作企业名称列表
		double discountPrice=initialtotal;
		boolean contains=false;
		enterprise=((EnterpriseHotelproPO)po).getEnterprise();
		for(int i=0;i<enterprise.size();i++){
			if(enterprise.get(i).equals(personpo.getEnterpriseName())){
				contains=true;
				break;
			}
		}
		if(contains)
			discountPrice=discountPrice*(((EnterpriseHotelproPO)po).getDiscount())/100.0;
		return discountPrice;
		
	}
	
}
