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
	
	private ObservableList<String> stars=FXCollections.observableArrayList();
	
	private ObservableList<String> scores=FXCollections.observableArrayList();
	
	private ObservableList<String> areas=FXCollections.observableArrayList();
	
	private ObservableList<String> booked=FXCollections.observableArrayList();

	/**
	 * 接受primarystage用来完成界面最小化和可移动化设置
	 * 
	 * @param primaryStage
	 */
	public HotelSearchui(Stage primaryStage, String personname) {
		this.primaryStage = primaryStage;
		this.personname = personname;
		prices.addAll("0-300","300-600","600-1200","1200以上");
		stars.addAll("1-5","2-5","3-5","4-5","5");
		scores.addAll("1.0-5.0","2.0-5.0","3.0-5.0","4.0-5.0","5.0");
		areas.addAll("商圈1","商圈2");
		booked.addAll("是","否");
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
		hotelSearchuiController.setPriceChoiceBox(prices);
		hotelSearchuiController.setStarChoiceBox(stars);
		hotelSearchuiController.setScoreChoiceBox(scores);
		hotelSearchuiController.setAreaChoiceBox(areas);
		hotelSearchuiController.setBookedChoiceBox(booked);
		hotelSearchuiController.initTableView();
	}
}
