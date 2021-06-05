package by.bobruisk.konsov.game.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.Buttons;
import by.bobruisk.konsov.game.resourses.Labels;
import by.bobruisk.konsov.game.view.helper.ComponentHelper;
import by.bobruisk.konsov.game.view.helper.FrameSelector;
/**
 * This class creates the character menu
 * @author Sergey
 *
 */
public class CharacterMenu extends JFrame{
	private static final long serialVersionUID = -6874980771312025209L;
	private final static Logger LOGGER = Logger.getLogger(CharacterMenu.class);
	private JLabel name;
	private JLabel avatar;
	private JLabel level;	
	private JLabel clas;	
	private JLabel health;	
	private JLabel defence;	
	private JLabel power;	
	private JLabel dexterity;
	private JLabel intelligence;	
	private JLabel expirience;
	private JButton anotherAccount;
	private JButton playBattle;
	
	public CharacterMenu(Player player) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 740);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		name = Labels.createCharacterLabel(player.getName(), 50, 0, 250, 20);
		avatar = new JLabel(
				new ImageIcon(CharacterMenu.class.getClassLoader().getResource(player.getIi())));
		level = Labels.createCharacterLabel("Уровень: " + player.getLevel(), 50, 380, 250, 20);	
		clas = Labels.createCharacterLabel("Класс: " + player.getPlayerClass(), 50, 420, 250, 20);	
		health = Labels.createCharacterLabel("Здоровье: " + player.getHealthPoints(), 50, 460, 250, 20);	
		defence = Labels.createCharacterLabel("Защита: " + player.getDefense(), 50, 500, 250, 20);	
		power = Labels.createCharacterLabel("Сила: " + player.getPower(), 50, 540, 250, 20);	
		dexterity = Labels.createCharacterLabel("Ловкость: " + player.getDexterity(), 50, 580, 250, 20);
		intelligence = Labels.createCharacterLabel("Интеллект: " + player.getIntelligence(), 50, 620, 250, 20);	
		expirience = Labels.createCharacterLabel("Текущий опыт: " + player.getExpirience(), 50, 660, 250, 20);		
		anotherAccount = Buttons.createClassButton("Главное меню", 600, 620, 250, 20);
		playBattle = Buttons.createClassButton("B бой", 600, 660, 250, 20);
		avatar.setBounds(0, 20, 250, 350);
		anotherAccount.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameSelector.getLoginMenu();
			}
		});
		playBattle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameSelector.getBattleMenu(player);
			}
		});
		ComponentHelper.addComponents(this.getContentPane(), 
				name,level,anotherAccount,playBattle,clas,health,defence,power,dexterity,intelligence,expirience,avatar);
		LOGGER.info("menu was created");
		setVisible(true);
	}
}
