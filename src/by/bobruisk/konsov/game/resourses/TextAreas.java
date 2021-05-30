package by.bobruisk.konsov.game.resourses;

import java.awt.Color;

import javax.swing.JTextArea;

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
