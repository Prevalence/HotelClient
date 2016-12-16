package ui.personui.orderViewui;

import java.util.ArrayList;
import java.util.Calendar;

import businessLogic.orderbl.OrderController;
import businessLogic.userbl.UserController;
import businessLogicService.orderblService.OrderblService;
import businessLogicService.userblService.UserblService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import ui.helper.OrderButtonCell;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.RoomInfoVO;
import vo.orderVO.orderblVO.OrderVO;
import vo.orderVO.orderuiVO.OrderViewVO;

public class OrderViewuiController {

	@FXML
	private Button hotelSearchButton;
	@FXML
	private Button personInfoButton;
	@FXML
	private Button personOrderButton;
	@FXML
	private Button reverseButton;
	@FXML
	private Button commentSearchButton;
	@FXML
	private Pane mainPane;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView orderTable;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn hotelNameCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn expectedTimeCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn stateCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn orderNumberCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn buttonCol;

	@SuppressWarnings("unused")
	private UserblService userbl;

	private OrderblService orderbl;

	// 填充进TableView的酒店数据
	private ObservableList<OrderViewVO> orderData;

	private ArrayList<OrderViewVO> orderViewList;

	// 订单数据表
	private ArrayList<OrderVO> orders;

	// 酒店搜索界面
	private Pane hotelSearchPane;

	// 个人信息界面
	private Pane personInfoPane;

	private Stage primaryStage;

	private String personname;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public OrderViewuiController() {
		userbl = new UserController();
		orderbl = new OrderController();
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
	 * 跳转个人信息界面
	 */
	@FXML
	private void viewPersonInfo() {
		personInfoPane = new PersonInfoui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(personInfoPane);
	}

	/**
	 * 查看订单详细内容
	 */
	@FXML
	private void viewOrderInfo() {

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
	 * 初始化订单列表
	 */
	@SuppressWarnings("unchecked")
	public void initOrderTable() {
		hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		orderNumberCol.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));
		expectedTimeCol.setCellValueFactory(new PropertyValueFactory<>("expectedTime"));
		stateCol.setCellValueFactory(new PropertyValueFactory<>("state"));
		buttonCol.setCellFactory(new Callback<TableColumn<OrderViewVO, Boolean>, TableCell<OrderViewVO, Boolean>>() {

			@Override
			public TableCell<OrderViewVO, Boolean> call(TableColumn<OrderViewVO, Boolean> p) {
				OrderButtonCell buttonCell = new OrderButtonCell(orderTable, mainPane, primaryStage, personname);
				return buttonCell;
			}
		});
		orders = orderbl.personOrders(personname);
		orderViewList = getOrderViewList(orders);
		orderData = FXCollections.observableArrayList(orderViewList);
		orderTable.setItems(orderData);
	}

	/**
	 * 从orderVO列表中获取用于界面显示的orderViewVO列表
	 * 
	 * @return orderList
	 */
	private ArrayList<OrderViewVO> getOrderViewList(ArrayList<OrderVO> orders) {
		ArrayList<OrderViewVO> orderList = new ArrayList<OrderViewVO>();
		String orderNumber = "";
		String orderState = "";
		String expectedTime = null;
		String hotelName = "";
		OrderViewVO order = null;
		for (int i = 0; i < orders.size(); i++) {
			orderNumber = orders.get(i).getOrderID();
			expectedTime = orders.get(i).getLatestExecutetime();
			hotelName = orders.get(i).getHotelname();
			orderState = orders.get(i).getOrderstate();
			order = new OrderViewVO(hotelName,orderNumber,expectedTime,orderState);
			orderList.add(order);
		}
		return orderList;
	}
}
