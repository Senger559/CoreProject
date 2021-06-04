package by.bobruisk.konsov.game.view.helper;

import javax.swing.JFrame;

public class FrameCreator {
	/**
	 * sets the selected frame to the standard values for the application
	 */
	public static JFrame setFrame(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 740);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		return frame;
	}

}
