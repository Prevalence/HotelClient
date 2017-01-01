package ui.hotelworkerui.promotionui.periodPromotionEditui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.promotionvo.hotelpromotionVO.PeriodHotelproVO;

public class PeriodPromotionEditui extends Pane{
	private Stage primaryStage;

	private String workerName;
	
	private ObservableList<String> months = FXCollections.observableArrayList();
	
	private PeriodHotelproVO promotion;

	private PeriodPromotionEdituiController birthdayPromotionuiController;

	/**
		 * 接受primarystage用来完成界面最小化和可移动化设置
		 * 
		 * @param primaryStage
		 */
		public PeriodPromotionEditui(Stage primaryStage, String workerName,PeriodHotelproVO promotion) {
			this.primaryStage = primaryStage;
			this.workerName = workerName;
			this.promotion = promotion;
			months.addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
			initPromotionViewui();
		};

	/**
	 * 初始化界面
	 */
	public void initPromotionViewui() {
		// 设置新的Pane
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/特定时间优惠编辑.fxml"));
		loader.setRoot(this);
		try {
			loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Scene scene = new Scene(this);
		// primaryStage.setScene(scene);
		birthdayPromotionuiController = loader.getController();
		birthdayPromotionuiController.launchStage(primaryStage);
		birthdayPromotionuiController.setWorkerNameAndShowInfo(workerName);
		birthdayPromotionuiController.setMonthChoiceBox(months);
		birthdayPromotionuiController.setPromotionVO(promotion);
	}
}
