package ui.marketui.creditPayui;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class CreditPayui {
	private Stage primaryStage;

	private String personname;

	private CreditPayuiController creditPayViewuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public CreditPayui(Stage primaryStage, String personname) {
			this.primaryStage = primaryStage;
			this.personname = personname;
			initCreditPayViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initCreditPayViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CreditPayui.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		creditPayViewuiController = loader.getController();
		creditPayViewuiController.launchStage(primaryStage);
		creditPayViewuiController.setPersonname(personname);
	}
}
