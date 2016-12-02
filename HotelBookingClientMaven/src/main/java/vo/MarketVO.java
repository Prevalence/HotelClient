package vo;

import java.io.Serializable;

import po.MarketPO;

public class MarketVO  implements Serializable{
	String username;
	String password;

	public MarketVO() {
		super();
	}
	public MarketVO(String userName, String password) {
		this.username=username;
		this.password=password;
	}
	public MarketVO(MarketPO po) {
		this.username=po.getUsername();
		this.password=password;
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
