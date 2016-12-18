package ui.hotelworkerui.orderViewui;

import java.util.ArrayList;

import businessLogic.orderbl.OrderController;
import businessLogic.userbl.UserController;
import businessLogicService.orderblService.OrderblService;
import businessLogicService.userblService.UserblService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import ui.helper.OrderButtonCell;
import ui.hotelworkerui.hotelInfoui.HotelInfoui;
import ui.hotelworkerui.promotionui.Promotionui;
import ui.hotelworkerui.roomInfoui.RoomInfoui;
import vo.orderVO.orderblVO.OrderVO;
import vo.orderVO.orderuiVO.HotelOrderVO;

public class OrderViewuiController {

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
	private Pane mainPane;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView orderTable;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn orderIDCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn personCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn stateCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn timeCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn buttonCol;

	@SuppressWarnings("unused")
	private UserblService userbl;
	
	private OrderblService orderbl;

	// 酒店订单浏览界面
	private Pane hotelOrderPane;

	// 促销策略界面
	private Pane promotionPane;

	// 酒店信息界面
	private Pane hotelInfoPane;

	// 房间信息界面
	private Pane roomInfoPane;
	
	// 填充进TableView的酒店数据
	private ObservableList<HotelOrderVO> orderData;

	private ArrayList<HotelOrderVO> orderViewList;

	// 订单数据表
	private ArrayList<OrderVO> orders;

	private Stage primaryStage;

	private String workerName;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public OrderViewuiController() {
		userbl = new UserController();
		orderbl = new OrderController();
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
	 * 点击确定按钮，按照日期筛选订单
	 */
	@FXML
	private void searchWithDate() {
		// hotelInfo = hotelbl.showHotelInfo(workerName);

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
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
		nameLabel.setText(workerName);
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
	 * 设置并显示订单信息
	 * @param order
	 */
	public void setAndShowOrder(OrderVO order){
		
	}
	
	/**
	 * 初始化订单列表
	 */
	@SuppressWarnings("unchecked")
	public void initOrderTable() {
		timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
		personCol.setCellValueFactory(new PropertyValueFactory<>("person"));
		orderIDCol.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));
		stateCol.setCellValueFactory(new PropertyValueFactory<>("state"));
		buttonCol.setCellFactory(new Callback<TableColumn<HotelOrderVO, Boolean>, TableCell<HotelOrderVO, Boolean>>() {
			
			@Override
			public TableCell<HotelOrderVO, Boolean> call(TableColumn<HotelOrderVO, Boolean> p) {
				@SuppressWarnings("rawtypes")
				OrderButtonCell buttonCell = new OrderButtonCell(orderTable, mainPane, primaryStage, workerName,"hotelworker",orders);
				return buttonCell;
			}
		});
		orders = orderbl.hotelOrders(userbl.getHotelWorkerInfo(workerName).getHotelName());
		orderViewList = getOrderViewList(orders);
		orderData = FXCollections.observableArrayList(orderViewList);
//		System.out.println("order:"+orders.get(0).getOrderID());
		orderTable.setItems(orderData);
	}
	
	/**
	 * 从orderVO列表中获取用于界面显示的HotelOrderVO列表
	 * 
	 * @return orderList
	 */
	private ArrayList<HotelOrderVO> getOrderViewList(ArrayList<OrderVO> orders) {
		ArrayList<HotelOrderVO> orderList = new ArrayList<HotelOrderVO>();
		String orderNumber = "";
		String orderState = "";
		String expectedTime = "";
		String person = "";
		HotelOrderVO order = null;
		for (int i = 0; i < orders.size(); i++) {
			orderNumber = orders.get(i).getOrderID();
			expectedTime = orders.get(i).getPredictExecutetime();
			person = orders.get(i).getPersonname();
			orderState = orders.get(i).getOrderstate();
			order = new HotelOrderVO(orderNumber,expectedTime,person,orderState);
			orderList.add(order);
		}
		return orderList;
	}
}
