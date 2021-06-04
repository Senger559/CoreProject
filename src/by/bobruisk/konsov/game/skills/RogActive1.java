package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;
/**
 * stores the mechanics of the basic skill
 * @author Senger
 *
 */
public class RogActive1 extends Skill{

	private static final long serialVersionUID = -6938751147983391436L;
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
