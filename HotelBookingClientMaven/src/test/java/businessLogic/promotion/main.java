package businessLogic.promotion;

import po.PromotionPO;
import vo.PromotionVO;
import vo.promotionvo.hotelpromotionvo.BirthdayHotelproVO;

public class main {
	public static void main(String[] args) {
		BirthdayHotelproVO prom=new BirthdayHotelproVO("123", "生日折扣","BirthdayHotelPromtion",
				"南京大酒店", 500);
		System.out.println(prom.getPromotionID());
		BirthdayHotelproVO po=prom.topo(prom);
		System.out.println(prom.topo(prom).getHotelnameOrWeb());
		System.out.println(po.getHotelnameOrWeb());
		System.out.println(po);
	}

}
