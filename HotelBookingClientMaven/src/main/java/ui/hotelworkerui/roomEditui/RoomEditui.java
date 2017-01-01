package ui.hotelworkerui.roomEditui;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class RoomEditui {
	private Stage primaryStage;

	private String workerName;

	private RoomEdituiController hotelInfoViewuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public RoomEditui(Stage primaryStage, String workerName) {
			this.primaryStage = primaryStage;
			this.workerName = workerName;
			initHotelInfoViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initHotelInfoViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/酒店信息修改界面.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		hotelInfoViewuiController = loader.getController();
		hotelInfoViewuiController.launchStage(primaryStage);
		hotelInfoViewuiController.setWorkerNameAndShowInfo(workerName);
		hotelInfoViewuiController.initTableView();
	}
}
