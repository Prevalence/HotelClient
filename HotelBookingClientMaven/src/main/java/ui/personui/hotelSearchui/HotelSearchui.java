package ui.personui.hotelSearchui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HotelSearchui extends Pane {
	private Stage primaryStage;

	private HotelSearchuiController hotelSearchuiController;
	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public HotelSearchui(Stage primaryStage,String personname) {
		this.primaryStage = primaryStage;
		initHotelSearchui();
	};

	/**
	 * 初始化hotelSearchPane
	 */
	public void initHotelSearchui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HotelSearchui.fxml"));
		loader.setRoot(this);
		
		hotelSearchuiController = loader.getController();
		hotelSearchuiController.launchStage(primaryStage);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
