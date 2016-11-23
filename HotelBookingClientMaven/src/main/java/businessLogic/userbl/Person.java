package businessLogic.userbl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import dataService.userDataService.UserDataService;
import po.PersonPO;
import vo.HotelVO;
import vo.PersonVO;
/**
 * @author xiamutian
 */

public class Person {
	UserDataService userDataService;
	PersonPO person=new PersonPO();
	
	/**
	 * 客户注册
	 * @return boolean
	 * @throws RemoteException 
	 */
	public boolean register(PersonVO vo) throws RemoteException{
		PersonPO personPO=new PersonPO(vo);
		return userDataService.addPerson(personPO);
		
	}
	
	/**
	 * 客户信息保存
	 * @return boolean
	 * @throws RemoteException 
	 */
	public boolean personSave(PersonVO personInfo) throws RemoteException{
		PersonPO personPO=new PersonPO(personInfo);
		return userDataService.modifyPerson(personPO);
		
	}
	
	/**
	 * 会员注册
	 * @param vipType 0代表不是VIP，1代表是普通VIP，2代表是企业VIP
	 * @param vipInfo 若是普通VIP，info为生日，格式如：20160120；若是企业VIP，格式为非空字符
	 * @return boolean
	 * @throws ParseException 
	 * @throws RemoteException 
	 */
	public boolean registeMember(PersonVO personInfo, int vipType, String vipInfo) throws ParseException, RemoteException{
		if(personInfo.getVIPType()==0){//不是会员，可以注册
			//判断vipInfo是否符合格式
			if(vipType==1){//注册普通会员
				if(vipInfo.length()!=8){
					return false;//生日格式不符合要求
				}else{
					int year=Integer.parseInt(vipInfo.substring(0, 4));
					int month=Integer.parseInt(vipInfo.substring(4, 6));
					int day=Integer.parseInt(vipInfo.substring(6, 8));
					//计算该月天数
					String strDate = year+"-"+day; 
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM"); 
					Calendar calendar = new GregorianCalendar(); 
					Date date1 = sdf.parse(strDate); 
					calendar.setTime(date1); //放入日期 
					int daysOfThisMonth=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
					
					if((1900<=year)&&(year<=Calendar.getInstance().YEAR)&&(1<=month)&&(month<=12)&&(1<=day)&&(day<=daysOfThisMonth)){//日期正确
						personInfo.setBirthday(vipInfo);
					}else{
						return false;//生日格式不符合要求
					}
				}
				
				personInfo.setVIP(1);
			}else if(vipType==2){//注册企业会员
				if(vipInfo.length()>0){
					personInfo.setEnterpriseName(vipInfo);
				}else{
					return false;//企业名称格式不符合要求
				}
				
				personInfo.setVIP(2);
			}
			personInfo.setVIPlevel((int)(personInfo.getCredit()/100));
			PersonPO personPO=new PersonPO(personInfo);
			userDataService.modifyPerson(personPO);
			return true;
		}else{//已是会员，不能再注册
			return false;
		}
	}
	
	/**
	 * 会员信息获取
	 * @return PersonPO
	 * @throws RemoteException 
	 */
	public PersonPO getPersonInfo(String personname) throws RemoteException{
		return 	userDataService.findPerson(personname);
	}
	
	/**
	 * 客户登陆
	 * @return boolean
	 * @throws RemoteException 
	 */
	public boolean Personlogin(String personname,String password) throws RemoteException{
		return userDataService.personLogin(personname, password);
		
	}

}
