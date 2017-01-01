package ui.marketui.promotionui.periodPromotionAddui;

import businessLogic.hotelbl.HotelController;
import businessLogic.promotionbl.PromotionController;
import businessLogic.userbl.UserController;
import businessLogicService.hotelblService.HotelblService;
import businessLogicService.promotionblService.PromotionblService;
import businessLogicService.userblService.UserblService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import vo.promotionvo.hotelpromotionVO.BirthdayHotelproVO;
import vo.promotionvo.hotelpromotionVO.PeriodHotelproVO;
import vo.promotionvo.webpromotionVO.PeriodWebproVO;

public class WebPeriodPromotionAdduiController {
	@FXML
	private Button hotelOrderButton;
	@FXML
	private Button promotionButton;
	@FXML
	private Button hotelInfoButton;
	@FXML
	private Button roomInfoButton;
	@FXML
	private Button okButton;
	@FXML
	private Label nameLabel;
	@FXML
	private Label feedbackLabel;
	@FXML
	private TextField promotionNameField;
	@FXML
	private TextField yearField1;
	@FXML
	private TextField yearField2;
	@FXML
	private TextField startTimeField;
	@FXML
	private TextField endTimeField;
	@FXML
	private TextField discountField;
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

	private String marketName;
	
	private String year1;

	private String year2;

	private String month1;

	private String month2;

	private String day1;

	private String day2;

	private ObservableList<String> days1 = FXCollections.observableArrayList();

	private ObservableList<String> days2 = FXCollections.observableArrayList();

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public WebPeriodPromotionAdduiController() {
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
	 * 新增酒店促销策略
	 */
	@FXML
	private void addPromotion() {
		String promotionName = promotionNameField.getText();
		year1 = yearField1.getText();
		year2 = yearField2.getText();
		String startTime = year1 + "-" + month1 + "-" + day1 + " 12:00:00";
		String endTime = year2 + "-" + month2 + "-" + day2 + " 12:00:00";
		System.out.println("time:--"+startTime);
		String discount = discountField.getText();
		if (discount.equals("") || promotionName.equals("")) {
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("促销策略信息不全！");
		} else {
			PromotionVO promotion = new PeriodWebproVO(0, promotionName, "网站特定时间优惠策略", "WebPromotion",
					startTime, endTime, Integer.parseInt(discount));
			if(promotionbl.addProm(promotion)){
				feedbackLabel.setTextFill(Color.web("#058cff"));
				feedbackLabel.setText("添加成功！");
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
	 * 设置月份选择的组件
	 * 
	 * @param others
	 */
	@SuppressWarnings("unchecked")
	public void setMonthChoiceBox(ObservableList<String> others) {
		monthChoices1.setItems(others);
		monthChoices2.setItems(others);
		monthChoices1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				month1 = monthChoices1.getSelectionModel().getSelectedItem().toString();
				if (month1.equals("01") || month1.equals("03") || month1.equals("05") || month1.equals("07")
						|| month1.equals("08") || month1.equals("10") || month1.equals("12")) {
					days1.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
							"30", "31");
				} else if (month1.equals("04") || month1.equals("06") || month1.equals("09") || month1.equals("11")) {
					days1.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
							"30");
				} else {
					days1.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28");
				}
				setDayChoiceBox1(days1);
			}
		});
		monthChoices2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				month2 = monthChoices2.getSelectionModel().getSelectedItem().toString();
				if (month2.equals("01") || month2.equals("03") || month2.equals("05") || month2.equals("07")
						|| month2.equals("08") || month2.equals("10") || month2.equals("12")) {
					days2.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
							"30", "31");
				} else if (month2.equals("04") || month2.equals("06") || month2.equals("09") || month2.equals("11")) {
					days2.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
							"30");
				} else {
					days2.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28");
				}
				setDayChoiceBox2(days2);
			}
		});
	}

	/**
	 * 设置第一个日选择的组件
	 * 
	 * @param others
	 */
	@SuppressWarnings("unchecked")
	private void setDayChoiceBox1(ObservableList<String> others) {
		dayChoices1.setItems(others);
		dayChoices1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// 就是房间类型
				day1 = dayChoices1.getSelectionModel().getSelectedItem().toString();
			}
		});
	}

	/**
	 * 设置第二个日选择的组件
	 * 
	 * @param others
	 */
	@SuppressWarnings("unchecked")
	private void setDayChoiceBox2(ObservableList<String> others) {
		dayChoices2.setItems(others);
		dayChoices2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// 就是房间类型
				day2 = dayChoices2.getSelectionModel().getSelectedItem().toString();
			}
		});
	}
}
