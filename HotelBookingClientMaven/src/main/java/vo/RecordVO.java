package vo;

import java.util.ArrayList;
import java.util.Calendar;

public class RecordVO {
	//时间，订单号，动作（订单执行、订单异常、订单撤销、充值），信用度变化、信用度结果
	private ArrayList<Calendar> time;
	private ArrayList<String> orderId;
	private ArrayList<String> operation;//"执行"\"异常"\"撤销"\"充值"
	private ArrayList<Integer> changeCredit;
	private ArrayList<Integer> resultCredit;
	
	
	public RecordVO() {
		super();
	}

	public RecordVO(ArrayList<Calendar> time, ArrayList<String> orderId, ArrayList<String> operation,
			ArrayList<Integer> changeCredit, ArrayList<Integer> resultCredit) {
		super();
		this.time = time;
		this.orderId = orderId;
		this.operation = operation;
		this.changeCredit = changeCredit;
		this.resultCredit = resultCredit;
	}

	public ArrayList<Calendar> getTime() {
		return time;
	}

	public void setTime(ArrayList<Calendar> time) {
		this.time = time;
	}

	public ArrayList<String> getOrderId() {
		return orderId;
	}

	public void setOrderId(ArrayList<String> orderId) {
		this.orderId = orderId;
	}

	public ArrayList<String> getOperation() {
		return operation;
	}

	public void setOperation(ArrayList<String> operation) {
		this.operation = operation;
	}

	public ArrayList<Integer> getChangeCredit() {
		return changeCredit;
	}

	public void setChangeCredit(ArrayList<Integer> changeCredit) {
		this.changeCredit = changeCredit;
	}

	public ArrayList<Integer> getResultCredit() {
		return resultCredit;
	}

	public void setResultCredit(ArrayList<Integer> resultCredit) {
		this.resultCredit = resultCredit;
	}
	
}
