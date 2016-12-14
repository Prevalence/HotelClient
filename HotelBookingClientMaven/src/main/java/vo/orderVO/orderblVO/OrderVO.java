package vo.orderVO.orderblVO;

import java.util.ArrayList;
import java.util.Calendar;
import po.OrderPO;
import po.hotelPO.RoomPO;
import vo.hotelVO.hotelblVO.RoomVO;

public class OrderVO {
	//订单的基本信息
	private String orderID;//时间201602020512（4年2月2日2时2分）+酒店ID（5位）+客户ID(5位)
	private int orderprice;
	private String orderstate;
	//订单状态,"nonExecute"代表未执行订单、"alreadyExecute"代表已执行订单、
	//"cancel"代表已撤销订单、"abnormal"代表异常订单、"delay"代表延期订单
	
	//酒店信息
	private String hotelname;
	private ArrayList<RoomVO> room;//包括房间类型、房间号、房间价格
	
	//入住者信息
	private String personname;//客户唯一标识，相当于personID
	private String realname;//客户真实姓名
	private int peoplenum;//包括child的人数
	private int childnum;//儿童的人数。默认为0
	
	//一系列时间
	private Calendar producttime;//订单生成时间
	private Calendar executetime;//订单执行时间
	private Calendar canceltime;//订单取消时间
	private Calendar latestExecutetime;//订单最晚执行时间
	private Calendar predictLeaveTime;//预计退房时间
	private Calendar actualLeaveTime;//实际退房时间
	
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
		
		this.producttime=orderPO.getProducttime();//订单生成时间
		this.executetime=orderPO.getExecutetime();//订单执行时间
		this.canceltime=orderPO.getCanceltime();//订单取消时间
		this.latestExecutetime=orderPO.getLatestExecutetime();//订单最晚执行时间
		this.predictLeaveTime = orderPO.getPredictLeaveTime();
		this.actualLeaveTime=orderPO.getActualLeaveTime();//退房时间
	}

	//有所有参数的构造函数
	public OrderVO(String orderID, int orderprice, String orderstate, String hotelname, ArrayList<RoomVO> room,
			String personname, String realname, int peoplenum, int childnum, Calendar producttime, Calendar executetime,
			Calendar canceltime, Calendar latestExecutetime, Calendar predictLeaveTime, Calendar actualLeaveTime) {
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
		this.latestExecutetime = latestExecutetime;
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

	public Calendar getProducttime() {
		return producttime;
	}

	public void setProducttime(Calendar producttime) {
		this.producttime = producttime;
	}

	public Calendar getExecutetime() {
		return executetime;
	}

	public void setExecutetime(Calendar executetime) {
		this.executetime = executetime;
	}

	public Calendar getCanceltime() {
		return canceltime;
	}

	public void setCanceltime(Calendar canceltime) {
		this.canceltime = canceltime;
	}

	public Calendar getLatestExecutetime() {
		return latestExecutetime;
	}

	public void setLatestExecutetime(Calendar latestExecutetime) {
		this.latestExecutetime = latestExecutetime;
	}

	public Calendar getPredictLeaveTime() {
		return predictLeaveTime;
	}

	public void setPredictLeaveTime(Calendar predictLeaveTime) {
		this.predictLeaveTime = predictLeaveTime;
	}

	public Calendar getActualLeaveTime() {
		return actualLeaveTime;
	}

	public void setActualLeaveTime(Calendar actualLeaveTime) {
		this.actualLeaveTime = actualLeaveTime;
	}


}