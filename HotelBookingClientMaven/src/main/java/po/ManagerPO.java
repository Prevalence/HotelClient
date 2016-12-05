package po;

import java.io.Serializable;

import vo.ManagerVO;
/**
 * 
 * @author xiamutian
 *
 */
public class ManagerPO  implements Serializable {
	private String username;
	private String password;
	private static final long serialVersionUID = 1L;
	
	public ManagerPO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public ManagerPO() {
		this.username=null;
		this.password=null;
	}
	public ManagerPO(ManagerVO vo){
		username=vo.getUsername();
		password=vo.getPassword();
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
