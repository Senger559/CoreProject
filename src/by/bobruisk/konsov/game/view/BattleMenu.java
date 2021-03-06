package by.bobruisk.konsov.game.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import by.bobruisk.konsov.game.controllers.BattleManager;
import by.bobruisk.konsov.game.controllers.ExperienseManager;
import by.bobruisk.konsov.game.controllers.MonsterLogic;
import by.bobruisk.konsov.game.controllers.OpponentCreator;
import by.bobruisk.konsov.game.controllers.PlayerLevelManager;
import by.bobruisk.konsov.game.main.GameRunner;
import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.Buttons;
import by.bobruisk.konsov.game.resourses.Labels;
import by.bobruisk.konsov.game.resourses.SkillType;
import by.bobruisk.konsov.game.view.helper.ComponentHelper;
import by.bobruisk.konsov.game.view.helper.FrameSelector;

public class BattleMenu extends JFrame{
	private static final long serialVersionUID = -8171191544502193366L;
	private final static Logger LOGGER = Logger.getLogger(BattleMenu.class);
	private Player monster = new Player();
	private Player player = new Player();
	private JLabel playerName,playerAvatar, playerLevel, playerClass, playerHealth, playerDefence, playerPower, playerDexterity, playerIntelligense, playerExpirience;
	private JLabel monsterName,monsterLevel,monsterAvatar, monsterClass, monsterHealth;

	private JTextArea battleLog = new JTextArea();
	private JScrollPane batScroll;
	private JButton basicSkill, active1Skill,active2Skill, ultimateSkill, close, mainMenu;
	private ActionListener butListener = new SkillListener();
	private OpponentCreator getEnemy= new OpponentCreator();
	public BattleMenu(Player player){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 740);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.player = player;
		monster.setLevel(player.getLevel());
		monster = getEnemy.getNewMonster(player.getLevel());
		playerName = Labels.createCharacterLabel("   "+ player.getName(), 0, 0, 250, 20);
		playerAvatar  = new JLabel(
				new ImageIcon(LoginMenu.class.getClassLoader().getResource(player.getIi()))); 
		playerAvatar.setBounds(0, 20, 250, 350);
		playerLevel = Labels.createCharacterLabel("   ??????????????: " + player.getLevel(), 50, 380, 250, 20);
		playerClass = Labels.createCharacterLabel("   ??????????: " + player.getPlayerClass(), 50, 420, 250, 20);
		playerHealth = Labels.createCharacterLabel("   ????????????????: " + player.getHealthPoints(), 50, 460, 250, 20);
		playerDefence = Labels.createCharacterLabel("   ????????????: " + player.getDefense(), 50, 500, 250, 20);
		playerPower = Labels.createCharacterLabel("   ????????: " + player.getPower(), 50, 540, 250, 20);
		playerDexterity = Labels.createCharacterLabel("   ????????????????: " + player.getDexterity(), 50, 580, 250, 20);
		playerIntelligense = Labels.createCharacterLabel("   ??????????????????: " + player.getIntelligence(), 50, 620, 250, 20);
		playerExpirience = Labels.createCharacterLabel("   ?????????????? ????????: " + player.getExpirience(), 50, 660, 250, 20);
		battleLog.setText("?????? ?????????? " + player.getName() + " ?? " + monster.getName() + " ?????????????? \n");
		
