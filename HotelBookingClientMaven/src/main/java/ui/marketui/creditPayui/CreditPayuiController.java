package ui.marketui.creditPayui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.marketui.orderViewui.MarketOrderViewui;
import ui.marketui.promotionui.MarketPromotionui;

public class CreditPayuiController {
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
	public CreditPayuiController() {
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
	 * 根据客户编号显示客户信息（信用值等）
	 */
	@FXML
	private void searchWithPersonNumber() {

	}

	/**
	 * 点击确定，充值信用
	 */
	@FXML
	private void addCredit() {

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
