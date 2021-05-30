package by.bobruisk.konsov.game.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import by.bobruisk.konsov.game.controllers.BattleManager;
import by.bobruisk.konsov.game.main.GameRunner;
import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.players.and.monsters.MonsterData;
import by.bobruisk.konsov.game.resourses.Buttons;
import by.bobruisk.konsov.game.resourses.Labels;
import by.bobruisk.konsov.game.resourses.SkillType;
import by.bobruisk.konsov.game.skills.WarActiv1;
import by.bobruisk.konsov.game.skills.WarActiv2;
import by.bobruisk.konsov.game.skills.WarBasic;
import by.bobruisk.konsov.game.skills.WarUltimate;
import by.bobruisk.konsov.game.view.helper.ComponentHelper;

public class BattleMenu extends JFrame{
	private Player monster = MonsterData.getFirst();
	private Player player = new Player();
	private JLabel playerName,playerAvatar, playerLevel, playerClass, playerHealth, playerDefence, playerPower, playerDexterity, playerIntelligense, playerExpirience;
	private JLabel monsterName,monsterLevel,monsterAvatar, monsterClass, monsterHealth;

	private JTextArea battleLog = new JTextArea();
	private JScrollPane batScroll;
	private JButton basicSkill, active1Skill,active2Skill, ultimateSkill, close, mainMenu;
	private ActionListener butListener = new SkillListener();
	
	public BattleMenu(Player player){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 740);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.player = player;
		playerName = Labels.createCharacterLabel("   "+ player.getName(), 0, 0, 250, 20);
		playerAvatar  = new JLabel(
				new ImageIcon(LoginMenu.class.getClassLoader().getResource(player.getIi()))); 
		playerAvatar.setBounds(0, 20, 250, 350);
		playerLevel = Labels.createCharacterLabel("   Уровень: " + player.getLevel(), 50, 380, 250, 20);
		playerClass = Labels.createCharacterLabel("   Класс: " + player.getPlayerClass(), 50, 420, 250, 20);
		playerHealth = Labels.createCharacterLabel("   Здоровье: " + player.getHealthPoints(), 50, 460, 250, 20);
		playerDefence = Labels.createCharacterLabel("   Защита: " + player.getDefense(), 50, 500, 250, 20);
		playerPower = Labels.createCharacterLabel("   Сила: " + player.getPower(), 50, 540, 250, 20);
		playerDexterity = Labels.createCharacterLabel("   Ловкость: " + player.getDexterity(), 50, 580, 250, 20);
		playerIntelligense = Labels.createCharacterLabel("   Интеллект: " + player.getIntelligence(), 50, 620, 250, 20);
		playerExpirience = Labels.createCharacterLabel("   Текущий опыт: " + player.getExpirience(), 50, 660, 250, 20);
		battleLog.setText("Бой между " + player.getName() + " и " + monster.getName() + " начался");
		
		//battleLog сделать нередактируемым
		batScroll = new JScrollPane(battleLog);
		batScroll.setBounds(250, 0, 400, 600);
		batScroll.setBorder(BorderFactory.createEmptyBorder());
		batScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		batScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		monsterName = Labels.createCharacterLabel(monster.getName(), 650, 0, 250, 20); 
		monsterAvatar = new JLabel(
				new ImageIcon(LoginMenu.class.getClassLoader().getResource(monster.getIi())));
		monsterAvatar.setBounds(650, 20, 250, 350);
		monsterLevel = Labels.createCharacterLabel("   Уровень: "+ monster.getLevel(), 650, 380, 250, 20);
		monsterClass = Labels.createCharacterLabel("   Класс: " + monster.getPlayerClass(), 650, 420, 250, 20);
		monsterHealth = Labels.createCharacterLabel("   Здоровье: " + monster.getHealthPoints(), 650, 460, 250, 20);
		
		basicSkill = Buttons.createSkillButton(player.getBasic(), 250, 600, 100, 100);
		active1Skill = Buttons.createSkillButton(player.getActive1(), 350, 600, 100, 100);
		active2Skill = Buttons.createSkillButton(player.getActive2(), 450, 600, 100, 100);
		ultimateSkill = Buttons.createSkillButton(player.getUltimate(), 550, 600, 100, 100);
		
		basicSkill.setActionCommand("basic");
		basicSkill.addActionListener(butListener);
		active1Skill.setActionCommand("active1");
		active1Skill.addActionListener(butListener);
		active2Skill.setActionCommand("active2");
		active2Skill.addActionListener(butListener);
		ultimateSkill.setActionCommand("ultimate");
		ultimateSkill.addActionListener(butListener);
		
