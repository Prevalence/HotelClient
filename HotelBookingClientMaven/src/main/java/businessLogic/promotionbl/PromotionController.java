package businessLogic.promotionbl;

import java.util.ArrayList;
import java.util.List;

import businessLogicService.promotionblService.PromotionblService;
import po.PromotionPO;
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
	public double priceCut(HotelVO hotelPO,OrderVO orderVO){
		PriceCalc pricecalc=new PriceCalc();
		double result=pricecalc.priceCut(hotelPO, orderVO);
		return result;
	}
	
	
	/**
	 * 
	 * @param hotelname
	 * @return
	 */
	public ArrayList<PromotionVO>getProm(String hotelname){
		Promotion pro=new Promotion();
		return pro.getProm(hotelname);
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
