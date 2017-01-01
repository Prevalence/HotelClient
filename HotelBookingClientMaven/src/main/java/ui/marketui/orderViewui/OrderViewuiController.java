package ui.marketui.orderViewui;

import java.util.ArrayList;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import ui.helper.OrderButtonCell;
import ui.marketui.creditPayui.CreditPayui;
import ui.marketui.promotionui.MarketPromotionui;
import vo.orderVO.orderblVO.OrderVO;
import vo.orderVO.orderuiVO.HotelOrderVO;

public class OrderViewuiController {

	@FXML
	private Button marketOrderButton;
	@FXML
	private Button promotionButton;
	@FXML
	private Button creditRechargeButton;
	@FXML
	private Button searchButton;
	@FXML
	private TextField orderIDField;
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

	// 网站订单浏览界面
	private Pane marketOrderPane;

	// 促销策略界面
	private Pane promotionPane;

	// 信用充值界面
	private Pane creditPayPane;

	// 填充进TableView的酒店数据
	private ObservableList<HotelOrderVO> orderData;

	private ArrayList<HotelOrderVO> orderViewList;

	// 订单数据表
	private ArrayList<OrderVO> orders;

	private Stage primaryStage;

	private String marketName;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public OrderViewuiController() {
		userbl = new UserController();
		orderbl = new OrderController();
	}

	/**
	 * 跳转到网站订单浏览界面
	 */
	@FXML
	private void viewMarketOrder() {
		marketOrderPane = new MarketOrderViewui(primaryStage, marketName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(marketOrderPane);
	}

	/**
	 * 跳转到促销策略界面
	 */
	@FXML
	private void viewPromotion() {
		promotionPane = new MarketPromotionui(primaryStage, marketName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(promotionPane);
	}

	/**
	 * 跳转到信用充值界面
	 */
	@FXML
	private void rechargeCredit() {
		// hotelInfo = hotelbl.showHotelInfo(marketName);
		creditPayPane = new CreditPayui(primaryStage, marketName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(creditPayPane);
	}

	/**
	 * 根据订单号查看订单详情,且必须是异常订单
	 */
	@FXML
	private void searchWithOrderNumber() {
		orderbl.getOrderInfo(orderIDField.getText());
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
	 * @param marketName
	 */
	public void setMarketName(String marketName) {
		this.marketName = marketName;
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
				OrderButtonCell buttonCell = new OrderButtonCell(orderTable, mainPane, primaryStage, marketName,
						"market", orders);
				return buttonCell;
			}
		});
		orders = orderbl.netOrders();
		orderViewList = getOrderViewList(orders);
		orderData = FXCollections.observableArrayList(orderViewList);
		// System.out.println("order:"+orders.get(0).getOrderID());
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
