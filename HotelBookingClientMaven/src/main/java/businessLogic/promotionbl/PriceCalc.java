package businessLogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businessLogic.userbl.Person;
import po.OrderPO;
import po.PromotionPO;
import po.personpo.PersonPO;
import vo.OrderVO;
import vo.PromotionVO;
import vo.hotelvo.HotelVO;
import vo.personvo.PersonVO;
/**
 * 
 * @author John
 *这个类负责选择出最优的价格，会调用Helper中的方法得到对应的Discount，然后计算出折后价并比较
 */
public class PriceCalc {
	private CalculatePrice discount=null;
//	private ArrayList<PromotionPO>promotionlist;
	/**
	 * 
	 * @param price 酒店房间的价格
	 * @param numberAndType 订单中房间数和类型
	 * @return 计算优惠后的最低价格
	 */
	public double priceCut(HotelVO hotelvo,OrderVO ordervo){
		
		ArrayList<PromotionVO>promotionvolist=new Promotion().getProm(hotelvo.getHotelname());//加入酒店促销策略;
		promotionvolist.addAll(new Promotion().getProm("WebPromotion"));//加入网站促销策略
		
		ArrayList<PromotionPO>promotionpolist = new ArrayList<PromotionPO>();
		for(int i=0; i<promotionvolist.size(); i++){
			PromotionPO propo=promotionvolist.get(i).topo(promotionvolist.get(i));
			promotionpolist.add(propo);
		}
		//process the PO and VO
//		ArrayList<String> roomtypes=ordervo.getRoomtype();
//		ArrayList<Integer> roomnumbers=ordervo.getRoomnum();
//		ArrayList<String> hotelroomtypes=hotelvo.getRoom().getRoomType();
//		ArrayList<Integer> hotelroomprice=hotelvo.getRoomPrice();
		int initialtotal=0;//原价
//		for(int i=0;i<roomtypes.size();i++){
//			for(int j=0;j<hotelroomtypes.size();j++){
//				if(roomtypes.get(i).equals(hotelroomtypes.get(j))){
//					initialtotal+=hotelroomprice.get(j)*roomnumbers.get(i);
//				}
//			}
//		}
		
		Person person=new Person();
		PersonPO personpo = null;
		try {
			personpo = new PersonPO(person.getPersonInfo(ordervo.getPersonname()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrderPO orderpo=new OrderPO(ordervo);
		double bestprice=0.0;
		if(personpo!=null)
		for(int i=0;i<promotionpolist.size();i++){
			discount=Helper.getcalculateinstance(promotionpolist.get(i).getPromotionType());
			double thisprice=discount.getprice(initialtotal,promotionpolist.get(i),personpo, orderpo);
			if(thisprice<bestprice)
				bestprice=thisprice;
		}
		return bestprice;
	}
}
