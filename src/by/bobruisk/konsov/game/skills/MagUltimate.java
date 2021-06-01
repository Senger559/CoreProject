package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class MagUltimate extends Skill{
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
