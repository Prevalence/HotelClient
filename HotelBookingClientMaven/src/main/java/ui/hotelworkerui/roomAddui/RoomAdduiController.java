package ui.hotelworkerui.roomAddui;

import java.util.ArrayList;

import businessLogic.hotelbl.HotelController;
import businessLogic.userbl.UserController;
import businessLogicService.hotelblService.HotelblService;
import businessLogicService.userblService.UserblService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.hotelworkerui.hotelInfoui.HotelInfoui;
import ui.hotelworkerui.orderViewui.HotelOrderViewui;
import ui.hotelworkerui.promotionui.Promotionui;
import ui.hotelworkerui.roomInfoui.RoomInfoui;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hoteluiVO.HotelRoomVO;

public class RoomAdduiController {

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
	private Label nameLabel;
	@FXML
	private Label hotelNameLabel;
	@FXML
	private Label scoreLabel;
	@FXML
	private Label areaLabel;
	@FXML
	private Label connectionLabel;
	@FXML
	private Label feedbackLabel;
	@FXML
	private TextField roomtypeField;
	@FXML
	private TextField numberField;
	@FXML
	private TextField priceField;
	@FXML
	private CheckBox wifiCheck;
	@FXML
	private CheckBox TVCheck;
	@FXML
	private CheckBox sofaCheck;
	@FXML
	private CheckBox diningCheck;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView roomTable;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn typeCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn priceCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn numberCol;
	@FXML
	private Pane mainPane;

	private UserblService userbl;

	private HotelblService hotelbl;

	// 酒店订单浏览界面
	private Pane hotelOrderPane;

	// 促销策略界面
	private Pane promotionPane;

	// 酒店信息界面
	private Pane hotelInfoPane;

	// 房间信息界面
	private Pane roomInfoPane;

	// 房间信息界面
	private Pane newRoomPane;

	private Stage primaryStage;

	private HotelVO hotelInfo;

	private String workerName;

	private String hotelName;

	// 填充进TableView的酒店数据
	private ObservableList<HotelRoomVO> roomData;

	private HotelRoomVO room;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public RoomAdduiController() {
		userbl = new UserController();
		hotelbl = new HotelController();
	}

	/**
	 * 跳转到酒店订单浏览界面
	 */
	@FXML
	private void viewHotelOrder() {
		hotelOrderPane = new HotelOrderViewui(primaryStage, workerName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelOrderPane);
	}

	/**
	 * 跳转到促销策略界面
	 */
	@FXML
	private void viewPromotion() {
		promotionPane = new Promotionui(primaryStage, workerName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(promotionPane);
	}

	/**
	 * 跳转到酒店信息维护界面
	 */
	@FXML
	private void viewHotelInfo() {
		// hotelInfo = hotelbl.showHotelInfo(workerName);
		hotelInfoPane = new HotelInfoui(primaryStage, workerName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelInfoPane);
	}

	/**
	 * 跳转到房间信息查看界面
	 */
	@FXML
	private void viewRoomInfo() {
		// hotelInfo = hotelbl.showHotelInfo(workerName);
		roomInfoPane = new RoomInfoui(primaryStage, workerName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(roomInfoPane);
	}

	/**
	 * 编辑房间信息
	 */
	@FXML
	private void addRoom() {
		String roomtype = roomtypeField.getText();
		String roomNumber = roomtypeField.getText();
		String roomPrice = roomtypeField.getText();
		if (roomtype.equals("") || roomNumber.equals("") || roomPrice.equals("")) {
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("信息填写不完整！");
		} else {
			if (hotelbl.addRoom(roomtype, Integer.parseInt(roomNumber),
					Integer.parseInt(roomPrice), hotelName)) {
				feedbackLabel.setTextFill(Color.web("#058cff"));
				feedbackLabel.setText("添加成功！");
			} else {
				feedbackLabel.setTextFill(Color.web("#f80202"));
				feedbackLabel.setText("系统错误！");
			}
		}
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
	 * @param workerName
	 */
	public void setWorkerNameAndShowInfo(String workerName) {
		this.workerName = workerName;
		nameLabel.setText(workerName);
		hotelName = userbl.getHotelWorkerInfo(workerName).getHotelName();
		hotelInfo = hotelbl.getHotelInfoByHotelworkerOrManager(hotelName);
		nameLabel.setText(workerName);
		hotelNameLabel.setText(hotelName);
		areaLabel.setText(hotelInfo.getCircle());
		scoreLabel.setText(String.valueOf(hotelInfo.getScore()));
		connectionLabel.setText(hotelInfo.getHotelPhone());
	}
}
