package ui.personui.hotelInfoViewui;

import java.util.ArrayList;

import businessLogic.hotelbl.HotelController;
import businessLogic.userbl.UserController;
import businessLogicService.hotelblService.HotelblService;
import businessLogicService.userblService.UserblService;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.personui.hotelSearchui.HotelSearchui;
import ui.personui.orderViewui.OrderViewui;
import ui.personui.personInfoui.PersonInfoui;
import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.RoomInfoVO;

public class HotelInfoViewuiController {
	// TODO

	@FXML
	private Pane mainPane;

	@SuppressWarnings("unused")
	private UserblService userbl;

	private HotelblService hotelbl;

	private HotelVO hotelInfo;

	@SuppressWarnings("unused")
	private ArrayList<RoomVO> room;

	@SuppressWarnings("unused")
	private ArrayList<RoomInfoVO> roomInfo;

	private ArrayList<CommentVO> comment;

	@SuppressWarnings("unused")
	private ArrayList<String> commentList;

	// 酒店搜索界面
	private Pane hotelSearchPane;

	// 个人信息界面
	private Pane personInfoViewPane;

	// 订单查看界面
	private Pane personOrderViewPane;

	private Stage primaryStage;

	private String personname;

	@SuppressWarnings("unused")
	private String hotelName;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public HotelInfoViewuiController() {
		userbl = new UserController();
		hotelbl = new HotelController();
	}

	public void goTohotelSearchui() {

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
	 * 跳转到酒店搜索界面
	 */
	@FXML
	private void viewHotelSearch() {
		hotelSearchPane = new HotelSearchui(primaryStage, personname);
		mainPane.getChildren().remove(0);
		mainPane.getChildren().add(hotelSearchPane);
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
	 * 传递酒店名，并将该酒店详情显示在界面上
	 * 
	 * @param hotelName
	 */
	public void setHotelNameAndShowInfo(String hotelName) {
		this.hotelName = hotelName;
		hotelInfo = hotelbl.showHotelInfo(hotelName);
		if(hotelInfo==null){
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		comment = hotelInfo.getComment();
		room = hotelInfo.getRoom();
		commentList = getCommentList(comment);

	}

	/**
	 * 从commentVO列表中获取comment字符串组成列表，用于界面显示
	 * 
	 * @return commentList
	 */
	private ArrayList<String> getCommentList(ArrayList<CommentVO> comment) {
		ArrayList<String> commentList = new ArrayList<String>();
		for (int i = 0; i < comment.size(); i++) {
			commentList.add(comment.get(i).getContent());
		}
		return commentList;
	}
	
	/**
	 * 从roomVO列表中获取用于界面显示的roomInfo列表
	 * 
	 * @return roomInfo
	 */
	@SuppressWarnings("unused")
	private ArrayList<RoomInfoVO> getRoomInfoList(ArrayList<RoomVO> room) {
		ArrayList<RoomInfoVO> roomInfo = new ArrayList<RoomInfoVO>();
		for (int i = 0; i < room.size(); i++) {
			
		}
		return roomInfo;
	}
}
