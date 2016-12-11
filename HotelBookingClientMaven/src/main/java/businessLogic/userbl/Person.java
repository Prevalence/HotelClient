package businessLogic.userbl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Calendar;

import dataService.userDataService.UserDataService;
import po.personPO.PersonPO;
import rmi.RemoteHelper;
import vo.personVO.PersonVO;
/**
 * @authorxiamutian 
 * @author 武秀峰
 */

public class Person {
	UserDataService userDataService=RemoteHelper.getInstance().getUserDataService();
	PersonPO person=new PersonPO();
	
	
	/**
	 * 客户注册
	 * @param vo
	 * @return 是否注册成功
	 * @throws RemoteException
	 */
	public boolean register(PersonVO vo) throws RemoteException{
		PersonPO personPO=new PersonPO(vo);
		return userDataService.addPerson(personPO);
	}
	
	/**
	 * 客户信息修改，信用不能修改，只能查看
	 * @param personInfo
	 * @return boolean 是否修改成功
	 * @throws RemoteException 
	 */
	public boolean modifyPerson(PersonVO personInfo) throws RemoteException{
		PersonPO personPO=new PersonPO(personInfo);
		return userDataService.modifyPerson(personPO);
		
	}
	
	/**
	 * 会员注册
	 * @param personvo
	 * @param vipType no代表不是VIP，ordinary代表是普通VIP，enterprise代表是企业VIP
	 * @param vipInfo 若是普通VIP，info为生日，格式如：20160120；若是企业VIP，格式为非空字符
	 * @return 是否注册成功
	 * @throws ParseException
	 * @throws RemoteException
	 */
	@SuppressWarnings("static-access")
	public boolean registeMember(PersonVO personvo, String vipType, String vipInfo) throws ParseException, RemoteException{
		if(personvo.getVipType().equals("no")){//不是会员，可以注册
			//判断vipInfo是否符合格式
			if(vipType.equals("ordinary")){//注册普通会员
				if(vipInfo.length()!=8){
					return false;//生日格式不符合要求
				}else{
					int year=Integer.parseInt(vipInfo.substring(0, 4));
					int month=Integer.parseInt(vipInfo.substring(4, 6));
					int date=Integer.parseInt(vipInfo.substring(6, 8));
//					//计算该月天数
//					String strDate = year+""+date;
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM"); 
//					Calendar calendar = new GregorianCalendar(); 
//					Date date1 = sdf.parse(strDate); 
//					calendar.setTime(date1); //放入日期 
//					int daysOfThisMonth=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
					
					if((1900<=year)&&(year<=Calendar.getInstance().YEAR)&&(1<=month)&&(month<=12)&&(1<=date)&&(date<=31)){//日期正确
						Calendar birthday=Calendar.getInstance();
						birthday.set(year, month, date);
						personvo.setBirthday(birthday);;
					}else{
						return false;//生日格式不符合要求
					}
				}
				
				personvo.setVipType("ordinary");
			}else if(vipType.equals("enterprise")){//注册企业会员
				if(vipInfo.length()>0){
					personvo.setEnterpriseName(vipInfo);
				}else{
					return false;//企业名称格式不符合要求
				}
				
				personvo.setVipType("enterprise");
			}
			personvo.setVipLevel((int)(personvo.getCredit()/100));
			PersonPO personPO=new PersonPO(personvo);
			userDataService.modifyPerson(personPO);
			return true;
		}else{//已是会员，不能再注册
			return false;
		}
	}
	
	/**
	 * 根据客户名称获取客户信息
	 * @param personname
	 * @return 客户信息
	 * @throws RemoteException
	 */
	public PersonVO getPersonInfo(String personname) throws RemoteException{
		PersonPO po=userDataService.findPerson(personname);
		PersonVO vo=new PersonVO(po);
		return vo;
	}
	
	/**
	 * 根据客户ID获取客户信息
	 * @param personID
	 * @return 客户信息
	 * @throws RemoteException
	 */
	public PersonVO getPersonInfo(int personID) throws RemoteException{
		PersonPO po=userDataService.findPerson(personID);
		PersonVO vo=new PersonVO(po);
		return vo;
	}
	
	/**
	 * 客户登陆
	 * @param personname
	 * @param password
	 * @return 是否登陆成功
	 * @throws RemoteException
	 */
	public boolean personLogin(String personname,String password) throws RemoteException{
		return userDataService.personLogin(personname, password);
		
	}
	
	/**
	 * 判断客户是否存在
	 * @param personname
	 * @return 若存在，返回true；若不存在，返回false
	 * @throws RemoteException
	 */
	public boolean isExist(String personname) throws RemoteException{
		return userDataService.isExist(personname, "person");
	}

}
