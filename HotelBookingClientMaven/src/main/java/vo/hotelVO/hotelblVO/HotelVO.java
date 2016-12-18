package vo.hotelVO.hotelblVO;

import java.util.ArrayList;

import po.hotelPO.CommentPO;
import po.hotelPO.HotelPO;
import po.hotelPO.RoomPO;

public class HotelVO {
	private int hotelID;//酒店唯一标识
	private String hotelname;
	private int star;//酒店星级
	private String feature;//酒店简介
	private ArrayList <Boolean> service;//设施服务，需要初始化list，所有的都要设为false，长度为4，分别是wifi，电视，沙发，空调
	private String address;
	private String circle;
	private double score;//酒店平均评分
	private ArrayList<RoomVO> room;
	private ArrayList<CommentVO> comment;
	private String hotelworker;
	private String hotelPhone;//酒店电话号码
	
	public HotelVO() {
		super();
	}

	public HotelVO(int hotelID, String hotelname, int star, String feature, ArrayList<Boolean> service, String address,
			String circle, double score, ArrayList<RoomVO> room, ArrayList<CommentVO> comment, String hotelworker, String hotelPhone) {
		super();
		this.setHotelID(hotelID);
		this.hotelname = hotelname;
		this.star = star;
		this.feature = feature;
		this.service = service;
		this.address = address;
		this.circle = circle;
		this.score = score;
		this.room = room;
		this.comment = comment;
		this.hotelworker = hotelworker;
		this.hotelPhone=hotelPhone;
	}

	public HotelVO(HotelPO po){
		this.hotelID=po.getHotelID();
		this.hotelname = po.getHotelname();
		this.star = po.getStar();
		this.feature = po.getFeature();
		this.service = po.getService();
		this.address = po.getAddress();
		this.circle = po.getCircle();
		this.score = po.getScore();
		
		ArrayList<RoomVO> roomvo=new ArrayList<RoomVO>();
		ArrayList<RoomPO> roompo=po.getRoom();
		if(roompo!=null){
			for(int i=0; i<roompo.size(); i++){
				roomvo.add(new RoomVO(roompo.get(i)));
			}
		}
		this.room=roomvo;
		
		ArrayList<CommentVO> commentpo=new ArrayList<CommentVO>();
		ArrayList<CommentPO> commentvo=po.getComment();
		if(commentpo!=null){
			for(int i=0; i<commentvo.size(); i++){
				commentpo.add(new CommentVO(commentvo.get(i)));
			}
		}
		this.comment = commentpo;
		
		this.hotelworker = po.getHotelworker();
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public ArrayList<Boolean> getService() {
		return service;
	}

	public void setService(ArrayList<Boolean> service) {
		this.service = service;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}


	public ArrayList<RoomVO> getRoom() {
		return room;
	}

	public void setRoom(ArrayList<RoomVO> room) {
		this.room = room;
	}

	public ArrayList<CommentVO> getComment() {
		return comment;
	}

	public void setComment(ArrayList<CommentVO> comment) {
		this.comment = comment;
	}

	public String getHotelworker() {
		return hotelworker;
	}

	public void setHotelworker(String hotelworker) {
		this.hotelworker = hotelworker;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public String getHotelPhone() {
		return hotelPhone;
	}

	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}
}
