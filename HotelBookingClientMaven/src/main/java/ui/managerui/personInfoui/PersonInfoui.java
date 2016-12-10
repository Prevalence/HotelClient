package ui.managerui.personInfoui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PersonInfoui extends Pane{
	private Stage primaryStage;

	private String personname;

	private PersonInfouiController userInfoViewuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public PersonInfoui(Stage primaryStage, String managerName, String personname) {
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
