package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class WarActiv2 extends Skill{
	
	{
		skillType= SkillType.ACTIVE2;
		name = "Усиление";
		description = "Увеличивает силу атаки персонажа";
		cooldown = 3;
	}

	@Override
	public int skillAction(Player player) {
		player.setPower((int)(player.getPower() * 1.1));
	return 0;
	}

}
