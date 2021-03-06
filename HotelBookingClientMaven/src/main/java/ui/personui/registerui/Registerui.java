package ui.personui.registerui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Registerui extends Pane{
	private Stage primaryStage;

	private RegisteruiController registeruiController;

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public Registerui(Stage primaryStage) {
		this.primaryStage = primaryStage;
		initRegisterui();
	};

	/**
	 * 初始化本界面
	 */
	public void initRegisterui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/客户注册界面.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Scene scene = new Scene(this);
//		primaryStage.setScene(scene);
		registeruiController = loader.getController();
		registeruiController.launchStage(primaryStage);
	}
}
