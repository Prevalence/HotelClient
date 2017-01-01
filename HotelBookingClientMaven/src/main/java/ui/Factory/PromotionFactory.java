package ui.Factory;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.hotelworkerui.promotionui.birthdayPromotionAddui.BirthdayPromotionAddui;
import ui.hotelworkerui.promotionui.birthdayPromotionEditui.BirthdayPromotionEditui;
import ui.hotelworkerui.promotionui.periodPromotionAddui.PeriodPromotionAddui;
import ui.hotelworkerui.promotionui.periodPromotionEditui.PeriodPromotionEditui;
import ui.managerui.hotelworkerInfoui.HotelworkerInfoui;
import ui.managerui.marketInfoui.MarketInfoui;
import ui.managerui.personInfoui.PersonInfoui;
import vo.promotionvo.PromotionVO;
import vo.promotionvo.hotelpromotionVO.PeriodHotelproVO;

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
		case "生日优惠策略":
			promotionPane = new BirthdayPromotionAddui(primaryStage, workerName);
			break;
		case "特定时间优惠策略":
			 promotionPane = new PeriodPromotionAddui(primaryStage, workerName);
			break;
		default:
			break;
		}
		return promotionPane;
	}

	public static Pane createPromotionEditPane(Stage primaryStage, String promotiontype, String workerName,
			PromotionVO promotion) {
		switch (promotiontype) {
		case "生日优惠策略":
			promotionPane = new BirthdayPromotionEditui(primaryStage, workerName,promotion);
			break;
		case "特定时间优惠策略":
			 promotionPane = new PeriodPromotionEditui(primaryStage, workerName,
			 (PeriodHotelproVO)promotion);
			break;
		default:
			break;
		}
		return promotionPane;
	}
}
