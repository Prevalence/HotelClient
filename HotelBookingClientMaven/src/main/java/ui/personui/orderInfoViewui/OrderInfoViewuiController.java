package ui.personui.orderInfoViewui;

import businessLogic.hotelbl.HotelController;
import businessLogic.orderbl.OrderController;
import businessLogic.userbl.UserController;
import businessLogicService.hotelblService.HotelblService;
import businessLogicService.orderblService.OrderblService;
import businessLogicService.userblService.UserblService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.orderVO.orderblVO.OrderVO;

public class OrderInfoViewuiController {
	
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
	private Label hotelPhoneLabel;
	@FXML
	private Label locationLabel;
	@FXML
	private Label hotelNameLabel;
	@FXML
	private Label scoreLabel;
	@FXML
	private Label areaLabel;
	@FXML
	private Label orderIDLabel;
	@FXML
	private Label roomtypeLabel;
	@FXML
	private Label peopleNumberLabel;
	@FXML
	private Label startTimeLabel;
	@FXML
	private Label endTimeLabel;
	@FXML
	private Label personLabel;
	@FXML
	private Label connectionLabel;
	@FXML
	private Label stateLabel;
	@FXML
	private Label priceLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label feedbackLabel;
	@FXML
	private Button hotelSearchButton;
	@FXML
	private Button personInfoButton;
	@FXML
	private Button personOrderButton;
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;
	
	private HotelblService hotelbl;
	
	private OrderblService orderbl;
	
	private OrderVO orderInfo;

	// 酒店详情查看界面
	private Pane hotelSearchPane;

	// 个人信息界面
	private Pane personInfoPane;
	
	//个人订单界面
	private Pane personOrderPane;

	private Stage primaryStage;

	private String personname;
	
	private String hotelName;
	
	private HotelVO hotelInfo;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public OrderInfoViewuiController() {
		userbl = new UserController();
		hotelbl = new HotelController();
		orderbl = new OrderController();
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
	 * 跳转个人信息界面
	 */
	@FXML
	private void viewPersonInfo() {
		personInfoPane = new PersonInfoui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(personInfoPane);
	}
	
	/**
	 * 跳转个人信息界面
	 */
	@FXML
	private void viewPersonOrder() {
		personOrderPane = new PersonInfoui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(personOrderPane);
	}
	
	/**
	 * 撤销未执行订单
	 */
	@FXML
	private void reverseOrder() {
		if(orderInfo.getOrderstate().equals("未执行")){
			if(orderbl.reverseOrder(orderInfo)){
				feedbackLabel.setTextFill(Color.web("#058cff"));
				feedbackLabel.setText("成功撤销订单。");
				orderInfo.setOrderstate("已撤销");
			}
			else{
				feedbackLabel.setTextFill(Color.web("#ff0000"));
				feedbackLabel.setText("系统错误。");
			}
		}
		else{
			feedbackLabel.setText("该订单已经生效，无法撤销。");
		}
	}
	
	/**
	 * 评价酒店
	 */
	@FXML
	private void commentHotel() {
		
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
	 * 设置并显示订单信息
	 * 
	 * @param order
	 */
	public void setAndShowOrder(OrderVO order) {
		this.orderInfo = order;
		orderIDLabel.setText("订单号：" + order.getOrderID());
		roomtypeLabel.setText("房间类型：" + order.getRoom().get(0).getRoomType());
		peopleNumberLabel.setText("人数：" + String.valueOf(order.getPeoplenum()));
		startTimeLabel.setText("入住时间：" + order.getExecutetime());
		endTimeLabel.setText("退房时间：" + order.getCanceltime());
		personLabel.setText("入住人：" + order.getRealname());
		connectionLabel.setText("联系方式："+order.getPersonPhone());
		stateLabel.setText(order.getOrderstate());
		priceLabel.setText("价格：" + String.valueOf(order.getRoom().get(0).getRoomPrice()));
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
			TVLabel.setText("电视");
		}
		if (hotelInfo.getService().get(2)) {
			sofaLabel.setText("沙发");
		}
		if (hotelInfo.getService().get(3)) {
			diningLabel.setText("餐厅");
		}
		featureLabel.setText(hotelInfo.getFeature());
		scoreLabel.setText(String.valueOf(hotelInfo.getScore()) + "/5");
		areaLabel.setText(hotelInfo.getCircle());
		locationLabel.setText(hotelInfo.getAddress());
		hotelNameLabel.setText(hotelName);
		hotelPhoneLabel.setText(hotelInfo.getHotelPhone());
	}
}
