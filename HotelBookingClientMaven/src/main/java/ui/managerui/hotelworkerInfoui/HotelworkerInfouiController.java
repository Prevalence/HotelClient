package ui.managerui.hotelworkerInfoui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.managerui.userSearchAndAddui.UserSearchAndAddui;
import ui.marketui.creditPayui.CreditPayui;
import ui.marketui.orderViewui.MarketOrderViewui;
import ui.marketui.promotionui.Promotionui;

public class HotelworkerInfouiController {
	@FXML
	private Button marketOrderButton;
	@FXML
	private Button promotionButton;
	@FXML
	private Button creditRechargeButton;
	@FXML
	private Button searchButton;
	@FXML
	private Pane mainPane;

	private UserblService userbl;

	// 网站管理人员首界面
	private Pane userSearchAndAddPane;

	private Stage primaryStage;

	private String managerName;

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
}
