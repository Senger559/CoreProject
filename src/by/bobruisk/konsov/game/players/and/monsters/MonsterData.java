package by.bobruisk.konsov.game.players.and.monsters;

import java.util.ArrayList;
import java.util.List;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.skills.WarActiv1;
import by.bobruisk.konsov.game.skills.WarActiv2;
import by.bobruisk.konsov.game.skills.WarBasic;
import by.bobruisk.konsov.game.skills.WarUltimate;

public class MonsterData {
	private static Player first = new Player();
	private static List<Player> monsters = new ArrayList<>();
	static {

		first.setName("first");
		first.setIi("Warroir05.jpg");
		first.setLevel(1);
		first.setExpirience(0);
		first.setDexterity(10);
		first.setHealthPoints(100);
		first.setIntelligence(10);
		first.setPower(10);
		first.setBattleWin(10);
		first.setBattleLose(10);
		first.setBasic(new WarBasic());
		first.setActive1(new WarActiv1());
		first.setActive2(new WarActiv2());
		first.setUltimate(new WarUltimate());
		monsters.add(first);

	}
	public static Player getFirst() {
		return first;
	}
	public static void setFirst(Player first) {
		MonsterData.first = first;
	}
	public static List<Player> getPlayers() {
		return monsters;
	}
	public static void setPlayers(List<Player> monsters) {
		MonsterData.monsters = monsters;
	}

}
