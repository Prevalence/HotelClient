package businessLogicService.promotionblService;

import java.util.ArrayList;

import vo.PromotionVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.orderVO.orderblVO.OrderVO;

public interface PromotionblService {
	/**
	 * 计算考虑优惠策略后的订单价格
	 * @param hotelvo
	 * @param ordervo
	 * @return 订单价格
	 */
	public double priceCut(HotelVO hotelvo,OrderVO ordervo);
	
	/**
	 * 增加促销策略
	 * @param prom
	 * @return 是否成功增加促销策略
	 */
	public boolean addProm(PromotionVO prom);
	
	/**
	 *删除促销策略 
	 * @param prom
	 * @return 是否成功删除促销策略
	 */
	public boolean deleteProm(PromotionVO prom);
	
	/**
	 * 修改促销策略
	 * @param prom
	 * @return 是否成功修改促销策略
	 */
	public boolean modifyProm(PromotionVO prom);
	
	/**
	 * 根据酒店名称找对应酒店的促销策略
	 * @param prom
	 * @return 促销策略列表，若没有，返回空的ArrayList<PromotionVO>
	 */
	public ArrayList<PromotionVO> getProm(String hotelname);
}
