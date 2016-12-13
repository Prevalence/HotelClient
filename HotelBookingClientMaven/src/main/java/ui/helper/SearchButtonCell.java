package ui.helper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.personui.hotelInfoViewui.HotelInfoViewui;
import ui.personui.orderInfoViewui.OrderInfoViewui;
import vo.hotelVO.hoteluiVO.HotelSearchVO;

public class SearchButtonCell extends TableCell<HotelSearchVO, Boolean> {
	private final Button cellButton = new Button("查看详情");
	private Pane newPane;
	@SuppressWarnings("unused")
	private Pane mainPane;
	@SuppressWarnings("unused")
	private Stage primaryStage;
	@SuppressWarnings("unused")
	private String personname;
	@SuppressWarnings("unused")
	private String selectedHotelName;
	@SuppressWarnings({ "rawtypes", "unused" })
	private TableView table;

	/**
	 * 搜索列表初始化
	 * 
	 * @param table
	 * @param mainPane
	 * @param primaryStage
	 * @param personname
	 * @param selectedHotelName
	 */
	@SuppressWarnings("rawtypes")
	public SearchButtonCell(TableView table, Pane mainPane, Stage primaryStage, String personname) {
		this.table = table;
		this.mainPane = mainPane;
		this.primaryStage = primaryStage;
		this.personname = personname;
		cellButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				String selectedHotelName = ((HotelSearchVO) table.getItems().get(getTableRow().getIndex()))
						.getHotelName();
				System.out.println("hotelName:"+selectedHotelName);
				newPane = new HotelInfoViewui(primaryStage, personname, selectedHotelName);
				mainPane.getChildren().remove(0);
				mainPane.getChildren().add(newPane);
			}
		});
	}

	/**
	 * 订单列表初始化
	 * 
	 * @param table
	 * @param mainPane
	 * @param primaryStage
	 * @param personname
	 */
	@SuppressWarnings("rawtypes")
	public SearchButtonCell(String personname, TableView table, Pane mainPane, Stage primaryStage) {
		this.table = table;
		this.mainPane = mainPane;
		this.primaryStage = primaryStage;
		this.personname = personname;
		cellButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				newPane = new OrderInfoViewui(primaryStage, personname);
				mainPane.getChildren().remove(0);
				mainPane.getChildren().add(newPane);
			}
		});
	}

	@Override
	protected void updateItem(Boolean t, boolean empty) {
		super.updateItem(t, empty);
		if (empty) {
			setGraphic(null);
			setText(null);
		} else {

			setGraphic(cellButton);
			setText(null);
		}
	}

}
