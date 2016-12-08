package ui.Factory;

import javafx.scene.layout.Pane;

public class ManagerFactory {
	private Pane userInfoPane;

	public static Pane createUserInfoPane(String usertype) {
		switch (usertype) {
		case "客户":

			break;
		case "酒店工作人员":

			break;
		case "网站营销人员":

			break;

		default:
			break;
		}
	}
}
