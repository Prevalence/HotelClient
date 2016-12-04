package businessLogicService.promotionblService;

import java.util.List;

import vo.OrderVO;
import vo.PromotionVO;
import vo.hotelVO.hotelblVO.HotelVO;

public interface PromotionblService {
	/**
	 * 
	 * @param price
	 * @param numberAndType(OrderVO)
	 * @return 酒店价格
	 */
	public double priceCut(HotelVO price,OrderVO numberAndType);
	/**
	 * 
	 * @param prom
	 * @return 是否成功增加促销策略
	 */
	public boolean addProm(PromotionVO prom);
	/**
	 * 
	 * @param prom
	 * @return 是否成功删除促销策略
	 */
	public boolean deleteProm(PromotionVO prom);
	/**
	 * 
	 * @param prom
	 * @return 是否成功修改促销策略
	 */
	public boolean modifyProm(PromotionVO prom);
	/**
	 * 
	 * @param prom
	 * @return 促销策略列表
	 */
	public List<PromotionVO>getProm(String hotelname);
}
