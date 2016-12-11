package ui.marketui.orderViewui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.marketui.creditPayui.CreditPayui;
import ui.marketui.promotionui.Promotionui;

public class OrderViewuiController {
	
	@FXML
	private Button marketOrderButton;
	@FXML
	private Button promotionButton;
	@FXML
	private Button creditRechargeButton;
	@FXML
	private Button searchButton;
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	// 网站订单浏览界面
	private Pane marketOrderPane;

	// 促销策略界面
	private Pane promotionPane;

	// 信用充值界面
	private Pane creditPayPane;

	private Stage primaryStage;

	private String marketName;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public OrderViewuiController() {
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
		promotionPane = new Promotionui(primaryStage, marketName);
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
	 * 根据订单号查看订单详情
	 */
	@FXML
	private void searchWithOrderNumber() {
		
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
	
	/**
	 * 登录之后调整界面大小，和之后更大的工作区域匹配
	 */
	public void modifyStageSize() {
		primaryStage.setWidth(980);
		primaryStage.setHeight(832);
		primaryStage.setX(400);
	}
}
