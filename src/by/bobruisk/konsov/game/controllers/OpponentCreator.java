package by.bobruisk.konsov.game.controllers;

import java.util.Random;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.PicturesData;
import by.bobruisk.konsov.game.resourses.PlayerClass;

public class OpponentCreator {
	private static String[] monsterName = new String[11];
	private static String[] tag= new String[11];
	private static int selectedMonster = 0;
	private static int monsterPool = 11;
	
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
		Random random = new Random();
		return tag[random.nextInt(monsterPool)] + " " +  monsterName[selectedMonster];
	}
	private String addImage() {
		Random random = new Random();
		selectedMonster = random.nextInt(monsterPool); 
		return PicturesData.getMonsterUrl()[selectedMonster];
	}
	private void setClass(Player monster) {
		int random = new Random().nextInt(3);
		switch (random) {
		case 0:
			monster.setPlayerClass(PlayerClass.WARRIOR);
			break;
		case 1:
			monster.setPlayerClass(PlayerClass.ROGUE);
			break;
		case 2:
			monster.setPlayerClass(PlayerClass.MAGE);
			break;
		}
	}
}
