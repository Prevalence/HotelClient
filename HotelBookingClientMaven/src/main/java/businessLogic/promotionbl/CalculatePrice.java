package businessLogic.promotionbl;


import po.OrderPO;
import po.PromotionPO;
import po.personPO.PersonPO;


/**
 * 
 * @author John
 *这个接口被多种实际的价格计算逻辑所实现
 */
public interface CalculatePrice {
	public double getprice(double initialtotal,PromotionPO po,PersonPO personpo,OrderPO orderpo);
		
	
}
