package vo.personVO;

import javafx.beans.property.SimpleStringProperty;

/**
 * 信用值变化VO，每一个记录一次信用变化
 * @author 铠联
 *
 */
public class CreditVO {
	private final SimpleStringProperty orderID;
    private final SimpleStringProperty time;
    private final SimpleStringProperty action;
    private final SimpleStringProperty change;

    public CreditVO(String orderID, String time, String action, String change) {
        this.orderID = new SimpleStringProperty(orderID);
        this.time = new SimpleStringProperty(time);
        this.action = new SimpleStringProperty(action);
        this.change = new SimpleStringProperty(change);
    }

    public String getOrderID() {
        return orderID.get();
    }

    public void setOrderID(String content) {
        orderID.set(content);
    }

    public String getTime() {
        return time.get();
    }

    public void setTime(String content) {
        time.set(content);
    }

    public String getAction() {
        return action.get();
    }

    public void setAction(String content) {
        action.set(content);
    }
    
    public String getChange() {
        return change.get();
    }

    public void setChange(String content) {
        change.set(content);
    }
}
