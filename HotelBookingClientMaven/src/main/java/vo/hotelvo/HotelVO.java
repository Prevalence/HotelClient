package vo.hotelvo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import po.hotelpo.CommentPO;
import po.hotelpo.HotelPO;
import po.hotelpo.RoomPO;


/**
 * 
 * @author 武秀峰
 *
 */
public class HotelVO implements Serializable {
	private String hotelname;
	private int star;//酒店星级
	private String feature;//酒店简介
	private ArrayList <Boolean> service;//设施服务，需要初始化list，所有的都要设为false
	private String address;
	private String circle;
	private double score;//酒店平均评分
	private ArrayList<RoomVO> room;
	private ArrayList<CommentVO> comment;
	private String hotelworker;
	
	public HotelVO() {
		super();
	}


	public HotelVO(String hotelname, int star, String feature, ArrayList<Boolean> service, String address,
			String circle, double score, ArrayList<RoomVO> room, ArrayList<CommentVO> comment, String hotelworker) {
		super();
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
	}



	public HotelVO(HotelPO po){
		this.hotelname = po.getHotelname();
		this.star = po.getStar();
		this.feature = po.getFeature();
		this.service = po.getService();
		this.address = po.getAddress();
		this.circle = po.getCircle();
		this.score = po.getScore();
		
		ArrayList<RoomVO> roomvo=new ArrayList<RoomVO>();
		ArrayList<RoomPO> roompo=po.getRoom();
		for(int i=0; i<roompo.size(); i++){
			roomvo.add(new RoomVO(roompo.get(i)));
		}
		this.room=roomvo;
		
		ArrayList<CommentVO> commentpo=new ArrayList<CommentVO>();
		ArrayList<CommentPO> commentvo=po.getComment();
		for(int i=0; i<commentvo.size(); i++){
			commentpo.add(new CommentVO(commentvo.get(i)));
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



}
