package data.dataHelper;

import java.util.ArrayList;
import po.OrderPO;

public interface OrderDataHelper {
	
	/**
	 * 从数据文件中读取订单数据
	 * @return ArrayList<OrderPO>
	 */
	public ArrayList<OrderPO> getOrderList();
	
	/**
	 * 向数据文件中写入订单数据
	 * @param list	
	 */
	public void updateOrderData(ArrayList<OrderPO> list);
}
