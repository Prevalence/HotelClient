package businessLogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businessLogic.userbl.Person;
import po.OrderPO;
import po.PromotionPO;
import po.personPO.PersonPO;
import vo.PromotionVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.orderVO.orderblVO.OrderVO;
/**
 * 
 * @author John
 *这个类负责选择出最优的价格，会调用Helper中的方法得到对应的Discount，然后计算出折后价并比较
 */
public class PriceCalc {
	private CalculatePrice discount=null;

	/**
	 * 计算最优价格
	 * @param hotelvo
	 * @param ordervo
	 * @return 计算优惠后的最低价格
	 */
	public double priceCut(HotelVO hotelvo,OrderVO ordervo){
		/**
		 * 	public HotelVO(int hotelID, String hotelname, int star, String feature, ArrayList<Boolean> service, String address,
			String circle, double score, ArrayList<RoomVO> room, ArrayList<CommentVO> comment, String hotelworker)
			
			public OrderVO(String orderID, int orderprice, String orderstate, String hotelname, ArrayList<RoomVO> room,
			String personname, String realname, int peoplenum, int childnum, Calendar producttime, Calendar executetime,
			Calendar canceltime, Calendar latestExecutetime, Calendar predictLeaveTime, Calendar actualLeaveTime)
		 */
		
		//以下方法实现计算原价
		int initialtotal=0;//原价
		ArrayList<RoomVO> orderRoomvoList=ordervo.getRoom();
		ArrayList<RoomVO> hotelRoomvoList=hotelvo.getRoom();
		for(int i=0; i<orderRoomvoList.size(); i++){
			for(int j=0; j<hotelRoomvoList.size(); j++){
				if(orderRoomvoList.get(i).getRoomType().equals(hotelRoomvoList.get(j).getRoomType())){//当房型确定时
					initialtotal=initialtotal+hotelRoomvoList.get(j).getRoomPrice();
					break;
				}
			}
		}
		
		//以下方法实现获取所有促销策略（包括酒店与网站促销策略）
		ArrayList<PromotionVO>promotionvolist=new Promotion().getProm(hotelvo.getHotelname());//加入酒店促销策略;
		promotionvolist.addAll(new Promotion().getProm("WebPromotion"));//加入网站促销策略
		
		ArrayList<PromotionPO>promotionpolist = new ArrayList<PromotionPO>();
		for(int i=0; i<promotionvolist.size(); i++){
			PromotionPO propo=new PromotionPO();
			propo=promotionvolist.get(i).toPO(promotionvolist.get(i));
			promotionpolist.add(propo);
		}
		
		//以下实现找人
		Person person=new Person();
		PersonPO personpo=null;
		try {
			personpo = new PersonPO(person.getPersonInfo(ordervo.getPersonname()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//以下实现促销策略降价计算
		OrderPO orderpo=new OrderPO(ordervo);
		double bestprice=initialtotal;
		if((personpo!=null)&&(promotionpolist!=null)){
			for(int i=0;i<promotionpolist.size();i++){
				PromotionPO temp=promotionpolist.get(i);
				String promotionType=temp.getPromotionType();
				discount=Helper.getcalculateinstance(promotionType);
				double thisprice=discount.getprice(initialtotal,promotionpolist.get(i), personpo, orderpo);
				if(thisprice<bestprice)
					bestprice=thisprice;
			}
		}

		return bestprice;
		
	}//结束方法
	
}//结束类
