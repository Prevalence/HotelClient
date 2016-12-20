package ui.personui.orderInfoViewui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.personInfoui.PersonInfoui;
import vo.orderVO.orderblVO.OrderVO;

public class OrderInfoViewuiController {
	
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
	private Button hotelSearchButton;
	@FXML
	private Button personInfoButton;
	@FXML
	private Button personOrderButton;
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;
	
	private OrderVO orderInfo;

	// 酒店详情查看界面
	private Pane hotelSearchPane;

	// 个人信息界面
	private Pane personInfoPane;
	
	//个人订单界面
	private Pane personOrderPane;

	private Stage primaryStage;

	private String personname;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public OrderInfoViewuiController() {
		userbl = new UserController();
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
		stateLabel.setText("状态：" + order.getOrderstate());
		priceLabel.setText("价格：" + String.valueOf(order.getRoom().get(0).getRoomPrice()));
	}
}
