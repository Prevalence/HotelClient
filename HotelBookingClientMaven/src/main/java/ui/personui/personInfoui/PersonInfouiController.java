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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.orderViewui.OrderViewui;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.HotelSearchVO;
import vo.personVO.PersonVO;
import vo.personVO.RecordVO;

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
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView orderTable;
	@FXML
	private Pane mainPane;

	private UserblService userbl;

	// 酒店详情查看界面
	private Pane hotelSearchPane;

	// 个人订单界面
	private Pane personOrderPane;

	private Stage primaryStage;

	private String personname;

	private PersonVO personInfo;

	private ArrayList<RecordVO> records;

	// 填充进TableView的酒店数据
	private ObservableList<RecordVO> recordData;

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
	 * 保存修改后的个人信息
	 */
	@FXML
	private void savePersonInfo() {
		String year = yearField.getText();
		String month = monthField.getText();
		String day = dayField.getText();
		String time = year + "-" + month + "-" + day + " 00:00:00";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date;
		try {
			date = df.parse(time);
			Calendar birthday = new GregorianCalendar();
			birthday.setTime(date);
			PersonVO newPersonInfo = new PersonVO(nameField.getText(), personInfo.getPassword(),
					personInfo.getPersonID(), personInfo.getCredit(), time, personInfo.getVipType(),
					personInfo.getVipLevel(), companyField.getText(), connectionField.getText());
			if (userbl.personSave(newPersonInfo)) {
				feedbackLabel.setTextFill(Color.web("#058cff"));
				feedbackLabel.setText("修改成功!");
			} else {
				feedbackLabel.setTextFill(Color.web("#ff0000"));
				feedbackLabel.setText("系统出错!");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			feedbackLabel.setText("日起输入格式不正确，请按照“yyyy-MM-dd”的格式输入!");
			e.printStackTrace();
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
	}

	/**
	 * 撤销修改
	 */
	@FXML
	private void reverse() {
		yearField.setText(personInfo.getBirthday().substring(0, 4));
		monthField.setText(personInfo.getBirthday().substring(5, 7));
		dayField.setText(personInfo.getBirthday().substring(8, 10));
		nameField.setText(personname);
		companyField.setText(personInfo.getEnterpriseName());
		connectionField.setText(personInfo.getPhoneNumber());
	}

	/**
	 * 会员登记
	 */
	@FXML
	private void memberRegister() {
		String year = yearField.getText();
		String month = monthField.getText();
		String day = dayField.getText();
		String time = year + "-" + month + "-" + day + " 00:00:00";
		String vipInfo = year + "-" +month + "-" + day;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			try {
				Date date = df.parse(time);
				Calendar birthday = new GregorianCalendar();
				birthday.setTime(date);
				PersonVO newPersonInfo = new PersonVO(nameField.getText(), personInfo.getPassword(),
						personInfo.getPersonID(), personInfo.getCredit(), time, personInfo.getVipType(),
						personInfo.getVipLevel(), companyField.getText(), connectionField.getText());
				if (userbl.registeMember(newPersonInfo, "普通会员", vipInfo)) {
					feedbackLabel.setTextFill(Color.web("#058cff"));
					feedbackLabel.setText("成功登记为普通会员。");
					personname = nameField.getText();
					nameLabel.setText(personname);
					memberTypeLabel.setText("普通会员");
					levelLabel.setText("userbl.getPersonInfo(personname).getVipLevel()");;
				} else {
					feedbackLabel.setTextFill(Color.web("#ff0000"));
					feedbackLabel.setText("信用值不够，无法成为会员。");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				feedbackLabel.setTextFill(Color.web("#ff0000"));
				feedbackLabel.setText("日起输入格式不正确，请按照“yyyy-MM-dd”的格式输入!");
				e.printStackTrace();
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
	 * 登录之后调整界面大小，和之后更大的工作区域匹配
	 */
	public void modifyStageSize() {
		primaryStage.setWidth(980);
		primaryStage.setHeight(832);
		primaryStage.setX(400);
	}

	/**
	 * 初始加载个人信息
	 */
	public void initPersonInfo() {
		personInfo = userbl.getPersonInfo(personname);
		yearField.setText(personInfo.getBirthday().substring(0, 4));
		yearField.setEditable(false);
		monthField.setText(personInfo.getBirthday().substring(5, 7));
		monthField.setEditable(false);
		dayField.setText(personInfo.getBirthday().substring(8, 10));
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
		IDCol.setCellValueFactory(new PropertyValueFactory<>("orderId"));
		timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
		actionCol.setCellValueFactory(new PropertyValueFactory<>("operation"));
		changeCol.setCellValueFactory(new PropertyValueFactory<>("changeCredit"));
		resultCol.setCellValueFactory(new PropertyValueFactory<>("resultCredit"));
		records = userbl.getRecord(personname);
		if (records != null) {
			recordData = FXCollections.observableArrayList(records);
			orderTable.setItems(recordData);
		} else {
			feedbackLabel.setText("目前还没有信用记录，欢迎使用我们的系统预订酒店。");
		}
	}

}
