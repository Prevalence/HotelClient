package ui.marketui.orderInfoViewui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.orderVO.orderblVO.OrderVO;

public class MarketOrderInfoViewui extends Pane{
	private Stage primaryStage;
	
	private OrderVO order;

	private String marketName;

	private OrderInfoViewuiController orderInfoViewViewuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public MarketOrderInfoViewui(Stage primaryStage, String marketName,OrderVO order) {
			this.primaryStage = primaryStage;
			this.marketName = marketName;
			initOrderInfoViewViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initOrderInfoViewViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网站营销人员订单详细查看界面.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		orderInfoViewViewuiController = loader.getController();
		orderInfoViewViewuiController.launchStage(primaryStage);
		orderInfoViewViewuiController.setMarketName(marketName);
	}
}
