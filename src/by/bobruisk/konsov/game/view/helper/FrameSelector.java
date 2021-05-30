package by.bobruisk.konsov.game.view.helper;

import by.bobruisk.konsov.game.main.GameRunner;
import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.view.BattleMenu;
import by.bobruisk.konsov.game.view.CharacterMenu;
import by.bobruisk.konsov.game.view.CreateCharacterMenu;
import by.bobruisk.konsov.game.view.LoginMenu;
import by.bobruisk.konsov.game.view.RegistrationMenu;

public class FrameSelector {
	
	public static void getLoginMenu() {
		GameRunner.getFrame().dispose();
		GameRunner.setFrame(new LoginMenu());
	}
	public static void getCreateCharacterMenu() {
		GameRunner.getFrame().dispose();
		GameRunner.setFrame(new CreateCharacterMenu());
	}
	public static void getRegistrationMenu() {
		GameRunner.getFrame().dispose();
		GameRunner.setFrame(new RegistrationMenu());
	}
	public static void getCharacterMenu(Player player) {
		GameRunner.getFrame().dispose();
		GameRunner.setFrame(new CharacterMenu(player));
	}
	public static void getBattleMenu(Player player) {
		GameRunner.getFrame().dispose();
		GameRunner.setFrame(new BattleMenu(player));
	}
}
