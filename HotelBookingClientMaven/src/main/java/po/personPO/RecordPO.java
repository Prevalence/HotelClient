package po.personPO;

import java.io.Serializable;
import java.util.Calendar;

import businessLogic.TimeFormTrans;
import vo.personVO.RecordVO;

public class RecordPO implements Serializable {
	//时间，订单号，动作（订单执行、订单异常、订单撤销、充值），信用度变化、信用度结果
	private Calendar time;
	private String orderId;
	private String operation;//"执行"\"异常"\"撤销"\"充值"
	private int changeCredit;
	private int resultCredit;
	
	public RecordPO() {
		super();
	}

	public RecordPO(Calendar time, String orderId, String operation, int changeCredit, int resultCredit) {
		super();
		this.time = time;
		this.orderId = orderId;
		this.operation = operation;
		this.changeCredit = changeCredit;
		this.resultCredit = resultCredit;
	}

	public RecordPO(RecordVO vo) {
		TimeFormTrans t=new TimeFormTrans();
		this.time = t.myToCalendar(vo.getTime());
		this.orderId = vo.getOrderId();
		this.operation = vo.getOperation();
		int credit=Integer.parseInt(vo.getChangeCredit());
		this.changeCredit = credit;
		this.resultCredit = Integer.parseInt(vo.getResultCredit());
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

	public int getResultCredit() {
		return resultCredit;
	}

	public void setResultCredit(int resultCredit) {
		this.resultCredit = resultCredit;
	}
	
}
