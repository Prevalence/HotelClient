package data.promotionData;
import java.util.*;

import dataService.promotionDataService.*;
import po.*;

public class PromotionDataMock extends PromotionData implements PromotionDataService {

	@Override
	public boolean add(PromotionPO promotion) {
		if(promotion.getDiscount()!=0)
			return true;
		return false;
	}

	@Override
	public ArrayList<PromotionPO> find(String hotelnames) {
		ArrayList<PromotionPO> test=new ArrayList<PromotionPO>();
		PromotionPO pro=new PromotionPO();
		pro.setName("南京大酒店");
		if(pro.getName().equals(hotelnames))
			pro.setDiscount(0.6);
			test.add(pro);
		
		return test;
	}

	@Override
	public boolean modify(PromotionPO promotion) {
		if(promotion.getDiscount()==0)
			return false;
		return true;
	}

	@Override
	public boolean delete(PromotionPO promotion) {
		if(promotion.getName().equals("打折"))
			return true;
		return false;
	}

}
