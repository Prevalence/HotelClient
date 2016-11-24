package ui.userui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Userui extends Pane{
	
	private Stage primaryStage;
	
	/**
	 * 传递primaryStage参数，用来完成最小化窗口，和可移动窗口
	 * @param primaryStage
	 */
	public Userui(Stage primaryStage){
		this.primaryStage=primaryStage;
		initUserui();
	};
	
	 /**
	  * 初始化User第一个界面：酒店搜索界面
	  */
    public void initUserui() {
        // Load root layout from fxml file.
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Userui.fxml"));
		loader.setRoot(this);;
		try{
			loader.load();
		}catch(Exception e){
			e.printStackTrace();
		}
    }
}
