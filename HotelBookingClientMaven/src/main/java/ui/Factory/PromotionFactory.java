package ui.Factory;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.hotelworkerui.promotionui.birthdayPromotionAddui.BirthdayPromotionAddui;
import ui.hotelworkerui.promotionui.birthdayPromotionEditui.BirthdayPromotionEditui;
import ui.managerui.hotelworkerInfoui.HotelworkerInfoui;
import ui.managerui.marketInfoui.MarketInfoui;
import ui.managerui.personInfoui.PersonInfoui;
import vo.PromotionVO;

public class PromotionFactory {
	private static Pane promotionPane;

	/**
	 * 创建查询酒店的窗口
	 * 
	 * @param primaryStage
	 * @param promotiontype
	 * @param workerName
	 * @param username
	 * @return
	 */
	public static Pane createPromotionPane(Stage primaryStage, String promotiontype, String workerName) {
		switch (promotiontype) {
		case "BirthdayHotelPromotion":
			promotionPane = new BirthdayPromotionAddui(primaryStage, workerName);
			break;
		case "PeriodHotelPromotion":
			// promotionPane = new HotelworkerInfoui(primaryStage, workerName,
			// username);
			break;
		default:
			break;
		}
		return promotionPane;
	}

	public static Pane createPromotionEditPane(Stage primaryStage, String promotiontype, String workerName,
			PromotionVO promotion) {
		switch (promotiontype) {
		case "BirthdayHotelPromotion":
			promotionPane = new BirthdayPromotionEditui(primaryStage, workerName,promotion);
			break;
		case "PeriodHotelPromotion":
			// promotionPane = new HotelworkerInfoui(primaryStage, workerName,
			// username);
			break;
		default:
			break;
		}
		return promotionPane;
	}
}
