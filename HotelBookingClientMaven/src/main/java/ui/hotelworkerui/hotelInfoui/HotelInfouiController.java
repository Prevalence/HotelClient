package ui.hotelworkerui.hotelInfoui;

import java.util.ArrayList;

import businessLogic.hotelbl.HotelController;
import businessLogic.userbl.UserController;
import businessLogicService.hotelblService.HotelblService;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.hotelworkerui.orderViewui.HotelOrderViewui;
import ui.hotelworkerui.promotionui.Promotionui;
import ui.hotelworkerui.roomInfoui.RoomInfoui;
import vo.hotelVO.hotelblVO.HotelVO;

public class HotelInfouiController {

	@FXML
	private Button hotelOrderButton;
	@FXML
	private Button promotionButton;
	@FXML
	private Button hotelInfoButton;
	@FXML
	private Button roomInfoButton;
	@FXML
	private Button searchButton;
	@FXML
	private Label nameLabel;
	@FXML
	private Label feedbackLabel;
	@FXML
	private TextField hotelNameField;
	@FXML
	private TextField areaField;
	@FXML
	private TextField featureField;
	@FXML
	private TextField locationField;
	@FXML
	private TextField starField;
	@FXML
	private TextField connectionField;
	@FXML
	private CheckBox wifiCheck;
	@FXML
	private CheckBox TVCheck;
	@FXML
	private CheckBox sofaCheck;
	@FXML
	private CheckBox diningCheck;
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	private HotelblService hotelbl;

	// 酒店订单浏览界面
	private Pane hotelOrderPane;

	// 促销策略界面
	private Pane promotionPane;

	// 酒店信息界面
	private Pane hotelInfoPane;

	// 房间信息界面
	private Pane roomInfoPane;

	private Stage primaryStage;

	private HotelVO hotelInfo;

	private String workerName;

	private String hotelName;

	private ArrayList<Boolean> service;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public HotelInfouiController() {
		userbl = new UserController();
		hotelbl = new HotelController();
	}

	/**
	 * 跳转到酒店订单浏览界面
	 */
	@FXML
	private void viewHotelOrder() {
		hotelOrderPane = new HotelOrderViewui(primaryStage, workerName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelOrderPane);
	}

	/**
	 * 跳转到促销策略界面
	 */
	@FXML
	private void viewPromotion() {
		promotionPane = new Promotionui(primaryStage, workerName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(promotionPane);
	}

	/**
	 * 跳转到酒店信息维护界面
	 */
	@FXML
	private void viewHotelInfo() {
		// hotelInfo = hotelbl.showHotelInfo(workerName);
		hotelInfoPane = new HotelInfoui(primaryStage, workerName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelInfoPane);
	}

	/**
	 * 跳转到房间信息查看界面
	 */
	@FXML
	private void viewRoomInfo() {
		// hotelInfo = hotelbl.showHotelInfo(workerName);
		roomInfoPane = new RoomInfoui(primaryStage, workerName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(roomInfoPane);
	}

	/**
	 * 保存酒店信息
	 */
	@FXML
	private void saveHotelInfo() {
		String hotelName = hotelNameField.getText();
		String area = areaField.getText();
		String feature = featureField.getText();
		String location = locationField.getText();
		String star = starField.getText();
		String connection = connectionField.getText();
		service = new ArrayList<Boolean>();
		service.add(wifiCheck.isSelected());
		service.add(TVCheck.isSelected());
		service.add(sofaCheck.isSelected());
		service.add(diningCheck.isSelected());
		if (hotelName.equals("") || area.equals("") || feature.equals("") || location.equals("") || star.equals("")
				|| connection.equals("")) {
			feedbackLabel.setText("修改后的信息不能为空！");
		}
		else if(!this.hotelName.equals(hotelName)){
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("不能修改酒店名称！");
		}
		else{
			hotelInfo.setCircle(area);
			hotelInfo.setFeature(feature);
			hotelInfo.setAddress(location);
			hotelInfo.setStar(Integer.parseInt(star));
			hotelInfo.setHotelPhone(connection);
			hotelInfo.setService(service);
			if(hotelbl.modifyHotelInfo(hotelInfo)){
				feedbackLabel.setText("修改成功！");
			}
			else{
				feedbackLabel.setText("系统出现错误！");
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
	 * @param workerName
	 */
	public void setWorkerNameAndShowInfo(String workerName) {
		this.workerName = workerName;
		nameLabel.setText(workerName);
		hotelName = userbl.getHotelWorkerInfo(workerName).getHotelName();
		hotelInfo = hotelbl.getHotelInfoByHotelworkerOrManager(hotelName);
		nameLabel.setText(workerName);
		hotelNameField.setText(hotelName);
		areaField.setText(hotelInfo.getCircle());
		featureField.setText(hotelInfo.getFeature());
		locationField.setText(hotelInfo.getAddress());
		starField.setText(String.valueOf(hotelInfo.getStar()));
		connectionField.setText(hotelInfo.getHotelPhone());
		;
		service = hotelInfo.getService();
		if (service.get(0)) {
			wifiCheck.setSelected(true);
		}
		if (service.get(1)) {
			TVCheck.setSelected(true);
		}
		if (service.get(2)) {
			sofaCheck.setSelected(true);
		}
		if (service.get(3)) {
			diningCheck.setSelected(true);
		}
	}
}
