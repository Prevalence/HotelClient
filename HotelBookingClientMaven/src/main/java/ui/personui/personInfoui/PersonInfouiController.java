package ui.personui.personInfoui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.orderViewui.OrderViewui;

public class PersonInfouiController {
	//TODO
	
	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	// 酒店详情查看界面
	private Pane hotelSearchPane;

	// 个人订单界面
	private Pane personOrderPane;

	private Stage primaryStage;

	private String personname;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public PersonInfouiController() {
		userbl = new UserController();
	}

	/**
	 * 跳转到个人订单查看界面
	 */
	@FXML
	private void viewPersonOrder() {
		personOrderPane = new OrderViewui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(personOrderPane);
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
