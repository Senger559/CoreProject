package by.bobruisk.konsov.game.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import by.bobruisk.konsov.game.controllers.CharacterCreator;
import by.bobruisk.konsov.game.main.GameRunner;
import by.bobruisk.konsov.game.resourses.Buttons;
import by.bobruisk.konsov.game.resourses.ClassDescription;
import by.bobruisk.konsov.game.resourses.Labels;
import by.bobruisk.konsov.game.resourses.PicturesData;
import by.bobruisk.konsov.game.resourses.PlayerClass;
import by.bobruisk.konsov.game.resourses.TextAreas;
import by.bobruisk.konsov.game.view.helper.ComponentHelper;
import by.bobruisk.konsov.game.view.helper.FrameSelector;


public class CreateCharacterMenu extends JFrame{
//	private ActionListener selectAvatarJB = new SelectAvatarListener();
	private ActionListener SelectClassJB = new ButListener();
	private JTextField enteringName = new JTextField("������� ���");
	private JTextArea characterDescription = TextAreas.createUneditable(567, 0, 300, 900);
	private JLabel selectAvatar = Labels.createColorlessLabel("�������� ������", Color.black, 300, 400, 250, 20);
	private JLabel selectClas  = Labels.createColorlessLabel("�������� �����", Color.black, 300, 450, 250, 20);
	private JLabel avatar = new JLabel(
			new ImageIcon(LoginMenu.class.getClassLoader().getResource(PicturesData.getPicture())));
	private JButton previous = Buttons.createButton("<<", 300, 427, 125, 20);
	private JButton next = Buttons.createButton(">>", 425, 427, 125, 20);
	private JButton warrior = Buttons.createClassButton("warrior", 300, 480, 250, 30);
	private JButton rogue = Buttons.createClassButton("rogue", 300, 520, 250, 30);
	private JButton mage = Buttons.createClassButton("mage", 300, 560, 250, 30);
	private JButton create = Buttons.createButton("�������", 365, 640, 124, 30);
	
	
	public CreateCharacterMenu() {	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 740);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		enteringName.setBounds(300, 0, 250, 30);
		enteringName.setHorizontalAlignment(JLabel.CENTER);
		enteringName.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs,String str, AttributeSet a) throws BadLocationException {
                    if (getLength()< 16) {
                        super.insertString(offs, str,a);
                    }  
            }
        });	
		enteringName.setText(CharacterCreator.getName());
		avatar.setBounds(300, 40, 250, 350);	
		previous.addActionListener(SelectClassJB);
		previous.setActionCommand("previous");
		next.addActionListener(SelectClassJB);
		next.setActionCommand("next");	
		warrior.addActionListener(SelectClassJB);
		warrior.setActionCommand("warrior");
		rogue.addActionListener(SelectClassJB);
		rogue.setActionCommand("rogue");
		mage.addActionListener(SelectClassJB);
		mage.setActionCommand("mage");
		create.addActionListener(SelectClassJB);
		create.setActionCommand("create");
		characterDescription.setText(ClassDescription.getDescription());
		ComponentHelper.addComponents(this.getContentPane(),warrior,rogue,mage, selectClas,characterDescription, enteringName,selectAvatar,previous,next,create,avatar);
		setVisible(true);
	}
	class ButListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if("warrior".equals(e.getActionCommand())) {
				ClassDescription.setSelected(PlayerClass.WARRIOR);
				characterDescription.setText(ClassDescription.getDescription());
			} else if("rogue".equals(e.getActionCommand())) {
				ClassDescription.setSelected(PlayerClass.ROGUE);
				characterDescription.setText(ClassDescription.getDescription());
			} else if("mage".equals(e.getActionCommand())) {
				ClassDescription.setSelected(PlayerClass.MAGE);
				characterDescription.setText(ClassDescription.getDescription());
			} else if("create".equals(e.getActionCommand())) {
				CharacterCreator.saveName(enteringName.getText());
				
				// ����� ���������� ������� � ����������� �� ������				
				FrameSelector.getCharacterMenu(CharacterCreator.create());
				
				
			} else if("previous".equals(e.getActionCommand())) {
				getAnotherPicture(PicturesData.getSelectedPicture()-1);
			} else if("next".equals(e.getActionCommand())) {
				getAnotherPicture(PicturesData.getSelectedPicture()+1);			
			}
		}
		public void getAnotherPicture(int picNumber) {
			if(picNumber<0) {
				PicturesData.setSelectedPicture(PicturesData.getUrl().length-1);
			} else if(picNumber>PicturesData.getUrl().length-1) {	
				PicturesData.setSelectedPicture(0);
			} else {
				PicturesData.setSelectedPicture(picNumber);
			}
			CharacterCreator.saveName(enteringName.getText());
			FrameSelector.getCreateCharacterMenu();
		}

	}
}
