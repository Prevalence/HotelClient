package ui.managerui.marketInfoui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MarketInfouil extends Pane {
	private Stage primaryStage;

	private String managerName;

	private String marketName;

	private MarketInfouiControllerl marketInfouiController;

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public MarketInfouil(Stage primaryStage, String managerName, String marketName) {
		this.primaryStage = primaryStage;
		this.managerName = managerName;
		initMarketInfoui();
	};

	/**
	 * 初始化界面
	 */
	public void initMarketInfoui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网站管理人员搜索得到网站营销人员的界面.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		marketInfouiController = loader.getController();
		marketInfouiController.launchStage(primaryStage);
		marketInfouiController.setManagerName(managerName);
		marketInfouiController.modifyStageSize();
		marketInfouiController.setMarketName(marketName);
	}
}
