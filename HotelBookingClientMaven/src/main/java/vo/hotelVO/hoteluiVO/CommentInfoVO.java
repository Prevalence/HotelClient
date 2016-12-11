package vo.hotelVO.hoteluiVO;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.beans.property.SimpleStringProperty;

public class CommentInfoVO {
	private final SimpleStringProperty personname;
	private final SimpleStringProperty time;
	private final SimpleStringProperty content;

	public CommentInfoVO(String personname, Calendar time, String content) {
		this.personname = new SimpleStringProperty(personname);
		this.time = new SimpleStringProperty(new SimpleDateFormat("yyyy-MM-dd").format(time.getTime()));
		this.content = new SimpleStringProperty(content);
	}

	public String getPersonname() {
		return personname.get();
	}

	public void setPersonname(String content) {
		personname.set(content);
	}

	public String getTime() {
		return time.get();
	}

	public void setTime(int content) {
		time.set(String.valueOf(content));
	}

	public String getContent() {
		return content.get();
	}

	public void setContent(String content) {
		this.content.set(content);
	}
}
