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
import ui.helper.SearchButtonCell;
import ui.personui.hotelInfoViewui.HotelInfoViewui;
import ui.personui.orderViewui.OrderViewui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelConditionVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.HotelSearchMock;
import vo.hotelVO.hoteluiVO.HotelSearchVO;
import vo.orderVO.orderblVO.OrderVO;
import vo.orderVO.orderuiVO.OrderViewVO;

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
	private Label starLabel;
	@FXML
	private Label scoreLabel;
	@FXML
	private Label areaLabel;
	@FXML
	private Label bookedLabel;
	@FXML
	private Label sortLabel;
	@FXML
	private Label feedbackLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private ChoiceBox<String> priceChoices;
	@FXML
	private ChoiceBox<String> starChoices;
	@FXML
	private ChoiceBox<String> scoreChoices;
	@FXML
	private ChoiceBox<String> areaChoices;
	@FXML
	private ChoiceBox<String> bookedChoices;
	@FXML
	private ChoiceBox<String> sortChoices;
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
	private TableColumn scoreCol;
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

	String hotelName;

	private int[] lowerPrice = { 0, 300, 600, 900, 1200 };

	private int priceLower = 0;

	private int[] higherPrice = { 300, 600, 900, 1200, -1 };

	private int priceHigher = -1;

	private int[] star = { 1, 2, 3, 4, 5 };

	// 选择的星级筛选条件，表示最低星级
	private int starSelected = 1;

	private double[] score = { 1.0, 2.0, 3.0, 4.0, 5.0 };

	// 选择的评分筛选条件，表示最低评分
	private double scoreSelected = 0.0;

	private String[] areas = { "商圈1", "商圈2" };

	private String area = "";

	private boolean[] booked = { true, false };

	private boolean bookedSelected = false;

	// 订单数据表
	private ArrayList<OrderVO> orders;

	public HotelSearchuiController() {
		hotelbl = new HotelController();
		hotelWorstConditionVO = new HotelConditionVO("", null, 0, 0.0, false, null);
		hotelBestConditionVO = new HotelConditionVO("", null, 5, 5.0, false, null);
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
		if (!hotelName.equals("")) {
			if (hotelbl.getHotelInfoByPerson(hotelName) != null) {
				hotelInfoViewPane = new HotelInfoViewui(primaryStage, personname, hotelName);
				mainPane.getChildren().remove(0);
				mainPane.getChildren().add(hotelInfoViewPane);
			} else {
				feedbackLabel.setText("搜索的酒店不存在，请确保酒店名称正确。");
			}
		}
		else{
			feedbackLabel.setText("未输入酒店名称！");
		}
	}

	/**
	 * 用价格区间筛选，以列表形式显示搜索结果
	 */
	@SuppressWarnings("unchecked")
	@FXML
	private void searchWithPrice() {
		searchTable.refresh();
		searchTable.setItems(searchData);
	}

	/**
	 * 用星级筛选，以列表形式显示搜索结果
	 */
	@SuppressWarnings("unchecked")
	@FXML
	private void searchWithStar() {
		searchTable.refresh();
		searchTable.setItems(searchData);
	}

	/**
	 * 用评分区间筛选，以列表形式显示搜索结果
	 */
	@SuppressWarnings("unchecked")
	@FXML
	private void searchWithScore() {
		searchTable.refresh();
		searchTable.setItems(searchData);
	}

	/**
	 * 用商圈筛选，以列表形式显示搜索结果
	 */
	@SuppressWarnings("unchecked")
	@FXML
	private void searchWithArea() {
		searchTable.refresh();
		searchTable.setItems(searchData);
	}

	/**
	 * 用是否预定过筛选，以列表形式显示搜索结果
	 */
	@SuppressWarnings("unchecked")
	@FXML
	private void searchWithBooked() {
		searchTable.refresh();
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
		nameLabel.setText(personname);
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
	 * 设置价格区间选择的组件
	 * 
	 * @param others
	 */
	public void setPriceChoiceBox(ObservableList<String> others) {
		priceChoices.setItems(others);
		priceChoices.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				priceLabel.setText("");
				hotelName = searchField.getText();
				if (hotelName.equals("")) {
					hotelName = null;
				}
				if (!area.equals("")) {
					priceLower = lowerPrice[priceChoices.getSelectionModel().getSelectedIndex()];
					priceHigher = higherPrice[priceChoices.getSelectionModel().getSelectedIndex()];
					ArrayList<RoomVO> roomListLower = new ArrayList<RoomVO>();
					ArrayList<RoomVO> roomListHigher = new ArrayList<RoomVO>();
					RoomVO roomLower = new RoomVO(null, null, priceLower, null, null);
					RoomVO roomHigher = new RoomVO(null, null, priceHigher, null, null);
					roomListLower.add(roomLower);
					roomListHigher.add(roomHigher);
					hotelWorstConditionVO.setHotelName(hotelName);
					hotelBestConditionVO.setHotelName(hotelName);
					hotelWorstConditionVO.setRoom(roomListLower);
					hotelBestConditionVO.setRoom(roomListHigher);
					hotelWorstConditionVO.setStar(starSelected);
					hotelBestConditionVO.setStar(5);
					hotelWorstConditionVO.setScore(scoreSelected);
					hotelBestConditionVO.setScore(5.0);
					hotelWorstConditionVO.setCircle(area);
					hotelBestConditionVO.setCircle(area);
					hotelWorstConditionVO.setBooked(bookedSelected);
					hotelBestConditionVO.setBooked(bookedSelected);
					ArrayList<HotelSearchVO> searchDataList = hotelbl.findWithReq(hotelWorstConditionVO,
							hotelBestConditionVO);
					searchData = FXCollections.observableArrayList(searchDataList);
					// ArrayList<HotelSearchVO> searchDataList =
					// hotelbl.findWithReq(hotelWorstConditionVO,
					// hotelBestConditionVO);
					// searchData =
					// FXCollections.observableArrayList(searchDataList);
					searchWithPrice();
				} else {
					feedbackLabel.setText("必须先选择商圈才能进行酒店筛选！");
				}
			}
		});
	}

	/**
	 * 设置星级区间选择的组件
	 * 
	 * @param others
	 */
	public void setStarChoiceBox(ObservableList<String> others) {
		starChoices.setItems(others);
		starChoices.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				starLabel.setText("");
				hotelName = searchField.getText();
				if (hotelName.equals("")) {
					hotelName = null;
				}
				if (!area.equals("")) {
					starSelected = star[starChoices.getSelectionModel().getSelectedIndex()];
					ArrayList<RoomVO> roomListLower = new ArrayList<RoomVO>();
					ArrayList<RoomVO> roomListHigher = new ArrayList<RoomVO>();
					RoomVO roomLower = new RoomVO(null, null, 0, null, null);
					RoomVO roomHigher = new RoomVO(null, null, -1, null, null);
					roomListLower.add(roomLower);
					roomListHigher.add(roomHigher);
					hotelWorstConditionVO.setHotelName(hotelName);
					hotelBestConditionVO.setHotelName(hotelName);
					hotelWorstConditionVO.setStar(starSelected);
					hotelBestConditionVO.setStar(5);
					hotelWorstConditionVO.setScore(scoreSelected);
					hotelBestConditionVO.setScore(5.0);
					hotelWorstConditionVO.setCircle(area);
					hotelBestConditionVO.setCircle(area);
					hotelWorstConditionVO.setBooked(bookedSelected);
					hotelBestConditionVO.setBooked(bookedSelected);
					ArrayList<HotelSearchVO> searchDataList = hotelbl.findWithReq(hotelWorstConditionVO,
							hotelBestConditionVO);
					searchData = FXCollections.observableArrayList(searchDataList);
					searchWithStar();
				} else {
					feedbackLabel.setText("必须先选择商圈才能进行酒店筛选！");
				}
			}
		});
	}

	/**
	 * 设置评分区间选择的组件
	 * 
	 * @param others
	 */
	public void setScoreChoiceBox(ObservableList<String> others) {
		scoreChoices.setItems(others);
		scoreChoices.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				scoreLabel.setText("");
				hotelName = searchField.getText();
				if (hotelName.equals("")) {
					hotelName = null;
				}
				if (!area.equals("")) {
					scoreSelected = score[scoreChoices.getSelectionModel().getSelectedIndex()];
					ArrayList<RoomVO> roomListLower = new ArrayList<RoomVO>();
					ArrayList<RoomVO> roomListHigher = new ArrayList<RoomVO>();
					RoomVO roomLower = new RoomVO(null, null, 0, null, null);
					RoomVO roomHigher = new RoomVO(null, null, -1, null, null);
					roomListLower.add(roomLower);
					roomListHigher.add(roomHigher);
					hotelWorstConditionVO.setHotelName(hotelName);
					hotelBestConditionVO.setHotelName(hotelName);
					hotelWorstConditionVO.setRoom(roomListLower);
					hotelBestConditionVO.setRoom(roomListHigher);
					hotelWorstConditionVO.setStar(starSelected);
					hotelBestConditionVO.setStar(5);
					hotelWorstConditionVO.setScore(scoreSelected);
					hotelBestConditionVO.setScore(5.0);
					hotelWorstConditionVO.setCircle(area);
					hotelBestConditionVO.setCircle(area);
					hotelWorstConditionVO.setBooked(bookedSelected);
					hotelBestConditionVO.setBooked(bookedSelected);
					ArrayList<HotelSearchVO> searchDataList = hotelbl.findWithReq(hotelWorstConditionVO,
							hotelBestConditionVO);
					searchData = FXCollections.observableArrayList(searchDataList);
					searchWithScore();
				} else {
					feedbackLabel.setText("必须先选择商圈才能进行酒店筛选！");
				}
			}
		});
	}

	/**
	 * 设置商圈选择的组件
	 * 
	 * @param others
	 */
	public void setAreaChoiceBox(ObservableList<String> others) {
		areaChoices.setItems(others);
		areaChoices.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				areaLabel.setText("");
				hotelName = searchField.getText();
				if (hotelName.equals("")) {
					hotelName = null;
				}
				area = areas[areaChoices.getSelectionModel().getSelectedIndex()];
				if (!area.equals("")) {
					ArrayList<RoomVO> roomListLower = new ArrayList<RoomVO>();
					ArrayList<RoomVO> roomListHigher = new ArrayList<RoomVO>();
					RoomVO roomLower = new RoomVO(null, null, 0, null, null);
					RoomVO roomHigher = new RoomVO(null, null, -1, null, null);
					roomListLower.add(roomLower);
					roomListHigher.add(roomHigher);
					hotelWorstConditionVO.setHotelName(hotelName);
					hotelBestConditionVO.setHotelName(hotelName);
					hotelWorstConditionVO.setRoom(roomListLower);
					hotelBestConditionVO.setRoom(roomListHigher);
					hotelWorstConditionVO.setStar(starSelected);
					hotelBestConditionVO.setStar(5);
					hotelWorstConditionVO.setScore(scoreSelected);
					hotelBestConditionVO.setScore(5.0);
					hotelWorstConditionVO.setCircle(area);
					hotelBestConditionVO.setCircle(area);
					hotelWorstConditionVO.setBooked(bookedSelected);
					hotelBestConditionVO.setBooked(bookedSelected);
					ArrayList<HotelSearchVO> searchDataList = hotelbl.findWithReq(hotelWorstConditionVO,
							hotelBestConditionVO);
					searchData = FXCollections.observableArrayList(searchDataList);
					searchWithArea();
				} else {
					feedbackLabel.setText("必须先选择商圈才能进行酒店筛选！");
				}
			}
		});
	}

	/**
	 * 设置评分区间选择的组件
	 * 
	 * @param others
	 */
	public void setBookedChoiceBox(ObservableList<String> others) {
		bookedChoices.setItems(others);
		bookedChoices.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				bookedLabel.setText("");
				hotelName = searchField.getText();
				if (hotelName.equals("")) {
					hotelName = null;
				}
				if (!area.equals("")) {
					bookedSelected = booked[bookedChoices.getSelectionModel().getSelectedIndex()];
					ArrayList<RoomVO> roomListLower = new ArrayList<RoomVO>();
					ArrayList<RoomVO> roomListHigher = new ArrayList<RoomVO>();
					RoomVO roomLower = new RoomVO(null, null, 0, null, null);
					RoomVO roomHigher = new RoomVO(null, null, -1, null, null);
					roomListLower.add(roomLower);
					roomListHigher.add(roomHigher);
					hotelWorstConditionVO.setHotelName(hotelName);
					hotelBestConditionVO.setHotelName(hotelName);
					hotelWorstConditionVO.setRoom(roomListLower);
					hotelBestConditionVO.setRoom(roomListHigher);
					hotelWorstConditionVO.setStar(starSelected);
					hotelBestConditionVO.setStar(5);
					hotelWorstConditionVO.setScore(scoreSelected);
					hotelBestConditionVO.setScore(5.0);
					hotelWorstConditionVO.setCircle(area);
					hotelBestConditionVO.setCircle(area);
					hotelWorstConditionVO.setBooked(bookedSelected);
					hotelBestConditionVO.setBooked(bookedSelected);
					ArrayList<HotelSearchVO> searchDataList = hotelbl.findWithReq(hotelWorstConditionVO,
							hotelBestConditionVO);
					searchData = FXCollections.observableArrayList(searchDataList);
					searchWithBooked();
				} else {
					feedbackLabel.setText("必须先选择商圈才能进行酒店筛选！");
				}
			}
		});
	}

	/**
	 * 设置排序方式选择的组件
	 * 
	 * @param others
	 */
	public void setSortChoiceBox(ObservableList<String> others) {
		sortChoices.setItems(others);
		sortChoices.setOnAction(new EventHandler<ActionEvent>() {
			@SuppressWarnings("unchecked")
			public void handle(ActionEvent event) {
				sortLabel.setText("");
				int index = sortChoices.getSelectionModel().getSelectedIndex();
				System.out.println("index:" + index);
				sort(index);
				searchTable.setItems(searchData);
			}
		});
	}

	/**
	 * 排序
	 * 
	 * @param index
	 */
	private void sort(int index) {
		HotelSearchVO temp;
		switch (index) {
		case 0:
			for (int i = 0; i < searchData.size(); i++) {
				for (int j = i + 1; j < searchData.size(); j++) {

//					 if(hotelbl.get<searchData.get(j));
//					 searchData.
				}

			}
			break;
		case 1:
			for (int i = 0; i < searchData.size(); i++) {
				for (int j = i + 1; j < searchData.size(); j++) {

					if (Integer.parseInt(searchData.get(i).getStar()) < Integer.parseInt(searchData.get(j).getStar())) {
						temp = searchData.get(i);
						searchData.set(i, searchData.get(j));
						searchData.set(j, temp);
					}

				}
			}
			break;
		case 2:
			for (int i = 0; i < searchData.size(); i++) {
				for (int j = i + 1; j < searchData.size(); j++) {

					if (Double.parseDouble(searchData.get(i).getScore()) < Double
							.parseDouble(searchData.get(j).getScore())) {
						temp = searchData.get(i);
						searchData.set(i, searchData.get(j));
						searchData.set(j, temp);
					}

				}
			}
			break;
		default:
			break;
		}
	}

	/**
	 * 初始设置TableView的属性，绑定内部按钮
	 */
	@SuppressWarnings("unchecked")
	public void initTableView() {
		hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		starCol.setCellValueFactory(new PropertyValueFactory<>("star"));
		scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
		areaCol.setCellValueFactory(new PropertyValueFactory<>("area"));
		locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
		buttonCol
				.setCellFactory(new Callback<TableColumn<HotelSearchVO, Boolean>, TableCell<HotelSearchVO, Boolean>>() {

					@Override
					public TableCell<HotelSearchVO, Boolean> call(TableColumn<HotelSearchVO, Boolean> p) {
						SearchButtonCell buttonCell = new SearchButtonCell(searchTable, mainPane, primaryStage,
								personname);
						return buttonCell;
					}
				});
	}

}