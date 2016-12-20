package ui.personui.hotelCommentui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HotelCommentuiController {
	// TODO

	@FXML
	private Label nameLabel;
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	// 酒店详情查看界面
	@SuppressWarnings("unused")
	private Pane hotelInfoViewPane;

	// 个人信息界面
	@SuppressWarnings("unused")
	private Pane personInfoViewPane;

	@SuppressWarnings("unused")
	private Stage primaryStage;

	@SuppressWarnings("unused")
	private String personname;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public HotelCommentuiController() {
		userbl = new UserController();
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
}
