package ui.marketui.promotionui.periodPromotionEditui;

import java.text.SimpleDateFormat;

import businessLogic.hotelbl.HotelController;
import businessLogic.promotionbl.PromotionController;
import businessLogic.userbl.UserController;
import businessLogicService.hotelblService.HotelblService;
import businessLogicService.promotionblService.PromotionblService;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.hotelworkerui.hotelInfoui.HotelInfoui;
import ui.hotelworkerui.orderViewui.HotelOrderViewui;
import ui.hotelworkerui.promotionui.Promotionui;
import ui.hotelworkerui.roomInfoui.RoomInfoui;
import ui.marketui.creditPayui.CreditPayui;
import ui.marketui.orderViewui.MarketOrderViewui;
import ui.marketui.promotionui.MarketPromotionui;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.promotionvo.PromotionVO;
import vo.promotionvo.webpromotionVO.PeriodWebproVO;

public class WebPeriodPromotionEdituiController {
	@FXML
	private Button hotelOrderButton;
	@FXML
	private Button promotionButton;
	@FXML
	private Button hotelInfoButton;
	@FXML
	private Button roomInfoButton;
	@FXML
	private Button oButton;
	@FXML
	private Label nameLabel;
	@FXML
	private Label hotelNameLabel;
	@FXML
	private Label scoreLabel;
	@FXML
	private Label areaLabel;
	@FXML
	private Label connectionLabel;
	@FXML
	private Label oldStartTimeLabel;
	@FXML
	private Label oldEndTimeLabel;
	@FXML
	private Label feedbackLabel;
	@FXML
	private TextField promotionNameField;
	@FXML
	private TextField startTimeField;
	@FXML
	private TextField endTimeField;
	@FXML
	private TextField discountField;
	@FXML
	private TextField monthField1;
	@FXML
	private TextField monthField2;
	@FXML
	private TextField dayField1;
	@FXML
	private TextField dayField2;

	@FXML
	private Pane mainPane;

	private UserblService userbl;

	private HotelblService hotelbl;

	private PromotionblService promotionbl;

	// 网站订单浏览界面
	private Pane marketOrderPane;

	// 促销策略界面
	private Pane promotionPane;

	// 信用充值界面
	private Pane creditPayPane;

	private Stage primaryStage;

	private String hotelName;

	private String marketName;

	private HotelVO hotelInfo;
	
	private PeriodWebproVO promotion;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public WebPeriodPromotionEdituiController() {
		userbl = new UserController();
		promotionbl = new PromotionController();
		hotelbl = new HotelController();
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
	 * 编辑酒店促销策略
	 */
	@FXML
	private void addPromotion() {
		String promotionName = promotionNameField.getText();
		String startTime = startTimeField.getText();
		String endTime = endTimeField.getText();
		String discount = discountField.getText();
		if (discount.equals("") || promotionName.equals("")) {
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("促销策略信息不全！");
		} else {
			PromotionVO promotion = new PeriodWebproVO(0, promotionName, "特定时间优惠策略", "WebPromotion",
					startTime, endTime, Integer.parseInt(discount));
			if(promotionbl.modifyProm(promotion)){
				feedbackLabel.setTextFill(Color.web("#058cff"));
				feedbackLabel.setText("编辑成功！");
			}
			else{
				feedbackLabel.setTextFill(Color.web("#f80202"));
				feedbackLabel.setText("系统错误！");
			}
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
	 * @param marketName
	 */
	public void setMarketName(String marketName) {
		this.marketName = marketName;
		nameLabel.setText(marketName);
	}
	
	/**
	 * 传递促销策略信息
	 * 
	 * @param marketName
	 */
	public void setPromotionVO(PeriodWebproVO promotion) {
		this.promotion=promotion;
		promotionNameField.setText(promotion.getPromotionName());
		discountField.setText(String.valueOf(promotion.getDiscount()));
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String dateStr=sdf.format(.getTime());
		oldStartTimeLabel.setText(promotion.getStartTime());
		oldEndTimeLabel.setText(promotion.getEndTime());
	}
}
