package by.bobruisk.konsov.game.controllers;

import org.apache.log4j.Logger;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;
import by.bobruisk.konsov.game.view.RegistrationMenu;
/**
 * This class calculates the logic of the battle
 * @author Sergey 
 *
 */
public class BattleManager {
	private final static Logger LOGGER = Logger.getLogger(BattleManager.class);
	private static StringBuilder log = new StringBuilder();
	
	public static String performBasicAttack (Player defender, Player attacker,String battleLog, SkillType skillType) {
		LOGGER.info("An attack has been made" + attacker.getName() + " on the player" + defender.getName() + " a skill " + skillType.toString());
		log.delete(0, log.length());
		log.append(battleLog);
		int skillDamage = selectSkill(attacker, skillType);
		int damage = determinateDamage(defender, attacker, skillDamage);		
		createAttackLog (defender, attacker,skillType, damage);
		return log.toString();
	}
	public static int determinateDamage(Player defender, Player attacker, int skillDamage) {
		int damage = (skillDamage - defender.getDefense()) < 0 ? 0 : skillDamage - defender.getDefense();
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
	public static void createAttackLog (Player defender, Player attacker, SkillType skillType, int damage) {
		LOGGER.trace("An attack record was created");
		String skillMessage = attacker.getName() + " использовал " + getSkillName(attacker, skillType) + "\n";
		String damageMessage = defender.getName() + " получил " + damage  + " урона\n\n";
		log.append(skillMessage).append(damageMessage);
	}
	
	public static String getSkillName (Player attacker, SkillType skillType) {
		LOGGER.trace("skill name passed");
		String skillName = null;
		switch(skillType) {
		case BASIC:
			skillName = attacker.getBasic().getName();
			break;
		case ACTIVE1:
			skillName = attacker.getActive1().getName();
			break;
		case ACTIVE2:
			skillName = attacker.getActive2().getName();
			break;
		case ULTIMATE:
			skillName = attacker.getUltimate().getName();
			break;
		}
		return skillName;
	}
	public static int selectSkill(Player attacker, SkillType skillType) {
		
		int skillDamage = 0;
		switch(skillType) {
		case BASIC:
			skillDamage = getBasicDamage(attacker);
			LOGGER.trace("Base damage calculated");
			break;
		case ACTIVE1:
			skillDamage = getActive1Damage(attacker);
			LOGGER.trace("Increased damage calculated");
			break;
		case ACTIVE2:
			skillDamage = getActive2Damage(attacker);
			LOGGER.trace("Special damage calculated");
			break;
		case ULTIMATE:
			skillDamage = getUltimateDamage(attacker);
			LOGGER.trace("Ultimate Damage calculated");
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
