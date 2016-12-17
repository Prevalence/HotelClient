package ui.loginui;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Loginui extends Pane{
	private LoginuiController loginuiController;
    private Stage primaryStage;
    private ObservableList<String> others = FXCollections.observableArrayList();
    
    public Loginui(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hotel Booking System");
        others.add("酒店工作人员");
        others.add("网站营销人员");
        others.add("网站管理人员");
        others.add("还原");
        initLoginui();
    }

    /**
     * Initializes the root layout.
     */
    public void initLoginui() {
        	// 设置新的Pane
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Loginui2.fxml"));
    		loader.setRoot(this);
    		try {
    			loader.load();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
            //将primaryStage传递到controller中
            loginuiController = loader.getController();
            loginuiController.launchStage(primaryStage);
            loginuiController.setChoiceBox(others);
    }
}
