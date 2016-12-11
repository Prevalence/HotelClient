package ui.personui.registerui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.loginui.Loginui;

public class SucceedToRegisteruiController {
	//TODO
	
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	// 酒店详情查看界面
	private Pane loginuiPane;

	private Stage primaryStage;

	public SucceedToRegisteruiController() {
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
	 * 传递Main的primaryStage
	 * 
	 * @param primaryStage
	 */
	public void launchStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
