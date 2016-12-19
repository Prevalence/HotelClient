package ui.helper;

import java.util.ArrayList;

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
import vo.orderVO.orderblVO.OrderVO;
import vo.orderVO.orderuiVO.OrderViewVO;

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
	// 订单数据表
	private ArrayList<OrderVO> orders;

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
				System.out.println("hotelName:" + selectedHotelName);
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
//				newPane = new OrderInfoViewui(primaryStage, personname);
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

	/**
	 * 从orderVO列表中获取用于界面显示的orderViewVO列表
	 * 
	 * @return orderList
	 */
	private ArrayList<OrderViewVO> getOrderViewList(ArrayList<OrderVO> orders) {
		ArrayList<OrderViewVO> orderList = new ArrayList<OrderViewVO>();
		String orderNumber = "";
		String orderState = "";
		String expectedTime = "";
		String hotelName = "";
		OrderViewVO order = null;
		for (int i = 0; i < orders.size(); i++) {
			orderNumber = orders.get(i).getOrderID();
			expectedTime = orders.get(i).getPredictExecutetime();
			hotelName = orders.get(i).getHotelname();
			orderState = orders.get(i).getOrderstate();
			order = new OrderViewVO(hotelName, orderNumber, expectedTime, orderState);
			orderList.add(order);
		}
		return orderList;
	}

}
