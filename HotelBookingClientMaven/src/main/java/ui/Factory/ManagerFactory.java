package ui.Factory;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.managerui.hotelworkerAddui.HotelworkerAddui;
import ui.managerui.hotelworkerInfoui.HotelworkerInfoui;
import ui.managerui.marketAddui.MarketAddui;
import ui.managerui.marketInfoui.MarketInfoui;
import ui.managerui.personInfoui.PersonInfoui;

public class ManagerFactory {
	private static Pane userInfoPane;

	/**
	 * 创建查询酒店的窗口
	 * @param primaryStage
	 * @param usertype
	 * @param managerName
	 * @param username
	 * @return
	 */
	public static Pane createUserInfoPane(Stage primaryStage, String usertype, String managerName, String username) {
		switch (usertype) {
		case "客户":
			userInfoPane = new PersonInfoui(primaryStage, managerName, username);
			break;
		case "酒店工作人员":
			userInfoPane = new HotelworkerInfoui(primaryStage, managerName, username);
			break;
		case "网站营销人员":
			userInfoPane = new MarketInfoui(primaryStage, managerName, username);
			break;
		default:
			break;
		}
		return userInfoPane;
	}
	
	public static Pane createUserAddPane(Stage primaryStage, String usertype, String managerName, String username) {
		switch (usertype) {
		case "酒店工作人员":
			userInfoPane = new HotelworkerAddui(primaryStage, managerName, username);
			break;
		case "网站营销人员":
			userInfoPane = new MarketAddui(primaryStage, managerName, username);
			break;
		default:
			break;
		}
		return userInfoPane;
	}
}
