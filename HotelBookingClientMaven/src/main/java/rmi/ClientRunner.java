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
		//remoteHelper.getHotelDataService().showHotelinfo("nanj");
		
		remoteHelper.getOrderDataService().exceptionFind();
	}
	
	public static void main(String[] args) throws RemoteException{//������
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
