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
		monsterName[0] = "чуул";
		monsterName[1] = "кобольд";
		monsterName[2] = "баатезу";
		monsterName[3] = "допельгангер";
		monsterName[4] = "хитн";
		monsterName[5] = "исчадие";
		monsterName[6] = "кабан";
		monsterName[7] = "карга";
		monsterName[8] = "костяной Дьявол";
		monsterName[9] = "кваггот";
		monsterName[10] = "тролль";
		tag[0] = "Злобный";
		tag[1] = "Коварный";
		tag[2] = "Безумный";
		tag[3] = "Древний";
		tag[4] = "Безымянный";
		tag[5] = "Опасный";
		tag[6] = "Притаившийся";
		tag[7] = "Теневой";
		tag[8] = "Пробуждённый";
		tag[9] = "Лихой";
		tag[10] = "Рьяный";
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
