package ui.marketui.orderViewui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MarketOrderViewui extends Pane{
	private Stage primaryStage;

	private String marketName;

	private OrderViewuiController orderViewuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public MarketOrderViewui(Stage primaryStage, String marketName) {
			this.primaryStage = primaryStage;
			this.marketName = marketName;
			initOrderViewViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initOrderViewViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网站营销人员首界面.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		orderViewuiController = loader.getController();
		orderViewuiController.launchStage(primaryStage);
		orderViewuiController.setMarketName(marketName);
		orderViewuiController.modifyStageSize();
		orderViewuiController.initOrderTable();
	}
}
