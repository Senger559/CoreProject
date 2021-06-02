package by.bobruisk.konsov.game.controllers;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.PlayerClass;

public class PlayerLevelManager {
	private static final int warriorHealthMod = 20;
	private static final int warriorBasicHealth = 200;
	private static final int warriorDEfMod = 10;
	private static final int warriorBasicDef = 20;
	private static final int warriorPowMod = 10;
	private static final int warriorBasicPow = 35;
	private static final int warriorDexMod = 5;
	private static final int warriorBasicDex = 15;
	private static final int warriorIntMod = 5;
	private static final int warriorBasicInt = 5;
	
	private static final int rogueHealthMod = 15;
	private static final int rogueBasicHealth = 170;
	private static final int rogueDEfMod = 10;
	private static final int rogueBasicDef = 10;
	private static final int roguePowMod = 5;
	private static final int rogueBasicPow = 15;
	private static final int rogueDexMod = 10;
	private static final int rogueBasicDex = 45;
	private static final int rogueIntMod = 5;
	private static final int rogueBasicInt = 5;
	
	private static final int mageHealthMod = 10;
	private static final int mageBasicHealth = 150;
	private static final int mageDEfMod = 5;
	private static final int mageBasicDef = 5;
	private static final int magePowMod = 5;
	private static final int mageBasicPow = 5;
	private static final int mageDexMod = 10;
	private static final int mageBasicDex = 15;
	private static final int mageIntMod = 10;
	private static final int mageBasicInt = 55;
	
	public static void lvlUp(Player player) {
		if (player.getPlayerClass() == PlayerClass.WARRIOR) {
			WarSetLvlStats(player,player.getLevel());
		} else if (player.getPlayerClass() == PlayerClass.ROGUE) {
			RogSetLvlStats(player,player.getLevel());
		} else if (player.getPlayerClass() == PlayerClass.MAGE) {
			MagSetLvlStats(player,player.getLevel());
		}
	}
	
	private static void WarSetLvlStats(Player player, int level) {
		player.setHealthPoints(warriorBasicHealth + warriorHealthMod*(level-1));
		player.setDefense(warriorBasicDef + warriorDEfMod*(level-1));
		player.setPower(warriorBasicPow + warriorPowMod*(level-1));
		player.setDexterity(warriorBasicDex + warriorDexMod*(level-1));
		player.setIntelligence(warriorBasicInt + warriorIntMod*(level-1));
	}
	
	private static void RogSetLvlStats(Player player, int level) {
		player.setHealthPoints(rogueBasicHealth + rogueHealthMod*(level-1));
		player.setDefense(rogueBasicDef + rogueDEfMod*(level-1));
		player.setPower(rogueBasicPow + roguePowMod*(level-1));
		player.setDexterity(rogueBasicDex + rogueDexMod*(level-1));
		player.setIntelligence(rogueBasicInt + rogueIntMod*(level-1));
	}
	
	private static void MagSetLvlStats(Player player, int level) {
		player.setHealthPoints(mageBasicHealth + mageHealthMod*(level-1));
		player.setDefense(mageBasicDef + mageDEfMod*(level-1));
		player.setPower(mageBasicPow + magePowMod*(level-1));
		player.setDexterity(mageBasicDex + mageDexMod*(level-1));
		player.setIntelligence(mageBasicInt + mageIntMod*(level-1));
	}
	
}
