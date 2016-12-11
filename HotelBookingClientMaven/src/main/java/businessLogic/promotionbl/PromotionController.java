package businessLogic.promotionbl;

import java.util.ArrayList;

import businessLogicService.promotionblService.PromotionblService;
import vo.OrderVO;
import vo.PromotionVO;
import vo.hotelVO.hotelblVO.HotelVO;

public class PromotionController implements PromotionblService{
	/**
	 * 
	 * @param hotelPO
	 * @param orderVO
	 * @return
	 */
	public double priceCut(HotelVO hotelVO,OrderVO orderVO){
		PriceCalc pricecalc=new PriceCalc();
		double result=pricecalc.priceCut(hotelVO, orderVO);
		return result;
	}
	
	
	/**
	 * 返回酒店促销策略或者网站促销策略，当hotelNameOrWeb为"WebPromotion"时，返网站促销策略；
	 * 否则为酒店名称，返回对应酒店促销策略
	 * @param hotelnameOrWeb
	 * @return
	 */
	public ArrayList<PromotionVO>getProm(String hotelnameOrWeb){
		Promotion pro=new Promotion();
		return pro.getProm(hotelnameOrWeb);
	}
	/**
	 * 
	 * @param prom
	 * @param operation
	 * @return
	 */
	public boolean addProm(PromotionVO prom){
		Promotion pro=new Promotion();
		boolean result=pro.addProm(prom);
		return result;
	}
	/**
	 * 
	 * @param prom
	 * @return
	 */
	public boolean deleteProm(PromotionVO prom){
		Promotion pro=new Promotion();
		boolean result=pro.deleteProm(prom);
		return result;
	}
	/**
	 * 
	 * @param prom
	 * @return
	 */
	public boolean modifyProm(PromotionVO prom){
		Promotion pro=new Promotion();
		boolean result=pro.modifyProm(prom);
		return result;
	}

}
