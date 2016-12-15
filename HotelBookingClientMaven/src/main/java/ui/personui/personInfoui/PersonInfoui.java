package ui.personui.personInfoui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PersonInfoui extends Pane{
	private Stage primaryStage;

	private String personname;

	private PersonInfouiController personInfoViewuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public PersonInfoui(Stage primaryStage, String personname) {
			this.primaryStage = primaryStage;
			this.personname = personname;
			initPersonInfoViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initPersonInfoViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/个人信息及信用值界面.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		personInfoViewuiController = loader.getController();
		personInfoViewuiController.launchStage(primaryStage);
		personInfoViewuiController.setPersonname(personname);
		personInfoViewuiController.initPersonInfo();
	}
}
