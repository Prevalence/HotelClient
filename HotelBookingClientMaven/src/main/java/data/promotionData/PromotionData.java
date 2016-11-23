package data.promotionData;

import java.util.ArrayList;

import dataService.promotionDataService.PromotionDataService;
import po.PromotionPO;

public class PromotionData implements PromotionDataService{
	private static PromotionData promotiondata;
	/**
	 * 
	 * @return 唯一的PromotionData对象
	 */
	public static PromotionData getInstance(){
		if(promotiondata==null)
			promotiondata=new PromotionDataMock();
		return promotiondata;
	}
	
	public boolean add(PromotionPO promotion) {
		System.out.println("Promotiondata.add is called.");
		return true;
	}

	public ArrayList<PromotionPO> find(String hotelnames) {
		System.out.println("Promotiondata.find is called.");
		ArrayList<PromotionPO> test=new ArrayList<PromotionPO>();
		return test;
	}

	public boolean modify(PromotionPO promotion) {
		System.out.println("Promotiondata.modify is called.");
		return true;
	}

	public boolean delete(PromotionPO promotion) {
		System.out.println("Promotiondata.delete is called.");
		return true;
	}
}
