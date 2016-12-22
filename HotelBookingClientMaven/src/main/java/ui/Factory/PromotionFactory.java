package ui.Factory;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.hotelworkerui.promotionui.birthdayPromotionui.BirthdayPromotionui;
import ui.managerui.hotelworkerInfoui.HotelworkerInfoui;
import ui.managerui.marketInfoui.MarketInfoui;
import ui.managerui.personInfoui.PersonInfoui;

public class PromotionFactory {
	private static Pane promotionPane;

	/**
	 * 创建查询酒店的窗口
	 * @param primaryStage
	 * @param promotiontype
	 * @param workerName
	 * @param username
	 * @return
	 */
	public static Pane createPromotionPane(Stage primaryStage, String promotiontype, String workerName) {
		switch (promotiontype) {
		case "BirthdayHotelPromotion":
			promotionPane = new BirthdayPromotionui(primaryStage, workerName);
			break;
		case "PeriodHotelPromotion":
//			promotionPane = new HotelworkerInfoui(primaryStage, workerName, username);
			break;
		default:
			break;
		}
		return promotionPane;
	}
}
