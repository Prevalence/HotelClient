package ui.personui.orderReviewui;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.orderVO.orderblVO.OrderVO;

public class OrderReviewui extends Pane {
	private Stage primaryStage;

	private String personname;

	private String hotelName;

	private HotelVO hotelInfo;
	
	private OrderVO orderInfo;

	private OrderReviewuiController orderReviewuiController;

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public OrderReviewui(Stage primaryStage, String personname, String hotelName, HotelVO hotelInfo,
			OrderVO orderInfo) {
		this.primaryStage = primaryStage;
		this.personname = personname;
		this.hotelName = hotelName;
		this.hotelInfo = hotelInfo;
		initorderReviewui();
	};

	/**
	 * 初始化界面
	 */
	public void initorderReviewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/入住信息输入界面（带价格）.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		orderReviewuiController = loader.getController();
		orderReviewuiController.launchStage(primaryStage);
		orderReviewuiController.setPersonname(personname);
		orderReviewuiController.setHotelNameAndShowInfo(hotelName);
		orderReviewuiController.setHotelVO(hotelInfo);
		orderReviewuiController.setOrderVO(orderInfo);
	}
}
