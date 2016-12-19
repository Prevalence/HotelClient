package ui.personui.createOrderui;

import java.util.ArrayList;

import businessLogic.hotelbl.HotelController;
import businessLogicService.hotelblService.HotelblService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.RoomInfoVO;

public class CreateOrderui extends Pane {
	private Stage primaryStage;

	private String personname;

	private String hotelName;

	private HotelVO hotelInfo;

	private ArrayList<RoomInfoVO> roomInfo;

	private ObservableList<String> types = FXCollections.observableArrayList();

	private ObservableList<String> months = FXCollections.observableArrayList();

	private CreateOrderuiController createOrderuiController;

	private HotelblService hotelbl;

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public CreateOrderui(Stage primaryStage, String personname, String hotelName, HotelVO hotelInfo) {
		hotelbl = new HotelController();
		this.primaryStage = primaryStage;
		this.personname = personname;
		this.hotelName = hotelName;
		this.hotelInfo = hotelInfo;
		this.roomInfo = hotelbl.getHotelRoomInfo(hotelName);
		for (int i = 0; i < roomInfo.size(); i++) {
			types.add(roomInfo.get(i).getRoomtype());
		}
		months.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
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
		createOrderuiController.setRoomChoiceBox(types);
		createOrderuiController.setMonthChoiceBox(months);
	}
}
