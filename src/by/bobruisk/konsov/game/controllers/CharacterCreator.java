package by.bobruisk.konsov.game.controllers;


import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.players.and.monsters.PlayerData;
import by.bobruisk.konsov.game.resourses.ClassDescription;
import by.bobruisk.konsov.game.resourses.PicturesData;
import by.bobruisk.konsov.game.resourses.PlayerClass;
import by.bobruisk.konsov.game.skills.MagActive1;
import by.bobruisk.konsov.game.skills.MagActive2;
import by.bobruisk.konsov.game.skills.MagBasic;
import by.bobruisk.konsov.game.skills.MagUltimate;
import by.bobruisk.konsov.game.skills.RogActive1;
import by.bobruisk.konsov.game.skills.RogActive2;
import by.bobruisk.konsov.game.skills.RogBasic;
import by.bobruisk.konsov.game.skills.RogUltimate;
import by.bobruisk.konsov.game.skills.WarActiv1;
import by.bobruisk.konsov.game.skills.WarActiv2;
import by.bobruisk.konsov.game.skills.WarBasic;
import by.bobruisk.konsov.game.skills.WarUltimate;

public class CharacterCreator {
	private static String name = "герой";
	
	public static Player create() {
		Player player = new Player();
		player.setName(name);
		player.setIi(PicturesData.getUrl()[PicturesData.getSelectedPicture()]);
		player.setPlayerClass(ClassDescription.getSelected());
		player.setLevel(1);
		player.setExpirience(0);
		setSkills(player);
		PlayerLevelManager.lvlUp(player);
		PlayerData.getPlayers().add(player);
		return player;
	}
	public static void saveName(String charName) {
		if(!charName.isEmpty()) {
			name = charName;
		}
	}
	public static String getName() {
		return name;
	}
	public static void setSkills(Player player) {
		if (player.getPlayerClass() == PlayerClass.WARRIOR) {
			setWarriorSkills(player);
		} else if (player.getPlayerClass() == PlayerClass.ROGUE) {
			setRogueSkills(player);
		} else if (player.getPlayerClass() == PlayerClass.MAGE) {
			setMageSkills(player);
		}
	}
	public static void setWarriorSkills(Player player) {
		player.setBasic(new WarBasic());
		player.setActive1(new WarActiv1());
		player.setActive2(new WarActiv2());
		player.setUltimate(new WarUltimate());
	}
	public static void setRogueSkills(Player player) {
		player.setBasic(new RogBasic());
		player.setActive1(new RogActive1());
		player.setActive2(new RogActive2());
		player.setUltimate(new RogUltimate());
	}
	public static void setMageSkills(Player player) {
		player.setBasic(new MagBasic());
		player.setActive1(new MagActive1());
		player.setActive2(new MagActive2());
		player.setUltimate(new MagUltimate());
	}
}