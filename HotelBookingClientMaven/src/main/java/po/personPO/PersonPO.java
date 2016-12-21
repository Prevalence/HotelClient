package po.personPO;
import java.io.Serializable;
import java.util.Calendar;

import vo.personVO.PersonVO;
import businessLogic.TimeFormTrans;

/**
 * 
 * @author 武秀峰
 *
 */
public class PersonPO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String username;//客户真实姓名
	private String password;
	private int personID;//五位personID，客户唯一标识
	private int credit;
	private Calendar birthday;//客户生日，仅包含年月日信息
	private String vipType;	//no代表不是VIP，ordinary代表是普通VIP，enterprise代表是企业VIP
	private int vipLevel;//只有0-5这几个等级，vipLevel=credit/1000；最高5级；消费金额不足1000元时等级为0
	private String enterpriseName;//企业会员登记企业名称
	private String phoneNumber;//由11位数字组成的电话号码

	//构造函数
	public PersonPO() {
		super();
	}
	
	public PersonPO(String username, String password, int personID, int credit, Calendar birthday, String vipType,
			int vipLevel, String enterpriseName, String phoneNumber) {
		super();
		this.username = username;
		this.password = password;
		this.personID = personID;
		this.credit = credit;
		this.birthday = birthday;
		this.vipType = vipType;
		this.vipLevel = vipLevel;
		this.enterpriseName = enterpriseName;
		this.phoneNumber=phoneNumber;
	}
	public PersonPO(PersonVO vo) {
		this.username=vo.getUsername();
		if(vo.getPassword()!=null){
			this.password=vo.getPassword();
		}
		this.personID=vo.getPersonID();
		this.credit=vo.getCredit();
		
		TimeFormTrans t=new TimeFormTrans();
		Calendar c=t.myToCalendar(vo.getBirthday());
		this.birthday = c;
		this.vipType = vo.getVipType();
		this.vipLevel = vo.getVipLevel();
		this.enterpriseName = vo.getEnterpriseName();
		this.phoneNumber=vo.getPhoneNumber();
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}