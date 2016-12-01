package ui.personui.hotelInfoViewui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.hotelVO.HotelInfoVO;

public class HotelInfoViewuiController {
	//TODO

	@FXML
	private Pane mainPane;

	private UserblService userbl;
	
	private HotelInfoVO hotelInfo;

	// 酒店搜索界面
	private Pane hotelSearchPane;

	// 酒店详情查看界面
	private Pane hotelInfoViewPane;

	// 个人信息界面
	private Pane personInfoViewPane;

	// 订单查看界面
	private Pane OrderViewPane;

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
