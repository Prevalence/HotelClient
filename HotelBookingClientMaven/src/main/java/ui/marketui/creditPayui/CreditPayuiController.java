package ui.marketui.creditPayui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.marketui.orderViewui.MarketOrderViewui;
import ui.marketui.promotionui.MarketPromotionui;
import vo.personVO.PersonVO;
import vo.personVO.RecordVO;

public class CreditPayuiController {
	
	@FXML
	private TextField personNumberField;
	@FXML
	private TextField creditAddField;
	@FXML
	private TextField personNameField;
	@FXML
	private TextField VIPTypeField;
	@FXML
	private TextField connectionField;
	@FXML
	private TextField creditField;
	@FXML
	private TextField VIPLevelField;
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
	private Button searchButton;
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	// 网站订单浏览界面
	private Pane marketOrderPane;

	// 促销策略界面
	private Pane promotionPane;

	// 信用充值界面
	private Pane creditPayPane;

	private Stage primaryStage;

	private String marketName;
	
	private PersonVO personInfo;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public CreditPayuiController() {
		userbl = new UserController();
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
	 * 根据客户编号显示客户信息（信用值等）
	 */
	@FXML
	private void searchWithPersonNumber() {
		String personNumber = personNumberField.getText();
		if(personNumber.equals("")){
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("搜索信息不能为空!");
		}
		else{
			personInfo = userbl.getPersonInfo(personNumber);
			if(personInfo==null){
				feedbackLabel.setTextFill(Color.web("#f80202"));
				feedbackLabel.setText("没有找到该客户!");
			}
			else{
				feedbackLabel.setText("");
				personNameField.setText(personInfo.getUsername());
				VIPTypeField.setText(personInfo.getVipType());
				connectionField.setText(personInfo.getPhoneNumber());
				creditField.setText(String.valueOf(personInfo.getCredit()));
				VIPLevelField.setText(String.valueOf(personInfo.getVipLevel()));
			}
		}
	}

	/**
	 * 点击确定，充值信用
	 */
	@FXML
	private void addCredit() {
		String credit = creditAddField.getText();
		if(credit.equals("")){
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("增加的信用值不能为空!");
		}
		else if(personInfo==null){
			feedbackLabel.setTextFill(Color.web("#f80202"));
			feedbackLabel.setText("还没有确定充值客户对象!");
		}else{
			RecordVO record=new RecordVO("", "", "", credit, "");
			if(userbl.changeCredit(personInfo.getUsername(), record)){
				feedbackLabel.setTextFill(Color.web("#058cff"));
				feedbackLabel.setText("充值成功！");
			}
			else{
				feedbackLabel.setTextFill(Color.web("#f80202"));
				feedbackLabel.setText("系统出错!");
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
	}
}
