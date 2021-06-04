package by.bobruisk.konsov.game.resourses;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * This class contains templates for creating Jlabel elements
 * @author Sergey
 *
 */
public class Labels {
	/**
	 * creates a transparent label with no borders and a white font color
	 */
	public static JLabel createColorlessLabel( String name, Color foreground,int x,int y,int width,int height) {
		JLabel label = new JLabel(name);
		label.setBounds(x, y, width, height);
		label.setForeground(foreground);
		label.setFont(new Font("Serif", Font.PLAIN, 18));
		label.setHorizontalAlignment(JLabel.CENTER);
		return label;
	}
	/**
	 * creates a label with a defined background color. default is white
	 */
	public static JLabel createColorLabel ( String name, Color background,int x,int y,int width,int height) {
		JLabel label = new JLabel();
		label.setName(name);
		label.setOpaque(true);
		label.setBackground(background);
		label.setBounds(x, y, width, height);
		label.setHorizontalAlignment(JLabel.CENTER);
		return label;
	}
	/**
	 * creates a label with the character's name
	 */
	public static JLabel createCharacterLabel(String name,int x,int y,int width,int height) {
		JLabel label = new JLabel(name);
		label.setBounds(x, y, width, height);
		label.setBackground(Color.white);
		label.setFont(new Font("Serif", Font.PLAIN, 18));
		return label;
		
	}
}
