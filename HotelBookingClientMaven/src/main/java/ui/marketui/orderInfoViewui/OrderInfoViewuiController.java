package ui.marketui.orderInfoViewui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.hotelworkerui.hotelInfoui.HotelInfoui;
import ui.hotelworkerui.orderViewui.HotelOrderViewui;
import ui.hotelworkerui.promotionui.Promotionui;
import ui.hotelworkerui.roomInfoui.RoomInfoui;
import ui.marketui.creditPayui.CreditPayui;
import ui.marketui.orderViewui.MarketOrderViewui;
import ui.marketui.promotionui.MarketPromotionui;
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
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	// 酒店订单浏览界面
	@SuppressWarnings("unused")
	private Pane marketOrderPane;

	// 促销策略界面
	@SuppressWarnings("unused")
	private Pane promotionPane;

	// 酒店信息界面
	@SuppressWarnings("unused")
	private Pane creditPane;

	// 房间信息界面
	@SuppressWarnings("unused")
	private Pane roomInfoPane;
	@SuppressWarnings("unused")
	private Stage primaryStage;

	@SuppressWarnings("unused")
	private String marketName;
	
	private OrderVO orderInfo;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public OrderInfoViewuiController() {
		userbl = new UserController();
	}

	/**
	 * 跳转到酒店订单浏览界面
	 */
	@FXML
	private void viewMarketOrder() {
		marketOrderPane = new MarketOrderViewui(primaryStage, marketName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(marketOrderPane);
	}

	/**
	 * 跳转到促销策略界面
	 */
	@FXML
	private void viewPromotion() {
		promotionPane = new MarketPromotionui(primaryStage, marketName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(promotionPane);
	}

	/**
	 * 跳转到酒店信息维护界面
	 */
	@FXML
	private void viewHotelInfo() {
		// hotelInfo = hotelbl.showHotelInfo(marketName);
		creditPane = new CreditPayui(primaryStage, marketName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(creditPane);
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
	 * @param marketName
	 */
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	
}
