package by.bobruisk.konsov.game.controllers;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class BattleManager {
	
	private static StringBuilder log = new StringBuilder();
	
	public static String performBasicAttack (Player defender, Player attacker, SkillType skillType) {
		int skillDamage = selectSkill(attacker, skillType);
		int damage = determinateDamage(defender, attacker, skillDamage);
		int lastHealth = controlLastHealth(defender, damage);
		createAttackLog (defender, attacker,attacker.getBasic().getName(), damage);
		return log.toString();
	}
	public static int determinateDamage(Player defender, Player attacker, int skillPower) {
		int damage = attacker.getBasic().skillAction(attacker) - defender.getDefense();
		int lastHealth = controlLastHealth(defender, damage);
		defender.setHealthPoints(lastHealth);
		return damage;
	}
	
	public static int controlLastHealth(Player defender, int damage) {
		int lastHealth = defender.getHealthPoints() - damage;
		if(lastHealth < 0) {
			lastHealth = 0;
		}
		return lastHealth;
	}
	public static void createAttackLog (Player defender, Player attacker, String skillName, int damage) {
		String skillMessage = attacker.getName() + " использовал " + skillName + "\n";
		String damageMessage = defender.getName() + " получил " + damage  + " урона\n\n";
		log.append(skillMessage).append(damageMessage);
	}
	public static int selectSkill(Player attacker, SkillType skillType) {
		int skillDamage = 0;
		switch(skillType) {
		case BASIC:
			skillDamage = getBasicDamage(attacker);
			break;
		case ACTIVE1:
			skillDamage = getActive1Damage(attacker);
			break;
		case ACTIVE2:
			skillDamage = getActive2Damage(attacker);
			break;
		case ULTIMATE:
			skillDamage = getUltimateDamage(attacker);
			break;
		}
		return skillDamage;
	}
	
	public static int getBasicDamage(Player attacker) {
		 return attacker.getBasic().skillAction(attacker);
	}
	
	public static int getActive1Damage(Player attacker) {
		 return attacker.getActive1().skillAction(attacker);
	}
	
	public static int getActive2Damage(Player attacker) {
		 return attacker.getActive2().skillAction(attacker);
	}
	
	public static int getUltimateDamage(Player attacker) {
		 return attacker.getUltimate().skillAction(attacker);
	}
}
