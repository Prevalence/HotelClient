package businessLogic;

import businessLogic.userbl.UserController;
public class main {
	public static void main(String[] args) {
		UserController u=new UserController();
		u.getPersonInfo("xiamutian");
	}

}
