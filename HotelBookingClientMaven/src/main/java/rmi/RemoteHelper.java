package rmi;

import java.rmi.Remote;

import dataService.hotelDataService.HotelDataService;
import dataService.orderDataService.OrderDataService;
import dataService.promotionDataService.PromotionDataService;
import dataService.searchDataService.SearchDataService;
import dataService.userDataService.UserDataService;



public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper() {	//Default constructor
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public HotelDataService getHotelDataService(){
		return (HotelDataService)remote;
	}
	
	public OrderDataService getOrderDataService(){
		return (OrderDataService)remote;
	}
	public PromotionDataService getPromotionDataService(){
		return (PromotionDataService)remote;
	}
	public SearchDataService getSearchDataService(){
		return (SearchDataService)remote;
	}
	public UserDataService getUserDataService(){
		return (UserDataService)remote;
	}
}
