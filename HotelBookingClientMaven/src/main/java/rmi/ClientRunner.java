package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.personPO.PersonPO;
import rmi.RemoteHelper;

public class ClientRunner {
	private RemoteHelper remoteHelper;
	
	public ClientRunner() {
		linkToServer();
//		initGUI();
	}
	
	private void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8888/DataRemoteObject"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
//	private void initGUI() {
//		MainFrame mainFrame = new MainFrame();
//	}
	
//	public void test() throws RemoteException{
//		@SuppressWarnings("unused")
//		PersonPO personvo1=new PersonPO("xiamutian", "123", 12345, 3000, null, "enterprise",
//				3, "南京大学", "11122223333");
		//remoteHelper.getHotelDataService().showHotelinfo("nanj");
//		System.out.println(remoteHelper.getOrderDataService().exceptionFind().get(0).getOrderstate());
		//System.out.println(remoteHelper.getHotelDataService().showHotelinfo("南京大酒店").getAddress());
//		System.out.println(remoteHelper.getPromotionDataService().find("南京大酒店").get(1).getPromotionType());
//		System.out.println(remoteHelper.getSearchDataService().showSearchHistory("小夏"));
//		System.out.println(remoteHelper.getUserDataService().findHotelWorker("小夏"));
//		UserDataService e=remoteHelper.getUserDataService();
//		boolean r=e.addPerson(personvo1);
//		System.out.println(r);
//		PromotionVO v=new PromotionVO();
//		PromotionPO propo=new PromotionPO();
//		propo=.toPO(promotionvolist.get(i));
//	}
//	
//	public static void main(String[] args) throws RemoteException{//������
//		ClientRunner cr = new ClientRunner();
//		cr.test();
//	}
}
