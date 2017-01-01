package ui.hotelworkerui.hotelInfoui;

import java.util.ArrayList;

import businessLogic.hotelbl.HotelController;
import businessLogic.userbl.UserController;
import businessLogicService.hotelblService.HotelblService;
import businessLogicService.userblService.UserblService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import ui.helper.SearchButtonCell;
import ui.hotelworkerui.orderViewui.HotelOrderViewui;
import ui.hotelworkerui.promotionui.Promotionui;
import ui.hotelworkerui.roomEditui.RoomEditui;
import ui.hotelworkerui.roomInfoui.RoomInfoui;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.HotelRoomVO;
import vo.hotelVO.hoteluiVO.HotelSearchVO;
import vo.hotelVO.hoteluiVO.RoomInfoVO;
import vo.promotionvo.PromotionVO;

public class HotelInfouiController {

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
	private Label feedbackLabel;
	@FXML
	private TextField hotelNameField;
	@FXML
	private TextField areaField;
	@FXML
	private TextField featureField;
	@FXML
	private TextField locationField;
	@FXML
	private TextField starField;
	@FXML
	private TextField connectionField;
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

	private ArrayList<Boolean> service;

	private ArrayList<RoomInfoVO> rooms;

	private ArrayList<HotelRoomVO> roomList;

	// 填充进TableView的酒店数据
	private ObservableList<HotelRoomVO> roomData;

	private HotelRoomVO room;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public HotelInfouiController() {
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
	private void editRoom() {
		// hotelInfo = hotelbl.showHotelInfo(workerName);
		RoomInfoVO room = rooms.get(roomTable.getSelectionModel().getSelectedIndex());
		newRoomPane = new RoomEditui(primaryStage, workerName,room);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(newRoomPane);
	}
	
	/**
	 * 增加新的房型
	 */
	@FXML
	private void addRoom() {
		// hotelInfo = hotelbl.showHotelInfo(workerName);
		newRoomPane = new RoomInfoui(primaryStage, workerName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(newRoomPane);
	}
	
	/**
	 * 删除房型
	 */
	@FXML
	private void deleteRoom() {
		// hotelInfo = hotelbl.showHotelInfo(workerName);
		newRoomPane = new RoomInfoui(primaryStage, workerName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(newRoomPane);
	}


	/**
	 * 保存酒店信息
	 */
	@FXML
	private void saveHotelInfo() {
		String hotelName = hotelNameField.getText();
		String area = areaField.getText();
		String feature = featureField.getText();
		String location = locationField.getText();
		String star = starField.getText();
		String connection = connectionField.getText();
		service = new ArrayList<Boolean>();
		service.add(wifiCheck.isSelected());
		service.add(TVCheck.isSelected());
		service.add(sofaCheck.isSelected());
		service.add(diningCheck.isSelected());
		if (hotelName.equals("") || area.equals("") || feature.equals("") || location.equals("") || star.equals("")
				|| connection.equals("")) {
			feedbackLabel.setText("修改后的信息不能为空！");
		} else if (!this.hotelName.equals(hotelName)) {
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("不能修改酒店名称！");
		} else {
			hotelInfo.setCircle(area);
			hotelInfo.setFeature(feature);
			hotelInfo.setAddress(location);
			hotelInfo.setStar(Integer.parseInt(star));
			hotelInfo.setHotelPhone(connection);
			hotelInfo.setService(service);
			if (hotelbl.modifyHotelInfo(hotelInfo)) {
				feedbackLabel.setText("修改成功！");
			} else {
				feedbackLabel.setText("系统出现错误！");
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
		hotelNameField.setText(hotelName);
		areaField.setText(hotelInfo.getCircle());
		featureField.setText(hotelInfo.getFeature());
		locationField.setText(hotelInfo.getAddress());
		starField.setText(String.valueOf(hotelInfo.getStar()));
		connectionField.setText(hotelInfo.getHotelPhone());
		service = hotelInfo.getService();
		if (service.get(0)) {
			wifiCheck.setSelected(true);
		}
		if (service.get(1)) {
			TVCheck.setSelected(true);
		}
		if (service.get(2)) {
			sofaCheck.setSelected(true);
		}
		if (service.get(3)) {
			diningCheck.setSelected(true);
		}
	}

	/**
	 * 初始设置TableView的属性，绑定内部按钮
	 */
	@SuppressWarnings("unchecked")
	public void initTableView() {
		typeCol.setCellValueFactory(new PropertyValueFactory<>("roomtype"));
		numberCol.setCellValueFactory(new PropertyValueFactory<>("totalNumber"));
		priceCol.setCellValueFactory(new PropertyValueFactory<>("roomPrice"));
		rooms = hotelbl.getHotelRoomInfo(hotelName);
		roomList = getHotelRoomList(rooms);
		roomData = FXCollections.observableArrayList(roomList);
		roomTable.setItems(roomData);
		System.out.println("roomm:"+rooms.get(0).getRoomtype());
	}

	/**
	 * 从roomVO列表中获取用于界面显示的roomInfo列表
	 * 
	 * @return roomInfo
	 */
	@SuppressWarnings("unused")
	private ArrayList<HotelRoomVO> getHotelRoomList(ArrayList<RoomInfoVO> rooms) {
		ArrayList<RoomInfoVO> roomInfoList = new ArrayList<RoomInfoVO>();
		ArrayList<HotelRoomVO> roomList = new ArrayList<HotelRoomVO>();
		String roomtype = "";
		int roomPrice = 0;
		int totalNumber = 0;
		for (int i = 0; i < rooms.size(); i++) {
			roomtype = rooms.get(i).getRoomtype();
			roomPrice = Integer.parseInt(rooms.get(i).getRoomPrice());
			// totalNumber = hotelbl.getAvailableNumber(hotelName, roomtype,
			// starttime, endtime)
			room = new HotelRoomVO(roomtype, roomPrice, totalNumber);
			roomList.add(room);
		}
		return roomList;
	}
}
