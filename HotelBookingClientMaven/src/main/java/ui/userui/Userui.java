package ui.userui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Userui extends Pane{
	
	private Stage primaryStage;
	
	/**
	 * ����primaryStage���������������С�����ڣ��Ϳ��ƶ�����
	 * @param primaryStage
	 */
	public Userui(Stage primaryStage){
		this.primaryStage=primaryStage;
		initUserui();
	};
	
	 /**
	  * ��ʼ��User��һ�����棺�Ƶ���������
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
