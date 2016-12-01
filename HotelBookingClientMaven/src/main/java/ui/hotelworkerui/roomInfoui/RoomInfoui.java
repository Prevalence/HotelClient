package ui.hotelworkerui.roomInfoui;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class RoomInfoui {
	private Stage primaryStage;

	private String personname;

	private RoomInfouiController roomInfoViewuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public RoomInfoui(Stage primaryStage, String personname) {
			this.primaryStage = primaryStage;
			this.personname = personname;
			initRoomInfoViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initRoomInfoViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RoomInfoui.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		roomInfoViewuiController = loader.getController();
		roomInfoViewuiController.launchStage(primaryStage);
		roomInfoViewuiController.setPersonname(personname);
	}
}
