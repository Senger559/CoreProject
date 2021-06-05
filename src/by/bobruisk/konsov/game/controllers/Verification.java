package by.bobruisk.konsov.game.controllers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import by.bobruisk.konsov.game.main.GameRunner;
import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.view.RegistrationMenu;
import by.bobruisk.konsov.game.view.helper.FrameSelector;
/**
 * This class checks the correctness of filling in the fields and checks the uniqueness of the login-password pair
 * @author Sergey 
 *
 */
public class Verification {
	private static FileManager fileManager = new FileManager();
	private static List<Player> players = new ArrayList<>();
	private final static Logger LOGGER = Logger.getLogger(RegistrationMenu.class);
	
	public static void checkingEntered(String login, String password) {
		fileManager.checkFile();
		setPlayers(fileManager.extract());
		if (login.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(GameRunner.getFrame(), "Заполните пустующие поля!");
			LOGGER.debug("fields are not filled in");
		} else {
			boolean search = false;
			for (int i = 0; i < players.size(); i++) {
				if (checkLogin( login, i) && checkPassword(password, i)) {
					search = true;
					FrameSelector.getCharacterMenu(players.get(i));
					break;
				}
			}
			if (!search) {
				JOptionPane.showMessageDialog(GameRunner.getFrame(),
						"Введены неверные данные\n Проверьте логин и пароль");
			}
		}
	}
/**
 * This method checks the registration
 */
	public static void registrationCheck(String login, String password) {
		fileManager.checkFile();
		setPlayers(fileManager.extract());	
		if (login.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(GameRunner.getFrame(), "Заполните пустующие поля!");
			LOGGER.debug("fields are not filled in");
		} else {
			boolean search = false;
			LOGGER.debug( players.size()+ " ");
			for (int i = 0; i < players.size(); i++) {
				if (checkLogin(login, i) && checkPassword(password, i)) {
					search = true;
					break;
				}
			}
			if (!search) {
				JOptionPane.showMessageDialog(GameRunner.getFrame(), "Поздравляем!\n Вы успешно зарегистрированы");
				LOGGER.info("успешная регистрация нового игрока");
				Player newPlayer = new Player();
				newPlayer.setLogin(login);
				newPlayer.setPassword(password);
				players.add(newPlayer);
				FrameSelector.getCreateCharacterMenu();
			} else {
				JOptionPane.showMessageDialog(GameRunner.getFrame(),
						"Введены неверные данные\n Заняты логин или пароль");
				LOGGER.debug("ввод неверных данных");
			}
		}
	}
	/**
	 * This method checks the login
	 */
	public static boolean searchLogin(String login) {
		boolean search = false;
		if (login.isEmpty()) {
			JOptionPane.showMessageDialog(GameRunner.getFrame(), "Заполните пустующие поля!");
			LOGGER.debug("fields are not filled in");
		} else {
			for (int i = 0; i < players.size(); i++) {
				if (checkLogin(login, i)) {
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
			checkLabel.setText("Ник занят!");
			LOGGER.debug("nickname verification failed");
		} else {
			if (!login.isEmpty()) {
				checkLabel.setForeground(Color.green);
				checkLabel.setText("Ник не занят!");
				LOGGER.debug("nickname verification successful");
			}
		}
	}

	public static boolean checkLogin(String login, int i) {
		LOGGER.debug("checking your nickname");
		return (login.equals(players.get(i).getLogin())) ? true : false;
	}

	public static boolean checkPassword(String password, int i) {
		LOGGER.debug("checking your password");
		return (password.equals(players.get(i).getPassword())) ? true : false;
	}

	public static FileManager getFileManager() {
		return fileManager;
	}

	public static void setFileManager(FileManager fileManager) {
		Verification.fileManager = fileManager;
	}

	public static List<Player> getPlayers() {
		return players;
	}

	public static void setPlayers(List<Player> players) {
		Verification.players = players;
	}

}