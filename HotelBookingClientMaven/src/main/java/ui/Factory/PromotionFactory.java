package ui.Factory;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.hotelworkerui.promotionui.birthdayPromotionAddui.BirthdayPromotionAddui;
import ui.hotelworkerui.promotionui.birthdayPromotionEditui.BirthdayPromotionEditui;
import ui.hotelworkerui.promotionui.periodPromotionAddui.PeriodPromotionAddui;
import ui.hotelworkerui.promotionui.periodPromotionEditui.PeriodPromotionEditui;
import ui.marketui.promotionui.periodPromotionAddui.WebPeriodPromotionAddui;
import ui.marketui.promotionui.periodPromotionEditui.WebPeriodPromotionEditui;
import vo.promotionvo.PromotionVO;
import vo.promotionvo.hotelpromotionVO.PeriodHotelproVO;
import vo.promotionvo.webpromotionVO.PeriodWebproVO;

public class PromotionFactory {
	private static Pane promotionPane;

	/**
	 * 创建查询酒店的窗口
	 * 
	 * @param primaryStage
	 * @param promotiontype
	 * @param userName
	 * @param username
	 * @return
	 */
	public static Pane createPromotionPane(Stage primaryStage, String promotiontype, String userName) {
		switch (promotiontype) {
		case "生日优惠策略":
			promotionPane = new BirthdayPromotionAddui(primaryStage, userName);
			break;
		case "特定时间优惠策略":
			 promotionPane = new PeriodPromotionAddui(primaryStage, userName);
			break;
		case "网站特定时间优惠策略":
			 promotionPane = new WebPeriodPromotionAddui(primaryStage, userName);
			break;
		default:
			break;
		}
		return promotionPane;
	}

	public static Pane createPromotionEditPane(Stage primaryStage, String promotiontype, String userName,
			PromotionVO promotion) {
		switch (promotiontype) {
		case "生日优惠策略":
			promotionPane = new BirthdayPromotionEditui(primaryStage, userName,promotion);
			break;
		case "特定时间优惠策略":
			 promotionPane = new PeriodPromotionEditui(primaryStage, userName,
			 (PeriodHotelproVO)promotion);
			break;
		case "网站特定时间优惠策略":
			 promotionPane = new WebPeriodPromotionEditui(primaryStage, userName,
			 (PeriodWebproVO)promotion);
			break;
		default:
			break;
		}
		return promotionPane;
	}
}
