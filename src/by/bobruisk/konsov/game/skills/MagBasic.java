package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class MagBasic extends Skill{
	{
		skillType= SkillType.BASIC;
		name = "Толчок";
		description = "Наносит врагу базовый урон";
		cooldown = 0;
	}

	@Override
	public int skillAction(Player player) {
		int damage = player.getIntelligence() * 1;
		return 0;
	}

}
