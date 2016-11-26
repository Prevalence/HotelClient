package ui.loginui;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {

    private Stage primaryStage;
    private Pane rootLayout;
    private ObservableList<String> others = FXCollections.observableArrayList();
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hotel Booking System");
        others.add("酒店工作人员");
        others.add("网站营销人员");
        others.add("网站管理人员");
        initLoginui();
    }

    /**
     * Initializes the root layout.
     */
    public void initLoginui() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/Loginui.fxml"));
            rootLayout =  loader.load();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            
            primaryStage.setScene(scene);
            primaryStage.show();
            //将primaryStage传递到controller中
            LoginuiController loginuiController = loader.getController();
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
