package vo.personVO;

import businessLogic.TimeFormTrans;
import po.personPO.RecordPO;

public class RecordVO {
	//时间，订单号，动作（订单执行、订单异常、订单撤销、充值），信用度变化、信用度结果
	private String time;
	private String orderId;
	private String operation;//"执行"\"异常"\"撤销"\"充值"
	private String changeCredit;
	private Integer resultCredit;
	
	public RecordVO() {
		super();
	}

	public RecordVO(String time, String orderId, String operation, String changeCredit, Integer resultCredit) {
		super();
		this.time = time;
		this.orderId = orderId;
		this.operation = operation;
		this.changeCredit = changeCredit;
		this.resultCredit = resultCredit;
	}

	public RecordVO(RecordPO po) {
		TimeFormTrans t=new TimeFormTrans();
		this.time = t.myToString(po.getTime());
		this.orderId = po.getOrderId();
		this.operation = po.getOperation();
		String credit=Integer.toString(po.getChangeCredit());
		this.changeCredit = credit;
		this.resultCredit = po.getResultCredit();
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getChangeCredit() {
		return changeCredit;
	}

	public void setChangeCredit(String changeCredit) {
		this.changeCredit = changeCredit;
	}

	public Integer getResultCredit() {
		return resultCredit;
	}

	public void setResultCredit(Integer resultCredit) {
		this.resultCredit = resultCredit;
	}


}
