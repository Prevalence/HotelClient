package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import po.hotelPO.RoomPO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.orderVO.orderblVO.OrderVO;
import businessLogic.TimeFormTrans;
/**
 * 
 * @author xiamutian
 * @author 武秀峰
 *
 */
public class OrderPO implements Serializable{
	//订单的基本信息
	private String orderID;//时间201602020512（4年2月2日2时2分）+酒店ID（5位）+客户ID(5位)
	private static final long serialVersionUID = 1L;
	private int orderprice;
	private String orderstate;//订单状态,“未执行”、“已执行”、“已撤销”、“异常”、“延期”
	
	//酒店信息
	private String hotelname;
	private ArrayList<RoomPO> room;//包括房间类型、房间号、房间价格
	
	//入住者信息
	private String personname;//客户唯一标识，相当于personID
	private String realname;//客户真实姓名
	private int peoplenum;//包括child的人数
	private int childnum;//儿童的人数。默认为0
	
	//一系列时间
	private Calendar producttime;//订单生成时间
	private Calendar executetime;//订单实际执行时间
	private Calendar canceltime;//订单取消时间
	private Calendar predictExecutetime;//订单预计执行时间
	private Calendar predictLeaveTime;//预计退房时间
	private Calendar actualLeaveTime;//实际退房时间
	
	//空构造函数
	public OrderPO() {
		
	}
	
	//vo转po
	public OrderPO(OrderVO orderVO){
		this.orderID=orderVO.getOrderID();
		this.orderprice=orderVO.getOrderprice();
		this.orderstate=orderVO.getOrderstate();
		
		this.hotelname=orderVO.getHotelname();
		ArrayList<RoomPO> roompoList=new ArrayList<RoomPO>();
		ArrayList<RoomVO> roomvoList=orderVO.getRoom();
		if(roomvoList!=null){
			for(int i=0; i<roomvoList.size(); i++){
				RoomPO roomvo=new RoomPO(roomvoList.get(i));
				roompoList.add(roomvo);
			}
		}
		this.room=roompoList;
		
		this.personname=orderVO.getPersonname();
		this.realname=orderVO.getRealname();//客户真实姓名
		this.peoplenum=orderVO.getPeoplenum();//包括child的人数
		this.childnum=orderVO.getChildnum();//儿童的人数。默认为0
		
		TimeFormTrans t=new TimeFormTrans();
		this.producttime=t.myToCalendar(orderVO.getProducttime());//订单生成时间
		this.executetime=t.myToCalendar(orderVO.getExecutetime());//订单执行时间
		this.canceltime=t.myToCalendar(orderVO.getCanceltime());//订单取消时间
		this.predictExecutetime=t.myToCalendar(orderVO.getPredictExecutetime());//订单最晚执行时间
		this.predictLeaveTime = t.myToCalendar(orderVO.getPredictLeaveTime());
		this.actualLeaveTime=t.myToCalendar(orderVO.getActualLeaveTime());//退房时间
	}

	//有所有参数的构造函数
	public OrderPO(String orderID, int orderprice, String orderstate, String hotelname, ArrayList<RoomPO> room,
			String personname, String realname, int peoplenum, int childnum, Calendar producttime, Calendar executetime,
			Calendar canceltime, Calendar predictExecutetime, Calendar predictLeaveTime, Calendar actualLeaveTime) {
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
		this.predictExecutetime = predictExecutetime;
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

	public ArrayList<RoomPO> getRoom() {
		return room;
	}

	public void setRoom(ArrayList<RoomPO> room) {
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

	public Calendar getPredictExecutetime() {
		return predictExecutetime;
	}

	public void setPredictExecutetime(Calendar predictExecutetime) {
		this.predictExecutetime =predictExecutetime;
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
