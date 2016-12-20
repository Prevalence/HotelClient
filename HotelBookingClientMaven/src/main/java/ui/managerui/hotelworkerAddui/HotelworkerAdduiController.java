package ui.managerui.hotelworkerAddui;

import java.util.ArrayList;

import businessLogic.hotelbl.HotelController;
import businessLogic.userbl.UserController;
import businessLogicService.hotelblService.HotelblService;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.managerui.userSearchAndAddui.UserSearchAndAddui;
import vo.HotelWorkerVO;
import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;

public class HotelworkerAdduiController {
	@FXML
	private Button returnButton;
	@FXML
	private Button saveButton;
	@FXML
	private TextField workIDField;
	@FXML
	private TextField hotelField;
	@FXML
	private TextField passwordField;
	@FXML
	private Label feedbackLabel;
	@FXML
	private Pane mainPane;

	private UserblService userbl;
	
	private HotelblService hotelbl;

	// 网站管理人员首界面
	private Pane userSearchAndAddPane;

	private Stage primaryStage;

	private HotelWorkerVO hotelworkerInfo;

	private String managerName;

	@SuppressWarnings("unused")
	private String hotelworkerName;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public HotelworkerAdduiController() {
		userbl = new UserController();
		hotelbl = new HotelController();
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
	 * 添加酒店工作人员
	 */
	@FXML
	private void addHotelworker() {
		String workID = workIDField.getText();
		String password = passwordField.getText();
		String hotel = hotelField.getText();
		if (workID.equals("") || password.equals("") || hotel.equals("")) {
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("信息填写不完整！");
		} else {
			hotelworkerInfo = new HotelWorkerVO(workID, password, hotel);
			if (userbl.hotelWorkerAdd(hotelworkerInfo)) {
				ArrayList<Boolean> booked = new ArrayList<Boolean>();
				ArrayList<RoomVO> room = new ArrayList<RoomVO>();
				 ArrayList<CommentVO> comment= new ArrayList<CommentVO>();
				for(int i=0;i<4;i++){
					booked.add(true);
				}
				hotelbl.addHotel(new HotelVO(0, hotel, 1, "未填写", booked, "未填写",
						"未填写", 5.0,room,comment, workID, "未填写"));
				feedbackLabel.setTextFill(Color.web("#058cff"));
				feedbackLabel.setText("添加成功！");
			}
			else{
				feedbackLabel.setTextFill(Color.web("#f80202"));
				feedbackLabel.setText("无法重复添加！");
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

	/**
	 * 设置并显示酒店工作人员名称
	 * @param marketName
	 */
	public void setHotelworkerName(String hotelworkerName) {
		this.hotelworkerName = hotelworkerName;
		workIDField.setText(hotelworkerName);
	}
}
