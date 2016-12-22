package vo.promotionvo.promotionuiVO;

import po.personPO.RecordPO;

public class PromotionuiVO {
	// 时间，订单号，动作（订单执行、订单异常、订单撤销、充值），信用度变化、信用度结果
	private String promotionID;
	private String promotionName;
	private String promotiontype;// "执行"\"异常"\"撤销"\"充值"

	public PromotionuiVO() {
	}

	public PromotionuiVO(String promotionID, String promotionName, String promotiontype) {
		this.promotionName = promotionName;
		this.promotionID = promotionID;
		this.promotiontype = promotiontype;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(String promotionID) {
		this.promotionID = promotionID;
	}

	public String getPromotiontype() {
		return promotiontype;
	}

	public void setPromotiontype(String promotiontype) {
		this.promotiontype = promotiontype;
	}
}
