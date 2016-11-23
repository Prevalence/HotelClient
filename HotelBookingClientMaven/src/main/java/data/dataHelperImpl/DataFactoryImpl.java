package data.dataHelperImpl;

import data.dataHelper.DataFactory;
import data.dataHelper.OrderDataHelper;

public class DataFactoryImpl implements DataFactory{

	public OrderDataHelper getOrderDataHelper() {
		OrderDataHelper orderDao = new OrderDataTxtHelper();
		//OrderDao orderDao = new OrderDataMysqlHelper();
		return orderDao;
	}

}
