package ui.managerui.userInfoui;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class UserInfoui {
	private Stage primaryStage;

	private String personname;

	private UserInfouiController userInfoViewuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public UserInfoui(Stage primaryStage, String personname) {
			this.primaryStage = primaryStage;
			this.personname = personname;
			initUserInfoViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initUserInfoViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UserInfoui.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		userInfoViewuiController = loader.getController();
		userInfoViewuiController.launchStage(primaryStage);
		userInfoViewuiController.setPersonname(personname);
	}
}
