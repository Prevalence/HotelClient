package vo;

import java.io.Serializable;
import java.util.Calendar;


public class PersonVO  implements Serializable {
	private String username;
	private String password;
	private int personID;
	private int credit;
	private Calendar birthday;//客户生日，仅包含年月日信息
	private String vipType;	//no代表不是VIP，ordinary代表是普通VIP，enterprise代表是企业VIP
	private int vipLevel;
	private String enterpriseName;//企业会员登记企业名称
	
	
	public PersonVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonVO(String username, String password, int personID, int credit, Calendar birthday, String vipType,
			int vipLevel, String enterpriseName) {
		super();
		this.username = username;
		this.password = password;
		this.personID = personID;
		this.credit = credit;
		this.birthday = birthday;
		this.vipType = vipType;
		this.vipLevel = vipLevel;
		this.enterpriseName = enterpriseName;
	}
	
	//get and set
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
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public Calendar getBirthday() {
		return birthday;
	}
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}
	public String getVipType() {
		return vipType;
	}
	public void setVipType(String vipType) {
		this.vipType = vipType;
	}
	public int getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	
	
}
