package ui.hotelworkerui.orderViewui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OrderViewui extends Pane{
	private Stage primaryStage;

	private String personname;

	private OrderViewuiController orderViewuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public OrderViewui(Stage primaryStage, String personname) {
			this.primaryStage = primaryStage;
			this.personname = personname;
			initOrderViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initOrderViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/酒店工作人员首界面.fxml"));
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
		orderViewuiController.setPersonname(personname);
		orderViewuiController.modifyStageSize();
	}
}
