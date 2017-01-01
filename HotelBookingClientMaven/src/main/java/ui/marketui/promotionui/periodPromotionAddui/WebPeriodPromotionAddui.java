package ui.marketui.promotionui.periodPromotionAddui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WebPeriodPromotionAddui extends Pane{
	private Stage primaryStage;

	private String marketName;
	
	private ObservableList<String> months = FXCollections.observableArrayList();
	
	private WebPeriodPromotionAdduiController birthdayPromotionuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public WebPeriodPromotionAddui(Stage primaryStage, String marketName) {
			this.primaryStage = primaryStage;
			this.marketName = marketName;
			months.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
			initPromotionViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initPromotionViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网站促销策略之特定时间优惠.fxml"));
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
		birthdayPromotionuiController.setMarketName(marketName);
		birthdayPromotionuiController.setMonthChoiceBox(months);
	}
}
