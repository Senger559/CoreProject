package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class MagActive1 extends Skill{
	{
		skillType= SkillType.ACTIVE1;
		name = "Молния";
		description = "Наносит врагу урон равный двукратному значению интеллекта";
		cooldown = 1;
	}
	@Override
	public int skillAction(Player player) {
		int damage = player.getIntelligence() * 2;
		return damage;
	}

}
