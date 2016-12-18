package ui.hotelworkerui.orderInfoViewui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.orderVO.orderblVO.OrderVO;

public class HotelOrderInfoViewui extends Pane {
	private Stage primaryStage;

	private String hotelName;

	private OrderVO order;

	private OrderInfoViewuiController orderInfoViewuiController;

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public HotelOrderInfoViewui(Stage primaryStage, String hotelName, OrderVO order) {
		this.primaryStage = primaryStage;
		this.hotelName = hotelName;
		this.order = order;
		initOrderInfoViewui();
	};

	/**
	 * 初始化界面
	 */
	public void initOrderInfoViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/酒店订单查看界面.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		orderInfoViewuiController = loader.getController();
		orderInfoViewuiController.launchStage(primaryStage);
		orderInfoViewuiController.setWorkerName(hotelName);
		orderInfoViewuiController.setAndShowOrder(order);
	}
}
