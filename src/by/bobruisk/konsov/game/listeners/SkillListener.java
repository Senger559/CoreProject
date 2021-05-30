package by.bobruisk.konsov.game.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import by.bobruisk.konsov.game.model.Player;
// при нажатии кнопок навыков запускает методы соот навыка
public class SkillListener implements ActionListener {
	private Player player;
	private Player monster;
	

	private int playerActive1Modificator = 0;
	private int playerActive2Modificator = 0;
	private int playerUltimateModificator = 0;
	
	private int monsterActive1Modificator = 0;
	private int monsterActive2Modificator = 0;
	private int monsterUltimateModificator = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("basic".equals(e.getActionCommand())) {
			monster.setHealthPoints(monster.getHealthPoints() + monster.getDefense()- player.getBasic().skillAction(player));
			
			if (monster.getHealthPoints() != 0) {
				//ход монстра
				monsterSkillAction (monster);
			} else {
				// победа, добавление очка победы и опыта за врага
			}
			if (player.getHealthPoints() <= 0) {
				// game over добавление очка поражений, опыт не засчитывается
			}
		} else if ("active1".equals(e.getActionCommand())) {
			monster.setHealthPoints(monster.getHealthPoints() + monster.getDefense()- player.getBasic().skillAction(player));
			if (monster.getHealthPoints() != 0) {
				//ход монстра
				monsterSkillAction (monster);
			} else {
				// победа, добавление очка победы и опыта за врага
			}
			if (player.getHealthPoints() <= 0) {
				// game over добавление очка поражений, опыт не засчитывается
			}
		} else if ("active2".equals(e.getActionCommand())) {
			monster.setHealthPoints(monster.getHealthPoints() + monster.getDefense()- player.getBasic().skillAction(player));
			if (monster.getHealthPoints() != 0) {
				//ход монстра
				monsterSkillAction (monster);
			} else {
				// победа, добавление очка победы и опыта за врага
			}
			if (player.getHealthPoints() <= 0) {
				// game over добавление очка поражений, опыт не засчитывается
			}
		} else if ("ultimate".equals(e.getActionCommand())) {
			monster.setHealthPoints(monster.getHealthPoints() + monster.getDefense()- player.getBasic().skillAction(player));
			if (monster.getHealthPoints() != 0) {
				//ход монстра
				monsterSkillAction (monster);
			} else {
				// победа, добавление очка победы и опыта за врага
			}
			if (player.getHealthPoints() <= 0) {
				// game over добавление очка поражений, опыт не засчитывается
			}
		}

	}
	// ход монстра.что делает монстр в свой раунд
	public void monsterSkillAction (Player monster) {
		Random r = new Random ();
		int skill = r.nextInt(4);
		while (true) {// выбирает, какой скилл использовать
			if (skill != 0) {
				if (skill == 1) {
					if (monsterActive1Modificator != 0) {
						skill++;
						break;
					}
				} else if (skill == 2) {
						if (monsterActive1Modificator != 0) {
							skill++;
							break;
						}
				} else if (skill == 3) {
						if (monsterActive1Modificator != 0) {
							skill = 0;
							break;
						}
						
					}
				}
			break;
		}
		//переопределяет кд навыков
		if (monsterActive1Modificator != 0) {
			monsterActive1Modificator--;
			//передача значений в панель
		}
		if (monsterActive2Modificator != 0) {
			monsterActive2Modificator--;
			//передача значений в панель
		}
		if (monsterUltimateModificator != 0) {
			monsterUltimateModificator--;
			//передача значений в панель
		}
		
		switch (skill) {// потом добавить механики остальных типов
			case 0: 
				player.setHealthPoints(player.getHealthPoints() + player.getDefense() - monster.getBasic().skillAction(monster));
			case 1:
				player.setHealthPoints(player.getHealthPoints() + player.getDefense() - monster.getBasic().skillAction(monster));
			case 2:
				player.setHealthPoints(player.getHealthPoints() + player.getDefense() - monster.getBasic().skillAction(monster));
			case 3:
				player.setHealthPoints(player.getHealthPoints() + player.getDefense() - monster.getBasic().skillAction(monster));
		}
			
		
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Player getMonster() {
		return monster;
	}
	public void setMonster(Player monster) {
		this.monster = monster;
	}



}