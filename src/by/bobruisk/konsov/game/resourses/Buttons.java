package by.bobruisk.konsov.game.resourses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import by.bobruisk.konsov.game.skills.Skill;

public class Buttons {
	public static JButton createButton( String name,int x,int y,int width,int height) {
		JButton button = new JButton(name);
		button.setBounds(x, y, width, height);
		button.setFont(new Font("Serif", Font.PLAIN, 18));
		button.setHorizontalAlignment(JLabel.CENTER);
		return button;
	}
	public static JButton createClassButton( String name,int x,int y,int width,int height) {
		JButton button = new JButton(name);
		button.setFont(new Font("Serif", Font.PLAIN, 18));
		button.setBorderPainted(true);
		button.setBackground(Color.white);
		button.setBounds(x, y, width, height);
		return button;
	}
	public static JButton createSkillButton(Skill skill,int x,int y,int width,int height) {
		JButton button = new JButton(skill.getName());
		button.setBounds(x, y, width, height);
		return button;
	}
}

