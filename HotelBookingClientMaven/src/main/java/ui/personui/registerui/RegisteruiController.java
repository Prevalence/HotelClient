package ui.personui.registerui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.loginui.Loginui;
import ui.personui.hotelInfoViewui.HotelInfoViewui;
import ui.personui.personInfoui.PersonInfoui;

public class RegisteruiController {
	//TODO
	
	@FXML
	private Pane mainPane;

	private UserblService userbl;

	// 酒店详情查看界面
	private Pane loginuiPane;

	// 个人信息界面
	private Pane succeedToRegisterPane;

	private Stage primaryStage;

	public RegisteruiController() {
		userbl = new UserController();
	}

	/**
	 * 返回到登录界面
	 * 
	 * @return boolean
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
		succeedToRegisterPane = new SucceedToRegisterui(primaryStage);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(succeedToRegisterPane);
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
