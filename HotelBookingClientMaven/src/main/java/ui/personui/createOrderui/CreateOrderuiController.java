package ui.personui.createOrderui;

import java.util.ArrayList;
import java.util.Calendar;

import businessLogic.hotelbl.HotelController;
import businessLogic.userbl.UserController;
import businessLogicService.hotelblService.HotelblService;
import businessLogicService.userblService.UserblService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.orderViewui.OrderViewui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.CommentInfoVO;
import vo.hotelVO.hoteluiVO.RoomInfoVO;

public class CreateOrderuiController {

	@FXML
	private Label wifiLabel;
	@FXML
	private Label TVLabel;
	@FXML
	private Label sofaLabel;
	@FXML
	private Label diningLabel;
	@FXML
	private Label featureLabel;
	@FXML
	private Label connectionLabel;
	@FXML
	private Label locationLabel;
	@FXML
	private Label hotelNameLabel;
	@FXML
	private Label scoreLabel;
	@FXML
	private Label areaLabel;
	@FXML
	private Label numberLabel;
	@FXML
	private Label roomPriceLabel;
	@FXML
	private TextField peopleField;
	@SuppressWarnings("rawtypes")
	@FXML
	private ChoiceBox roomChoices;
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	private HotelblService hotelbl;

	private HotelVO hotelInfo;

	private ArrayList<RoomVO> room;

	// 填充进hotelInfoTable的酒店数据
	private ObservableList<RoomInfoVO> roomData;

	private ArrayList<RoomInfoVO> roomInfoList;

	private RoomInfoVO roomInfo;

	// 填充进commentTable的酒店数据
	private ObservableList<CommentInfoVO> commentData;

	private ArrayList<CommentVO> comment;

	private ArrayList<CommentInfoVO> commentList;

	private CommentInfoVO commentInfo;

	// 酒店搜索界面
	private Pane hotelSearchPane;

	// 个人信息界面
	private Pane personInfoViewPane;

	// 订单查看界面
	private Pane personOrderViewPane;

	private Stage primaryStage;

	private String personname;

	@SuppressWarnings("unused")
	private String hotelName;

	private String roomSelected;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public CreateOrderuiController() {
		userbl = new UserController();
		hotelbl = new HotelController();
	}

	/**
	 * 跳转到个人信息维护界面
	 * 
	 * @return boolean
	 */

	@FXML
	private void viewPersonInfo() {
		personInfoViewPane = new PersonInfoui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(personInfoViewPane);
	}

	/**
	 * 跳转到个人订单查看界面
	 */
	@FXML
	private void viewPersonOrder() {
		personOrderViewPane = new OrderViewui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(personOrderViewPane);
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
	 * 生成订单，跳转到订单信息填写界面
	 */
	@FXML
	private void createOrder() {

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
	}

	/**
	 * 传递酒店信息的VO
	 * 
	 * @param hotelInfo
	 */
	public void setHotelVO(HotelVO hotelInfo) {
		this.hotelInfo = hotelInfo;
		room = hotelInfo.getRoom();
	}

	/**
	 * 传递酒店名，并将该酒店详情显示在界面上
	 * 
	 * @param hotelName
	 */
	@SuppressWarnings("unchecked")
	public void setHotelNameAndShowInfo(String hotelName) {
		this.hotelName = hotelName;
		hotelInfo = hotelbl.showHotelInfo(hotelName);
		if (hotelInfo.getService().get(0)) {
			wifiLabel.setText("wifi");
		}
		if (hotelInfo.getService().get(1)) {
			wifiLabel.setText("电视");
		}
		if (hotelInfo.getService().get(2)) {
			wifiLabel.setText("沙发");
		}
		if (hotelInfo.getService().get(3)) {
			wifiLabel.setText("餐厅");
		}
		featureLabel.setText(hotelInfo.getFeature());
		// connectionLabel.setText(hotelInfo.get);
		scoreLabel.setText(String.valueOf(hotelInfo.getScore()) + "/5");
		areaLabel.setText(hotelInfo.getCircle());
		locationLabel.setText(hotelInfo.getAddress());
		hotelNameLabel.setText(hotelName);

	}

	/**
	 * 设置评分区间选择的组件
	 * 
	 * @param others
	 */
	@SuppressWarnings("unchecked")
	public void setRoomChoiceBox(ObservableList<String> others) {
		roomChoices.setItems(others);
		roomChoices.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//就是房间类型
				roomSelected = roomChoices.getSelectionModel().getSelectedItem().toString();
				roomPriceLabel.setText(room.get(roomChoices.getSelectionModel().getSelectedIndex()).getRoomType());
				numberLabel.setText(room.get(roomChoices.getSelectionModel().getSelectedIndex()).getRoomnum());
				
			}
		});
	}

}
