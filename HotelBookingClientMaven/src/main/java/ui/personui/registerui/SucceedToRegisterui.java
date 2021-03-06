package ui.personui.registerui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SucceedToRegisterui extends Pane{
	private Stage primaryStage;

	private SucceedToRegisteruiController succeedToRegisteruiController;

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public SucceedToRegisterui(Stage primaryStage) {
		this.primaryStage = primaryStage;
		initSucceedToRegisterui();
	};

	/**
	 * 初始化本界面
	 */
	public void initSucceedToRegisterui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SucceedToRegisterui.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Scene scene = new Scene(this);
//		primaryStage.setScene(scene);
		succeedToRegisteruiController = loader.getController();
		succeedToRegisteruiController.launchStage(primaryStage);
	}
}
