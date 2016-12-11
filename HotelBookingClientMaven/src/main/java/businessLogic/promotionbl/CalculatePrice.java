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
	
	/**
	 * 计算价格
	 * @param initialtotal
	 * @param promotionpo
	 * @param personpo
	 * @param orderpo
	 * @return double 返回价格
	 */
	public double getprice(double initialtotal,PromotionPO promotionpo,PersonPO personpo,OrderPO orderpo);
		
	
}
