package ui.personui.createOrderui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.hotelVO.hotelblVO.HotelVO;

public class CreateOrderui extends Pane {
	private Stage primaryStage;

	private String personname;

	private String hotelName;

	private HotelVO hotelInfo;

	private CreateOrderuiController createOrderuiController;

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public CreateOrderui(Stage primaryStage, String personname, String hotelName, HotelVO hotelInfo) {
		this.primaryStage = primaryStage;
		this.personname = personname;
		this.hotelName = hotelName;
		this.hotelInfo = hotelInfo;
		initcreateOrderui();
	};

	/**
	 * 初始化界面
	 */
	public void initcreateOrderui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/入住信息输入界面.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		createOrderuiController = loader.getController();
		createOrderuiController.launchStage(primaryStage);
		createOrderuiController.setPersonname(personname);
		createOrderuiController.setHotelNameAndShowInfo(hotelName);
		createOrderuiController.setHotelVO(hotelInfo);
	}
}
