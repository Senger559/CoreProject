package by.bobruisk.konsov.game.resourses;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import by.bobruisk.konsov.game.model.Player;

public class Labels {

	public static JLabel createColorlessLabel( String name, Color foreground,int x,int y,int width,int height) {
		JLabel label = new JLabel(name);
		label.setBounds(x, y, width, height);
		label.setForeground(foreground);
		label.setFont(new Font("Serif", Font.PLAIN, 18));
		label.setHorizontalAlignment(JLabel.CENTER);
		return label;
	}

	public static JLabel createColorLabel ( String name, Color background,int x,int y,int width,int height) {
		JLabel label = new JLabel();
		label.setName(name);
		label.setOpaque(true);
		label.setBackground(background);
		label.setBounds(x, y, width, height);
		label.setHorizontalAlignment(JLabel.CENTER);
		return label;
	}
	public static JLabel createCharacterLabel(String name,int x,int y,int width,int height) {
		JLabel label = new JLabel(name);
		label.setBounds(x, y, width, height);
		label.setBackground(Color.white);
		label.setFont(new Font("Serif", Font.PLAIN, 18));
		return label;
		
	}
}
