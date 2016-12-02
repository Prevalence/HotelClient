package businessLogic.userbl;

import java.util.ArrayList;

import po.MarketPO;
import po.PersonPO;

public class MarketMock extends Market{
	public PersonPO getPersonInfo(String personname){
		/**
		 * 获取客户信息
		 * @author xiamutian
		 */
		PersonPO pp=new PersonPO();
		PersonPO pp1=new PersonPO();
		pp1.setUsername("xiamutian");
		PersonPO pp2=new PersonPO();
		pp2.setUsername("xiekailian");
		pp1.setCredit(1000);
		pp2.setCredit(900);
		ArrayList<PersonPO> List = new ArrayList<PersonPO>(); 
		List.add(pp1);
		List.add(pp2);
		for(int i=0;i<List.size();i++){
			if(List.get(i).getUsername().equals(personname)){
				pp=List.get(i);
				return pp;
			}
		}
		return null;
	
	}
	public MarketPO getMarketInfo(String marketname){
		/**
		 * 获取网站营销人员信息
		 * @author xiamutian
		 */
		MarketPO pp1=new MarketPO();
		pp1.setUsername("xiamutian");
		MarketPO pp2=new MarketPO();
		pp2.setUsername("xiekailian");
		pp1.setPassword("123");
		pp2.setPassword("456");
		ArrayList<MarketPO> List = new ArrayList<MarketPO>(); 
		List.add(pp1);
		List.add(pp2);
		for(int i=0;i<List.size();i++){
			if(List.get(i).getUsername().equals(marketname)){
				System.out.print("find");

				return List.get(i);

			}
		}
		return null;
		
	}
	public boolean addCredit (String personname,int credit){
		/**
		 * 修改信用值
		 * @author xiamutian
		 */
		return true;
		
	}
	public boolean marketlogin(String marketname,String password){
		/**
		 * 网站营销人员的登陆
		 * @author xiamutian
		 */
		return true;
		
	}
}
