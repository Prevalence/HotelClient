package businessLogic.userbl;
import java.util.ArrayList;

import po.PersonPO;
import vo.PersonVO;

public class PersonMock extends Person {
	PersonPO pp=new PersonPO();
	PersonPO pp1=new PersonPO();
	PersonPO pp2=new PersonPO();
	public boolean register(PersonVO personinfo){
		/**
		 * 客户注册
		 * @author xiamutian
		 * @return boolean
		 */
		return false;
		
	}
	public boolean modifyPerson(PersonVO personinfo){
		/**
		 * 客户信息保存
		 * @author xiamutian
		 * @return boolean
		 */
		return false;
		
	}
	public boolean registerMember(PersonVO person_info){
		/**
		 * 会员注册
		 * @author xiamutian
		 * @return boolean
		 */
		return false;
		
	}
	public PersonPO getPersonInfo(String personname){
		/**
		 * 会员信息获取
		 * @author xiamutian
		 * @return PersonPO
		 */

		pp1.setUsername("xiamutian");

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
	public boolean personLogin(String personname,String password){
		/**
		 * 客户登陆
		 * @author xiamutian
		 * @return boolean
		 */
		return false;
		
	}
}
