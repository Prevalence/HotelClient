package vo.personVO;


import po.personPO.PersonPO;
import businessLogic.TimeFormTrans;


public class PersonVO {
	private String username;
	private String password;
	private int personID;
	private int credit;
	private String birthday;//客户生日，仅包含年月日信息
	private String vipType;	//"普通客户"、“普通会员”、“企业会员”
	private int vipLevel;//只有0-5这几个等级，vipLevel=credit/1000；最高5级；消费金额不足1000元时等级为0
	private String enterpriseName;//企业会员登记企业名称
	private String phoneNumber;//由11位数字组成的电话号码
	
	public PersonVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonVO(String username, String password, int personID, int credit, String birthday, String vipType,
			int vipLevel, String enterpriseName, String phoneNumber) {
		super();
		this.username = username;
		this.password = password;
		this.personID = personID;
		this.credit = credit;
		this.setBirthday(birthday);
		this.vipType = vipType;
		this.vipLevel = vipLevel;
		this.enterpriseName = enterpriseName;
		this.phoneNumber = phoneNumber;
	}
	
	public PersonVO(PersonPO po) {
		super();
		this.username = po.getUsername();
		this.password = po.getPassword();
		this.personID = po.getPersonID();
		this.credit = po.getCredit();
		
		TimeFormTrans t=new TimeFormTrans();
		String birth=t.myToString(po.getBirthday());
		this.birthday=birth;
		this.vipType = po.getVipType();
		this.vipLevel = po.getVipLevel();
		this.enterpriseName = po.getEnterpriseName();
		this.phoneNumber = po.getPhoneNumber();
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
