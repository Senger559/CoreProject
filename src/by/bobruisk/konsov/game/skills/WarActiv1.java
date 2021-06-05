package by.bobruisk.konsov.game.skills;
/**
 * stores the mechanics of the activq1 skill
 */
import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class WarActiv1 extends Skill{

	private static final long serialVersionUID = -612178598301116100L;

	{
		skillType= SkillType.ACTIVE1;
		name = "������";
		description = "������� ����� ���� ������ ���������� ���� ���������";
		cooldown = 1;
	}

	@Override
	public int skillAction(Player player) {
		int damage = player.getPower() * 2;
		return damage;
	}

}
