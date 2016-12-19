package ui.managerui.hotelworkerInfoui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HotelworkerInfoui extends Pane {
	private Stage primaryStage;

	private String managerName;

	private String hotelworkerName;

	private HotelworkerInfouiController hotelworkerInfouiController;

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public HotelworkerInfoui(Stage primaryStage, String managerName, String hotelworkerName) {
		this.primaryStage = primaryStage;
		this.managerName = managerName;
		this.hotelworkerName = hotelworkerName;
		inithotelworkerInfoui();
	};

	/**
	 * 初始化界面
	 */
	public void inithotelworkerInfoui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网站管理人员搜索得到酒店工作人员的界面.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		hotelworkerInfouiController = loader.getController();
		hotelworkerInfouiController.launchStage(primaryStage);
		hotelworkerInfouiController.setManagerName(managerName);
		hotelworkerInfouiController.modifyStageSize();
		hotelworkerInfouiController.setWorkerAndShowInfo(hotelworkerName);
	}
}
