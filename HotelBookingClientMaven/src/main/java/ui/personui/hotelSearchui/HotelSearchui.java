package ui.personui.hotelSearchui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HotelSearchui extends Pane {
	private Stage primaryStage;

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public HotelSearchui(Stage primaryStage) {
		this.primaryStage = primaryStage;
		initHotelSearchui();
	};

	/**
	 * 初始化hotelSearchPane
	 */
	public void initHotelSearchui() {
		// Load root layout from fxml file.
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Userui.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
