package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class WarUltimate extends Skill{
	
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
