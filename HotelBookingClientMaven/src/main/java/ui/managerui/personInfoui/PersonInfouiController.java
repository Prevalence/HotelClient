package ui.managerui.personInfoui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.managerui.userSearchAndAddui.UserSearchAndAddui;

public class PersonInfouiController {
	@FXML
	private Button returnButton;
	@FXML
	private Button saveButton;
	@FXML
	private TextField personnameField;
	@FXML
	private TextField VIPTypeField;
	@FXML
	private TextField VIPLevelField;
	@FXML
	private TextField connectionField;
	@FXML
	private TextField creditField;
	@FXML
	private Pane mainPane;

	private UserblService userbl;

	// 网站管理人员首界面
	private Pane userSearchAndAddPane;

	private Stage primaryStage;

	private String managerName;
	
	private String personname;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public PersonInfouiController() {
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
	
	public void setPersonname(String personname){
		this.personname=personname;
		personnameField.setText(personname);
	}
}
