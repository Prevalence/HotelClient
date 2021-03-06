package ui.personui.orderReviewui;

import java.util.ArrayList;

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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.personui.createOrderui.CreateOrderui;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.orderInfoViewui.OrderInfoViewui;
import ui.personui.orderViewui.OrderViewui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.CommentInfoVO;
import vo.hotelVO.hoteluiVO.RoomInfoVO;
import vo.orderVO.orderblVO.OrderVO;

public class OrderReviewuiController {

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
	private Label roomNumberLabel;
	@FXML
	private Label priceLabel;
	@FXML
	private Label orderNumberLabel;
	@FXML
	private Label roomtypeLabel;
	@FXML
	private Label peopleLabel;
	@FXML
	private Label enterTimeLabel;
	@FXML
	private Label endTimeLabel;
	@FXML
	private Label customerLabel;	
	@FXML
	private Label personConnectionLabel;
	@FXML
	private Label feedbackLabel;
	@FXML
	private Label nameLabel;
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

	private OrderVO orderInfo;

	// 个人信息界面
	private Pane personInfoViewPane;

	// 订单查看界面
	private Pane personOrderViewPane;

	// 订单填写界面
	private Pane createOrderPane;
	
	//酒店搜索界面
	private Pane hotelSearchPane;

	private Pane orderInfoPane;

	private Stage primaryStage;

	private String personname;

	@SuppressWarnings("unused")
	private String hotelName;

	private String roomSelected;

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

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public OrderReviewuiController() {
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
	 * 跳转到酒店搜索界面
	 */
	@FXML
	private void viewHotelSearch() {
		hotelSearchPane = new HotelSearchui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelSearchPane);
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
	 * 返回订单信息填写界面
	 */
	@FXML
	private void returnToOrder() {
		createOrderPane = new CreateOrderui(primaryStage, personname, hotelName, hotelInfo);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(createOrderPane);
	}

	/**
	 * 生成订单，跳转到订单浏览界面
	 */
	@FXML
	private void createOrder() {
		orderbl.createOrder(orderInfo);
		orderInfoPane = new OrderViewui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(orderInfoPane);
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
		room = hotelInfo.getRoom();
		
	}

	/**
	 * 传递酒店名，并将该酒店详情显示在界面上
	 * 
	 * @param hotelName
	 */
	public void setHotelNameAndShowInfo(String hotelName) {
		this.hotelName = hotelName;
		hotelInfo = hotelbl.getHotelInfoByPerson(hotelName);
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
	 * 传递订单信息的VO
	 * 
	 * @param orderInfo
	 */
	public void setAndShowOrderVO(OrderVO orderInfo) {
		this.orderInfo = orderInfo;
		roomNumberLabel.setText(String.valueOf(orderInfo.getRoomNum()));
		priceLabel.setText(String.valueOf(orderInfo.getOrderprice()));
		orderNumberLabel.setText(orderInfo.getOrderID());
		roomtypeLabel.setText(orderInfo.getRoom().get(0).getRoomType());
		peopleLabel.setText(String.valueOf(orderInfo.getPeoplenum()));
		enterTimeLabel.setText(orderInfo.getPredictExecutetime());
		endTimeLabel.setText(orderInfo.getPredictLeaveTime());
		customerLabel.setText(orderInfo.getRealname());	
		personConnectionLabel.setText(orderInfo.getPersonPhone());
	}

}
