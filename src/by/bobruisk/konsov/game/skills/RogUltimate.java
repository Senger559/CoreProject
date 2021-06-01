package by.bobruisk.konsov.game.skills;

import java.util.Random;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class RogUltimate extends Skill{
	{
		skillType= SkillType.ULTIMATE;
		name = "Риск";
		description = "Наносит мощный, но нестабильный урон противнику";
		cooldown = 4;
	}
	@Override
	public int skillAction(Player player) {
		Random r = new Random();
		int damage = player.getDexterity() * 2 + player.getDexterity()*r.nextInt(4);
		System.out.println(damage);
		return damage;
	}

}
