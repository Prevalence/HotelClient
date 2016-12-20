package ui.helper;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.hotelworkerui.orderInfoViewui.HotelOrderInfoViewui;
import ui.marketui.orderInfoViewui.MarketOrderInfoViewui;
import ui.personui.orderInfoViewui.OrderInfoViewui;
import vo.orderVO.orderblVO.OrderVO;

public class OrderButtonCell<T> extends TableCell<T, Boolean> {
	private final Button cellButton = new Button("查看详情");
	private Pane newPane;
	@SuppressWarnings("unused")
	private Pane mainPane;
	@SuppressWarnings("unused")
	private Stage primaryStage;
	@SuppressWarnings("unused")
	private String username;
	@SuppressWarnings({ "rawtypes", "unused" })
	private TableView table;

	/**
	 * 订单列表初始化
	 * 
	 * @param table
	 * @param mainPane
	 * @param primaryStage
	 * @param username
	 */
	@SuppressWarnings("rawtypes")
	public OrderButtonCell(TableView table, Pane mainPane, Stage primaryStage, String username, String type,
			ArrayList<OrderVO> orders) {
		this.table = table;
		this.mainPane = mainPane;
		this.primaryStage = primaryStage;
		this.username = username;
		cellButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				if (type.equals("person")) {
					OrderVO order=orders.get(getTableRow().getIndex());
					newPane = new OrderInfoViewui(primaryStage, username,order);
				} else if (type.equals("hotelworker")) {
					OrderVO order=orders.get(getTableRow().getIndex());
					newPane = new HotelOrderInfoViewui(primaryStage, username,order);
				} else if (type.equals("market")) {
					OrderVO order=orders.get(getTableRow().getIndex());
					newPane = new MarketOrderInfoViewui(primaryStage, username,order);
				}
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
