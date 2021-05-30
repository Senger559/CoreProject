package by.bobruisk.konsov.game.main;

import javax.swing.JFrame;

import by.bobruisk.konsov.game.view.LoginMenu;
import by.bobruisk.konsov.game.view.helper.FrameCreator;


public class GameRunner {

	private static JFrame frame;

	public static void main(String[] args) {
		setFrame(new LoginMenu());
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		GameRunner.frame = frame;
	}

}
