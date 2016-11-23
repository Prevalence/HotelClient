package businessLogic.userbl;

import java.rmi.RemoteException;

import dataService.userDataService.UserDataService;
import po.MarketPO;
import po.PersonPO;
/**
 * @author xiamutian
 */

public class Market {
	MarketPO market=new MarketPO();
	UserDataService userDataService;

	/**
	 * 获取客户信息
	 * @throws RemoteException 
	 */
	public PersonPO getPersonInfo(String personname) throws RemoteException{
		return userDataService.findPerson(personname);
	}
	
	/**
	 * 获取网站营销人员信息
	 * @throws RemoteException 
	 */
	public MarketPO getMarketInfo(String marketname) throws RemoteException{
		return userDataService.findMarket(marketname);
	}
	
	/**
	 * 修改信用值
	 * @throws RemoteException 
	 */
	public boolean changeCredit (String personname,int credit) throws RemoteException{
		return userDataService.changeCredit(personname, credit);//报错正常，dataservice层修改完就对了
	}
	
	/**
	 * 网站营销人员的登陆
	 * @throws RemoteException 
	 */
	public boolean Marketlogin(String marketname,String password) throws RemoteException{
		return userDataService.marketLogin(marketname, password);
	}
	
	
}
