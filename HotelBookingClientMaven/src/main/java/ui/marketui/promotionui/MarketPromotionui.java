package ui.marketui.promotionui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MarketPromotionui extends Pane{
	private Stage primaryStage;

	private String marketName;
	
	private ObservableList<String> promotions=FXCollections.observableArrayList();

	private PromotionuiController promotionViewuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public MarketPromotionui(Stage primaryStage, String marketName) {
			this.primaryStage = primaryStage;
			this.marketName = marketName;
			promotions.addAll("特定时间优惠");
			initPromotionViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initPromotionViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网站促销策略界面.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		promotionViewuiController = loader.getController();
		promotionViewuiController.launchStage(primaryStage);
		promotionViewuiController.setMarketName(marketName);
		promotionViewuiController.setPromotionChoiceBox(promotions);
		promotionViewuiController.initTableView();
	}
}
