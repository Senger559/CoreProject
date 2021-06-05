package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;
/**
 * stores the mechanics of the ultimate skill
 * @author Sergey
 *
 */
public class MagUltimate extends Skill{

	private static final long serialVersionUID = 7043682238179094900L;
	{
		skillType= SkillType.ULTIMATE;
		name = "Шторм";
		description = "Наносит мощный урон противнику";
		cooldown = 4;
	}
	@Override
	public int skillAction(Player player) {
		int damage = (int)(player.getIntelligence() * 4.5);
		return damage;
	}

}
