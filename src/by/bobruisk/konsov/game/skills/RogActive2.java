package by.bobruisk.konsov.game.skills;

import java.util.Random;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;
/**
 * stores the mechanics of the active2 skill
 * @author Sergey
 *
 */
public class RogActive2 extends Skill{

	private static final long serialVersionUID = -4748904614924652152L;
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
