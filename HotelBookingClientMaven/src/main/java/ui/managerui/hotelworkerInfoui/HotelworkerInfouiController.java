package ui.managerui.hotelworkerInfoui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.managerui.userSearchAndAddui.UserSearchAndAddui;
import vo.HotelWorkerVO;

public class HotelworkerInfouiController {
	@FXML
	private Button returnButton;
	@FXML
	private Button saveButton;
	@FXML
	private TextField workIDField;
	@FXML
	private TextField hotelField;
	@FXML
	private TextField passwordField;
	@FXML
	private Label feedbackLabel;
	@FXML
	private Pane mainPane;

	private UserblService userbl;

	// 网站管理人员首界面
	private Pane userSearchAndAddPane;

	private Stage primaryStage;

	private HotelWorkerVO hotelworkerInfo;

	private String managerName;

	@SuppressWarnings("unused")
	private String hotelworkerName;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public HotelworkerInfouiController() {
		userbl = new UserController();
	}

	/**
	 * 返回网站管理人员首界面
	 */
	@FXML
	private void returnToFirst() {
		userSearchAndAddPane = new UserSearchAndAddui(primaryStage, managerName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(userSearchAndAddPane);
	}

	/**
	 * 保存修改的信息
	 */
	@FXML
	private void saveChanges() {
		String workID = workIDField.getText();
		String password = passwordField.getText();
		String hotel = hotelField.getText();
		if (workID.equals("") || password.equals("") || hotel.equals("")) {
			feedbackLabel.setText("信息填写不完整！");
		} else {
			hotelworkerInfo = new HotelWorkerVO(workID, password, hotel);
			userbl.hotelWorkerSave(hotelworkerInfo);
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
	 * @param managerName
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	/**
	 * 登录之后调整界面大小，和之后更大的工作区域匹配
	 */
	public void modifyStageSize() {
		primaryStage.setWidth(1000);
		primaryStage.setHeight(800);
		primaryStage.setX(400);
	}

	public void setHotelworkerName(String hotelworkerName) {
		this.hotelworkerName = hotelworkerName;
		workIDField.setText(hotelworkerName);
	}
}
