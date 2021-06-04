package by.bobruisk.konsov.game.resourses;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class TextFields {
	/**
	 * 
	 * generates a text field based on the ready-made parameters
	 * @author Sergey
	 * @return JTextField
	 */
	
	public static JTextField createTextFForLogMenu( Color foreground,int x,int y,int width,int height) {
		JTextField textField  = new JTextField();
		textField.setForeground(foreground);
		textField.setOpaque(false);
		textField.setFont(new Font("Serif", Font.PLAIN, 18));
		textField.setBounds(x, y, width, height);
		textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, foreground));
		return textField;
	}
}
