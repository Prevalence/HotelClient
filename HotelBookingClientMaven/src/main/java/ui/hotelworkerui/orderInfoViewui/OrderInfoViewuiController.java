package ui.hotelworkerui.orderInfoViewui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OrderInfoViewuiController {
	//TODO
	
		@FXML
		private Pane mainPane;

		private UserblService userbl;

		// 酒店订单浏览界面
		private Pane hotelOrderPane;

		// 促销策略界面
		private Pane promotionPane;

		// 酒店信息界面
		private Pane hotelInfoPane;

		// 房间信息界面
		private Pane roomInfoPane;

		private Stage primaryStage;

		private String personname;

		/**
		 * The constructor. The constructor is called before the initialize()
		 * method.
		 */
		public OrderInfoViewuiController() {
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
