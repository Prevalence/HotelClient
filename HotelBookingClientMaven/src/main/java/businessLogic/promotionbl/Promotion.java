
package businessLogic.promotionbl;
import java.util.ArrayList;
import dataService.promotionDataService.PromotionDataService;
import po.PromotionPO;
import rmi.RemoteHelper;
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
		PromotionPO promotionpo=prom.toPO(prom);
		return promotiondataservice.add(promotionpo);
	}
	
	/**
	 * 
	 * @param prom
	 * @return
	 */
	public boolean deleteProm(PromotionVO prom){
		PromotionPO promotionpo=prom.toPO(prom);
		return promotiondataservice.delete(promotionpo);
	}
	
	/**
	 * 
	 * @param prom
	 * @return
	 */
	public boolean modifyProm(PromotionVO prom){
		PromotionPO promotionpo=prom.toPO(prom);
		return promotiondataservice.modify(promotionpo);
	}
	
	/**
	 * 找到促销策略
	 * @param hotelname
	 * @return
	 */
	public ArrayList<PromotionVO> getProm(String hotelnameOrWeb){
		//返回酒店促销策略或者网站促销策略，当hotelNameOrWeb为"WebPromotion"时，返网站促销策略；
		//否则为酒店名称，返回对应酒店促销策略
		ArrayList<PromotionPO> propoList=promotiondataservice.find(hotelnameOrWeb);
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
