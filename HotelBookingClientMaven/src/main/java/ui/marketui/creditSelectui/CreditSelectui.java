package ui.marketui.creditSelectui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.orderVO.orderblVO.OrderVO;

public class CreditSelectui extends Pane{
	private Stage primaryStage;

	private OrderVO order;

	private String marketName;

	private CreditSelectuiController creditSelectuiController;

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public CreditSelectui(Stage primaryStage, String marketName, OrderVO order) {
		this.primaryStage = primaryStage;
		this.marketName = marketName;
		this.order = order;
		initOrderInfoViewViewui();
	};

	/**
	 * 初始化界面
	 */
	public void initOrderInfoViewViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网站营销人员恢复信用值选择界面.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		creditSelectuiController = loader.getController();
		creditSelectuiController.launchStage(primaryStage);
		creditSelectuiController.setMarketName(marketName);
		creditSelectuiController.setAndShowOrder(order);
		;
	}
	
}
