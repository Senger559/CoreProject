package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class RogBasic extends Skill{
	{
		skillType= SkillType.BASIC;
		name = "Трюк";
		description = "Наносит врагу урон равный ловкости персонажа";
		cooldown = 0;
	}
	@Override
	public int skillAction(Player player) {
		int damage = player.getDexterity() * 1;
		return damage;
	}

}
