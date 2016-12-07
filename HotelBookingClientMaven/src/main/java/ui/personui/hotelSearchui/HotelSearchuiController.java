package ui.personui.hotelSearchui;

import java.util.ArrayList;

import businessLogic.hotelbl.HotelController;
import businessLogicService.hotelblService.HotelblService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import ui.helper.ButtonCell;
import ui.personui.hotelInfoViewui.HotelInfoViewui;
import ui.personui.orderViewui.OrderViewui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hotelblVO.HotelConditionVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.HotelSearchMock;
import vo.hotelVO.hoteluiVO.HotelSearchVO;

public class HotelSearchuiController {

	@FXML
	private Button hotelSearchButton;
	@FXML
	private Button personInfoButton;
	@FXML
	private Button orderInfoButton;
	@FXML
	private Button starButton;
	@FXML
	private Button facilityButton;
	@FXML
	private Button haveBookedButton;
	@FXML
	private Button searchButton;
	@FXML
	private TextField searchField;
	@FXML
	private Label priceLabel;
	@FXML
	private ChoiceBox<String> priceChoices;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView searchTable;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn hotelNameCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn starCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn areaCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn locationCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn buttonCol;

	@FXML
	private Pane mainPane;

	private HotelblService hotelbl;

	// 填充进TableView的酒店数据
	private ObservableList<HotelSearchVO> searchData;

	// 筛选上限条件的数据包
	private HotelConditionVO hotelWorstConditionVO;

	// 筛选下限条件的数据包
	private HotelConditionVO hotelBestConditionVO;

	// 酒店详情查看界面
	private Pane hotelInfoViewPane;

	// 个人信息界面
	private Pane personInfoViewPane;

	// 个人订单界面
	private Pane personOrderViewPane;

	private Stage primaryStage;

	private String personname;

	private int[] lowerPrice = { 0, 300, 600, 900, 1200 };

	private int priceLower;

	private int[] higherPrice = { 300, 600, 900, 1200, -1 };

	private int priceHigher;

	private int[] star = { 1, 2, 3, 4, 5 };

	public HotelSearchuiController() {
		hotelbl = new HotelController();
		hotelWorstConditionVO = new HotelConditionVO(null, null, null, null, 0, 0.0, false, null);
		hotelBestConditionVO = new HotelConditionVO(null, null, null, null, 0, 0.0, false, null);
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
	 * 输入酒店名称搜索后，跳转到酒店详情查看界面
	 */
	@FXML
	private void searchHotelInfo() {
		String hotelName = searchField.getText();
		// hotelInfo = hotelbl.showHotelInfo(hotelName);
		hotelInfoViewPane = new HotelInfoViewui(primaryStage, personname, hotelName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelInfoViewPane);
	}

	/**
	 * 用价格区间筛选，以列表形式显示搜索结果
	 */
	@SuppressWarnings("unchecked")
	@FXML
	private void searchWithPrice() {
		searchTable.refresh();

		ArrayList<HotelSearchVO> searchDataList = new ArrayList<HotelSearchVO>();
		searchDataList.add(new HotelSearchMock("njuHotel", "5", "nanjing", "nju"));
		searchData = FXCollections.observableArrayList(searchDataList);

		searchTable.setItems(searchData);
	}

	/**
	 * 用星级筛选，以列表形式显示搜索结果
	 */
	@SuppressWarnings("unchecked")
	@FXML
	private void searchWithStar() {
		searchTable.refresh();

		ArrayList<HotelSearchVO> searchDataList = new ArrayList<HotelSearchVO>();
		searchDataList.add(new HotelSearchMock("njuHotel", "4", "nanjing", "nju"));
		searchData = FXCollections.observableArrayList(searchDataList);

		searchTable.setItems(searchData);
	}

	/**
	 * 用评分区间筛选，以列表形式显示搜索结果
	 */
	@SuppressWarnings("unchecked")
	@FXML
	private void searchWithScore() {
		searchTable.refresh();

		ArrayList<HotelSearchVO> searchDataList = new ArrayList<HotelSearchVO>();
		searchDataList.add(new HotelSearchMock("njuHotel", "3", "nanjing", "nju"));
		searchData = FXCollections.observableArrayList(searchDataList);

		searchTable.setItems(searchData);
	}

	/**
	 * 用是否预定过筛选，以列表形式显示搜索结果
	 */
	@SuppressWarnings("unchecked")
	@FXML
	private void searchWithHistory() {
		searchTable.refresh();

		ArrayList<HotelSearchVO> searchDataList = new ArrayList<HotelSearchVO>();
		searchDataList.add(new HotelSearchMock("njuHotel", "2", "nanjing", "nju"));
		searchData = FXCollections.observableArrayList(searchDataList);

		searchTable.setItems(searchData);
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
	 * 登录之后调整界面大小，和之后更大的工作区域匹配
	 */
	public void modifyStageSize() {
		primaryStage.setWidth(1000);
		primaryStage.setHeight(800);
		primaryStage.setX(400);
	}

	/**
	 * 设置价格区间选择的组件
	 * 
	 * @param others
	 */
	public void setChoiceBox(ObservableList<String> others) {
		priceChoices.setItems(others);
		priceChoices.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				priceLabel.setText("");
				priceLower = lowerPrice[priceChoices.getSelectionModel().getSelectedIndex()];
				priceHigher = higherPrice[priceChoices.getSelectionModel().getSelectedIndex()];
				ArrayList<RoomVO> roomListLower = new ArrayList<RoomVO>();
				ArrayList<RoomVO> roomListHigher = new ArrayList<RoomVO>();
				RoomVO roomLower = new RoomVO(null, null, priceLower, null, null);
				RoomVO roomHigher = new RoomVO(null, null, priceHigher, null, null);
				roomListLower.add(roomLower);
				roomListHigher.add(roomHigher);
				hotelWorstConditionVO.setRoom(roomListLower);
				hotelBestConditionVO.setRoom(roomListHigher);
				// ArrayList<HotelSearchVO> searchDataList =
				// hotelbl.findWithReq(hotelWorstConditionVO,
				// hotelBestConditionVO);
				// searchData =
				// FXCollections.observableArrayList(searchDataList);
				searchWithPrice();
			}
		});
		// priceChoices.setItems(others);
		// priceChoices.setOnAction(new EventHandler<ActionEvent>() {
		// public void handle(ActionEvent event) {
		// usertype = type[priceChoices.getSelectionModel().getSelectedIndex()];
		// if (usertype.equals("还原")) {
		// usertype = "客户";
		// otherLabel.setText("其他方式登录");
		// } else {
		// otherLabel.setText(usertype);
		// }
		// System.out.println(usertype);
		// }
		// });
	}

	/**
	 * 初始设置TableView的属性，绑定内部按钮
	 */
	@SuppressWarnings("unchecked")
	public void initTableView() {
		hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		starCol.setCellValueFactory(new PropertyValueFactory<>("star"));
		areaCol.setCellValueFactory(new PropertyValueFactory<>("area"));
		locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
		buttonCol
				.setCellFactory(new Callback<TableColumn<HotelSearchVO, Boolean>, TableCell<HotelSearchVO, Boolean>>() {

					@Override
					public TableCell<HotelSearchVO, Boolean> call(TableColumn<HotelSearchVO, Boolean> p) {
						ButtonCell buttonCell = new ButtonCell(searchTable, mainPane, primaryStage, personname);
						return buttonCell;
					}

				});
	}
}