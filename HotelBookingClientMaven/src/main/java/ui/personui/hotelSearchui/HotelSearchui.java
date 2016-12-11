package ui.personui.hotelSearchui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HotelSearchui extends Pane {
	private Stage primaryStage;

	private String personname;

	private HotelSearchuiController hotelSearchuiController;
	
	private ObservableList<String> prices=FXCollections.observableArrayList();

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public HotelSearchui(Stage primaryStage, String personname) {
		this.primaryStage = primaryStage;
		this.personname = personname;
		prices.add("0-300");
		System.out.println(prices.get(0));
		initHotelSearchui();
	};

	/**
	 * 初始化本界面
	 */
	public void initHotelSearchui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HotelSearchui.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Scene scene = new Scene(this);
//		primaryStage.setScene(scene);
		hotelSearchuiController = loader.getController();
		hotelSearchuiController.launchStage(primaryStage);
		hotelSearchuiController.setPersonname(personname);
		hotelSearchuiController.modifyStageSize();
		hotelSearchuiController.setChoiceBox(prices);
		hotelSearchuiController.initTableView();
	}
}
