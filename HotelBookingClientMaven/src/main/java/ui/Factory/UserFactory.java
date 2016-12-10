package ui.Factory;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.hotelworkerui.orderViewui.HotelOrderViewui;
import ui.managerui.userSearchAndAddui.UserSearchAndAddui;
import ui.marketui.orderViewui.MarketOrderViewui;
import ui.personui.hotelSearchui.HotelSearchui;

public class UserFactory {
	private static Pane userPane;

	public static Pane createUserPane(Stage primaryStage, String usertype, String username) {
		switch (usertype) {
		case "person":
			userPane = new HotelSearchui(primaryStage, username);
			break;
		case "hoteworker":
			userPane = new HotelOrderViewui(primaryStage, username);
			break;
		case "market":
			userPane = new MarketOrderViewui(primaryStage, username);
			break;
		case "manager":
			userPane = new UserSearchAndAddui(primaryStage, username);
			break;
		default:
			break;
		}
		return userPane;
	}
}
