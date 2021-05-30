package by.bobruisk.konsov.game.controllers;

import by.bobruisk.konsov.game.model.Player;

public class BattleManager {
	
	private static StringBuilder log = new StringBuilder();
	
	public static String getBasicAttack (Player defender, Player attacker) {
		int damage = attacker.getBasic().skillAction(attacker) - defender.getDefense();
		defender.setHealthPoints(defender.getHealthPoints() - damage);
		String skillMessage = attacker.getName() + " использовал " + attacker.getBasic().getName() + "\n";
		String damageMessage = defender.getName() + " получил " + damage  + " урона\n";
		log.append(skillMessage).append(damageMessage);
		return log.toString();
	}
}
