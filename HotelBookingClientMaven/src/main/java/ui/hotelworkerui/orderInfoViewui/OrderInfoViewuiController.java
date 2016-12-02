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
