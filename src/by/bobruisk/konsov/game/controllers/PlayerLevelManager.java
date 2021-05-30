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
	
//	public static void lvlUp(Player player) {
//		if (player.getPlayerClass() == PlayerClass.WARRIOR) {
//			setWarNextLevel(player);
//		} else if (player.getPlayerClass() == PlayerClass.ROGUE) {
//			setRogNextLevel(player);
//		} else if (player.getPlayerClass() == PlayerClass.MAGE) {
//			setMagNextLevel(player);
//		}
//	}
//	public static void setFirstLvl(Player player) {
//		if (player.getPlayerClass() == PlayerClass.WARRIOR) {
//			setWarFirstLevel(player);
//		} else if (player.getPlayerClass() == PlayerClass.ROGUE) {
//			setRogFirstLevel(player);
//		} else if (player.getPlayerClass() == PlayerClass.MAGE) {
//			setMagFirstLevel(player);
//		}
//	}
//	public static void setWarFirstLevel(Player player) {
//		player.setLevel(1);
//		player.setHealthPoints(200);
//		player.setDefense(20);
//		player.setPower(35);
//		player.setDexterity(15);
//		player.setIntelligence(5);
//		player.setExpirience(0);
//		player.setBattleLose(0);
//		player.setBattleWin(0);
//	}
//	public static void setWarNextLevel(Player player) {
//		player.setLevel(player.getLevel()+1);
//		player.setHealthPoints(player.getHealthPoints()+20);
//		player.setDefense(player.getDefense()+10);
//		player.setPower(player.getPower()+10);
//		player.setDexterity(player.getDexterity()+5);
//		player.setIntelligence(player.getIntelligence()+5);
//		
//	}	
//	public static void setRogFirstLevel(Player player) {
//		player.setLevel(1);
//		player.setHealthPoints(170);
//		player.setDefense(10);
//		player.setPower(15);
//		player.setDexterity(45);
//		player.setIntelligence(5);
//		player.setExpirience(0);
//		player.setBattleLose(0);
//		player.setBattleWin(0);
//	}
//	public static void setRogNextLevel(Player player) {
//		player.setLevel(player.getLevel()+1);
//		player.setHealthPoints(player.getHealthPoints()+15);
//		player.setDefense(player.getDefense()+10);
//		player.setPower(player.getPower()+5);
//		player.setDexterity(player.getDexterity()+10);
//		player.setIntelligence(player.getIntelligence()+5);	
//	}
//	public static void setMagFirstLevel(Player player) {
//		player.setLevel(1);
//		player.setHealthPoints(150);
//		player.setDefense(5);
//		player.setPower(5);
//		player.setDexterity(15);
//		player.setIntelligence(55);
//		player.setExpirience(0);
//		player.setBattleLose(0);
//		player.setBattleWin(0);
//	}
//	public static void setMagNextLevel(Player player) {
//		player.setLevel(player.getLevel()+1);
//		player.setHealthPoints(player.getHealthPoints()+10);
//		player.setDefense(player.getDefense()+5);
//		player.setPower(player.getPower()+5);
//		player.setDexterity(player.getDexterity()+5);
//		player.setIntelligence(player.getIntelligence()+10);
//		
//	}
}
