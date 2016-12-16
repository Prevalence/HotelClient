package ui.personui.personInfoui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.orderViewui.OrderViewui;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.personVO.PersonVO;

public class PersonInfouiController {

	@FXML
	private Button editButton;
	@FXML
	private Button reverseButton;
	@FXML
	private TextField yearField;
	@FXML
	private TextField monthField;
	@FXML
	private TextField dayField;
	@FXML
	private TextField companyField;
	@FXML
	private TextField connectionField;
	@FXML
	private TextField nameField;
	@FXML
	private Label memberTypeLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label levelLabel;
	@FXML
	private Label creditLabel;
	@FXML
	private Label feedbackLabel;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn IDCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn timeCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn actionCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn changeCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn resultCol;
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	// 酒店详情查看界面
	private Pane hotelSearchPane;

	// 个人订单界面
	private Pane personOrderPane;

	private Stage primaryStage;

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
	 * 跳转到个人订单查看界面
	 */
	@FXML
	private void viewPersonOrder() {
		personOrderPane = new OrderViewui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(personOrderPane);
	}

	/**
	 * 跳转到酒店搜索界面
	 */
	@FXML
	private void viewHotelSearch() {
		hotelSearchPane = new HotelSearchui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelSearchPane);
	}

	/**
	 * 跳转到酒店搜索界面
	 */
	@FXML
	private void savePersonInfo() {
		String year = yearField.getText();
		String month = monthField.getText();
		String day = dayField.getText();
		String time = year + "-" + month + "-" + day;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (!userbl.isExist(nameField.getText(), "person") || nameField.getText().equals(personname)) {
			try {
				Date date = df.parse(time);
				Calendar birthday = new GregorianCalendar();
				birthday.setTime(date);
				PersonVO newPersonInfo = new PersonVO(nameField.getText(), personInfo.getPassword(),
						personInfo.getPersonID(), personInfo.getCredit(), birthday, personInfo.getVipType(),
						personInfo.getVipLevel(), companyField.getText(), connectionField.getText());
				userbl.personSave(newPersonInfo);
				personname = nameField.getText();
				nameLabel.setText(personname);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				feedbackLabel.setText("日起输入格式不正确，请按照“yyyy-MM-dd”的格式输入!");
				e.printStackTrace();
			}
		}

	}

	/**
	 * 将个人信息界面设置为可修改
	 */
	@FXML
	private void setEditable() {
		yearField.setEditable(true);
		monthField.setEditable(true);
		dayField.setEditable(true);
		companyField.setEditable(true);
		connectionField.setEditable(true);
		nameField.setEditable(true);
	}
	
	/**
	 * 撤销修改
	 */
	@FXML
	private void reverse() {
		yearField.setText(new SimpleDateFormat("yyyy-MM-dd").format(personInfo.getBirthday()).substring(0, 4));
		monthField.setText(new SimpleDateFormat("yyyy-MM-dd").format(personInfo.getBirthday()).substring(5, 7));
		dayField.setText(new SimpleDateFormat("yyyy-MM-dd").format(personInfo.getBirthday()).substring(8, 10));
		nameField.setText(personname);
		companyField.setText(personInfo.getEnterpriseName());
		connectionField.setText(personInfo.getPhoneNumber());
	}
	
	/**
	 * 将个人信息界面设置为可修改
	 */
	@FXML
	private void memberRegister() {
		String year = yearField.getText();
		String month = monthField.getText();
		String day = dayField.getText();
		String time = year + "-" + month + "-" + day;
		String vipInfo = year+month+day;
		int i= Integer.parseInt("01");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (!userbl.isExist(nameField.getText(), "person") || nameField.getText().equals(personname)) {
			try {
				Date date = df.parse(time);
				Calendar birthday = new GregorianCalendar();
				birthday.setTime(date);
				PersonVO newPersonInfo = new PersonVO(nameField.getText(), personInfo.getPassword(),
						personInfo.getPersonID(), personInfo.getCredit(), birthday, personInfo.getVipType(),
						personInfo.getVipLevel(), companyField.getText(), connectionField.getText());
				userbl.registeMember(personInfo, "", vipInfo);
				personname = nameField.getText();
				nameLabel.setText(personname);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				feedbackLabel.setText("日起输入格式不正确，请按照“yyyy-MM-dd”的格式输入!");
				e.printStackTrace();
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
	 * @param personname
	 */
	public void setPersonname(String personname) {
		this.personname = personname;
		nameLabel.setText(personname);
	}

	/**
	 * 初始加载个人信息
	 */
	public void initPersonInfo() {
		personInfo = userbl.getPersonInfo(personname);
		yearField.setText(new SimpleDateFormat("yyyy-MM-dd").format(personInfo.getBirthday()).substring(0, 4));
		yearField.setEditable(false);
		monthField.setText(new SimpleDateFormat("yyyy-MM-dd").format(personInfo.getBirthday()).substring(5, 7));
		monthField.setEditable(false);
		dayField.setText(new SimpleDateFormat("yyyy-MM-dd").format(personInfo.getBirthday()).substring(8, 10));
		dayField.setEditable(false);
		nameField.setText(personname);
		nameField.setEditable(false);
		companyField.setText(personInfo.getEnterpriseName());
		companyField.setEditable(false);
		connectionField.setText(personInfo.getPhoneNumber());
		connectionField.setEditable(false);
		memberTypeLabel.setText(personInfo.getVipType());
		levelLabel.setText(String.valueOf(personInfo.getVipLevel()));
		creditLabel.setText(String.valueOf(personInfo.getCredit()));
	}
	
	/**
	 * 初始设置TableView的属性，绑定内部按钮
	 */
	@SuppressWarnings("unchecked")
	public void initTableView() {
		IDCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
		actionCol.setCellValueFactory(new PropertyValueFactory<>("operation"));
		changeCol.setCellValueFactory(new PropertyValueFactory<>("changeCredit"));
		resultCol.setCellValueFactory(new PropertyValueFactory<>("resultCredit"));
//		personInfo.get
	}
	
	
}
