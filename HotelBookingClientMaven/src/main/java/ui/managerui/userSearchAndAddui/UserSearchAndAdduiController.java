package ui.managerui.userSearchAndAddui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.Factory.ManagerFactory;

public class UserSearchAndAdduiController {

	@FXML
	private Button addButton;
	@FXML
	private Button searchButton;
	@FXML
	private TextField usertypeField;
	@FXML
	private TextField usernameField;
	@FXML
	private Label feedbackLabel;
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	// 用户信息界面
	private Pane userInfoPane;

	private Stage primaryStage;

	private String managerName;

	private String usertype;

	private String username;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public UserSearchAndAdduiController() {
		userbl = new UserController();
	}

	/**
	 * 添加用户（酒店工作人员和网站营销人员）
	 */
	@FXML
	private void addUser() {
		usertype = usertypeField.getText();
		username = usernameField.getText();
		if (usertype.equals("") || username.equals("")) {
			feedbackLabel.setText("添加信息不全，无法继续，请补全用户类型或用户名称！");
		} else if (usertype.equals("客户")) {
			feedbackLabel.setText("没有添加和客户的权限！");
		} else if (userbl.isExist(username, usertype)) {
			System.out.println("yyyyyyyes!");
			feedbackLabel.setText("该用户已经存在！");
		} else {
			System.out.println("username:"+username);
			userInfoPane = ManagerFactory.createUserAddPane(primaryStage, usertype, managerName, username);
			mainPane.getChildren().remove(0);
			mainPane.getChildren().add(userInfoPane);
		}
	}

	/**
	 * 搜索用户（客户、酒店工作人员和网站营销人员）
	 */
	@FXML
	private void searchUser() {
		usertype = usertypeField.getText();
		username = usernameField.getText();
		if (usertype.equals("") || username.equals("")) {
			feedbackLabel.setText("搜索信息不全，无法搜索，请补全用户类型或用户名称！");
		} else {
			System.out.println("username1:"+username);
			userInfoPane = ManagerFactory.createUserInfoPane(primaryStage, usertype, managerName, username);
			mainPane.getChildren().remove(0);
			mainPane.getChildren().add(userInfoPane);
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
		primaryStage.setWidth(980);
		primaryStage.setHeight(832);
		primaryStage.setX(400);
	}
}
