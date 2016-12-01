package po.personpo;

import java.util.ArrayList;
import java.util.Calendar;

public class RecordPO {
	//时间，订单号，动作（订单执行、订单异常、订单撤销、充值），信用度变化、信用度结果
	private Calendar time;
	private String orderId;
	private String operation;//"执行"\"异常"\"撤销"\"充值"
	private int changeCredit;
	private Integer resultCredit;
	
	
	public RecordPO() {
		super();
	}

	public RecordPO(Calendar time, String orderId, String operation, int changeCredit, Integer resultCredit) {
		super();
		this.time = time;
		this.orderId = orderId;
		this.operation = operation;
		this.changeCredit = changeCredit;
		this.resultCredit = resultCredit;
	}


	public Calendar getTime() {
		return time;
	}


	public void setTime(Calendar time) {
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


	public int getChangeCredit() {
		return changeCredit;
	}


	public void setChangeCredit(int changeCredit) {
		this.changeCredit = changeCredit;
	}


	public Integer getResultCredit() {
		return resultCredit;
	}


	public void setResultCredit(Integer resultCredit) {
		this.resultCredit = resultCredit;
	}

	
	
}
