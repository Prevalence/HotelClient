package ui.managerui.marketAddui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MarketAddui extends Pane{
	private Stage primaryStage;

	private String managerName;
	
	private String marketName;

	private MarketAdduiController marketAdduiController;

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public MarketAddui(Stage primaryStage, String managerName,String marketName) {
		this.primaryStage = primaryStage;
		this.managerName = managerName;
		this.marketName=marketName;
		inithotelworkerInfoui();
	};

	/**
	 * 初始化界面
	 */
	public void inithotelworkerInfoui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网站管理人员添加网站营销人员的界面.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		marketAdduiController = loader.getController();
		marketAdduiController.launchStage(primaryStage);
		marketAdduiController.setManagerName(managerName);
		marketAdduiController.modifyStageSize();
		marketAdduiController.setMarketName(marketName);
	}
}
