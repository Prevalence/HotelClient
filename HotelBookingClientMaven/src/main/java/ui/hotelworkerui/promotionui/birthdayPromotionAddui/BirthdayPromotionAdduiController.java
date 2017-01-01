package ui.hotelworkerui.promotionui.birthdayPromotionAddui;

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
import vo.hotelVO.hotelblVO.HotelVO;
import vo.promotionvo.PromotionVO;
import vo.promotionvo.hotelpromotionVO.BirthdayHotelproVO;

public class BirthdayPromotionAdduiController {
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
	private Label feedbackLabel;
	@FXML
	private TextField promotionNameField;
	@FXML
	private TextField discountField;

	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	private HotelblService hotelbl;

	private PromotionblService promotionbl;

	// 酒店订单浏览界面
	private Pane hotelOrderPane;

	// 促销策略界面
	private Pane promotionPane;

	// 酒店信息界面
	private Pane hotelInfoPane;

	// 房间信息界面
	private Pane roomInfoPane;

	private Stage primaryStage;

	private String hotelName;

	private String workerName;

	private HotelVO hotelInfo;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public BirthdayPromotionAdduiController() {
		userbl = new UserController();
		promotionbl = new PromotionController();
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
		// hotelInfo = hotelbl.showHotelInfo(hotelName);
		hotelInfoPane = new HotelInfoui(primaryStage, workerName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelInfoPane);
	}

	/**
	 * 跳转到房间信息查看界面
	 */
	@FXML
	private void viewRoomInfo() {
		// hotelInfo = hotelbl.showHotelInfo(hotelName);
		roomInfoPane = new RoomInfoui(primaryStage, workerName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(roomInfoPane);
	}

	/**
	 * 新增酒店促销策略
	 */
	@FXML
	private void addPromotion() {
		String promotionName = promotionNameField.getText();
		String discount = discountField.getText();
		if (discount.equals("") || promotionName.equals("")) {
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("促销策略信息不全！");
		} else {
			PromotionVO promotion = new BirthdayHotelproVO(0, promotionName, "生日优惠策略", hotelName,
					Integer.parseInt(discount));
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
	 * 传递用户名并显示信息
	 * 
	 * @param workerName
	 */
	public void setWorkerNameAndShowInfo(String workerName) {
		this.workerName = workerName;
		nameLabel.setText(workerName);
		hotelName = userbl.getHotelWorkerInfo(workerName).getHotelName();
		hotelInfo = hotelbl.getHotelInfoByHotelworkerOrManager(hotelName);
		nameLabel.setText(workerName);
		hotelNameLabel.setText(hotelName);
		areaLabel.setText(hotelInfo.getCircle());
		scoreLabel.setText(String.valueOf(hotelInfo.getScore()));
		connectionLabel.setText(hotelInfo.getHotelPhone());
	}
}
