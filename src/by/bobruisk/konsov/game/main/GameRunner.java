package by.bobruisk.konsov.game.main;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

import by.bobruisk.konsov.game.view.LoginMenu;
/**
 * runs the program and stores the current frame
 * @author Sergey
 *
 */
public class GameRunner {
	private final static Logger LOGGER = Logger.getLogger(GameRunner.class);
	private static JFrame frame;

	public static void main(String[] args) {
		LOGGER.info("The program is running");
		setFrame(new LoginMenu());
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		GameRunner.frame = frame;
	}

}
