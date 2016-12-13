package ui.hotelworkerui.roomInfoui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.hotelworkerui.hotelInfoui.HotelInfoui;
import ui.hotelworkerui.orderViewui.HotelOrderViewui;
import ui.hotelworkerui.promotionui.Promotionui;

public class RoomInfouiController {
	@FXML
	private Button hotelOrderButton;
	@FXML
	private Button promotionButton;
	@FXML
	private Button hotelInfoButton;
	@FXML
	private Button roomInfoButton;
	@FXML
	private Button searchButton;
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	// 酒店订单浏览界面
	private Pane hotelOrderPane;

	// 促销策略界面
	private Pane promotionPane;

	// 酒店信息界面
	private Pane hotelInfoPane;

	// 房间信息界面
	private Pane roomInfoPane;

	private Stage primaryStage;

	private String hotelName;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public RoomInfouiController() {
		userbl = new UserController();
	}

	/**
	 * 跳转到酒店订单浏览界面
	 */
	@FXML
	private void viewHotelOrder() {
		hotelOrderPane = new HotelOrderViewui(primaryStage, hotelName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelOrderPane);
	}

	/**
	 * 跳转到促销策略界面
	 */
	@FXML
	private void viewPromotion() {
		promotionPane = new Promotionui(primaryStage, hotelName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(promotionPane);
	}

	/**
	 * 跳转到酒店信息维护界面
	 */
	@FXML
	private void viewHotelInfo() {
		// hotelInfo = hotelbl.showHotelInfo(hotelName);
		hotelInfoPane = new HotelInfoui(primaryStage, hotelName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelInfoPane);
	}

	/**
	 * 跳转到房间信息查看界面
	 */
	@FXML
	private void viewRoomInfo() {
		// hotelInfo = hotelbl.showHotelInfo(hotelName);
		roomInfoPane = new RoomInfoui(primaryStage, hotelName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(roomInfoPane);
	}

	/**
	 * 传递Main的primaryStage
	 * 
	 * @param primaryStage
	 */
	public void launchStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	/**
	 * 传递用户名
	 * 
	 * @param hotelName
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
}
