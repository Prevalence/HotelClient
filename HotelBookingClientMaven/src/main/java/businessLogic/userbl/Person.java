package businessLogic.userbl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import dataService.userDataService.UserDataService;
import po.personPO.PersonPO;
import po.personPO.RecordPO;
import rmi.RemoteHelper;
import vo.personVO.PersonVO;
import vo.personVO.RecordVO;
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
	 * @param vipType
	 * @param vipInfo 若是普通VIP，info为生日，格式如：2016-01-20 //企业VIP线下进行
	 * @return 是否注册成功
	 * @throws ParseException
	 * @throws RemoteException
	 */
	@SuppressWarnings("static-access")
	public boolean registeMember(PersonVO personvo, String vipType, String vipInfo) throws ParseException, RemoteException{
		if(personvo.getVipType().equals("普通客户")){//不是会员，可以注册
			//判断vipInfo是否符合格式
			String birthday=vipInfo+" 00:00:00";
			personvo.setBirthday(birthday);;
			personvo.setVipType("普通会员");
			if
			personvo.setVipLevel((int)(personvo.getCredit()/1000));
			PersonPO personPO=new PersonPO(personvo);
			return userDataService.modifyPerson(personPO);
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
		PersonVO vo=new PersonVO();
		if(po!=null){
			vo=new PersonVO(po);	
			return vo;
		}
		return null;
	}
	
	/**
	 * 根据客户ID获取客户信息
	 * @param personID
	 * @return 客户信息
	 * @throws RemoteException
	 */
	public PersonVO getPersonInfo(int personID) throws RemoteException{
		PersonPO po=userDataService.findPerson(personID);
		PersonVO vo=new PersonVO();
		if(po!=null){
			vo=new PersonVO(po);
			return vo;
		}
		return null;
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
		UserController usercontroller=new UserController();
		if(usercontroller.getPersonInfo(personname)==null){
			return false;
		}
		return true;
	}
	
	/**
	 * 写入客户信用记录
	 * @param personname
	 * @param record
	 * @return
	 */
	public boolean writeRecord(String personname, RecordVO record) throws RemoteException{
		// TODO Auto-generated method stub
		RecordPO po=new RecordPO(record);
		return userDataService.writeRecord(personname, po);
	}

	/**
	 * 获取客户信用记录
	 * @param personID
	 * @return
	 */
	public ArrayList<RecordVO> getRecord(String personname) throws RemoteException{
		// TODO Auto-generated method stub
		ArrayList<RecordPO> polist=userDataService.getRecord(personname);
		ArrayList<RecordVO> volist=new ArrayList<RecordVO>();
		if(polist!=null){
			for(int i=0;i<polist.size();i++){
				RecordVO vo=new RecordVO(polist.get(i));
				System.out.println(vo.getOperation());
				System.out.println(vo.getOrderId());
				volist.add(vo);
			}
			
		}
		return volist;
	}

}
