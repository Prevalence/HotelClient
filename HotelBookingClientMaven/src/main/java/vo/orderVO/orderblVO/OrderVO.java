package vo.orderVO.orderblVO;

import java.util.ArrayList;
import po.OrderPO;
import po.hotelPO.RoomPO;
import vo.hotelVO.hotelblVO.RoomVO;
import businessLogic.TimeFormTrans;

public class OrderVO {
	//订单的基本信息
	private String orderID;//时间201602020512（4年2月2日2时2分）+酒店ID（5位）+客户ID(5位)
	private int orderprice;
	private String orderstate;//订单状态,“未执行”、“已执行”、“已撤销”、“异常”、“延期”
	
	//酒店信息
	private String hotelname;
	private ArrayList<RoomVO> room;//包括房间类型、房间号、房间价格
	
	//入住者信息
	private String personname;//客户唯一标识，相当于personID
	private String realname;//客户真实姓名
	private int peoplenum;//包括child的人数
	private int childnum;//儿童的人数。默认为0
	
	//一系列时间
	private String producttime;//订单生成时间
	private String executetime;//订单实际执行时间
	private String canceltime;//订单取消时间
	private String predictExecutetime;//预计入住时间
	private String predictLeaveTime;//预计退房时间
	private String actualLeaveTime;//实际退房时间
	
	//空构造函数
	public OrderVO() {
		
	}
	
	//vo转po
	public OrderVO(OrderPO orderPO){
		this.orderID=orderPO.getOrderID();
		this.orderprice=orderPO.getOrderprice();
		this.orderstate=orderPO.getOrderstate();
		
		this.hotelname=orderPO.getHotelname();
		ArrayList<RoomVO> roomvoList=new ArrayList<RoomVO>();
		ArrayList<RoomPO> roompoList=orderPO.getRoom();
		if(roompoList!=null){
			for(int i=0; i<roompoList.size(); i++){
				RoomVO roomvo=new RoomVO(roompoList.get(i));
				roomvoList.add(roomvo);
			}
		}
		this.room=roomvoList;
		
		this.personname=orderPO.getPersonname();
		this.realname=orderPO.getRealname();//客户真实姓名
		this.peoplenum=orderPO.getPeoplenum();//包括child的人数
		this.childnum=orderPO.getChildnum();//儿童的人数。默认为0
		
		TimeFormTrans t=new TimeFormTrans();
		this.producttime=t.myToString(orderPO.getProducttime());//订单生成时间
		this.executetime=t.myToString(orderPO.getExecutetime());//订单执行时间
		this.canceltime=t.myToString(orderPO.getCanceltime());//订单取消时间
		this.setPredictExecutetime(t.myToString(orderPO.getPredictExecutetime()));//订单最晚执行时间
		this.predictLeaveTime = t.myToString(orderPO.getPredictExecutetime());
		this.actualLeaveTime=t.myToString(orderPO.getActualLeaveTime());//退房时间
	}

	//有所有参数的构造函数
	public OrderVO(String orderID, int orderprice, String orderstate, String hotelname, ArrayList<RoomVO> room,
			String personname, String realname, int peoplenum, int childnum, String producttime, String executetime,
			String canceltime, String predictExecutetime, String predictLeaveTime, String actualLeaveTime) {
		super();
		this.orderID = orderID;
		this.orderprice = orderprice;
		this.orderstate = orderstate;
		this.hotelname = hotelname;
		this.room = room;
		this.personname = personname;
		this.realname = realname;
		this.peoplenum = peoplenum;
		this.childnum = childnum;
		this.producttime = producttime;
		this.executetime = executetime;
		this.canceltime = canceltime;
		this.setPredictExecutetime(predictExecutetime);
		this.predictLeaveTime = predictLeaveTime;
		this.actualLeaveTime = actualLeaveTime;
	}

	//get and set
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public int getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(int orderprice) {
		this.orderprice = orderprice;
	}

	public String getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public ArrayList<RoomVO> getRoom() {
		return room;
	}

	public void setRoom(ArrayList<RoomVO> room) {
		this.room = room;
	}

	public String getPersonname() {
		return personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public int getPeoplenum() {
		return peoplenum;
	}

	public void setPeoplenum(int peoplenum) {
		this.peoplenum = peoplenum;
	}

	public int getChildnum() {
		return childnum;
	}

	public void setChildnum(int childnum) {
		this.childnum = childnum;
	}

	public String getProducttime() {
		return producttime;
	}

	public void setProducttime(String producttime) {
		this.producttime = producttime;
	}

	public String getExecutetime() {
		return executetime;
	}

	public void setExecutetime(String executetime) {
		this.executetime = executetime;
	}

	public String getCanceltime() {
		return canceltime;
	}

	public void setCanceltime(String canceltime) {
		this.canceltime = canceltime;
	}



	public String getPredictLeaveTime() {
		return predictLeaveTime;
	}

	public void setPredictLeaveTime(String predictLeaveTime) {
		this.predictLeaveTime = predictLeaveTime;
	}

	public String getActualLeaveTime() {
		return actualLeaveTime;
	}

	public void setActualLeaveTime(String actualLeaveTime) {
		this.actualLeaveTime = actualLeaveTime;
	}

	public String getPredictExecutetime() {
		return predictExecutetime;
	}

	public void setPredictExecutetime(String predictExecutetime) {
		this.predictExecutetime = predictExecutetime;
	}

}
