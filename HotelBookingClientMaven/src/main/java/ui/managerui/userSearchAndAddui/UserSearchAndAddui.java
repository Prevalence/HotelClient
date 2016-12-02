package ui.managerui.userSearchAndAddui;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class UserSearchAndAddui {
	private Stage primaryStage;

	private String personname;

	private UserSearchAndAdduiController userSearchAndAddViewuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public UserSearchAndAddui(Stage primaryStage, String personname) {
			this.primaryStage = primaryStage;
			this.personname = personname;
			initUserSearchAndAddViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initUserSearchAndAddViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UserSearchAndAddui.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		userSearchAndAddViewuiController = loader.getController();
		userSearchAndAddViewuiController.launchStage(primaryStage);
		userSearchAndAddViewuiController.setPersonname(personname);
	}
}
