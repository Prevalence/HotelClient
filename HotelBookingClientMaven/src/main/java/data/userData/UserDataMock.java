package data.userData;

import java.util.ArrayList;

import po.HotelWorkerPO;
import po.ManagerPO;
import po.MarketPO;
import po.PersonPO;

public class UserDataMock extends UserData{

	@Override
	public boolean addPerson(PersonPO personInfo) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public PersonPO findPerson(String personname) {
		// TODO Auto-generated method stub
		PersonPO pp=new PersonPO();
		PersonPO pp1=new PersonPO();
		pp1.setuserName("xiamutian");
		PersonPO pp2=new PersonPO();
		pp2.setuserName("xiekailian");
		pp1.setCredit(1000);
		pp2.setCredit(900);
		ArrayList<PersonPO> List = new ArrayList<PersonPO>(); 
		List.add(pp1);
		List.add(pp2);
		for(int i=0;i<List.size();i++){
			if(List.get(i).getuserName().equals(personname)){
				pp=List.get(i);
				return pp;
			}
		}
		return null;
	}

	@Override
	public boolean modifyPerson(PersonPO personInfo) {
		PersonPO pp1=new PersonPO();
		pp1.setuserName("xiamutian");
		PersonPO pp2=new PersonPO();
		pp2.setuserName("xiekailian");
		pp1.setCredit(1000);
		pp2.setCredit(900);
		ArrayList<PersonPO> List = new ArrayList<PersonPO>(); 
		List.add(pp1);
		List.add(pp2);
		for(int i=0;i<List.size();i++){
			if(List.get(i).getuserName().equals(personInfo.getuserName())){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean personLogin(String personname, String password) {
		boolean hasname=false;
		PersonPO pp=new PersonPO();
		PersonPO pp1=new PersonPO();
		pp1.setuserName("xiamutian");
		PersonPO pp2=new PersonPO();
		pp2.setuserName("xiekailian");
		pp1.setpassword("123");
		pp2.setpassword("456");
		pp1.setCredit(1000);
		pp2.setCredit(900);
		ArrayList<PersonPO> List = new ArrayList<PersonPO>(); 
		List.add(pp1);
		List.add(pp2);
		for(int i=0;i<List.size();i++){
			if(List.get(i).getuserName().equals(personname)){
				pp=List.get(i);
				hasname=true;
			}
		}
		if(hasname){
			if(pp.getpassword().equals(password)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		}

	@Override
	public MarketPO findMarket(String marketname) {
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

	@Override
	public boolean modifyMarket(MarketPO marketInfo) {
		MarketPO pp1=new MarketPO();
		pp1.setUsername("xiamutian");
		MarketPO pp2=new MarketPO();
		pp2.setUsername("xiekailian");
		ArrayList<MarketPO> List = new ArrayList<MarketPO>(); 
		List.add(pp1);
		List.add(pp2);
		for(int i=0;i<List.size();i++){
			if(List.get(i).getUsername().equals(marketInfo.getUsername())){
				return true;
			}
		}
		return false;
		}

	@Override
	public boolean marketLogin(String marketname, String password) {
		boolean hasname=false;
		MarketPO pp=new MarketPO();
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
				pp=List.get(i);
				hasname=true;
			}
		}
		if(hasname){
			if(pp.getPassword().equals(marketname)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		}		

	@Override
	public boolean changeCredit(String username, int credit) {
		PersonPO pp1=new PersonPO();
		pp1.setuserName("xiamutian");
		PersonPO pp2=new PersonPO();
		pp2.setuserName("xiekailian");
		ArrayList<PersonPO> List = new ArrayList<PersonPO>(); 
		List.add(pp1);
		List.add(pp2);
		for(int i=0;i<List.size();i++){
			if(List.get(i).getuserName().equals(username)){
				return true;
			}
		}
		return false;		
	}

	@Override
	public HotelWorkerPO findHotelWorker(String hotelWorkername) {
		HotelWorkerPO pp1=new HotelWorkerPO();
		pp1.setUsername("xiamutian");
		HotelWorkerPO pp2=new HotelWorkerPO();
		pp2.setUsername("xiekailian");
		pp1.setHotelname("123");
		pp2.setHotelname("456");
		ArrayList<HotelWorkerPO> List = new ArrayList<HotelWorkerPO>(); 
		List.add(pp1);
		List.add(pp2);
		for(int i=0;i<List.size();i++){
			if(List.get(i).getUsername().equals(hotelWorkername)){
				return List.get(i);
			}
		}
		return null;			
	}

	@Override
	public boolean modifyHotelWorker(HotelWorkerPO hotelWorkerInfo) {
		HotelWorkerPO pp1=new HotelWorkerPO();
		pp1.setUsername("xiamutian");
		HotelWorkerPO pp2=new HotelWorkerPO();
		pp2.setUsername("xiekailian");
		ArrayList<HotelWorkerPO> List = new ArrayList<HotelWorkerPO>(); 
		List.add(pp1);
		List.add(pp2);
		for(int i=0;i<List.size();i++){
			if(List.get(i).getUsername().equals(hotelWorkerInfo.getUsername())){
				return true;
			}
		}
		return false;
		}	

	@Override
	public boolean hotelWorkerLogin(String hotelWorkername, String password) {
		boolean hasname=false;
		HotelWorkerPO pp=new HotelWorkerPO();
		HotelWorkerPO pp1=new HotelWorkerPO();
		HotelWorkerPO pp2=new HotelWorkerPO();
		pp1.setUsername("xiamutian");
		pp2.setUsername("xiekailian");
		pp1.setPassword("123");
		pp2.setPassword("456");
		ArrayList<HotelWorkerPO> List = new ArrayList<HotelWorkerPO>(); 
		List.add(pp1);
		List.add(pp2);
		for(int i=0;i<List.size();i++){
			if(List.get(i).getUsername().equals(hotelWorkername)){
				pp=List.get(i);
				hasname=true;
			}
		}
		if(hasname){
			if(pp.getPassword().equals(hotelWorkername)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
			}
	}

	@Override
	public boolean addMarket(MarketPO marketInfo) {
		// TODO Auto-generated method stub
		return super.addMarket(marketInfo);
	}

	@Override
	public boolean managerLogin(String managername, String password) {
		boolean hasname=false;
		ManagerPO pp=new ManagerPO();
		ManagerPO pp1=new ManagerPO();
		pp1.setUsername("xiamutian");
		ManagerPO pp2=new ManagerPO();
		pp2.setUsername("xiekailian");
		pp1.setPassword("123");
		pp2.setPassword("456");
		ArrayList<ManagerPO> List = new ArrayList<ManagerPO>(); 
		List.add(pp1);
		List.add(pp2);
		for(int i=0;i<List.size();i++){
			if(List.get(i).getUsername().equals(managername)){
				pp=List.get(i);
				hasname=true;
			}
		}
		if(hasname){
			if(pp.getPassword().equals(managername)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		}

}
