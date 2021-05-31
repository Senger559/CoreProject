package by.bobruisk.konsov.game.controllers;

import java.util.Random;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class MonsterLogic {
	private static int monsterActive1Modificator = 0;
	private static int monsterActive2Modificator = 0;
	private static int monsterUltimateModificator = 0;
	private static StringBuilder log = new StringBuilder();
		
	public static void selectSkill(Player player, Player monster) {
		Random r = new Random ();
		int skill = r.nextInt(4);
		System.out.println(skill);
		while (true) {// выбирает, какой скилл использовать
			if (skill != 0) {
				if (skill == 1) {
					if (monsterActive1Modificator != 0) {
						skill --;	
					} else {
					log.append(BattleManager.performBasicAttack(player, monster,"", SkillType.ACTIVE1));
					monsterActive1Modificator = 2;
					break;
					}
				
				} else if (skill == 2) {
						if (monsterActive2Modificator != 0) {
							skill --;
						} else {
						log.append(BattleManager.performBasicAttack(player, monster,"", SkillType.ACTIVE2)); 
						monsterActive2Modificator = 3;
						break;
						}
						
				} else if (skill == 3) {
						if (monsterUltimateModificator != 0) {
							skill --;
						} else {
						log.append(BattleManager.performBasicAttack(player, monster,"", SkillType.ULTIMATE));
						monsterUltimateModificator = 4;
						break;
						}
					}
				} else {
					log.append(BattleManager.performBasicAttack(player, monster,"", SkillType.BASIC));
					break;
				}
		}
	}
	// ход монстра.что делает монстр в свой раунд
	public static void monsterSkillAction (Player player, Player monster, String battleLog) {
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
