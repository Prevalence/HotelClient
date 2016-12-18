package po.hotelPO;

import java.io.Serializable;
import java.util.ArrayList;

import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;

public class HotelPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int hotelID;// 酒店唯一标识
	private String hotelname;
	private int star;// 酒店星级
	private String feature;// 酒店简介
	private ArrayList<Boolean> service;// 设施服务，需要初始化list，所有的都要设为false
	private String address;
	private String circle;
	private double score;// 酒店平均评分
	private ArrayList<RoomPO> room;
	private ArrayList<CommentPO> comment;
	private String hotelworker;
	private String hotelPhone;// 酒店电话号码

	public HotelPO() {
		super();
	}

	public HotelPO(int hotelID, String hotelname, int star, String feature, ArrayList<Boolean> service, String address,
			String circle, double score, ArrayList<RoomPO> room, ArrayList<CommentPO> comment, String hotelworker,
			String hotelPhone) {
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
		this.hotelPhone = hotelPhone;
	}

	public HotelPO(HotelVO vo) {
		this.hotelID = vo.getHotelID();
		this.hotelname = vo.getHotelname();
		this.star = vo.getStar();
		this.feature = vo.getFeature();
		this.service = vo.getService();
		this.address = vo.getAddress();
		this.circle = vo.getCircle();
		this.score = vo.getScore();

		ArrayList<RoomPO> roompo = new ArrayList<RoomPO>();
		ArrayList<RoomVO> roomvo = vo.getRoom();
		if (roomvo != null) {
			for (int i = 0; i < roomvo.size(); i++) {
				roompo.add(new RoomPO(roomvo.get(i)));
			}
		}
		this.room=roompo;
		
		ArrayList<CommentPO> commentpo=new ArrayList<CommentPO>();
		ArrayList<CommentVO> commentvo=vo.getComment();
		if(commentvo!=null){
			for(int i=0; i<commentvo.size(); i++){
				commentpo.add(new CommentPO(commentvo.get(i)));
			}
		}
		this.comment = commentpo;

		this.hotelworker = vo.getHotelworker();
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

	public ArrayList<RoomPO> getRoom() {
		return room;
	}

	public void setRoom(ArrayList<RoomPO> room) {
		this.room = room;
	}

	public ArrayList<CommentPO> getComment() {
		return comment;
	}

	public void setComment(ArrayList<CommentPO> comment) {
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
