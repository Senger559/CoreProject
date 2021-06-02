package by.bobruisk.konsov.game.resourses;

import java.util.ArrayList;

import by.bobruisk.konsov.game.model.Account;
import by.bobruisk.konsov.game.model.Player;

public class Accounts {

	private static ArrayList<Account> userList;

	static {
		userList = new ArrayList<>();
		Account ac1 = new Account();
		ac1.setLogin("login");
		ac1.setPassword("password");
		ac1.setPlayer(new Player());
		userList.add(ac1);
		Account ac2 = new Account();
		ac2.setLogin("login2");
		ac2.setPassword("password2");
		ac2.setPlayer(new Player());
		userList.add(ac2);
		Account ac3 = new Account();
		ac3.setLogin("login3");
		ac3.setPassword("password3");
		ac3.setPlayer(new Player());
		userList.add(ac3);
	}

	public static ArrayList<Account> getUserList() {
		return userList;
	}
	// конструкция класс.поле= поле в статике по причине одного и того же имени
	public static void setUserList(ArrayList<Account> userList) {
		Accounts.userList = userList;
	}

	public static void addNewUser(String login, String password) {
		Account ac = new Account();
		ac.setPlayer(new Player());
		ac.setLogin(login);
		ac.setPassword(password);
		userList.add(ac);
	}

	public static Account getLast() {
		return userList.get(userList.size() - 1);
	}

}