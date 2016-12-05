package vo;

import java.io.Serializable;

import po.MarketPO;

public class MarketVO {
	String username;
	String password;

	public MarketVO() {
		super();
	}
	public MarketVO(String username, String password) {
		this.username=username;
		this.password=password;
	}
	public MarketVO(MarketPO po) {
		this.username=po.getUsername();
		this.password=po.getPassword();
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

}
