package businessLogic.userbl;

import java.rmi.RemoteException;

import dataService.userDataService.UserDataService;
import po.MarketPO;
import po.personpo.PersonPO;
import rmi.RemoteHelper;
import vo.MarketVO;
import vo.personvo.PersonVO;
/**
 * @author xiamutian
 * @author 武秀峰
 */

public class Market {
	UserDataService userDataService=RemoteHelper.getInstance().getUserDataService();

	/**
	 * 网站营销人员的登陆
	 * @throws RemoteException 
	 */
	public boolean marketlogin(String marketname,String password) throws RemoteException{
		return userDataService.marketLogin(marketname, password);
	}
	/**
	 * 获取客户信息
	 * @throws RemoteException 
	 */
	public PersonVO getPersonInfo(String personname) throws RemoteException{
		PersonPO po=userDataService.findPerson(personname);
		PersonVO vo=new PersonVO(po);
		return vo;
	}
	
	/**
	 * 获取网站营销人员信息
	 * @throws RemoteException 
	 */
	public MarketVO getMarketInfo(String marketname) throws RemoteException{
		MarketPO po=userDataService.findMarket(marketname);
		MarketVO vo=new MarketVO(po);
		return vo;
	}
	
	/**
	 * 修改信用值
	 * @throws RemoteException 
	 */
	public boolean changeCredit (String personname,int credit) throws RemoteException{
		return userDataService.changeCredit(personname, credit);
	}
	

	
	
}
