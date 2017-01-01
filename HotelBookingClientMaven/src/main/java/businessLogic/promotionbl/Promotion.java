package businessLogic.promotionbl;

import java.util.ArrayList;
import dataService.promotionDataService.PromotionDataService;
import po.PromotionPO;
import rmi.RemoteHelper;
import vo.promotionvo.PromotionVO;
/**
 * 
 * @author John
 * @author 武秀峰
 *
 */
public class Promotion {
	private PromotionDataService promotiondataservice;
	
	/**
	 * 增加促销策略
	 * @param prom
	 * @return 是否成功增加促销策略
	 */
	public boolean addProm(PromotionVO prom){
		PromotionPO promotionpo=prom.toPO(prom);
		return promotiondataservice.add(promotionpo);
	}
	
	/**
	 * 删除促销策略
	 * @param prom
	 * @return 是否成功删除促销策略
	 */
	public boolean deleteProm(PromotionVO prom){
		PromotionPO promotionpo=prom.toPO(prom);
		return promotiondataservice.delete(promotionpo);
	}
	
	/**
	 * 修改促销策略
	 * @param prom
	 * @return 是否成功修改促销策略
	 */
	public boolean modifyProm(PromotionVO prom){
		PromotionPO promotionpo=prom.toPO(prom);
		return promotiondataservice.modify(promotionpo);
	}
	
	/**
	 * 找到促销策略
	 * @param hotelnameOrWeb 
	 * 	注：返回酒店促销策略或者网站促销策略，当hotelNameOrWeb为"WebPromotion"时，返网站促销策略；
			否则为酒店名称，返回对应酒店促销策略
	 * @return ArrayList<PromotionVO> 促销策略列表
	 */
	public ArrayList<PromotionVO> getProm(String hotelnameOrWeb){
		//返回酒店促销策略或者网站促销策略，当hotelNameOrWeb为"WebPromotion"时，返网站促销策略；
		//否则为酒店名称，返回对应酒店促销策略
		ArrayList<PromotionPO> propoList=promotiondataservice.find(hotelnameOrWeb);
//		System.out.println("promotion:"+propoList.size());
		ArrayList<PromotionVO> provoList=new ArrayList<PromotionVO>();
		if(propoList!=null){
			for(int i=0; i<propoList.size(); i++){
				PromotionVO provo=(propoList.get(i)).toVO(propoList.get(i));
				provoList.add(provo);
			}
		}
		return provoList;
	}

	
	/**
	 * 构造函数
	 */
	public Promotion(){
		promotiondataservice=RemoteHelper.getInstance().getPromotionDataService();
	}
}
