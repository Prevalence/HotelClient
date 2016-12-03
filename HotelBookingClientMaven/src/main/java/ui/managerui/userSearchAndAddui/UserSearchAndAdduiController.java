package ui.managerui.userSearchAndAddui;

import businessLogic.userbl.UserController;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserSearchAndAdduiController {
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
		public UserSearchAndAdduiController() {
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
		
		/**
		 * 登录之后调整界面大小，和之后更大的工作区域匹配
		 */
		public void modifyStageSize() {
			primaryStage.setWidth(1000);
			primaryStage.setHeight(800);
			primaryStage.setX(400);
		}
}
