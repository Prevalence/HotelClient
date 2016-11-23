package po;
import java.io.Serializable;

import vo.PersonVO;
public class PersonPO implements Serializable{
	private String username;
	private String password;
	private int credit;
	private int VIPlevel;
	private String VIPinfo;
	private String birthday;//客户生日，无论是否是会员都可以有此信息，格式如：20160212
	private int vipType;	//0代表不是VIP，1代表是普通VIP，2代表是企业VIP
	private int personID;
	private String enterpriseName;//企业会员登记企业名称

	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getVipType() {
		return vipType;
	}
	public void setVipType(int vipType) {
		this.vipType = vipType;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public PersonPO(String userName,String password,String userType,String hotel,int Credit,int VIP,int VIPlevel,String VIPinfo,int id){
		super();
		this.username=userName;
		this.password=password;
		this.credit=Credit;
		this.VIPlevel=VIPlevel;
		this.VIPinfo=VIPinfo;
		this.personID=id;
		birthday=null;
		vipType=0;
		enterpriseName=null;
	}
	public PersonPO(){
		super();
		this.username=null;
		this.password=null;
		this.credit=0;
		this.VIPlevel=0;
		this.VIPinfo=null;
		this.personID=0;
	}
	public PersonPO(PersonVO vo) {
		this.username=vo.getuserName();
		this.password=vo.getpassword();
		this.credit=(int) vo.getCredit();
		this.VIPlevel=vo.getVIPlevel();
		birthday=vo.getBirthrday();
		enterpriseName=vo.getEnterpriseName();
	}
	public int getPersonID(){
		return personID;
	}
	public String getuserName(){
		return username;}
	public String getpassword(){
		return password;}
	public int getCredit(){
		return credit;}
	public int getVIPlevel(){
		return VIPlevel;}
	public String getVIPinfo (){
		return VIPinfo;}
	public void setuserName(String userName){
		this.username=userName;}
	public void setpassword(String password){
		this.password=password;}
	public void setCredit(int Credit){
		this.credit=Credit;}
	public void setVIPlevel(int VIPlevel){
		this.VIPlevel=VIPlevel;}
	public void setVIPinfo(String VIPinfo){
		this.VIPinfo=VIPinfo;}
	public void setPersonID(int id){
		this.personID=id;
	}
}