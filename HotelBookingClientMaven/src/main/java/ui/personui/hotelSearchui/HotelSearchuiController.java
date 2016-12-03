package ui.personui.hotelSearchui;

import java.util.ArrayList;

import businessLogic.hotelbl.HotelController;
import businessLogicService.hotelblService.HotelblService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import ui.personui.hotelInfoViewui.HotelInfoViewui;
import ui.personui.orderViewui.OrderViewui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hoteluiVO.HotelSearchMock;
import vo.hotelVO.hoteluiVO.HotelSearchVO;

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
	@FXML
	private TableView searchTable;
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
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn buttonCol;

	@FXML
	private Pane mainPane;

	private HotelblService hotelbl;

	private ObservableList<HotelSearchVO> searchData;

	private HotelSearchVO hotelInfo;

	// 酒店详情查看界面
	private Pane hotelInfoViewPane;

	// 个人信息界面
	private Pane personInfoViewPane;

	// 个人订单界面
	private Pane personOrderViewPane;

	private Stage primaryStage;

	private String personname;

	public HotelSearchuiController() {
		hotelbl = new HotelController();
	}

	// 内部类，定义TableView中的按钮
	public class ButtonCell extends TableCell<HotelSearchVO, Boolean> {
		private final Button cellButton = new Button("查看详情");

		ButtonCell() {
			cellButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent t) {
					String selectedHotelName = ((HotelSearchVO) searchTable.getItems().get(getTableRow().getIndex()))
							.getHotelName();
					hotelInfoViewPane=new HotelInfoViewui(primaryStage, personname, selectedHotelName);
					mainPane.getChildren().remove(0);
					mainPane.getChildren().add(hotelInfoViewPane);
				}
			});
		}

		// Display button if the row is not empty
		@Override
		protected void updateItem(Boolean t, boolean empty) {
			super.updateItem(t, empty);
			if (empty) {
				setGraphic(null);
				setText(null);
			} else {
				// btnBox.getChildren().clear();
				// if(((OrderVO)tableView.getItems().get(getTableRow().getIndex())).orderType
				// == OrderType.Executed){
				// btnBox.getChildren().add(detailButton);
				// }else {
				// btnBox.getChildren().addAll(detailButton, checkInButton);
				// }
				setGraphic(cellButton);
				setText(null);
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
	 * 跳转到个人订单查看界面
	 */
	@FXML
	private void viewPersonOrder() {
		personOrderViewPane = new OrderViewui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(personOrderViewPane);
	}

	/**
	 * 输入酒店名称搜索后，跳转到酒店详情查看界面
	 */
	@FXML
	private void ViewHotelInfo() {
		String hotelName = searchField.getText();
		// hotelInfo = hotelbl.showHotelInfo(hotelName);
		hotelInfoViewPane = new HotelInfoViewui(primaryStage, personname, hotelName);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelInfoViewPane);
	}

	/**
	 * 以列表形式显示搜索结果
	 */
	@SuppressWarnings("unchecked")
	@FXML
	private void search() {
		searchTable.refresh();
		ArrayList<HotelSearchVO> searchData0 = new ArrayList<HotelSearchVO>();
		searchData0.add(new HotelSearchMock("njuHotel", "5", "nanjing", "nju"));
		searchData = FXCollections.observableArrayList(searchData0);
		// searchData=FXCollections.observableArrayList(hotelbl.showHotelInfo(hotelName));
		hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		starCol.setCellValueFactory(new PropertyValueFactory<>("star"));
		areaCol.setCellValueFactory(new PropertyValueFactory<>("area"));
		locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
		buttonCol
				.setCellFactory(new Callback<TableColumn<HotelSearchVO, Boolean>, TableCell<HotelSearchVO, Boolean>>() {

					@Override
					public TableCell<HotelSearchVO, Boolean> call(TableColumn<HotelSearchVO, Boolean> p) {
						ButtonCell buttonCell = new ButtonCell();
						return buttonCell;
					}

				});
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

	/**
	 * 登录之后调整界面大小，和之后更大的工作区域匹配
	 */
	public void modifyStageSize() {
		primaryStage.setWidth(1000);
		primaryStage.setHeight(800);
		primaryStage.setX(400);
	}
}