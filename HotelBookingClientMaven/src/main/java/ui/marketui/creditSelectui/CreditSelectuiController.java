package ui.marketui.creditSelectui;

import businessLogic.orderbl.OrderController;
import businessLogic.userbl.UserController;
import businessLogicService.orderblService.OrderblService;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.marketui.creditPayui.CreditPayui;
import ui.marketui.orderViewui.MarketOrderViewui;
import ui.marketui.promotionui.MarketPromotionui;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.orderVO.orderblVO.OrderVO;

public class CreditSelectuiController {
	@FXML
	private Label nameLabel;
	@FXML
	private Label feedbackLabel;
	@FXML
	private TextArea commentArea;

	private final ToggleGroup group = new ToggleGroup();
	@FXML
	private RadioButton halfButton;
	@FXML
	private RadioButton allButton;
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	private OrderblService orderbl;

	/// 网站订单浏览界面
	private Pane marketOrderPane;

	// 促销策略界面
	private Pane promotionPane;

	// 信用充值信息界面
	private Pane creditPayPane;

	private Stage primaryStage;

	private String marketName;

	private OrderVO orderInfo;

	private int percentOfCredit = 1;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public CreditSelectuiController() {
		userbl = new UserController();
		orderbl = new OrderController();
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
		if (halfButton.isSelected()) {
			percentOfCredit = 1;
		} else if (halfButton.isSelected()) {
			percentOfCredit = 2;
		}
		if (orderInfo.getOrderstate().equals("异常")) {
			if (orderbl.handleAbnormalOrder(orderInfo, percentOfCredit)) {
				feedbackLabel.setTextFill(Color.web("#058cff"));
				feedbackLabel.setText("成功处理异常订单！");
			} else {
				feedbackLabel.setTextFill(Color.web("#f80202"));
				feedbackLabel.setText("系统错误！");
			}
		} else {
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("不能重复恢复信用值！");
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
	 * 设置并显示订单信息
	 * 
	 * @param order
	 */
	public void setAndShowOrder(OrderVO order) {
		this.orderInfo = order;
	}

	/**
	 * 传递用户名
	 * 
	 * @param marketName
	 */
	public void setMarketName(String marketName) {
		this.marketName = marketName;
		nameLabel.setText(marketName);
		halfButton.setToggleGroup(group);
		allButton.setToggleGroup(group);
		halfButton.setSelected(true);
	}
}
