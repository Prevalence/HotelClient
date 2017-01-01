package ui.marketui.promotionui;

import java.util.ArrayList;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.Factory.PromotionFactory;
import ui.marketui.creditPayui.CreditPayui;
import ui.marketui.orderViewui.MarketOrderViewui;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.promotionvo.PromotionVO;
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

	// 具体促销策略界面
	private Pane newPromotionPane;

	private String workerName;

	private String hotelName;

	private String promotionSelected;

	private String[] promotions = { "网站特定时间优惠策略" };

	private ArrayList<PromotionVO> promotionVOs;

	private ArrayList<PromotionuiVO> promotionList;

	private ObservableList<PromotionuiVO> promotionData;

	// 网站订单浏览界面
	private Pane marketOrderPane;

	// 促销策略界面
	private Pane promotionPane;

	// 信用充值界面
	private Pane creditPayPane;

	private Stage primaryStage;

	private String marketName;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public PromotionuiController() {
		userbl = new UserController();
		promotionbl = new PromotionController();
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
	 * 编辑原有酒店促销策略
	 */
	@FXML
	private void editPromotion() {
		if (promotionTable.getSelectionModel().getSelectedIndex() == -1) {
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("没有选中要编辑的促销策略！");
		} else {
			PromotionVO promotion = promotionVOs.get(promotionTable.getSelectionModel().getSelectedIndex());
			String promotiontype = promotionVOs.get(promotionTable.getSelectionModel().getSelectedIndex())
					.getPromotionType();
			newPromotionPane = PromotionFactory.createPromotionEditPane(primaryStage, promotiontype, workerName,
					promotion);
			mainPane.getChildren().remove(0);
			mainPane.getChildren().add(newPromotionPane);
		}
	}

	/**
	 * 删除原有酒店促销策略
	 */
	@SuppressWarnings("unchecked")
	@FXML
	private void deletePromotion() {
		if (promotionTable.getSelectionModel().getSelectedIndex() == -1) {
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("没有选中要删除的促销策略！");
		} else {
			PromotionVO promotion = promotionVOs.get(promotionTable.getSelectionModel().getSelectedIndex());
			if(promotionbl.deleteProm(promotion)){
				feedbackLabel.setTextFill(Color.web("#058cff"));
				feedbackLabel.setText("删除成功！");
				promotionVOs = promotionbl.getProm(hotelName);
				promotionList = getpromotionViewList(promotionVOs);
				promotionData = FXCollections.observableArrayList(promotionList);
				promotionTable.setItems(promotionData);
			}
			else{
				feedbackLabel.setTextFill(Color.web("#f80202"));
				feedbackLabel.setText("系统错误，删除失败！");
			}
		}
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
		nameLabel.setText(marketName);
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
		promotionVOs = promotionbl.getProm("WebPromotion");
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
