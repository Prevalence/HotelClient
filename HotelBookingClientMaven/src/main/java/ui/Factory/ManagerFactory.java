package ui.Factory;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.managerui.hotelworkerInfoui.HotelworkerInfoui;
import ui.managerui.marketInfoui.MarketInfouil;
import ui.managerui.personInfoui.PersonInfoui;

public class ManagerFactory {
	private static Pane userInfoPane;

	public static Pane createUserInfoPane(Stage primaryStage, String usertype, String managerName, String username) {
		switch (usertype) {
		case "客户":
			userInfoPane = new PersonInfoui(primaryStage, managerName, username);
			break;
		case "酒店工作人员":
			userInfoPane = new HotelworkerInfoui(primaryStage, managerName, username);
			break;
		case "网站营销人员":
			userInfoPane = new MarketInfouil(primaryStage, managerName, username);
			break;
		default:
			break;
		}
		return userInfoPane;
	}
}
