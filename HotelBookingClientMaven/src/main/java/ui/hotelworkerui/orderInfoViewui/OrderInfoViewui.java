package ui.hotelworkerui.orderInfoViewui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OrderInfoViewui extends Pane{
	private Stage primaryStage;

	private String personname;

	private OrderInfoViewuiController orderInfoViewuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public OrderInfoViewui(Stage primaryStage, String personname) {
			this.primaryStage = primaryStage;
			this.personname = personname;
			initOrderInfoViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initOrderInfoViewui() {
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
		orderInfoViewuiController = loader.getController();
		orderInfoViewuiController.launchStage(primaryStage);
		orderInfoViewuiController.setPersonname(personname);
	}
}
