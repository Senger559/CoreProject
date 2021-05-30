package by.bobruisk.konsov.game.skills;

import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.SkillType;

public class WarBasic extends Skill {
	{
		skillType= SkillType.BASIC;
		name = "����";
		description = "������� ����� ���� ������ ���� ���������";
		cooldown = 0;
	}

	@Override
	public int skillAction(Player player) {
		int damage = player.getPower() * 1;
		return damage;

	}

}