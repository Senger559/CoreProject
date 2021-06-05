package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;
/**
 * stores the mechanics of the active2 skill
 * @author Sergey
 *
 */
public class MagActive2 extends Skill{

	private static final long serialVersionUID = -3991607615753750727L;

	{
		skillType= SkillType.ACTIVE2;
		name = "Закалка";
		description = "Незначительно увеличивает защиту до конца боя, наносит умеренный урон";
		cooldown = 3;
	}

	@Override
	public int skillAction(Player player) {
		player.setDefense((int)(player.getDefense()*1.5));
		return (int)(player.getIntelligence() * 0.7);
	}

}
