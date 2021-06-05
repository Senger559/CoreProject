package by.bobruisk.konsov.game.players.and.monsters;

import java.util.ArrayList;
import java.util.List;

import by.bobruisk.konsov.game.controllers.CharacterCreator;
import by.bobruisk.konsov.game.controllers.PlayerLevelManager;
import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.ClassDescription;
import by.bobruisk.konsov.game.resourses.PicturesData;
import by.bobruisk.konsov.game.resourses.PlayerClass;

/**
 * Sets basic, "trial" player records
 * @author Sergey 
 *
 */
public class PlayerData {
	private static Player first = new Player();
	private static List<Player> players = new ArrayList<>();
	static {

		players = new ArrayList<>();
		Player p1 = new Player();
		p1.setLogin("login");
		p1.setPassword("password");
		p1.setName("test1");
		p1.setLevel(1);
		p1.setIi(PicturesData.getUrl()[7]);
		p1.setPlayerClass(PlayerClass.WARRIOR);
		p1.setClassDescriptionL(ClassDescription.getWarriorDescription());
		PlayerLevelManager.lvlUp(p1);
		CharacterCreator.setSkills(p1);
		players.add(p1);
		Player p2 = new Player();
		p2.setLogin("login2");
		p2.setLevel(1);
		p2.setPassword("password2");
		p2.setName("test2");
		p2.setIi(PicturesData.getUrl()[5]);
		CharacterCreator.setSkills(p2);
		PlayerLevelManager.lvlUp(p2);
		p2.setPlayerClass(PlayerClass.ROGUE);
		p2.setClassDescriptionL(ClassDescription.getRogueDescription());
		players.add(p2);
		Player p3 = new Player();
		p3.setLogin("login3");
		p3.setLevel(1);
		p3.setPassword("password3");
		p3.setName("test3");
		p3.setIi(PicturesData.getUrl()[3]);
		CharacterCreator.setSkills(p3);
		PlayerLevelManager.lvlUp(p3);
		p3.setPlayerClass(PlayerClass.MAGE);
		p3.setClassDescriptionL(ClassDescription.getMageDescription());
		players.add(p3);

	}
	public static Player getFirst() {
		return first;
	}
	public static void setFirst(Player first) {
		PlayerData.first = first;
	}
	public static List<Player> getPlayers() {
		return players;
	}
	public static void setPlayers(List<Player> players) {
		PlayerData.players = players;
	}


}
