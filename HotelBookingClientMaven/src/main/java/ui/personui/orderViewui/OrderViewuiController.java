package ui.personui.orderViewui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import ui.helper.ButtonCell;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hoteluiVO.HotelSearchVO;

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
	private void viewOrderInfo(){
		
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
	public void initOrderTable(){
		hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		starCol.setCellValueFactory(new PropertyValueFactory<>("star"));
		areaCol.setCellValueFactory(new PropertyValueFactory<>("area"));
		locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
		buttonCol
				.setCellFactory(new Callback<TableColumn<HotelSearchVO, Boolean>, TableCell<HotelSearchVO, Boolean>>() {

					@Override
					public TableCell<HotelSearchVO, Boolean> call(TableColumn<HotelSearchVO, Boolean> p) {
						ButtonCell buttonCell = new ButtonCell(searchTable, mainPane, primaryStage, personname,
								personname);
						return buttonCell;
					}

				});
	}
}
