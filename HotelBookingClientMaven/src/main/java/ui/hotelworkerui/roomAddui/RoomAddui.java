package ui.hotelworkerui.roomAddui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.hotelVO.hoteluiVO.HotelRoomVO;

public class RoomAddui extends Pane{
	private Stage primaryStage;

	private String workerName;

	private RoomAdduiController roomAdduiController;

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public RoomAddui(Stage primaryStage, String workerName) {
		this.primaryStage = primaryStage;
		this.workerName = workerName;
		initHotelInfoViewui();
	};

	/**
	 * 初始化界面
	 */
	public void initHotelInfoViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/酒店的房间添加.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		roomAdduiController = loader.getController();
		roomAdduiController.launchStage(primaryStage);
		roomAdduiController.setWorkerNameAndShowInfo(workerName);
	}
}
