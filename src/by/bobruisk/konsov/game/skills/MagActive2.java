package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class MagActive2 extends Skill{
	{
		skillType= SkillType.ACTIVE2;
		name = "«акалка";
		description = "Ќезначительно увеличивает защиту до конца бо€, наносит умеренный урон";
		cooldown = 3;
	}

	@Override
	public int skillAction(Player player) {
		player.setDefense((int)(player.getDefense()*1.5));
		return (int)(player.getIntelligence() * 0.7);
	}

}
