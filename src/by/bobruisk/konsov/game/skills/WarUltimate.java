package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;
/**
 * stores the mechanics of the ultimate skill
 */
public class WarUltimate extends Skill{
	

	private static final long serialVersionUID = -2337996630113032206L;

	{
		skillType= SkillType.ULTIMATE;
		name = "Pаскол";
		description = "Наносит мощный урон противнику";
		cooldown = 4;
	}

	@Override
	public int skillAction(Player player) {
		int damage = (int)(player.getPower() * 4.5);
		return damage;
	}
}
