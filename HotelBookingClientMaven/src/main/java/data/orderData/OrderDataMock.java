package data.orderData;

import java.util.ArrayList;

import po.OrderPO;

public class OrderDataMock extends OrderData {
	OrderPO order1 = new OrderPO();
	OrderPO order2 = new OrderPO();
	OrderPO order3 = new OrderPO();
	private ArrayList<OrderPO> list = new ArrayList<OrderPO>();

	public OrderDataMock() {
		order1.setID("1");
		order1.setPersonname("xiekailian");
		order1.setHotelname("nju");
		order1.setTime("10/1");
		order1.setOrderstate(0);
		order2.setID("2");
		order2.setPersonname("xiamutian");
		order2.setHotelname("nju");
		order2.setTime("10/2");
		order2.setOrderstate(1);
		order3.setID("3");
		order3.setPersonname("xiekaihang");
		order3.setHotelname("gulou");
		order3.setTime("10/3");
		order3.setOrderstate(2);
		list.add(order1);
		list.add(order2);
		list.add(order3);
	}

	@Override
	public ArrayList<OrderPO> personFind(String personname) {
		ArrayList<OrderPO> personList=new ArrayList<OrderPO>();
		OrderPO temp=null;
		for (int i = 0; i < list.size(); i++) {
			temp=list.get(i);
			if (temp.getPersonname().equals(personname)) {
				personList.add(temp);
			}
		}
		return personList;
	}

	@Override
	public ArrayList<OrderPO> hotelFind(String hotelname) {
		ArrayList<OrderPO> hotelList=new ArrayList<OrderPO>();
		OrderPO temp=null;
		for (int i = 0; i < list.size(); i++) {
			temp=list.get(i);
			if (temp.getHotelname().equals(hotelname)) {
				hotelList.add(temp);
			}
		}
		return hotelList;
	}

	@Override
	public ArrayList<OrderPO> exceptionFind() {
		// TODO Auto-generated method stub
		return list;
	}

}
