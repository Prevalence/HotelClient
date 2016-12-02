package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataService.hotelDataService.HotelDataService;
import rmi.RemoteHelper;

public class ClientRunner {
	private RemoteHelper remoteHelper;
	
	public ClientRunner() {//���췽����������һ������
		linkToServer();
//		initGUI();
	}
	
	private void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			//��Զ�̶���ע�ᵽRMIע��������ϣ�������ΪDataRemoteObject?
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
	
	public void test() throws RemoteException{
//		System.out.println(remoteHelper.getHotelDataService().showHotelinfo("南京大酒店"));
		//remoteHelper.getHotelDataService().showHotelinfo("nanj");
//		System.out.println(remoteHelper.getOrderDataService().exceptionFind().get(0).getOrderstate());
		//System.out.println(remoteHelper.getHotelDataService().showHotelinfo("南京大酒店").getAddress());
		System.out.println(remoteHelper.getPromotionDataService().find("南京大酒店").get(1).getPromotionType());
//		System.out.println(remoteHelper.getSearchDataService().showSearchHistory("小夏"));
//		System.out.println(remoteHelper.getUserDataService().findHotelWorker("小夏"));
	}
	
	public static void main(String[] args) throws RemoteException{//������
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
