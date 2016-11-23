package businessLogic.promotion;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import businessLogic.promotionbl.PriceCalc;
import po.HotelPO;
import vo.OrderVO;

public class PriceCalcTest {
	PriceCalc price=new PriceCalc();
	@Test
	public void testPriceCut() {
		HotelPO hotel=new HotelPO();
		ArrayList<Integer> roomprice=new ArrayList<Integer>();
		roomprice.add(200);
		roomprice.add(300);
		ArrayList<String> roomtype=new ArrayList<String>();
		roomtype.add("单人房");
		roomtype.add("双人房");
		hotel.setRoomPrice(roomprice);
		hotel.setRoomType(roomtype);
		OrderVO or=new OrderVO();
		ArrayList<Integer> roomnum=new ArrayList<Integer>();
		roomnum.add(5);
		or.setRoomnum(roomnum);
		ArrayList<String> roomty=new ArrayList<String>();
		roomty.add("单人房");
		or.setRoomtype(roomty);
		assertEquals(1000,price.priceCut(hotel, or),1.0);
	}
}