		batScroll = new JScrollPane(battleLog);
		batScroll.setBounds(250, 0, 400, 600);
		batScroll.setBorder(BorderFactory.createEmptyBorder());
		batScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		monsterName = Labels.createCharacterLabel(monster.getName(), 650, 0, 250, 20); 
		monsterAvatar = new JLabel(
				new ImageIcon(LoginMenu.class.getClassLoader().getResource(monster.getIi())));
		monsterAvatar.setBounds(650, 20, 250, 350);
		monsterLevel = Labels.createCharacterLabel("   ??????????????: "+ monster.getLevel(), 650, 380, 250, 20);
		monsterClass = Labels.createCharacterLabel("   ??????????: " + monster.getPlayerClass(), 650, 420, 250, 20);
		monsterHealth = Labels.createCharacterLabel("   ????????????????: " + monster.getHealthPoints(), 650, 460, 250, 20);
		
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
		mainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameSelector.getCharacterMenu(player);
			}
		});
		mainMenu.setBounds(725, 630, 100, 21);
		close = new JButton ("close");
		close.setBounds(725, 660, 100, 21);
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameRunner.getFrame().dispose();
			}
		});
		this.getContentPane().setBackground(Color.white);
		ComponentHelper.addComponents(this.getContentPane(), playerName,playerAvatar, playerLevel, playerClass, playerHealth, playerDefence, 
				playerPower, playerDexterity, playerIntelligense, playerExpirience,
				monsterName,monsterLevel,monsterAvatar, monsterClass, monsterHealth,batScroll,
				basicSkill, active1Skill,active2Skill, ultimateSkill, close, mainMenu);
		LOGGER.info("menu was created");
		setVisible(true);
	}

	public Player getMonster() {
		return monster;
	}

	public void setMonster(Player monster) {
		this.monster = monster;
	}
	
	class SkillListener implements ActionListener {
		private int playerActive1Modificator = 0;
		private int playerActive2Modificator = 0;
		private int playerUltimateModificator = 0;

		@Override
		public void actionPerformed(ActionEvent e) {
			if ("basic".equals(e.getActionCommand())) {
				LOGGER.trace("basic attack used");
				makeMove(monster, player, battleLog.getText(), SkillType.BASIC);
				isAliveMonster();	
			} else if ("active1".equals(e.getActionCommand())) {
				LOGGER.trace("active1 attack used");
				makeMove(monster, player, battleLog.getText(), SkillType.ACTIVE1);
				playerActive1Modificator = 2;
				isAliveMonster();	
			} else if ("active2".equals(e.getActionCommand())) {
				LOGGER.trace("active2 attack used");
				makeMove(monster, player, battleLog.getText(), SkillType.ACTIVE2);	
				playerActive2Modificator = 3;
				isAliveMonster();	
			} else if ("ultimate".equals(e.getActionCommand())) {
				LOGGER.trace("ultimate attack used");
				makeMove(monster, player, battleLog.getText(), SkillType.ULTIMATE);
				playerUltimateModificator = 4;
				isAliveMonster();
			}
			decerseAllSkillCooldown();
		}
		
		private void decerseAllSkillCooldown() {
			playerActive1Modificator = decreaseSkillCoolDown(playerActive1Modificator, active1Skill);
			playerActive2Modificator = decreaseSkillCoolDown(playerActive2Modificator, active2Skill);
			playerUltimateModificator = decreaseSkillCoolDown(playerUltimateModificator, ultimateSkill);
		}
		//?????????????????????????? ???????? ?????????? ???? ??????????????????, ???????????? ???????????????? ?????????????????????? ???????????????????? ?? ?????? ????????????????.
		//?????? ?? ???? ??????????, ?? ???????? ???? ???????????????? ???????????????? ?????? ????????????(?????? ???? ??????????????????????, ?????????????????? ???? ??????????), ???????????????? ?????????????????????????? ??????????????????????
		private int decreaseSkillCoolDown(int modifier, JButton skillButton) {
			if(modifier!= 0) {
				--modifier;
				skillButton.setEnabled(false);
			} else {
				skillButton.setEnabled(true);
			}
			return modifier;
		}
		
		private boolean isAliveMonster() {
			if (monster.getHealthPoints() > 0) {
				getMonsterTurn();
			} else {
				getWin();
			}
			if (player.getHealthPoints() == 0) {
				getLose();
			}
			return false;
		}
		
		private void getMonsterTurn() {
			MonsterLogic.monsterSkillAction (player, monster, battleLog.getText());
			battleLog.setText("");
			battleLog.setText(MonsterLogic.getLog().toString());
			playerHealth.setText("   ????????????????: " + player.getHealthPoints());
		}
		
		private void getWin() {
			PlayerLevelManager.lvlUp(player);
			player.setBattleWin(player.getBattleWin()+1);
			ExperienseManager.addExperienceWin(player, monster.getLevel(), true);
			new BattleResultDialog(player, true);
			FrameSelector.getCharacterMenu(player);
		}
		
		private void getLose() {
			PlayerLevelManager.lvlUp(player);
			player.setBattleLose(player.getBattleLose()+1);
			ExperienseManager.addExperienceWin(player, monster.getLevel(), false);
			new BattleResultDialog(player, false);
			FrameSelector.getCharacterMenu(player);
		}
		
		
		
		private void makeMove (Player monster, Player player,String Log, SkillType skillType) {
			battleLog.setText(BattleManager.performBasicAttack(monster, player,Log, skillType));
			monsterHealth.setText("   ????????????????: " + monster.getHealthPoints());
		}

		public Player getPlayer() {
			return player;
		}

		public Player getMonster() {
			return monster;
		}

	}		
}

