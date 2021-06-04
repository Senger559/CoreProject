package by.bobruisk.konsov.game.controllers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import by.bobruisk.konsov.game.main.GameRunner;
import by.bobruisk.konsov.game.model.Account;
import by.bobruisk.konsov.game.resourses.Accounts;
import by.bobruisk.konsov.game.view.helper.FrameSelector;

public class Verification {
	private static FileManager fileManager = new FileManager();
	private static ArrayList<Account> accounts;
	public static void checkingEntered(String login, String password) {
		
		if (login.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(GameRunner.getFrame(), "��������� ��������� ����!");
		} else {
			fileManager.checkFile();
//			accounts = fileManager.read();
			boolean search = false;
			for (int i = 0; i < accounts.size(); i++) {
				if (checkLogin(accounts, login, i) && checkPassword(accounts,password, i)) {
					search = true;
					FrameSelector.getCharacterMenu(accounts.get(i).getPlayer());
					break;
				}
			}
			if (!search) {
				JOptionPane.showMessageDialog(GameRunner.getFrame(),
						"������� �������� ������\n ��������� ����� � ������");
			}
		}
	}

	public static void registrationCheck(String login, String password) {
		if (login.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(GameRunner.getFrame(), "��������� ��������� ����!");
		} else {
			fileManager.checkFile();
			boolean search = false;
			for (int i = 0; i < accounts.size(); i++) {
				if (checkLogin(accounts,login, i) && checkPassword(accounts,password, i)) {
					search = true;
					break;
				}
			}
			if (!search) {
				JOptionPane.showMessageDialog(GameRunner.getFrame(), "�����������!\n �� ������� ����������������");
				Accounts.addNewUser(login, password);
				FrameSelector.getCreateCharacterMenu();
			} else {
				JOptionPane.showMessageDialog(GameRunner.getFrame(),
						"������� �������� ������\n ������ ����� ��� ������");
			}
		}
	}

	public static boolean searchLogin(String login) {
		boolean search = false;
		if (login.isEmpty()) {
			JOptionPane.showMessageDialog(GameRunner.getFrame(), "��������� ��������� ����!");
		} else {
			fileManager.checkFile();
			for (int i = 0; i < Accounts.getUserList().size(); i++) {
				if (checkLogin(accounts,login, i)) {
					search = true;
					break;
				}
			}
		}
		return search;
	}
	public static void checkName(String login, JLabel checkLabel) {
		fileManager.checkFile();
		if (searchLogin(login)) {
			checkLabel.setForeground(Color.red);
			checkLabel.setText("��� �����!");
		} else {
			if (!login.isEmpty()) {
				checkLabel.setForeground(Color.green);
				checkLabel.setText("��� �� �����!");
			}
		}
	}

	public static boolean checkLogin(List<Account> accounts, String login, int i) {
		return (login.equals(accounts.get(i).getLogin())) ? true : false;
	}

	public static boolean checkPassword(List<Account> accounts,String password, int i) {
		return (password.equals(accounts.get(i).getPassword())) ? true : false;
	}

}