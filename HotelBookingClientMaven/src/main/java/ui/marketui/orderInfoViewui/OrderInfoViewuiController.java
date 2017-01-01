package ui.marketui.orderInfoViewui;

import businessLogic.userbl.UserController;
import businessLogicService.orderblService.OrderblService;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.marketui.creditPayui.CreditPayui;
import ui.marketui.creditSelectui.CreditSelectui;
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
	private Label feedbackLabel;
	@FXML
	private Pane mainPane;

	private UserblService userbl;
	
	private OrderblService orderbl;

	// 网站订单浏览界面
	private Pane marketOrderPane;

	// 促销策略界面
	private Pane promotionPane;

	// 信用充值信息界面
	private Pane creditPayPane;

	// 恢复信用值选择界面
	private Pane creditPane;
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
	 * 跳转到网站订单浏览界面
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
	 * 跳转到信用充值界面
	 */
	@FXML
	private void rechargeCredit() {
		// hotelInfo = hotelbl.showHotelInfo(marketName);
		creditPayPane = new CreditPayui(primaryStage, marketName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(creditPayPane);
	}
	
	/**
	 * 处理异常订单
	 */
	@FXML
	private void handleOrder() {
		if(orderInfo.getOrderstate().equals("异常")){
			creditPane = new CreditSelectui(primaryStage,marketName,orderInfo);
			mainPane.getChildren().remove(0);
			mainPane.getChildren().add(creditPane);
		}
		else{
			feedbackLabel.setText("该订单不是异常订单！");
		}
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
