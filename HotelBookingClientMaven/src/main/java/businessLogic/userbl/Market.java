package businessLogic.userbl;

import java.rmi.RemoteException;

import dataService.userDataService.UserDataService;
import po.MarketPO;
import po.personPO.PersonPO;
import rmi.RemoteHelper;
import vo.MarketVO;
import vo.personVO.PersonVO;
/**
 * @author xiamutian
 * @author 武秀峰
 */

public class Market {
	UserDataService userDataService=RemoteHelper.getInstance().getUserDataService();

	/**
	 * 网站营销人员的登陆
	 * @param marketname
	 * @param password
	 * @return 是否登陆成功
	 * @throws RemoteException
	 */
	public boolean marketlogin(String marketname,String password) throws RemoteException{
		return userDataService.marketLogin(marketname, password);
	}
	
	/**
	 * 获取客户信息
	 * @param personname
	 * @return 客户信息
	 * @throws RemoteException
	 */
	public PersonVO getPersonInfo(String personname) throws RemoteException{
		PersonPO po=userDataService.findPerson(personname);
		PersonVO vo=new PersonVO();
		if(po!=null){
			vo=new PersonVO(po);
		}
		return vo;
	}
	
	/**
	 * 获取网站营销人员信息
	 * @param marketname
	 * @return 网站营销人员信息
	 * @throws RemoteException
	 */
	public MarketVO getMarketInfo(String marketname) throws RemoteException{
		MarketPO po=userDataService.findMarket(marketname);
		MarketVO vo=new MarketVO();
		if(po!=null){
			vo=new MarketVO(po);
		}
		return vo;
	}
	
	/**
	 * 修改信用值
	 * @param personname
	 * @param credit
	 * @return 是否修改成功
	 * @throws RemoteException
	 */
	public boolean changeCredit (String personname,int credit) throws RemoteException{
		Person person=new Person();
		PersonVO personvo=person.getPersonInfo(personname);
		int oriCredit=personvo.getCredit();
		personvo.setCredit(oriCredit+credit);
		if(personvo.getVipType().equals("no")==false){//当客户是VIP时
			personvo.setVipLevel((oriCredit+credit)/1000);
		}
		return person.modifyPerson(personvo);
	}
	
	/**
	 * 判断网站营销人员是否存在
	 * @param marketname
	 * @return 若存在，返回true；若不存在，返回false
	 * @throws RemoteException
	 */
	public boolean isExist(String marketname) throws RemoteException{
		UserController usercontroller=new UserController();
		if(usercontroller.getMarketInfo(marketname)==null){
			return false;
		}
		return true;
	}
	
	
}
