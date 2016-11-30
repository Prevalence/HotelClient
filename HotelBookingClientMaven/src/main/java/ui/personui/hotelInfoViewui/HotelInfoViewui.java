package ui.personui.hotelInfoViewui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HotelInfoViewui extends Pane {

	private Stage primaryStage;

	private String personname;

	private String hotelName;

	private HotelInfoViewuiController hotelInfoViewuiController;

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public HotelInfoViewui(Stage primaryStage, String personname, String hotelName) {
		this.primaryStage = primaryStage;
		this.personname = personname;
		this.hotelName = hotelName;
		initHotelInfoViewui();
	};

	/**
	 * 初始化界面
	 */
	public void initHotelInfoViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HotelInfoViewui.fxml"));
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
		hotelInfoViewuiController.setPersonname(personname);
		hotelInfoViewuiController.setHotelNameAndShowInfo(hotelName);
	}
}
