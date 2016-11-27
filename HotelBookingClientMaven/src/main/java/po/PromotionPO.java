package po;

import java.io.Serializable;
import java.util.*;


/**
 * @author xiamutian
 * @author 谢凯航
 * @author 武秀峰
 */
public class PromotionPO implements Serializable {
	private String promotionID;//promotion的唯一标识
	private String promotionName;//promotion的名称，客户可见
	private String promotionType;
	private String hotelnameOrWeb;//若是酒店促销策略，则为酒店名称;若是网站促销策略，则为“WebPromotion”
	
	
	public PromotionPO() {
		super();
	}
//	public PromotionPO(String promotionID, String promotionName, String promotionType,
//			ArrayList<String> hotelnameOrWeb) {
//		super();
//		this.promotionID = promotionID;
//		this.promotionName = promotionName;
//		this.promotionType = promotionType;
//		this.hotelnameOrWeb = hotelnameOrWeb;
//	}
	public String getPromotionID() {
		return promotionID;
	}
	public void setPromotionID(String promotionID) {
		this.promotionID = promotionID;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public String getPromotionType() {
		return promotionType;
	}
	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}
	public String getHotelnameOrWeb() {
		return hotelnameOrWeb;
	}
	public void setHotelnameOrWeb(String hotelnameOrWeb) {
		this.hotelnameOrWeb = hotelnameOrWeb;
	}

	

}
