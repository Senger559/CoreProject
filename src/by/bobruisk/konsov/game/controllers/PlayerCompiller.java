package by.bobruisk.konsov.game.controllers;

import org.apache.log4j.Logger;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.ClassDescription;
import by.bobruisk.konsov.game.resourses.PicturesData;
import by.bobruisk.konsov.game.resourses.PlayerClass;
import by.bobruisk.konsov.game.view.RegistrationMenu;
/**
 * It is used to convert the player's class to a user-friendly view
 * @author Sergey
 *
 */
public class PlayerCompiller {
	
/**
 * prepares the "Player" class for writing
 */
	private final static Logger LOGGER = Logger.getLogger(RegistrationMenu.class);
	
	public static String prepareToWrite(Player player) {
		StringBuilder data = new StringBuilder();
		data.append(prepareClass(player));
		data.append(preparePicture(player));
		data.append(player.getLevel());
		LOGGER.debug("the object was prepared for recording " + data.toString());
		return data.toString();
	}
	
	private static int prepareClass(Player player) {
		if (player.getPlayerClass() == PlayerClass.WARRIOR) {
			return 0;
		} else if (player.getPlayerClass() == PlayerClass.ROGUE) {
			return 1;
		} else if (player.getPlayerClass() == PlayerClass.MAGE) {
			return 2;
		}
		return 0;
	}
	private static int preparePicture(Player player) {
		for(int i = 0; i < PicturesData.getUrl().length; i++) {
			if(player.getIi().equals(PicturesData.getUrl()[i])) {
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * prepares the "Player" class for reading
	 */
	public static Player prepareToRead (String data) {
		Player player = new Player();
		recoverClass( player, data);
		int ch = Integer.valueOf(data.charAt(1)-48);
		player.setIi(PicturesData.getUrl()[ch]);
		ch = Integer.valueOf(data.charAt(2)-48);
		player.setLevel(ch);
		PlayerLevelManager.lvlUp(player);
		ch = 0;
		LOGGER.debug("the object was restored " + player.toString());
		return player;
	}
	private static void recoverClass(Player player, String data) {
		int ch = Integer.valueOf(data.charAt(0)-48);
		if (ch == 0) {
			player.setPlayerClass(PlayerClass.WARRIOR);
			player.setClassDescriptionL(ClassDescription.getWarriorDescription());
			CharacterCreator.setSkills(player);
		} else if (ch == 1) {
			player.setPlayerClass(PlayerClass.ROGUE);
			player.setClassDescriptionL(ClassDescription.getRogueDescription());
			CharacterCreator.setSkills(player);
		} else if (ch == 2) {
			player.setPlayerClass(PlayerClass.MAGE);
			player.setClassDescriptionL(ClassDescription.getMageDescription());
			CharacterCreator.setSkills(player);
		}	
	}
}
