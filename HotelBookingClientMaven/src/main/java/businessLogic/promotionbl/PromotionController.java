package businessLogic.promotionbl;

import java.util.ArrayList;
import java.util.List;

import businessLogicService.promotionblService.PromotionblService;
import po.HotelPO;
import po.PromotionPO;
import vo.OrderVO;
import vo.PromotionVO;

public class PromotionController implements PromotionblService{
	/**
	 * 
	 * @param hotelPO
	 * @param orderVO
	 * @return
	 */
	public double priceCut(HotelPO hotelPO,OrderVO orderVO){
		PriceCalc pricecalc=new PriceCalc();
		double result=pricecalc.priceCut(hotelPO, orderVO);
		return result;
	}
	
	
	/**
	 * 
	 * @param hotelname
	 * @return
	 */
	public ArrayList<PromotionPO>getProm(String hotelname){
		Promotion pro=new Promotion();
		ArrayList<PromotionPO> promList=(ArrayList<PromotionPO>) pro.getProm(hotelname);
		return promList;
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
