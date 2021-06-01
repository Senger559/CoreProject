package by.bobruisk.konsov.game.controllers;

import by.bobruisk.konsov.game.model.Player;

public class ExperienseManager {
	private final static int[] LEVELS = {10, 50, 150, 200, 270};
	private final static int EXP_WIN_MOD = 5;
	
	public static void addExperienceWin(Player player, int opponentLvl, boolean battleResult) {
		int experience = battleResult ? opponentLvl*EXP_WIN_MOD : opponentLvl;
		player.setExpirience(player.getExpirience() + experience);
		controlLevel(player);
	}
	private static void controlLevel(Player player) {
		if (player.getLevel() >= 6) {
			player.setLevel(6);
		} else {
			setNewLevel (player);
		}
	}
	
	private static void setNewLevel (Player player) {
		for (int i = LEVELS.length; i > 0; i--) {
			if(player.getExpirience()> LEVELS[LEVELS.length-1]) {
				lvlUp(player, LEVELS.length+1);
				break;
			} else if (player.getExpirience()> LEVELS[LEVELS.length-2]) {
				lvlUp(player, LEVELS.length);
				break;
			} else if (player.getExpirience()> LEVELS[LEVELS.length-3]) {
				lvlUp(player, LEVELS.length-1);
				break;
			} else if (player.getExpirience()> LEVELS[LEVELS.length-4]) {
				lvlUp(player, LEVELS.length-2);
				break;
			} else if (player.getExpirience()> LEVELS[LEVELS.length-5]) {
				lvlUp(player, LEVELS.length-3);
				break;
			}
		}
	}
	private static void lvlUp(Player player, int level) {
		player.setLevel(level);
		PlayerLevelManager.lvlUp(player);
	}
}
