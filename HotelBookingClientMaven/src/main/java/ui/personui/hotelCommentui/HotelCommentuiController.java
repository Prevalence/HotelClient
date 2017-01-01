package ui.personui.hotelCommentui;

import java.util.Calendar;

import businessLogic.hotelbl.HotelController;
import businessLogic.userbl.UserController;
import businessLogicService.hotelblService.HotelblService;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelVO;

public class HotelCommentuiController {

	@FXML
	private Label wifiLabel;
	@FXML
	private Label TVLabel;
	@FXML
	private Label sofaLabel;
	@FXML
	private Label diningLabel;
	@FXML
	private Label featureLabel;
	@FXML
	private Label hotelPhoneLabel;
	@FXML
	private Label locationLabel;
	@FXML
	private Label hotelNameLabel;
	@FXML
	private Label scoreLabel;
	@FXML
	private Label areaLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label feedbackLabel;
	@FXML
	private TextArea commentArea;
	
	private final ToggleGroup group = new ToggleGroup();
	@FXML
	private RadioButton pointButton1;
	@FXML
	private RadioButton pointButton2;
	@FXML
	private RadioButton pointButton3;
	@FXML
	private RadioButton pointButton4;
	@FXML
	private RadioButton pointButton5;
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	private HotelblService hotelbl;

	private HotelVO hotelInfo;

	// 酒店详情查看界面
	@SuppressWarnings("unused")
	private Pane hotelInfoViewPane;

	// 个人信息界面
	@SuppressWarnings("unused")
	private Pane personInfoViewPane;

	// 酒店搜索界面
	private Pane hotelSearchPane;

	// 个人信息界面
	private Pane personInfoPane;

	// 个人订单界面
	private Pane personOrderPane;

	private Stage primaryStage;

	private String personname;

	private String hotelName;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public HotelCommentuiController() {
		userbl = new UserController();
		hotelbl = new HotelController();
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
	 * 提交评价
	 */
	@FXML
	private void submitComment() {
		String comment = commentArea.getText();
		int score = 5;
		if(pointButton1.isSelected()){
			score = 1;
		}else if(pointButton2.isSelected()){
			score = 2;
		}else if(pointButton3.isSelected()){
			score = 3;
		}else if(pointButton4.isSelected()){
			score = 4;
		}else if(pointButton5.isSelected()){
			score = 5;
		}
		CommentVO commentvo= new CommentVO(hotelName, personname, null, score, comment);
		if(hotelbl.addComment(commentvo)){
			feedbackLabel.setTextFill(Color.web("#058cff"));
			feedbackLabel.setText("评价成功！");
		}
		else{
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("系统出现异常!");
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
	 * @param personname
	 */
	public void setPersonname(String personname) {
		this.personname = personname;
		nameLabel.setText(personname);
	}

	/**
	 * 传递酒店名，并将该酒店详情显示在界面上
	 * 
	 * @param hotelName
	 */
	public void setHotelNameAndShowInfo(String hotelName) {
		this.hotelName = hotelName;
		hotelInfo = hotelbl.getHotelInfoByPerson(hotelName);
		if (hotelInfo.getService().get(0)) {
			wifiLabel.setText("wifi");
		}
		if (hotelInfo.getService().get(1)) {
			TVLabel.setText("电视");
		}
		if (hotelInfo.getService().get(2)) {
			sofaLabel.setText("沙发");
		}
		if (hotelInfo.getService().get(3)) {
			diningLabel.setText("餐厅");
		}
		featureLabel.setText(hotelInfo.getFeature());
		scoreLabel.setText(String.valueOf(hotelInfo.getScore()) + "/5");
		areaLabel.setText(hotelInfo.getCircle());
		locationLabel.setText(hotelInfo.getAddress());
		hotelNameLabel.setText(hotelName);
		hotelPhoneLabel.setText(hotelInfo.getHotelPhone());
		pointButton1.setToggleGroup(group);
		pointButton2.setToggleGroup(group);
		pointButton3.setToggleGroup(group);
		pointButton4.setToggleGroup(group);
		pointButton5.setToggleGroup(group);
		pointButton5.setSelected(true);
	}
}
