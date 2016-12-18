package ui.personui.hotelInfoViewui;

import java.util.ArrayList;
import java.util.Calendar;

import businessLogic.hotelbl.HotelController;
import businessLogic.userbl.UserController;
import businessLogicService.hotelblService.HotelblService;
import businessLogicService.userblService.UserblService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.personui.createOrderui.CreateOrderui;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.orderViewui.OrderViewui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.CommentInfoVO;
import vo.hotelVO.hoteluiVO.RoomInfoVO;

public class HotelInfoViewuiController {

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
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView roomInfoTable;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn roomtypeCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn priceCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView commentTable;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn nameCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn timeCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn commentCol;
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
	
	//订单信息填写界面
	private Pane createOrderPane;

	private Stage primaryStage;

	private String personname;

	@SuppressWarnings("unused")
	private String hotelName;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public HotelInfoViewuiController() {
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
	private void createOrder(){
		createOrderPane = new CreateOrderui(primaryStage, personname,hotelName,hotelInfo);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(createOrderPane);
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
	 * 传递酒店名，并将该酒店详情显示在界面上
	 * 
	 * @param hotelName
	 */
	@SuppressWarnings("unchecked")
	public void setHotelNameAndShowInfo(String hotelName) {
		this.hotelName = hotelName;
		hotelInfo = hotelbl.getHotelInfoByHotelworkerOrManager(hotelName);
		if(hotelInfo.getService().get(0)){
			wifiLabel.setText("wifi");
		}
		if(hotelInfo.getService().get(1)){
			wifiLabel.setText("电视");
		}
		if(hotelInfo.getService().get(2)){
			wifiLabel.setText("沙发");
		}
		if(hotelInfo.getService().get(3)){
			wifiLabel.setText("餐厅");
		}
		featureLabel.setText(hotelInfo.getFeature());
		//connectionLabel.setText(hotelInfo.get);
		scoreLabel.setText(String.valueOf(hotelInfo.getScore())+"/5");
		areaLabel.setText(hotelInfo.getCircle());
		locationLabel.setText(hotelInfo.getAddress());
		hotelNameLabel.setText(hotelName);
		connectionLabel.setText(hotelInfo.getHotelPhone());
		
		comment = hotelInfo.getComment();
		room = hotelInfo.getRoom();
		commentList = getCommentList(comment);
		roomInfoList = getRoomInfoList(room);
		roomData = FXCollections.observableArrayList(roomInfoList);
		commentData = FXCollections.observableArrayList(commentList);
		roomInfoTable.setItems(roomData);
		commentTable.setItems(commentData);
	}

	/**
	 * 从commentVO列表中获取comment字符串组成列表，用于界面显示
	 * 
	 * @return commentList
	 */
	private ArrayList<CommentInfoVO> getCommentList(ArrayList<CommentVO> comment) {
		ArrayList<CommentInfoVO> commentList = new ArrayList<CommentInfoVO>();
		String name = "";
		Calendar time = null;
		String content = "";
		for (int i = 0; i < comment.size(); i++) {
			name = comment.get(i).getPersonname();
			time = comment.get(i).getTime();
			content = comment.get(i).getContent();
			commentInfo=new CommentInfoVO(name,time,content);
			commentList.add(commentInfo);
		}
		return commentList;
	}

	/**
	 * 从roomVO列表中获取用于界面显示的roomInfo列表
	 * 
	 * @return roomInfo
	 */
	private ArrayList<RoomInfoVO> getRoomInfoList(ArrayList<RoomVO> room) {
		ArrayList<RoomInfoVO> roomInfoList = new ArrayList<RoomInfoVO>();
		String roomtype="";
		int roomPrice=0;
		for (int i = 0; i < room.size(); i++) {
			roomtype=room.get(i).getRoomType();
			roomPrice=room.get(i).getRoomPrice();
			roomInfo=new RoomInfoVO(roomtype,roomPrice);
			roomInfoList.add(roomInfo);
			System.out.println("roomPrice:"+roomInfo.getRoomPrice());
			System.out.println("roomtype:"+roomInfo.getRoomtype());
		}
		return roomInfoList;
	}
	
	/**
	 * 初始设置TableView的属性，绑定内部按钮
	 */
	@SuppressWarnings("unchecked")
	public void initTableView() {
		roomtypeCol.setCellValueFactory(new PropertyValueFactory<>("roomtype"));
		priceCol.setCellValueFactory(new PropertyValueFactory<>("roomPrice"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("personname"));
		timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
		commentCol.setCellValueFactory(new PropertyValueFactory<>("content"));
	}
}
