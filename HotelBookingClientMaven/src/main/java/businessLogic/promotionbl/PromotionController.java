package businessLogic.promotionbl;

import java.util.ArrayList;

import businessLogicService.promotionblService.PromotionblService;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.orderVO.orderblVO.OrderVO;
import vo.promotionvo.PromotionVO;

public class PromotionController implements PromotionblService{
	/**
	 * 得到最优价格
	 * @param hotelVO
	 * @param orderVO
	 * @return double 最优价格
	 */
	public double priceCut(HotelVO hotelVO,OrderVO orderVO){
		PriceCalc pricecalc=new PriceCalc();
		double result=pricecalc.priceCut(hotelVO, orderVO);
		return result;
	}
	
	/**
	 * 找到促销策略
	 * @param hotelnameOrWeb 
	 * 	注：返回酒店促销策略或者网站促销策略，当hotelNameOrWeb为"WebPromotion"时，返网站促销策略；
			否则为酒店名称，返回对应酒店促销策略
	 * @return ArrayList<PromotionVO> 促销策略列表
	 */
	public ArrayList<PromotionVO>getProm(String hotelnameOrWeb){
		Promotion pro=new Promotion();
		return pro.getProm(hotelnameOrWeb);
	}
	
	/**
	 * 增加促销策略
	 * @param prom
	 * @return 是否成功增加促销策略
	 */
	public boolean addProm(PromotionVO prom){
		System.out.println("vo:"+prom.getPromotionType());
		Promotion pro=new Promotion();
		boolean result=pro.addProm(prom);
		return result;
	}

	/**
	 * 删除促销策略
	 * @param prom
	 * @return 是否成功删除促销策略
	 */
	public boolean deleteProm(PromotionVO prom){
		Promotion pro=new Promotion();
		boolean result=pro.deleteProm(prom);
		return result;
	}

	/**
	 * 修改促销策略
	 * @param prom
	 * @return 是否成功修改促销策略
	 */
	public boolean modifyProm(PromotionVO prom){
		Promotion pro=new Promotion();
		boolean result=pro.modifyProm(prom);
		return result;
	}

}
