package ui.loginui;

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
import ui.hotelworkerui.orderViewui.OrderViewui;
import ui.personui.hotelSearchui.HotelSearchui;

public class LoginuiController {

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

	// 用户类型默认为客户，如果用户用其他方式登录再进行改变。
	private String usertype = "客户";

	// 与选择框对应的身份字符串数组
	private String type[] = { "酒店工作人员", "网站营销人员", "网站管理人员", "还原" };
	
	private UserblService userbl;

	// 客户的第一个界面：酒店搜索界面
	private Pane hotelSearchPane;

	// 酒店工作人员的第一个界面：酒店工作人员订单浏览界面
	private Pane hotelWorkerOrderInfouiPane;

	// 网站营销人员的第一个界面：网站营销人员订单浏览界面
	private Pane marketOrderInfouiPane;

	// 网站管理人员的第一个界面：搜索与添加用户界面
	private Pane managerSearchAndAdduiPane;

	private Stage primaryStage;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public LoginuiController() {
		userbl = new UserController();

	}

	/**
	 * 登录操作，根据逻辑层登录方法返回的布尔值显示错误提示或者跳转到下个界面
	 * 
	 * @return boolean
	 */

	@FXML
	private void Login() {
		String username = userNameField.getText();
		String password = passwordField.getText();
		// if (userbl.userLogin(username, password, usertype)) {
		if(usertype.equals("酒店工作人员")){
			System.out.println("yes!");
			 hotelWorkerOrderInfouiPane=new OrderViewui(primaryStage,username);
			 mainPane.getChildren().remove(0);
			 mainPane.getChildren().add(hotelWorkerOrderInfouiPane);
		}
		else if(usertype.equals("客户")){
		 hotelSearchPane = new HotelSearchui(primaryStage,username);
		 mainPane.getChildren().remove(0);
		 mainPane.getChildren().add(hotelSearchPane);
		}
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
	public void setChoiceBox(ObservableList<String> others) {
		otherChoices.setItems(others);
		otherChoices.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				usertype = type[otherChoices.getSelectionModel().getSelectedIndex()];
				if (usertype.equals("还原")) {
					usertype = "客户";
					otherLabel.setText("其他方式登录");
				} else {
					otherLabel.setText(usertype);
				}
				System.out.println(usertype);
			}
		});
	}
}