package by.bobruisk.konsov.game.view;

import java.awt.Color;
import java.awt.Container;
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



public class LoginMenu  extends JFrame{

		private JLabel login= Labels.createColorlessLabel("�����:", Color.white,220, 450, 200, 80);  
		private JLabel password = Labels.createColorlessLabel("������:", Color.white, 217, 500, 200, 80);
		private JLabel image  = new JLabel(
		new ImageIcon(LoginMenu.class.getClassLoader().getResource("loginMenu.jpg")));
		private JLabel enter = Labels.createColorlessLabel("�����", Color.white,375, 600, 100, 20);
		private JLabel registration = Labels.createColorlessLabel("�����������", Color.white,740, 10, 100, 20);
		private JLabel  check = Labels.createColorlessLabel("1", Color.white, 350, 410, 200, 80);
		private JTextField enteringLogin=TextFields.createTextFForLogMenu(Color.white, 355, 476, 200, 30);
		private JTextField enteringPassword=TextFields.createTextFForLogMenu(Color.white, 355, 526, 200, 30);
		
		public LoginMenu() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(900, 740);
			setLocationRelativeTo(null);
			setResizable(false);
			ComponentHelper.addComponents(this.getContentPane(),login,password,enter,registration,check,enteringLogin,enteringPassword, image);
			enter.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
//					Verification.checkingEntered(enteringLogin.getText(), enteringPassword.getText());
					JOptionPane.showMessageDialog(GameRunner.getFrame(), "��� ��������!");
				}
			});
			registration.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(GameRunner.getFrame(), "��� ��������!");
					FrameSelector.getRegistrationMenu();
					
				}
			});
			setVisible(true);
		}
}
