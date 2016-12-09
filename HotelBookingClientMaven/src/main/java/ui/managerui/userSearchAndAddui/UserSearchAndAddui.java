package ui.managerui.userSearchAndAddui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserSearchAndAddui extends Pane{
	private Stage primaryStage;

	private String managerName;

	private UserSearchAndAdduiController userSearchAndAddViewuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public UserSearchAndAddui(Stage primaryStage, String managerName) {
			this.primaryStage = primaryStage;
			this.managerName = managerName;
			initUserSearchAndAddViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initUserSearchAndAddViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/网站管理人员首界面.fxml"));
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
		userSearchAndAddViewuiController.setManagerName(managerName);
		userSearchAndAddViewuiController.modifyStageSize();
	}
}
