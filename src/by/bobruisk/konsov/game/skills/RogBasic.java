package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;
/**
 * stores the mechanics of the basic skill
 * @author Sergey
 *
 */
public class RogBasic extends Skill{

	private static final long serialVersionUID = 7150710327389736416L;
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
