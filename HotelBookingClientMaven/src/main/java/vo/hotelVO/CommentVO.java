package vo.hotelvo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import po.hotelpo.CommentPO;

public class CommentVO implements Serializable {
	private String hotelname;
	private String personname;//评价者
	private Calendar time;
	private int score;
	private String content;//评价内容
	
	
	public CommentVO() {
		super();
	}


	public CommentVO(String hotelname, String personname, Calendar time, int score, String content) {
		super();
		this.hotelname = hotelname;
		this.personname = personname;
		this.time = time;
		this.score = score;
		this.content = content;
	}
	
	public CommentVO(CommentPO po) {
		super();
		this.hotelname = po.getHotelname();
		this.personname = po.getPersonname();
		this.time = po.getTime();
		this.score = po.getScore();
		this.content = po.getContent();
	}

	public String getHotelname() {
		return hotelname;
	}


	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}


	public String getPersonname() {
		return personname;
	}


	public void setPersonname(String personname) {
		this.personname = personname;
	}


	public Calendar getTime() {
		return time;
	}


	public void setTime(Calendar time) {
		this.time = time;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


}
