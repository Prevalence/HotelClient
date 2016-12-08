package ui.marketui.orderInfoViewui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OrderInfoViewui extends Pane{
	private Stage primaryStage;

	private String personname;

	private OrderInfoViewuiController orderInfoViewViewuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public OrderInfoViewui(Stage primaryStage, String personname) {
			this.primaryStage = primaryStage;
			this.personname = personname;
			initOrderInfoViewViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initOrderInfoViewViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/OrderInfoViewui.fxml"));
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
		orderInfoViewViewuiController.setPersonname(personname);
	}
}
