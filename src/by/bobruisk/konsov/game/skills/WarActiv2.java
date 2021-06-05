package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;
/**
 * stores the mechanics of the active2 skill
 */
public class WarActiv2 extends Skill{
	

	private static final long serialVersionUID = -4239509332270918350L;

	{
		skillType= SkillType.ACTIVE2;
		name = "Усиление";
		description = "Увеличивает силу атаки персонажа";
		cooldown = 3;
	}

	@Override
	public int skillAction(Player player) {
		player.setPower((int)(player.getPower() * 1.1));
	return (int)(player.getPower() * 0.5);
	}

}
