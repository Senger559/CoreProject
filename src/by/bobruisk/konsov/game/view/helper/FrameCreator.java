package by.bobruisk.konsov.game.view.helper;

import javax.swing.JFrame;

public class FrameCreator {
	
	public static JFrame setFrame(JFrame frame) {
//		JFrame frame = new JFrame ();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 740);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		return frame;
	}

}
