package by.bobruisk.konsov.game.resourses;

import javax.swing.JTextArea;
/**
 * generates a JTextArea based on the ready-made parameters
 * @author Sergey
 *
 */
public class TextAreas {
	public static JTextArea createUneditable(int x,int y,int width,int height) {
		JTextArea ta = new JTextArea();	
		ta.setBorder(null);
		ta.setLineWrap(true);
		ta.setBounds(x, y, width, height);
		ta.setEditable(false);
		return ta;
	}
}
