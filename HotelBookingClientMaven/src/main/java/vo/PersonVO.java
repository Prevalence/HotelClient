package vo;

import java.io.Serializable;


public class PersonVO  implements Serializable {
	private String username;
	private String password;
	private long credit;
	private String birthday;//客户生日，无论是否是会员都可以有此信息，格式如：20160212
	private int vipType;
	private int vipLevel;
	private String enterpriseName;

	public PersonVO(String userName,String password,long Credit,String birthday,int vipType,int vipLevel,String enterpriseName){
		this.username=userName;
		this.password=password;
		this.credit=Credit;
		this.birthday=birthday;
		this.vipType=vipType;
		this.vipLevel=vipLevel;
		this.enterpriseName=enterpriseName;
	}
	public String getuserName(){
		return username;}
	public String getpassword(){
		return password;}
	public long getCredit(){
		return credit;}
	public String getBirthrday(){
		return birthday;}
	public int getVIPType(){
		return vipType;}
	public int getVIPlevel(){
		return vipLevel;}
	public String getEnterpriseName (){
		return enterpriseName;}
	public void setuserName(String userName){
		this.username=userName;}
	public void setpassword(String password){
		this.password=password;}
	public void setuserName(long Credit){
		this.credit=Credit;}
	public void setBirthday(String birthday){
		this.birthday=birthday;}
	public void setVIP(int VIP){
		this.vipType=VIP;}
	public void setVIPlevel(int VIPlevel){
		this.vipLevel=VIPlevel;}
	public void setEnterpriseName(String enterpriseName){
		this.enterpriseName=enterpriseName;
	}
}