		mainMenu  = new JButton ("Main");
		mainMenu.setBounds(725, 630, 100, 21);
		close = new JButton ("close");
		close.setBounds(725, 660, 100, 21);
		this.getContentPane().setBackground(Color.white);
		ComponentHelper.addComponents(this.getContentPane(), playerName,playerAvatar, playerLevel, playerClass, playerHealth, playerDefence, 
				playerPower, playerDexterity, playerIntelligense, playerExpirience,
				monsterName,monsterLevel,monsterAvatar, monsterClass, monsterHealth,batScroll,
				basicSkill, active1Skill,active2Skill, ultimateSkill, close, mainMenu);
		setVisible(true);
	}

	public Player getMonster() {
		return monster;
	}

	public void setMonster(Player monster) {
		this.monster = monster;
	}
	
	class SkillListener implements ActionListener {//монстра со всеми его модами и метами в отдельный файл?
		private int playerActive1Modificator = 0;
		private int playerActive2Modificator = 0;
		private int playerUltimateModificator = 0;
		
		private int monsterActive1Modificator = 0;
		private int monsterActive2Modificator = 0;
		private int monsterUltimateModificator = 0;
		
		public boolean isAliveMonster(Player monster) {
			if (monster.getHealthPoints() != 0) {
				//ход монстра
				monsterSkillAction (monster);
			} else {
				// победа, добавление очка победы и опыта за врага
			}
			if (player.getHealthPoints() <= 0) {
				// game over добавление очка поражений, опыт не засчитывается
			}
			return false;
		}
		public void makeMove (Player monster, Player player, SkillType skillType) {
			battleLog.setText(BattleManager.performBasicAttack(monster, player, skillType));
			monsterHealth.setText("   Здоровье: " + monster.getHealthPoints());
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if ("basic".equals(e.getActionCommand())) {
				makeMove(monster, player, SkillType.BASIC);
				isAliveMonster(monster);				
			} else if ("active1".equals(e.getActionCommand())) {
				makeMove(monster, player, SkillType.ACTIVE1);
				playerActive1Modificator = 2;
				isAliveMonster(monster);	
			} else if ("active2".equals(e.getActionCommand())) {
				makeMove(monster, player, SkillType.ACTIVE2);	
				playerActive2Modificator = 3;
				isAliveMonster(monster);	
			} else if ("ultimate".equals(e.getActionCommand())) {
				makeMove(monster, player, SkillType.ULTIMATE);
				playerUltimateModificator = 4;
				isAliveMonster(monster);
			}
			if (playerActive1Modificator != 0) {
				playerActive1Modificator--;
				active1Skill.setEnabled(false);
			} else {
				active1Skill.setEnabled(true);
			}
			if (playerActive2Modificator != 0) {
				playerActive2Modificator--;
				active2Skill.setEnabled(false);
			} else {
				active2Skill.setEnabled(true);
			}
			if (playerUltimateModificator != 0) {
				playerUltimateModificator--;
				ultimateSkill.setEnabled(false);
			} else {
				ultimateSkill.setEnabled(true);
			}
		}
	
		// ход монстра.что делает монстр в свой раунд
		public void monsterSkillAction (Player monster) {
			Random r = new Random ();
			int skill = r.nextInt(4);
			while (true) {// выбирает, какой скилл использовать
				if (skill != 0) {
					if (skill == 1) {
						if (monsterActive1Modificator != 0) {
							skill++;
							break;
						}
					} else if (skill == 2) {
							if (monsterActive1Modificator != 0) {
								skill++;
								break;
							}
					} else if (skill == 3) {
							if (monsterActive1Modificator != 0) {
								skill = 0;
								break;
							}					
						}
					}
				break;
			}
			
			//переопределяет кд навыков монстра
			if (monsterActive1Modificator != 0) {
				monsterActive1Modificator--;
				
			} 
			if (monsterActive2Modificator != 0) {
				monsterActive2Modificator--;
				
			} 
			if (monsterUltimateModificator != 0) {
				monsterUltimateModificator--;
				
			} 
			
			
			switch (skill) {// потом добавить механики остальных типов
				case 0: 
					player.setHealthPoints(player.getHealthPoints() + player.getDefense() - monster.getBasic().skillAction(monster));
				case 1:
					player.setHealthPoints(player.getHealthPoints() + player.getDefense() - monster.getBasic().skillAction(monster));
				case 2:
					player.setHealthPoints(player.getHealthPoints() + player.getDefense() - monster.getBasic().skillAction(monster));
				case 3:
					player.setHealthPoints(player.getHealthPoints() + player.getDefense() - monster.getBasic().skillAction(monster));
			}			
		}
		public Player getPlayer() {
			return player;
		}

		public Player getMonster() {
			return monster;
		}

	}	
}

