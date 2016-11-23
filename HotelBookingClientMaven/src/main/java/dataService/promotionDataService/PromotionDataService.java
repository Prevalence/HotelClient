package dataService.promotionDataService;
import java.rmi.Remote;
import java.util.*;

import po.*;
public interface PromotionDataService extends Remote{
	/**
	 * 添加促销策略
	 * @param promotion
	 * @return
	 */
	public boolean add(PromotionPO promotion);
	/**
	 * 返回酒店的促销策略
	 * @param hotelnames
	 * @return
	 */
	public ArrayList <PromotionPO> find(String hotelnames);
	/**
	 * 修改酒店促销策略
	 * @param promotion
	 * @return
	 */
	public boolean modify(PromotionPO promotion);
	/**
	 * 删除酒店促销策略
	 * @param promotion
	 * @return
	 */
	public boolean delete(PromotionPO promotion);
}
