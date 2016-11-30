package vo;

import java.util.ArrayList;
import java.util.Calendar;

public class CommentVO {
	private int AveScore;//酒店评价评分，即总评分
	private ArrayList<String> hotelname;
	private ArrayList<String> personname;//评价者
	private ArrayList<Calendar> time;
	private ArrayList<Integer> score;
	private ArrayList<String> content;//评价内容
	
	
	public CommentVO() {
		super();
	}
	public CommentVO(int aveScore, ArrayList<String> hotelname, ArrayList<String> personname, ArrayList<Calendar> time,
			ArrayList<Integer> score, ArrayList<String> content) {
		super();
		AveScore = aveScore;
		this.hotelname = hotelname;
		this.personname = personname;
		this.time = time;
		this.score = score;
		this.content = content;
	}
	public int getAveScore() {
		return AveScore;
	}
	public void setAveScore(int aveScore) {
		AveScore = aveScore;
	}
	public ArrayList<String> getHotelname() {
		return hotelname;
	}
	public void setHotelname(ArrayList<String> hotelname) {
		this.hotelname = hotelname;
	}
	public ArrayList<String> getPersonname() {
		return personname;
	}
	public void setPersonname(ArrayList<String> personname) {
		this.personname = personname;
	}
	public ArrayList<Calendar> getTime() {
		return time;
	}
	public void setTime(ArrayList<Calendar> time) {
		this.time = time;
	}
	public ArrayList<Integer> getScore() {
		return score;
	}
	public void setScore(ArrayList<Integer> score) {
		this.score = score;
	}
	public ArrayList<String> getContent() {
		return content;
	}
	public void setContent(ArrayList<String> content) {
		this.content = content;
	}


}
