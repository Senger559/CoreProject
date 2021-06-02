package by.bobruisk.konsov.game.controllers;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import by.bobruisk.konsov.game.main.GameRunner;
import by.bobruisk.konsov.game.resourses.Accounts;
import by.bobruisk.konsov.game.view.helper.FrameSelector;

public class Verification {

	public static void checkingEntered(String login, String password) {
		if (login.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(GameRunner.getFrame(), "Заполните пустующие поля!");
		} else {
			boolean search = false;
			for (int i = 0; i < Accounts.getUserList().size(); i++) {
				if (checkLogin(login, i) && checkPassword(password, i)) {
					search = true;
					//тут чтение из файла
//					FrameSelector.getCharacterMenu(player););

					break;
				}
			}
			if (!search) {
				JOptionPane.showMessageDialog(GameRunner.getFrame(),
						"Введены неверные данные\n Проверьте логин и пароль");
			}
		}
	}

	public static void registrationCheck(String login, String password) {
		if (login.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(GameRunner.getFrame(), "Заполните пустующие поля!");
		} else {
			boolean search = false;
			for (int i = 0; i < Accounts.getUserList().size(); i++) {
				if (checkLogin(login, i) && checkPassword(password, i)) {
					search = true;
					break;
				}
			}
			if (!search) {
				JOptionPane.showMessageDialog(GameRunner.getFrame(), "Поздравляем!\n Вы успешно зарегистрированы");
				Accounts.addNewUser(login, password);
				FrameSelector.getCreateCharacterMenu();
//				TextFields.setSpace();
			} else {
				JOptionPane.showMessageDialog(GameRunner.getFrame(),
						"Введены неверные данные\n Заняты логин или пароль");
			}
		}
	}

	public static boolean searchLogin(String login) {
		boolean search = false;
		if (login.isEmpty()) {
			JOptionPane.showMessageDialog(GameRunner.getFrame(), "Заполните пустующие поля!");
		} else {
			for (int i = 0; i < Accounts.getUserList().size(); i++) {
				if (checkLogin(login, i)) {
					search = true;
					break;
				}
			}
		}
		return search;
	}
	public static void checkName(String login, JLabel checkLabel) {
		if (searchLogin(login)) {
			checkLabel.setForeground(Color.red);
			checkLabel.setText("Ник занят!");
		} else {
			if (!login.isEmpty()) {
				checkLabel.setForeground(Color.green);
				checkLabel.setText("Ник не занят!");
			}
		}
	}

	public static boolean checkLogin(String login, int i) {
		return (login.equals(Accounts.getUserList().get(i).getLogin())) ? true : false;
	}

	public static boolean checkPassword(String password, int i) {
		return (password.equals(Accounts.getUserList().get(i).getPassword())) ? true : false;
	}

}