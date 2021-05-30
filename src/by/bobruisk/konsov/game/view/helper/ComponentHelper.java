package by.bobruisk.konsov.game.view.helper;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JLabel;

public class ComponentHelper {

	public static void addComponents(Container c, Component... com) {
		for (Component component : com) {
			c.add(component);
		}
	}
	public static void setLabelParam (JLabel label, String name, Color background,int x,int y,int width,int height) {
		label.setName(name);
		label.setOpaque(true);
		label.setBackground(background);
		label.setBounds(x, y, width, height);
	}

}
