package ui.managerui.personInfoui;

import java.rmi.RemoteException;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.managerui.userSearchAndAddui.UserSearchAndAddui;
import vo.MarketVO;
import vo.personVO.PersonVO;

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
	private Label feedbackLabel;
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	// 网站管理人员首界面
	private Pane userSearchAndAddPane;

	private Stage primaryStage;

	private String managerName;
	
	@SuppressWarnings("unused")
	private String personname;
	
	private PersonVO personInfo;

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
		String personname = personnameField.getText();
		String vipType = VIPTypeField.getText();
		String vipLevel = VIPLevelField.getText();
		String connection = connectionField.getText();
		String credit = creditField.getText();
		if (personname.equals("") || vipType.equals("")||vipLevel.equals("") || connection.equals("")||credit.equals("")) {
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("信息填写不完整！");
		} else {
			personInfo.setUsername(personname);
			personInfo.setVipType(vipType);
			personInfo.setVipLevel(Integer.parseInt(vipLevel));;
			personInfo.setPhoneNumber(connection);
			personInfo.setCredit(Integer.parseInt(credit));
			if (userbl.personSave(personInfo)) {
				feedbackLabel.setTextFill(Color.web("#058cff"));
				feedbackLabel.setText("修改成功！");
			}
			else{
				feedbackLabel.setTextFill(Color.web("#f80202"));
				feedbackLabel.setText("修改的名称已被使用！");
			}
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
	
	public void setPersonAndShowInfo(String personname){
		this.personname=personname;
		personInfo=userbl.getPersonInfo(personname);
		personnameField.setText(personname);
		VIPTypeField.setText(personInfo.getVipType());
		VIPLevelField.setText(String.valueOf(personInfo.getVipLevel()));
		connectionField.setText(personInfo.getPhoneNumber());
		creditField.setText(String.valueOf(personInfo.getCredit()));
	}
}
