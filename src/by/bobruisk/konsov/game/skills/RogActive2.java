package by.bobruisk.konsov.game.skills;

import java.util.Random;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class RogActive2 extends Skill{
	{
		skillType= SkillType.ACTIVE2;
		name = "Бросок удачи";
		description = "Наносит случайный урон пропорционально ловкости";
		cooldown = 3;
	}
	@Override
	public int skillAction(Player player) {
		Random r = new Random();
		return (int)(player.getDexterity() * r.nextInt(4));

	}

}
