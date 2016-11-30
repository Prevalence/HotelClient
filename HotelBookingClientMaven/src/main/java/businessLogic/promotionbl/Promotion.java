
package businessLogic.promotionbl;
import java.util.ArrayList;
import java.util.List;

import businessLogicService.promotionblService.PromotionblService;
import dataService.promotionDataService.PromotionDataService;
import po.PromotionPO;
import rmi.RemoteHelper;
import vo.OrderVO;
import vo.PromotionVO;
/**
 * 
 * @author John
 * @author 武秀峰
 *
 */
public class Promotion {
	private PromotionDataService promotiondataservice;
	/**
	 * 
	 * @param prom
	 * @param operation
	 * @return
	 */
	public boolean addProm(PromotionVO prom){
		PromotionPO promotionpo=prom.topo(prom);
		return promotiondataservice.add(promotionpo);
	}
	
	/**
	 * 
	 * @param prom
	 * @return
	 */
	public boolean deleteProm(PromotionVO prom){
		PromotionPO promotionpo=prom.topo(prom);
		return promotiondataservice.delete(promotionpo);
	}
	
	/**
	 * 
	 * @param prom
	 * @return
	 */
	public boolean modifyProm(PromotionVO prom){
		PromotionPO promotionpo=prom.topo(prom);
		return promotiondataservice.modify(promotionpo);
	}
	
	/**
	 * 找到促销策略
	 * @param hotelname
	 * @return
	 */
	public ArrayList<PromotionVO> getProm(String promotionType){
		//如果promotionType.equals("WebPromotion")，那么返回所有的网站促销策略
		//否则，promotionType为酒店名称，返回的是对应酒店的酒店促销策略
		ArrayList<PromotionPO> propoList=promotiondataservice.find(promotionType);
		ArrayList<PromotionVO> provoList=new ArrayList<PromotionVO>();
		for(int i=0; i<propoList.size(); i++){
			PromotionVO provo=new PromotionVO(propoList.get(i));
			provoList.add(provo);
		}
		
		return provoList;
	}

	
	/*构造函数*/
	public Promotion(){
		promotiondataservice=RemoteHelper.getInstance().getPromotionDataService();
	}
}
