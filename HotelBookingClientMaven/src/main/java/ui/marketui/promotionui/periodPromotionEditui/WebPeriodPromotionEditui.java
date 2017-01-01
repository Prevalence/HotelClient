package ui.marketui.promotionui.periodPromotionEditui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.promotionvo.hotelpromotionVO.PeriodHotelproVO;
import vo.promotionvo.webpromotionVO.PeriodWebproVO;

public class WebPeriodPromotionEditui extends Pane{
	private Stage primaryStage;

	private String workerName;
	
	private PeriodWebproVO promotion;
	
	private ObservableList<String> months = FXCollections.observableArrayList();

	private WebPeriodPromotionEdituiController birthdayPromotionuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public WebPeriodPromotionEditui(Stage primaryStage, String workerName,PeriodWebproVO promotion) {
			this.primaryStage = primaryStage;
			this.workerName = workerName;
			this.promotion = promotion;
			months.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
			initPromotionViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initPromotionViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网站促销策略之特定时间优惠编辑.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		birthdayPromotionuiController = loader.getController();
		birthdayPromotionuiController.launchStage(primaryStage);
		birthdayPromotionuiController.setMarketName(workerName);
		birthdayPromotionuiController.setPromotionVO(promotion);
		birthdayPromotionuiController.setMonthChoiceBox(months);
	}
}
