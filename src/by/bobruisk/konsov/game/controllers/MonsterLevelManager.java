package by.bobruisk.konsov.game.controllers;

import org.apache.log4j.Logger;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.PlayerClass;
/**
 * This class sets the parameters of monsters depending on the level of the player
 * @author Sergey 
 *
 */
public class MonsterLevelManager {
	private static final int warriorHealthMod = 25;
	private static final int warriorBasicHealth = 350;
	private static final int warriorDEfMod = 5;
	private static final int warriorBasicDef = 20;
	private static final int warriorPowMod = 10;
	private static final int warriorBasicPow = 25;
	private static final int warriorDexMod = 5;
	private static final int warriorBasicDex = 10;
	private static final int warriorIntMod = 5;
	private static final int warriorBasicInt = 5;
	
	private static final int rogueHealthMod = 20;
	private static final int rogueBasicHealth = 300;
	private static final int rogueDEfMod = 5;
	private static final int rogueBasicDef = 5;
	private static final int roguePowMod = 5;
	private static final int rogueBasicPow = 10;
	private static final int rogueDexMod = 10;
	private static final int rogueBasicDex = 15;
	private static final int rogueIntMod = 5;
	private static final int rogueBasicInt = 5;
	
	private static final int mageHealthMod = 10;
	private static final int mageBasicHealth = 250;
	private static final int mageDEfMod = 5;
	private static final int mageBasicDef = 15;
	private static final int magePowMod = 5;
	private static final int mageBasicPow = 5;
	private static final int mageDexMod = 10;
	private static final int mageBasicDex = 15;
	private static final int mageIntMod = 5;
	private static final int mageBasicInt = 15;
	private final static Logger LOGGER = Logger.getLogger(MonsterLevelManager.class);
	
	public static void lvlUp(Player monster) {
		LOGGER.info("monster lelel up " + monster.getLevel());
		if (monster.getPlayerClass() == PlayerClass.WARRIOR) {
			WarSetLvlStats(monster,monster.getLevel());
		} else if (monster.getPlayerClass() == PlayerClass.ROGUE) {
			RogSetLvlStats(monster,monster.getLevel());
		} else if (monster.getPlayerClass() == PlayerClass.MAGE) {
			MagSetLvlStats(monster,monster.getLevel());
		}
	}
	
	private static void WarSetLvlStats(Player monster, int level) {
		monster.setHealthPoints(warriorBasicHealth + warriorHealthMod*(level-1));
		monster.setDefense(warriorBasicDef + warriorDEfMod*(level-1));
		monster.setPower(warriorBasicPow + warriorPowMod*(level-1));
		monster.setDexterity(warriorBasicDex + warriorDexMod*(level-1));
		monster.setIntelligence(warriorBasicInt + warriorIntMod*(level-1));
	}
	
	private static void RogSetLvlStats(Player monster, int level) {
		monster.setHealthPoints(rogueBasicHealth + rogueHealthMod*(level-1));
		monster.setDefense(rogueBasicDef + rogueDEfMod*(level-1));
		monster.setPower(rogueBasicPow + roguePowMod*(level-1));
		monster.setDexterity(rogueBasicDex + rogueDexMod*(level-1));
		monster.setIntelligence(rogueBasicInt + rogueIntMod*(level-1));
	}
	
	private static void MagSetLvlStats(Player monster, int level) {
		monster.setHealthPoints(mageBasicHealth + mageHealthMod*(level-1));
		monster.setDefense(mageBasicDef + mageDEfMod*(level-1));
		monster.setPower(mageBasicPow + magePowMod*(level-1));
		monster.setDexterity(mageBasicDex + mageDexMod*(level-1));
		monster.setIntelligence(mageBasicInt + mageIntMod*(level-1));
	}

}
