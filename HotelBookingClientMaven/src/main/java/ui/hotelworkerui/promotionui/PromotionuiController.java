package ui.hotelworkerui.promotionui;

import java.util.ArrayList;

import businessLogic.promotionbl.PromotionController;
import businessLogic.userbl.UserController;
import businessLogicService.promotionblService.PromotionblService;
import businessLogicService.userblService.UserblService;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import ui.Factory.PromotionFactory;
import ui.helper.SearchButtonCell;
import ui.hotelworkerui.hotelInfoui.HotelInfoui;
import ui.hotelworkerui.orderViewui.HotelOrderViewui;
import ui.hotelworkerui.roomInfoui.RoomInfoui;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.HotelSearchVO;

public class PromotionuiController {

	@FXML
	private Label nameLabel;
	@FXML
	private Label feedbackLabel;
	@FXML
	private Button hotelOrderButton;
	@FXML
	private Button promotionButton;
	@FXML
	private Button hotelInfoButton;
	@FXML
	private Button roomInfoButton;
	@FXML
	private Button addButton;
	@FXML
	private Button editButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Pane mainPane;
	@FXML
	private ChoiceBox<String> promotionChoices;

	@SuppressWarnings("unused")
	private UserblService userbl;

	private PromotionblService promotionbl;

	// 酒店订单浏览界面
	private Pane hotelOrderPane;

	// 促销策略界面
	private Pane promotionPane;

	// 酒店信息界面
	private Pane hotelInfoPane;

	// 房间信息界面
	private Pane roomInfoPane;

	// 房间信息界面
	private Pane newPromotionPane;

	private Stage primaryStage;

	private String workerName;

	private String promotionSelected;

	private String[] promotions = { "BirthdayHotelPromotion", "PeriodHotelPromotion" };

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public PromotionuiController() {
		userbl = new UserController();
		promotionbl = new PromotionController();
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
	 * 新增酒店促销策略
	 */
	@FXML
	private void addPromotion() {

	}

	/**
	 * 编辑原有酒店促销策略
	 */
	@FXML
	private void editPromotion() {

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
	 * 设置要添加的促销策略的选择组件
	 * 
	 * @param others
	 */
	public void setBookedChoiceBox(ObservableList<String> others) {
		promotionChoices.setItems(others);
		promotionChoices.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				promotionSelected = promotions[promotionChoices.getSelectionModel().getSelectedIndex()];
				newPromotionPane = PromotionFactory.createPromotionPane(primaryStage, promotionSelected, workerName);
				mainPane.getChildren().remove(0);
				mainPane.getChildren().add(newPromotionPane);
			}
		});
	}

	/**
	 * 初始设置TableView的属性，绑定内部按钮
	 */
	// @SuppressWarnings("unchecked")
	// public void initTableView() {
	// workerNameCol.setCellValueFactory(new
	// PropertyValueFactory<>("workerName"));
	// starCol.setCellValueFactory(new PropertyValueFactory<>("star"));
	// scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
	// areaCol.setCellValueFactory(new PropertyValueFactory<>("area"));
	// locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
	// buttonCol
	// .setCellFactory(new Callback<TableColumn<HotelSearchVO, Boolean>,
	// TableCell<HotelSearchVO, Boolean>>() {
	//
	// @Override
	// public TableCell<HotelSearchVO, Boolean> call(TableColumn<HotelSearchVO,
	// Boolean> p) {
	// SearchButtonCell buttonCell = new SearchButtonCell(searchTable, mainPane,
	// primaryStage,
	// personname);
	// return buttonCell;
	// }
	// });
	// }
}
