package ui.hotelworkerui.orderInfoViewui;

import businessLogic.hotelbl.HotelController;
import businessLogic.orderbl.OrderController;
import businessLogic.userbl.UserController;
import businessLogicService.hotelblService.HotelblService;
import businessLogicService.orderblService.OrderblService;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.hotelworkerui.hotelInfoui.HotelInfoui;
import ui.hotelworkerui.orderViewui.HotelOrderViewui;
import ui.hotelworkerui.promotionui.Promotionui;
import ui.hotelworkerui.roomInfoui.RoomInfoui;
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
	private Label feedbackLabel;
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;
	
	private OrderblService orderbl;
	
	private HotelblService hotelbl;

	// 酒店订单浏览界面
	@SuppressWarnings("unused")
	private Pane hotelOrderPane;

	// 促销策略界面
	@SuppressWarnings("unused")
	private Pane promotionPane;

	// 酒店信息界面
	@SuppressWarnings("unused")
	private Pane hotelInfoPane;

	// 房间信息界面
	@SuppressWarnings("unused")
	private Pane roomInfoPane;

	@SuppressWarnings("unused")
	private Stage primaryStage;

	@SuppressWarnings("unused")
	private String workerName;

	private OrderVO orderInfo;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public OrderInfoViewuiController() {
		userbl = new UserController();
		orderbl = new OrderController();
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
	 * 确认入住
	 */
	@FXML
	private void liveIn() {
		if(orderbl.finishOrder(orderInfo)){
			feedbackLabel.setTextFill(Color.web("#058cff"));
			feedbackLabel.setText("成功办理入住！");;
		}
		else{
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("系统出现异常!");
		}
	}
	
	/**
	 * 退房
	 */
	@FXML
	private void leave() {
//		if(orderbl.){
//			orderInfo.get
//			feedbackLabel.setTextFill(Color.web("#058cff"));
//			feedbackLabel.setText("成功办理入住！");;
//		}
//		else{
//			feedbackLabel.setTextFill(Color.web("#f80202"));
//			feedbackLabel.setText("系统出现异常!");
//		}
	}

	/**
	 * 设置并显示订单信息
	 * 
	 * @param order
	 */
	public void setAndShowOrder(OrderVO order) {
		this.orderInfo = order;
		orderIDLabel.setText(order.getOrderID());
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
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
}
