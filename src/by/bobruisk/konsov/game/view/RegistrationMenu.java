package by.bobruisk.konsov.game.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import by.bobruisk.konsov.game.main.GameRunner;
import by.bobruisk.konsov.game.resourses.Labels;
import by.bobruisk.konsov.game.resourses.TextFields;
import by.bobruisk.konsov.game.view.helper.ComponentHelper;
import by.bobruisk.konsov.game.view.helper.FrameCreator;
import by.bobruisk.konsov.game.view.helper.FrameSelector;

public class RegistrationMenu extends JFrame{
	private JLabel login = Labels.createColorlessLabel("Логин:", Color.white,220, 450, 200, 80);
	private JLabel password = Labels.createColorlessLabel("Пароль:", Color.white, 217, 500, 200, 80);
	private JLabel check = Labels.createColorlessLabel("1", Color.white, 350, 420, 200, 80);
	private JLabel checkResult = Labels.createColorlessLabel("Проверить", Color.white, 560, 450, 200, 80);
	private JLabel finishRegistration = Labels.createColorlessLabel("Готово", Color.white,375, 600, 100, 20);
	private JLabel imageReg  = new JLabel(
			new ImageIcon(LoginMenu.class.getClassLoader().getResource("registrration.jpg")));
	private JTextField createLogin = TextFields.createTextFForLogMenu(Color.white, 355, 476, 200, 30);
	private JTextField createPassword = TextFields.createTextFForLogMenu(Color.white, 355, 526, 200, 30);
	
	public RegistrationMenu () {
//		setFrame(FrameCreator.getFrame());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 740);
		setLocationRelativeTo(null);
		setResizable(false);
		ComponentHelper.addComponents(this.getContentPane(), login,password,finishRegistration,checkResult,createLogin,createPassword,check,imageReg);
		checkResult.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(GameRunner.getFrame(), "Тык работает!");
//				checkName();
			}
		});
		finishRegistration.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(GameRunner.getFrame(), "Тык работает!");
				FrameSelector.getCreateCharacterMenu();
				
//				Verification.registrationCheck(createLogin.getText(), createPassword.getText());
			}
		});
		setVisible(true);
		
//	public JFrame getFrame() {
//		return frame;
//	}
//	public void setFrame(JFrame frame) {
//		this.frame = frame;
//	}
	}
}
