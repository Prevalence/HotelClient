package po;

import java.io.Serializable;

import vo.MarketVO;

public class MarketPO  implements Serializable{
	private String username;
	private String password;
	private static final long serialVersionUID = 1L;
	public MarketPO(){
		this.username=null;
		this.password=null;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public MarketPO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public MarketPO(MarketVO vo){
		username=vo.getUsername();
		password=vo.getPassword();
	}
	
}
