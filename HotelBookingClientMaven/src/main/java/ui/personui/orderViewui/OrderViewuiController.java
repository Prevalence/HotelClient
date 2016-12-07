package ui.personui.orderViewui;

import java.util.ArrayList;

import businessLogic.userbl.UserController;
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
import ui.helper.SearchButtonCell;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hoteluiVO.HotelSearchMock;
import vo.hotelVO.hoteluiVO.HotelSearchVO;
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

	private UserblService userbl;

	// 填充进TableView的酒店数据
	private ObservableList<OrderViewVO> orderData;
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
		buttonCol
				.setCellFactory(new Callback<TableColumn<OrderViewVO, Boolean>, TableCell<OrderViewVO, Boolean>>() {

					@Override
					public TableCell<OrderViewVO, Boolean> call(TableColumn<OrderViewVO, Boolean> p) {
						OrderButtonCell buttonCell = new OrderButtonCell(orderTable, mainPane, primaryStage,personname);
						return buttonCell;
					}
				});
		ArrayList<OrderViewVO> orderDataList = new ArrayList<OrderViewVO>();
		orderDataList.add(new OrderViewVO("njuHotel", "2008", "20:00", "未执行"));
		orderData = FXCollections.observableArrayList(orderDataList);
		orderTable.setItems(orderData);
	}
}
