package ui.loginui;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import rmi.ClientRunner;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {

	private LoginuiController loginuiController;
    private Stage primaryStage;
    private Pane rootLayout;
    private ObservableList<String> others = FXCollections.observableArrayList();
    @Override
    public void start(Stage primaryStage) {
    	@SuppressWarnings("unused")
		ClientRunner cr=new ClientRunner();
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hotel Booking System");
        others.add("酒店工作人员");
        others.add("网站营销人员");
        others.add("网站管理人员");
        others.add("还原");
        initLoginui();
    }

    /**
	 * 初始化本界面
	 */
    private void initLoginui() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/Loginui.fxml"));
            rootLayout =  loader.load();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(getClass().getResource("/酒店搜索界面/搜索键.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("/酒店搜索界面/选择框.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
            //将primaryStage传递到controller中
            loginuiController = loader.getController();
            loginuiController.launchStage(primaryStage);
            loginuiController.setChoiceBox(others);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
