package ui.personui.hotelInfoViewui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.orderViewui.OrderViewui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hoteluiVO.HotelInfoVO;

public class HotelInfoViewuiController {
	//TODO

	@FXML
	private Pane mainPane;

	private UserblService userbl;
	
	private HotelInfoVO hotelInfo;

	// 酒店搜索界面
	private Pane hotelSearchPane;

	// 个人信息界面
	private Pane personInfoViewPane;

	// 订单查看界面
	private Pane personOrderViewPane;

	private Stage primaryStage;

	private String personname;

	private String hotelName;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public HotelInfoViewuiController() {
		userbl = new UserController();
	}

	public void goTohotelSearchui() {

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

	/**
	 * 传递酒店名，并将该酒店详情显示在界面上
	 * @param hotelName
	 */
	public void setHotelNameAndShowInfo(String hotelName) {
		this.hotelName = hotelName;
		
	}

}
