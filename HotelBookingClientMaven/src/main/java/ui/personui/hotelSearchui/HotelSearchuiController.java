package ui.personui.hotelSearchui;

import businessLogic.hotelbl.HotelController;
import businessLogicService.hotelblService.HotelblService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.personui.hotelInfoViewui.HotelInfoViewui;
import ui.personui.personInfoui.PersonInfoViewui;
import vo.hotelVO.HotelSearchVO;

public class HotelSearchuiController {

	@FXML
	private Button hotelSearchButton;
	@FXML
	private Button personInfoButton;
	@FXML
	private Button orderInfoButton;
	@FXML
	private Button priceButton;
	@FXML
	private Button starButton;
	@FXML
	private Button facilityButton;
	@FXML
	private Button haveBookedButton;
	@FXML
	private Button searchButton;
	@FXML
	private TextField searchField;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn hotelNameCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn starCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn areaCol;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn locationCol;
	@FXML
	private TableView<HotelSearchVO> searchTable;
	@FXML
	private Pane mainPane;

	private HotelblService hotelbl;
	
	private ObservableList<HotelSearchVO> searchData;
	
	private HotelSearchVO hotelInfo;

	// 酒店详情查看界面
	private Pane hotelInfoViewPane;

	// 个人信息界面
	private Pane personInfoViewPane;

	private Stage primaryStage;

	private String personname;

	public HotelSearchuiController() {
		hotelbl = new HotelController();
	}

	/**
	 * 跳转到个人信息维护界面
	 * 
	 * @return boolean
	 */

	@FXML
	private void viewPersonInfo() {
		personInfoViewPane = new PersonInfoViewui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(personInfoViewPane);
	}

	/**
	 * 输入酒店名称搜索后，跳转到酒店详情查看界面
	 */
	@FXML
	private void hotelInfoView() {
		String hotelName = searchField.getText();
//		hotelInfo = hotelbl.showHotelInfo(hotelName);
		hotelInfoViewPane = new HotelInfoViewui(primaryStage, personname,hotelName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelInfoViewPane);
	}
	
	/**
	 * 以列表形式显示搜索结果
	 */
	@SuppressWarnings("unchecked")
	@FXML
	private void search() {
		searchTable.getColumns().clear();
		String hotelName = searchField.getText();
		searchData.get(0);
//		searchData=FXCollections.observableArrayList(hotelbl.showHotelInfo(hotelName));
		hotelNameCol.setCellValueFactory(
                new PropertyValueFactory<>("hotelName"));
		starCol.setCellValueFactory(
                new PropertyValueFactory<>("star"));
		areaCol.setCellValueFactory(
                new PropertyValueFactory<>("area"));
		locationCol.setCellValueFactory(
                new PropertyValueFactory<>("location"));
		searchTable.setItems(searchData);
		
	}

	/**
	 * 传递Main的primaryStage
	 * 
	 * @param primaryStage
	 */
	public void launchStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	/**
	 * 传递用户名
	 * 
	 * @param personname
	 */
	public void setPersonname(String personname) {
		this.personname = personname;
	}
}