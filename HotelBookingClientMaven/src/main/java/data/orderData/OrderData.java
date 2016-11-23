package data.orderData;

import java.util.ArrayList;

import data.dataHelper.DataFactory;
import data.dataHelper.OrderDataHelper;
import data.dataHelperImpl.DataFactoryImpl;
import dataService.orderDataService.OrderDataService;
import po.OrderPO;

public class OrderData implements OrderDataService {

	private ArrayList<OrderPO> list = null;

	private OrderDataHelper orderDataHelper;

	private DataFactory dataFactory;

	private static OrderData orderData = null;

	public static OrderData getOrderData() {
		if (orderData == null) {
			orderData = new OrderDataMock();
			return orderData;
		}
		return orderData;
	}

	public OrderData() {
		if (list == null) {
			dataFactory = new DataFactoryImpl();
			orderDataHelper = dataFactory.getOrderDataHelper();
			list = orderDataHelper.getOrderList();
		}
	}

	public void add(OrderPO order) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<OrderPO> personFind(String personname) {
		// TODO Auto-generated method stub
		return null;
	}

	public void modify(OrderPO order) {
		// TODO Auto-generated method stub

	}

	public ArrayList<OrderPO> hotelFind(String hotelname) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> exceptionFind() {
		// TODO Auto-generated method stub
		return null;
	}

}
