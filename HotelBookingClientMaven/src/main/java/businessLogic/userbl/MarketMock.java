package businessLogic.userbl;

import java.util.ArrayList;

import po.MarketPO;
import po.personPO.PersonPO;
import vo.MarketVO;
import vo.personVO.PersonVO;

public class MarketMock extends Market{
	public PersonVO getPersonInfo(String personname){
		/**
		 * 获取客户信息
		 * @author xiamutian
		 */
		PersonVO pp=new PersonVO();
		PersonVO pp1=new PersonVO();
		pp1.setUsername("xiamutian");
		PersonVO pp2=new PersonVO();
		pp2.setUsername("xiekailian");
		pp1.setCredit(1000);
		pp2.setCredit(900);
		ArrayList<PersonVO> List = new ArrayList<PersonVO>(); 
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
	public MarketVO getMarketInfo(String marketname){
		/**
		 * 获取网站营销人员信息
		 * @author xiamutian
		 */
		MarketVO pp1=new MarketVO();
		pp1.setUsername("xiamutian");
		MarketVO pp2=new MarketVO();
		pp2.setUsername("xiekailian");
		pp1.setPassword("123");
		pp2.setPassword("456");
		ArrayList<MarketVO> List = new ArrayList<MarketVO>(); 
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
