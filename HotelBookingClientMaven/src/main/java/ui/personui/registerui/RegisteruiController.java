package ui.personui.registerui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.loginui.Loginui;
import ui.personui.personInfoui.PersonInfoui;
import vo.personVO.PersonVO;

public class RegisteruiController {

	@FXML
	private Button loginButton;
	@FXML
	private Button signupButton;
	@FXML
	private ChoiceBox<String> otherChoices;
	@FXML
	private TextField userNameField;
	@FXML
	private TextField passwordField;
	@FXML
	private Label feedbackLabel;
	@FXML
	private Pane loginPane;
	@FXML
	private Pane mainPane;

	private UserblService userbl;

	// 登录界面
	private Pane loginuiPane;

	// 个人信息界面
	private Pane personInfoPane;

	private Stage primaryStage;

	private String personname;

	private PersonVO personInfo;

	private String password;

	public RegisteruiController() {
		userbl = new UserController();
	}

	/**
	 * 返回到登录界面
	 */
	@FXML
	private void backToLoginui() {
		loginuiPane = new Loginui(primaryStage);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(loginuiPane);
	}

	/**
	 * 注册成功，跳转到注册成功提示界面
	 */
	@FXML
	private void succeedToRegister() {
		personInfoPane = new PersonInfoui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(personInfoPane);
	}

	/**
	 * 注册操作，如果注册成功就跳转到个人信息界面，如果失败则反馈注册失败信息
	 * 
	 * @return boolean
	 */

	@FXML
	private void signup() {
		personname = userNameField.getText();
		password = passwordField.getText();
		if (!userbl.isExist(personname, "person")) {
			personInfo = new PersonVO(personname, password, -1, 1000, "2016-01-01 00:00:00", "普通客户", 0, "", "");
			userbl.register(personInfo);
			personInfoPane = new PersonInfoui(primaryStage,personname);
			mainPane.getChildren().remove(0);
			mainPane.getChildren().add(personInfoPane);
		}
		else{
			feedbackLabel.setText("该用户名已被使用");
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
}
