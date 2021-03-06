package ui.personui.hotelCommentui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HotelCommentui extends Pane{
	private Stage primaryStage;

	private String personname;
	
	private String hotelName;

	private HotelCommentuiController hotelCommentuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public HotelCommentui(Stage primaryStage, String personname,String hotelName) {
			this.primaryStage = primaryStage;
			this.personname = personname;
			this.hotelName = hotelName;
			initHotelCommentui();
		};

	/**
	 * 初始化界面
	 */
	public void initHotelCommentui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/客户评价酒店界面.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		hotelCommentuiController = loader.getController();
		hotelCommentuiController.launchStage(primaryStage);
		hotelCommentuiController.setPersonname(personname);
		hotelCommentuiController.setHotelNameAndShowInfo(hotelName);
	}
}
