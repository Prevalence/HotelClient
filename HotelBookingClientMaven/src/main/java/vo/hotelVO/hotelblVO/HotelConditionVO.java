package vo.hotelVO.hotelblVO;

import java.util.ArrayList;

public class HotelConditionVO {
	/**
	 * 1.	需要先明确地址和商圈，才能进行搜索
	 * 2.	可以通过酒店名称、房间（类型、原始价格区间、有空房期间（房间数量、入住日期，退房日期））、
	 * 星级、评分区间等条件进行搜索，这些条件可以独立起作用，也可以联合起作用
	 * 3.	可以限定只搜索自己预定过的酒店
	 */
//	private String address;
	private String hotelName;
	private String circle;
	private ArrayList<RoomVO> room;
	private int star;//酒店星级
	private double score;//酒店平均评分
	private boolean isBooked;//是否预订过,默认为没有被预订过，即false
	private String personname;//若限制已预订过，则必须有客户名称
	
	public HotelConditionVO() {
		super();
	}
	public HotelConditionVO(String circle, ArrayList<RoomVO> room, int star,
			double score, boolean isBooked, String personname) {
		super();
//		this.address = address;
		this.circle = circle;
		this.room = room;
		this.star = star;
		this.score = score;
		this.isBooked = isBooked;
		this.personname = personname;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public ArrayList<RoomVO> getRoom() {
		return room;
	}
	public void setRoom(ArrayList<RoomVO> room) {
		this.room = room;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public boolean isBooked() {
		return isBooked;
	}
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	//向hotelVO转化
	public HotelVO toHotelVO(HotelConditionVO hotelConditionVO){
		//注意转化过程少了condition的是否预订过这个条件，因此在bl层实现是需要注意判断
		HotelVO hotelVO=new HotelVO();
		hotelVO.setHotelname(hotelConditionVO.getHotelName());
		hotelVO.setStar(hotelConditionVO.getStar());
		hotelVO.setCircle(hotelConditionVO.getCircle());
		hotelVO.setScore(hotelConditionVO.getScore());
		hotelVO.setRoom(hotelConditionVO.getRoom());
		return hotelVO;
	}

	
}
