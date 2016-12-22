package ui.hotelworkerui.promotionui;

import java.util.ArrayList;

import businessLogic.hotelbl.HotelController;
import businessLogic.promotionbl.PromotionController;
import businessLogic.userbl.UserController;
import businessLogicService.hotelblService.HotelblService;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import ui.Factory.PromotionFactory;
import ui.helper.SearchButtonCell;
import ui.hotelworkerui.hotelInfoui.HotelInfoui;
import ui.hotelworkerui.orderViewui.HotelOrderViewui;
import ui.hotelworkerui.roomInfoui.RoomInfoui;
import vo.PromotionVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.HotelSearchVO;
import vo.orderVO.orderuiVO.OrderViewVO;
import vo.promotionvo.promotionuiVO.PromotionuiVO;

public class PromotionuiController {

	@FXML
	private Label nameLabel;
	@FXML
	private Label feedbackLabel;
	@FXML
	private Label hotelNameLabel;
	@FXML
	private Label scoreLabel;
	@FXML
	private Label areaLabel;
	@FXML
	private Label connectionLabel;
	@FXML
	private Button hotelpromotionButton;
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
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView promotionTable;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn IDCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn nameCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn typeCol;
	@FXML
	private Pane mainPane;
	@FXML
	private ChoiceBox<String> promotionChoices;

	private UserblService userbl;

	private PromotionblService promotionbl;

	private HotelblService hotelbl;

	// 酒店订单浏览界面
	private Pane hotelpromotionPane;

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

	private String hotelName;

	private String promotionSelected;

	private String[] promotions = { "生日优惠策略", "特定时间优惠策略" };

	private ArrayList<PromotionVO> promotionVOs;

	private ArrayList<PromotionuiVO> promotionList;

	private ObservableList<PromotionuiVO> promotionData;

	private HotelVO hotelInfo;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public PromotionuiController() {
		userbl = new UserController();
		promotionbl = new PromotionController();
		hotelbl = new HotelController();
	}

	/**
	 * 跳转到酒店订单浏览界面
	 */
	@FXML
	private void viewHotelOrder() {
		hotelpromotionPane = new HotelOrderViewui(primaryStage, workerName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelpromotionPane);
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
	 * 编辑原有酒店促销策略
	 */
	@FXML
	private void editPromotion() {
		if (promotionTable.getSelectionModel().getSelectedIndex() == -1) {
			feedbackLabel.setText("没有选中要编辑的促销策略！");
		} else {
			PromotionVO promotion = promotionVOs.get(promotionTable.getSelectionModel().getSelectedIndex());
			String promotiontype = promotionVOs.get(promotionTable.getSelectionModel().getSelectedIndex())
					.getPromotionType();
			System.out.println("promotiontype:" + promotiontype);
			newPromotionPane = PromotionFactory.createPromotionEditPane(primaryStage, promotiontype, workerName,
					promotion);
			mainPane.getChildren().remove(0);
			mainPane.getChildren().add(newPromotionPane);
		}
	}

	/**
	 * 删除原有酒店促销策略
	 */
	@FXML
	private void deletePromotion() {

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
	/**
	 * 传递用户名
	 * 
	 * @param workerName
	 */
	public void setWorkerNameAndShowInfo(String workerName) {
		this.workerName = workerName;
		nameLabel.setText(workerName);
		hotelName = userbl.getHotelWorkerInfo(workerName).getHotelName();
		hotelInfo = hotelbl.getHotelInfoByHotelworkerOrManager(hotelName);
		nameLabel.setText(workerName);
		hotelNameLabel.setText(hotelName);
		areaLabel.setText(hotelInfo.getCircle());
		scoreLabel.setText(String.valueOf(hotelInfo.getScore()));
		connectionLabel.setText(hotelInfo.getHotelPhone());
	}

	/**
	 * 设置要添加的促销策略的选择组件
	 * 
	 * @param others
	 */
	public void setPromotionChoiceBox(ObservableList<String> others) {
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
	@SuppressWarnings("unchecked")
	public void initTableView() {
		IDCol.setCellValueFactory(new PropertyValueFactory<>("promotionID"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("promotionName"));
		typeCol.setCellValueFactory(new PropertyValueFactory<>("promotiontype"));
		promotionVOs = promotionbl.getProm(hotelName);
		if (promotionVOs != null) {
			System.out.println("promotion:" + promotionVOs.size());
		}
		promotionList = getpromotionViewList(promotionVOs);
		promotionData = FXCollections.observableArrayList(promotionList);
		promotionTable.setItems(promotionData);
	}

	/**
	 * 从promotionVO列表中获取用于界面显示的PromotionuiVO列表
	 * 
	 * @return promotionList
	 */
	private ArrayList<PromotionuiVO> getpromotionViewList(ArrayList<PromotionVO> promotions) {
		ArrayList<PromotionuiVO> promotionList = new ArrayList<PromotionuiVO>();
		String promotionID = "";
		String promotionName = "";
		String promotiontype = "";
		PromotionuiVO promotion = null;
		for (int i = 0; i < promotions.size(); i++) {
			promotionID = String.valueOf(promotions.get(i).getPromotionID());
			promotiontype = promotions.get(i).getPromotionType();
			promotionName = promotions.get(i).getPromotionName();
			promotion = new PromotionuiVO(promotionID, promotionName, promotiontype);
			promotionList.add(promotion);
		}
		return promotionList;
	}
}
