package ui.personui.createOrderui;

import java.util.ArrayList;
import java.util.Calendar;

import businessLogic.hotelbl.HotelController;
import businessLogic.orderbl.OrderController;
import businessLogic.userbl.UserController;
import businessLogicService.hotelblService.HotelblService;
import businessLogicService.orderblService.OrderblService;
import businessLogicService.userblService.UserblService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.orderReviewui.OrderReviewui;
import ui.personui.orderViewui.OrderViewui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.CommentInfoVO;
import vo.hotelVO.hoteluiVO.RoomInfoVO;
import vo.orderVO.orderblVO.OrderVO;

public class CreateOrderuiController {

	@FXML
	private Label wifiLabel;
	@FXML
	private Label TVLabel;
	@FXML
	private Label sofaLabel;
	@FXML
	private Label diningLabel;
	@FXML
	private Label featureLabel;
	@FXML
	private Label connectionLabel;
	@FXML
	private Label locationLabel;
	@FXML
	private Label hotelNameLabel;
	@FXML
	private Label scoreLabel;
	@FXML
	private Label areaLabel;
	@FXML
	private Label numberLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label roomPriceLabel;
	@FXML
	private Label feedbackLabel;
	@FXML
	private TextField peopleField;
	@FXML
	private TextField yearField1;
	@FXML
	private TextField yearField2;
	@FXML
	private TextField customerField;
	@FXML
	private TextField connectionField;
	@FXML
	private TextField roomNumberField;
	@SuppressWarnings("rawtypes")
	@FXML
	private ChoiceBox roomChoices;
	@SuppressWarnings("rawtypes")
	@FXML
	private ChoiceBox monthChoices1;
	@SuppressWarnings("rawtypes")
	@FXML
	private ChoiceBox monthChoices2;
	@SuppressWarnings("rawtypes")
	@FXML
	private ChoiceBox dayChoices1;
	@SuppressWarnings("rawtypes")
	@FXML
	private ChoiceBox dayChoices2;
	@FXML
	private Pane mainPane;

	private ObservableList<String> days1 = FXCollections.observableArrayList();

	private ObservableList<String> days2 = FXCollections.observableArrayList();

	@SuppressWarnings("unused")
	private UserblService userbl;

	private HotelblService hotelbl;

	private OrderblService orderbl;

	private HotelVO hotelInfo;

	private ArrayList<RoomVO> room;

	// 填充进hotelInfoTable的酒店数据
	private ObservableList<RoomInfoVO> roomData;

	private ArrayList<RoomInfoVO> roomInfoList;

	private RoomInfoVO roomInfo;

	private OrderVO orderInfo;

	// 酒店搜索界面
	private Pane hotelSearchPane;

	// 个人信息界面
	private Pane personInfoViewPane;

	// 订单查看界面
	private Pane personOrderViewPane;

	// 订单二次确认界面
	private Pane orderReviewPane;

	private Stage primaryStage;

	private String personname;

	@SuppressWarnings("unused")
	private String hotelName;

	private String roomSelected;
	
	private String priceSelected;

	private String year1;

	private String year2;

	private String month1;

	private String month2;

	private String day1;

	private String day2;

	private String startTime;

	private String endTime;

	private String peopleNumber;

	private String customer;

	private String connection;

	private String roomNumber;

	private String phoneNumber;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public CreateOrderuiController() {
		userbl = new UserController();
		hotelbl = new HotelController();
		orderbl = new OrderController();
		roomSelected = "";
		year1 = "";
		year2 = "";
		month1 = "";
		month1 = "";
		day1 = "";
		day2 = "";
		roomNumber = "";
		connection = "";
		customer = "";
		peopleNumber = "";
	}

	/**
	 * 跳转到个人信息维护界面
	 * 
	 * @return boolean
	 */
	@FXML
	private void viewPersonInfo() {
		personInfoViewPane = new PersonInfoui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(personInfoViewPane);
	}

	/**
	 * 跳转到个人订单查看界面
	 */
	@FXML
	private void viewPersonOrder() {
		personOrderViewPane = new OrderViewui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(personOrderViewPane);
	}

