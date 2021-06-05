package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;
/**
 * stores the mechanics of the basic skill
 * @author Sergey
 *
 */
public class MagBasic extends Skill{

	private static final long serialVersionUID = -5318804171078985757L;

	{
		skillType= SkillType.BASIC;
		name = "Удар"; 
		description = "наносит урон пропорциональный уровню силы";
		cooldown = 0;
	}

	@Override
	public int skillAction(Player player) {
		return  player.getIntelligence() * 1;
	}

}
