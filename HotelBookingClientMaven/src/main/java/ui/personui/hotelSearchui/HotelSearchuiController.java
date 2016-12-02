package ui.personui.hotelSearchui;

import businessLogic.hotelbl.HotelController;
import businessLogicService.hotelblService.HotelblService;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.personui.hotelInfoViewui.HotelInfoViewui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hoteluiVO.HotelSearchVO;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Callback;

public class HotelSearchuiController {

	@FXML
	private Button hotelSearchButton;
	@FXML
	private Button personInfoButton;
	@FXML
	private Button HotelSearchVOInfoButton;
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
		initViewTable();
	}
	
	 private void initHotelSearchVOsViewTable() {

	        // create other columns. Removed as not important

	        //Insert Button
	        TableColumn<HotelSearchVO, String> actionCol = new TableColumn<>("Action");
	        actionCol.setSortable(false);

	        actionCol.setCellValueFactory(
	                new Callback<TableColumn.CellDataFeatures<HotelSearchVO, String>, ObservableValue<String>>() {

	                    @Override
	                    public ObservableValue<String> call(TableColumn.CellDataFeatures<HotelSearchVO, String> p) {
	                        return p.getValue().actionProperty();
	                    }
	                });

	        actionCol.setCellFactory(
	                new Callback<TableColumn<HotelSearchVO, String>, TableCell<HotelSearchVO, String>>() {

	                    @Override
	                    public TableCell<HotelSearchVO, String> call(TableColumn<HotelSearchVO, String> p) {
	                        ButtonCell buttonCell = new ButtonCell();

	                        // HOW TO BIND TO HotelSearchVO.action stringProperty ???
	                        //buttonCell.textProperty().bind(???);

	                        return buttonCell;
	                    }

	                });

	        searchTable.setItems();
	        searchTable.getColumns().addAll(actionCol);
	    }

	    //Define the button cell
	    private class ButtonCell extends TableCell<HotelSearchVO, String> {
	        final Button cellButton = new Button();

	        ButtonCell(){
	        	cellButton.setOnAction(new EventHandler<ActionEvent>(){
	                @Override
	                public void handle(ActionEvent t) {
	                    String id = ((HotelSearchVO) getTableRow().getItem()).hotelName(); // it will be order.id
	                    String action = getItem(); // it's actually will be order.action field

	                    // orderManager.doSomethingWithIdandAction
	                }
	            });
	        }

	        //Display button if the row is not empty
	        @Override
	        protected void updateItem(String t, boolean empty) {
	            super.updateItem(t, empty);
	            if (!empty) {
	                setGraphic(cellButton);
	            }
	        }
	    }

	/**
	 * 跳转到个人信息维护界面
	 * 
	 * @return boolean
	 */

	@FXML
	private void viewPersonInfo() {
		personInfoViewPane = new PersonInfoui(primaryStage, personname);
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