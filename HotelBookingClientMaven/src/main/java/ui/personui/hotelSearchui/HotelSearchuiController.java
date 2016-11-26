package ui.personui.hotelSearchui;

import businessLogic.userbl.UserController;
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
import javafx.stage.Stage;
import ui.personui.personInfoui.PersonInfoViewui;

public class HotelSearchuiController {

	@FXML
	private Button loginButton;
	@FXML
	private Button signupButton;
	@FXML
	private ChoiceBox<String> otherChoices;
	@FXML
	private Button forgetButton;
	@FXML
	private TextField userNameField;
	@FXML
	private TextField passwordField;
	@FXML
	private Label feedBackLabel;
	@FXML
	private Label otherLabel;
	@FXML
	private Pane mainPane;
	
	private UserblService userbl;

	// 酒店详情查看界面
	private Pane hotelInfoViewPane;

	// 个人信息界面
	private Pane personInfoViewPane;

	private Stage primaryStage;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public HotelSearchuiController() {
		userbl = new UserController();

	}

	/**
	 * 登录操作，根据逻辑层登录方法返回的布尔值显示错误提示或者跳转到下个界面
	 * 
	 * @return boolean
	 */

	@FXML
	private void ViewPersonInfo() {
		String username = userNameField.getText();
		String password = passwordField.getText();
		System.out.println("ok!");
		// if (userbl.userLogin(username, password, usertype)) {
		 personInfoViewPane = new PersonInfoViewui(primaryStage,username);
		 mainPane.getChildren().remove(0);
		 mainPane.getChildren().add(personInfoViewPane);
		// } else {
		// feedBackField.setText("用户名或密码不正确！");
		// }
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
	 * 设置其他方式登录的组件
	 * 
	 * @param others
	 */
	
}