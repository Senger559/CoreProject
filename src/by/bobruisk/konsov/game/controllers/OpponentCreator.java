package by.bobruisk.konsov.game.controllers;

import java.util.Random;

import org.apache.log4j.Logger;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.PicturesData;
import by.bobruisk.konsov.game.resourses.PlayerClass;
import by.bobruisk.konsov.game.view.RegistrationMenu;
/**
 * Creates an enemy monster according to the level of the character
 * @author Sergey
 *
 */
public class OpponentCreator {
	private static String[] monsterName = new String[11];
	private static String[] tag= new String[11];
	private static int selectedMonster = 0;
	private static int monsterPool = 11;
	private final static Logger LOGGER = Logger.getLogger(RegistrationMenu.class);
	static {
		monsterName[0] = "����";
		monsterName[1] = "�������";
		monsterName[2] = "�������";
		monsterName[3] = "������������";
		monsterName[4] = "����";
		monsterName[5] = "�������";
		monsterName[6] = "�����";
		monsterName[7] = "�����";
		monsterName[8] = "�������� ������";
		monsterName[9] = "�������";
		monsterName[10] = "������";
		tag[0] = "�������";
		tag[1] = "��������";
		tag[2] = "��������";
		tag[3] = "�������";
		tag[4] = "����������";
		tag[5] = "�������";
		tag[6] = "������������";
		tag[7] = "�������";
		tag[8] = "�����������";
		tag[9] = "�����";
		tag[10] = "������";
	}
	
	public Player getNewMonster (int playerLevel) {
		LOGGER.info("a new monster is being created");
		Player monster = new Player();
		monster.setLevel(playerLevel);
		monster.setIi(addImage());
		monster.setName(createName());
		setClass(monster);
		CharacterCreator.setSkills(monster);
		MonsterLevelManager.lvlUp(monster);
		return monster;
	}
	private String createName() {
		LOGGER.info("the monster is given a name");
		Random random = new Random();
		return tag[random.nextInt(monsterPool)] + " " +  monsterName[selectedMonster];
	}
	private String addImage() {
		LOGGER.info("the monster is assigned a picture");
		Random random = new Random();
		selectedMonster = random.nextInt(monsterPool); 
		return PicturesData.getMonsterUrl()[selectedMonster];
	}
	private void setClass(Player monster) {
		int random = new Random().nextInt(3);
		switch (random) {
		case 0:
			monster.setPlayerClass(PlayerClass.WARRIOR);
			LOGGER.info("the monster is assigned the warrior class");
			break;
		case 1:
			monster.setPlayerClass(PlayerClass.ROGUE);
			LOGGER.info("the monster is assigned the rogue class");
			break;
		case 2:
			monster.setPlayerClass(PlayerClass.MAGE);
			LOGGER.info("the monster is assigned the mage class");
			break;
		}
	}
}