	/**
	 * 跳转到酒店搜索界面
	 */
	@FXML
	private void viewHotelSearch() {
		hotelSearchPane = new HotelSearchui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelSearchPane);
	}

	/**
	 * 生成订单，跳转到订单信息填写界面
	 */
	@FXML
	private void createOrder() {
		year1 = yearField1.getText();
		year2 = yearField2.getText();
		startTime = year1 + "-" + month1 + "-" + day1 + " 12:00:00";
		endTime = year2 + "-" + month2 + "-" + day2 + " 12:00:00";
		peopleNumber = peopleField.getText();
		customer = customerField.getText();
		connection = connectionField.getText();
		roomNumber = roomNumberField.getText();
		phoneNumber = connectionField.getText();
		if (roomSelected.equals("") || year1.equals("") || year2.equals("") || month1.equals("") || month2.equals("")
				|| day1.equals("") || day2.equals("") || roomNumber.equals("") || connection.equals("")
				|| customer.equals("") || peopleNumber.equals("") || phoneNumber.equals("")) {
			feedbackLabel.setText("订单信息填写不完整！");
		} else {
			ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
			RoomVO room=new RoomVO(roomSelected,"",Integer.parseInt(priceSelected),null,null);
			rooms.add(room);
			orderInfo = new OrderVO("", 0, "未执行", hotelName, rooms, Integer.parseInt(roomNumber), personname,
					phoneNumber, customer, Integer.parseInt(peopleNumber), 0, "", "", "", startTime, endTime, "");
			orderReviewPane = new OrderReviewui(primaryStage, personname, hotelName, hotelInfo, orderInfo);
			mainPane.getChildren().remove(0);
			mainPane.getChildren().add(orderReviewPane);
		}
	}

	/**
	 * 查看当前时段内酒店剩余的某房间类型数量 前提是房间类型、入住时间和退房时间都已经填写
	 */
	@FXML
	private void seeNumber() {
		year1 = yearField1.getText();
		year2 = yearField2.getText();
		if (roomSelected.equals("")) {
			feedbackLabel.setText("未选择房间类型！");
		} else if (year1.equals("") || year2.equals("") || month1.equals("") || month2.equals("") || day1.equals("")
				|| day2.equals("")) {
			feedbackLabel.setText("日期填写不完整！");
		} else {
			startTime = year1 + "-" + month1 + "-" + day1 + " 12:00:00";
			endTime = year2 + "-" + month2 + "-" + day2 + " 12:00:00";
			numberLabel.setText(String
					.valueOf(hotelbl.getAvailableNumber(hotelInfo.getHotelname(), roomSelected, startTime, endTime)));
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
	 * @param personname
	 */
	public void setPersonname(String personname) {
		this.personname = personname;
		nameLabel.setText(personname);
	}

	/**
	 * 传递酒店信息的VO
	 * 
	 * @param hotelInfo
	 */
	public void setHotelVO(HotelVO hotelInfo) {
		this.hotelInfo = hotelInfo;
		roomInfoList = hotelbl.getHotelRoomInfo(hotelName);
	}

	/**
	 * 传递酒店名，并将该酒店详情显示在界面上
	 * 
	 * @param hotelName
	 */
	public void setHotelNameAndShowInfo(String hotelName) {
		this.hotelName = hotelName;
		hotelInfo = hotelbl.getHotelInfoByHotelworkerOrManager(hotelName);
		if (hotelInfo.getService().get(0)) {
			wifiLabel.setText("wifi");
		}
		if (hotelInfo.getService().get(1)) {
			wifiLabel.setText("电视");
		}
		if (hotelInfo.getService().get(2)) {
			wifiLabel.setText("沙发");
		}
		if (hotelInfo.getService().get(3)) {
			wifiLabel.setText("餐厅");
		}
		featureLabel.setText(hotelInfo.getFeature());
		// connectionLabel.setText(hotelInfo.get);
		scoreLabel.setText(String.valueOf(hotelInfo.getScore()) + "/5");
		areaLabel.setText(hotelInfo.getCircle());
		locationLabel.setText(hotelInfo.getAddress());
		hotelNameLabel.setText(hotelName);
		connectionLabel.setText(hotelInfo.getHotelPhone());
		
	}

	/**
	 * 设置房间类型选择的组件 当选择房间类型之后，在界面显示该房间类型的单价
	 * 
	 * @param others
	 */
	@SuppressWarnings("unchecked")
	public void setRoomChoiceBox(ObservableList<String> others) {
		roomChoices.setItems(others);
		roomChoices.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// 就是房间类型
				roomSelected = roomChoices.getSelectionModel().getSelectedItem().toString();
				System.out.println("roomSelected:"+roomSelected);
				priceSelected = roomInfoList.get(roomChoices.getSelectionModel().getSelectedIndex()).getRoomPrice();
				roomPriceLabel.setText(
						roomInfoList.get(roomChoices.getSelectionModel().getSelectedIndex()).getRoomPrice());
				// numberLabel.setText(room.get(roomChoices.getSelectionModel().getSelectedIndex()).getRoomnum());

			}
		});
	}

	/**
	 * 设置月份选择的组件
	 * 
	 * @param others
	 */
	@SuppressWarnings("unchecked")
	public void setMonthChoiceBox(ObservableList<String> others) {
		monthChoices1.setItems(others);
		monthChoices2.setItems(others);
		monthChoices1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				month1 = monthChoices1.getSelectionModel().getSelectedItem().toString();
				if (month1.equals("01") || month1.equals("03") || month1.equals("05") || month1.equals("07")
						|| month1.equals("08") || month1.equals("10") || month1.equals("12")) {
					days1.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
							"30", "31");
				} else if (month1.equals("04") || month1.equals("06") || month1.equals("09") || month1.equals("11")) {
					days1.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
							"30");
				} else {
					days1.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28");
				}
				setDayChoiceBox1(days1);
			}
		});
		monthChoices2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				month2 = monthChoices2.getSelectionModel().getSelectedItem().toString();
				if (month2.equals("01") || month2.equals("03") || month2.equals("05") || month2.equals("07")
						|| month2.equals("08") || month2.equals("10") || month2.equals("12")) {
					days2.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
							"30", "31");
				} else if (month2.equals("04") || month2.equals("06") || month2.equals("09") || month2.equals("11")) {
					days2.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
							"30");
				} else {
					days2.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28");
				}
				setDayChoiceBox2(days2);
			}
		});
	}

	/**
	 * 设置第一个日选择的组件
	 * 
	 * @param others
	 */
	@SuppressWarnings("unchecked")
	private void setDayChoiceBox1(ObservableList<String> others) {
		dayChoices1.setItems(others);
		dayChoices1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// 就是房间类型
				day1 = dayChoices1.getSelectionModel().getSelectedItem().toString();
			}
		});
	}

	/**
	 * 设置第二个日选择的组件
	 * 
	 * @param others
	 */
	@SuppressWarnings("unchecked")
	private void setDayChoiceBox2(ObservableList<String> others) {
		dayChoices2.setItems(others);
		dayChoices2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// 就是房间类型
				day2 = dayChoices2.getSelectionModel().getSelectedItem().toString();
			}
		});
	}

}
