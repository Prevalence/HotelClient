package ui.personui.hotelInfoViewui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.personui.personInfoui.PersonInfoViewui;

public class HotelInfoViewuiController {

	@FXML
	private Button hotelSearchButton;
	@FXML
	private Button personInfoButton;
	@FXML
	private Button orderInfoButton;
	@FXML
	private Button priceButton;
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
	private TextField passwordField;
	@FXML
	private Label feedBackLabel;
	@FXML
	private Label otherLabel;
	@FXML
	private Pane mainPane;

	private UserblService userbl;

	// 酒店详情查看界面
	private Pane hotelInfoViewPane;

	// 个人信息界面
	private Pane personInfoViewPane;

	private Stage primaryStage;

	private String personname;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public HotelInfoViewuiController() {
		userbl = new UserController();
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
}
