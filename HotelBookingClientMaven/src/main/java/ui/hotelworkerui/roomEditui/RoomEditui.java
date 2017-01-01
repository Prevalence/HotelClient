package ui.hotelworkerui.roomEditui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.hotelVO.hoteluiVO.HotelRoomVO;

public class RoomEditui extends Pane {
	private Stage primaryStage;

	private String workerName;

	private HotelRoomVO room;

	private RoomEdituiController hotelInfoViewuiController;

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public RoomEditui(Stage primaryStage, String workerName, HotelRoomVO room) {
		this.primaryStage = primaryStage;
		this.workerName = workerName;
		this.room = room;
		initHotelInfoViewui();
	};

	/**
	 * 初始化界面
	 */
	public void initHotelInfoViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/酒店的房间信息修改.fxml"));
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
		hotelInfoViewuiController.setRoom(room);
	}
}
