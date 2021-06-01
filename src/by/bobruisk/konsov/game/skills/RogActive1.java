package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class RogActive1 extends Skill{
	{
		skillType= SkillType.ACTIVE1;
		name = "Финт";
		description = "Наносит врагу урон равный двукратной локости персонажа";
		cooldown = 2;
	}
	@Override
	public int skillAction(Player player) {
		int damage = player.getDexterity() * 2;
		return damage;
	}

}
