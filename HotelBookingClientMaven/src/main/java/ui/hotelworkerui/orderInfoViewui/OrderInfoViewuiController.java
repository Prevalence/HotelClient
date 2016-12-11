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

		@SuppressWarnings("unused")
		private UserblService userbl;

		// 酒店订单浏览界面
		@SuppressWarnings("unused")
		private Pane hotelOrderPane;

		// 促销策略界面
		@SuppressWarnings("unused")
		private Pane promotionPane;

		// 酒店信息界面
		@SuppressWarnings("unused")
		private Pane hotelInfoPane;

		// 房间信息界面
		@SuppressWarnings("unused")
		private Pane roomInfoPane;

		@SuppressWarnings("unused")
		private Stage primaryStage;

		@SuppressWarnings("unused")
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
