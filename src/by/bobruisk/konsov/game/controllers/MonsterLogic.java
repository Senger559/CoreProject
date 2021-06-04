package by.bobruisk.konsov.game.controllers;

import java.util.Random;

import org.apache.log4j.Logger;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

/**
 * This class determines the behavior of the opponent monster, selects its skills to hit, and tracks their cooldown.
 * @author Sergey
 *
 */
public class MonsterLogic {
	private static int monsterActive1Modificator = 0;
	private static int monsterActive2Modificator = 0;
	private static int monsterUltimateModificator = 0;
	private static StringBuilder log = new StringBuilder();
	private final static Logger LOGGER = Logger.getLogger(MonsterLogic.class);	
	
	public static void selectSkill(Player player, Player monster) {
		Random r = new Random ();
		int skill = r.nextInt(4);
		LOGGER.trace("the monster chooses a skill to hit");
		while (true) {
			if (skill != 0) {
				if (skill == 1) {
					if (monsterActive1Modificator != 0) {
						skill --;	
					} else {
					log.append(BattleManager.performBasicAttack(player, monster,"", SkillType.ACTIVE1));
					LOGGER.trace("the monster uses an improved skill");
					monsterActive1Modificator = 2;
					break;
					}
				
				} else if (skill == 2) {
						if (monsterActive2Modificator != 0) {
							skill --;
						} else {
						log.append(BattleManager.performBasicAttack(player, monster,"", SkillType.ACTIVE2)); 
						LOGGER.trace("the monster uses a special skill");
						monsterActive2Modificator = 3;
						break;
						}
						
				} else if (skill == 3) {
						if (monsterUltimateModificator != 0) {
							skill --;
						} else {
						log.append(BattleManager.performBasicAttack(player, monster,"", SkillType.ULTIMATE));
						LOGGER.trace("the monster uses a ultimate skill");
						monsterUltimateModificator = 4;
						break;
						}
					}
				} else {
					log.append(BattleManager.performBasicAttack(player, monster,"", SkillType.BASIC));
					LOGGER.trace("the monster uses a basic skill");
					break;
				}
		}
	}
	public static void monsterSkillAction (Player player, Player monster, String battleLog) {
		LOGGER.trace("the monster attack");
		log.delete(0, log.length());
		log.append(battleLog);
		selectSkill(player, monster);
		decreaseModificator(monsterActive1Modificator);
		decreaseModificator(monsterActive2Modificator);
		decreaseModificator(monsterUltimateModificator);		
	}
	
	private static void decreaseModificator(int modificator) {
		modificator =  modificator > 0 ? --modificator : modificator;
	}
	public static StringBuilder getLog() {
		return log;
	}
	public static void setLog(StringBuilder log) {
		MonsterLogic.log = log;
	}
	
}
