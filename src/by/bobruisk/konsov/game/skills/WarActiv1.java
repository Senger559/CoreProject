package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class WarActiv1 extends Skill{
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
